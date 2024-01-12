package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.dto.AddCreditCardRequest;
import edu.northeastern.khoury.ds.domain.dto.card.CreditCardResponse;
import edu.northeastern.khoury.ds.domain.dto.card.CreditCardStatisticsResponse;
import edu.northeastern.khoury.ds.domain.model.Account;
import edu.northeastern.khoury.ds.domain.model.CreditCard;
import edu.northeastern.khoury.ds.exception.ResourceNotFoundException;
import edu.northeastern.khoury.ds.mapper.CreditCardMapper;
import edu.northeastern.khoury.ds.repository.CreditCardRepository;
import edu.northeastern.khoury.ds.repository.view.CreditCardStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreditCardService {

    private final AccountService accountService;
    private final CreditCardMapper creditCardMapper;
    private final CreditCardRepository creditCardRepository;
    private final AccessTokenInfoExtractor accessTokenInfoExtractor;
    private final CreditCardStatisticsRepository creditCardStatisticsRepository;

    public List<CreditCardResponse> find() {
        final String username = accessTokenInfoExtractor.getUsername();
        final Account account = accountService.findByUsernameLoadCreditCards(username);
        return account.getCreditCards().stream().map(creditCardMapper::mapToResponse).toList();
    }

    public CreditCardResponse add(AddCreditCardRequest request) {
        final String username = accessTokenInfoExtractor.getUsername();
        final Account account = accountService.findByUsernameLoadCreditCards(username);

        final CreditCard creditCard = findOrSave(request);
        account.getCreditCards().add(creditCard);
        accountService.save(account);

        return creditCardMapper.mapToResponse(creditCard);
    }

    private CreditCard findOrSave(AddCreditCardRequest request) {
        return creditCardRepository.findByNumber(request.number()).orElseGet(() -> save(request));
    }

//    public CreditCard findByNumber(String number) {
//        return creditCardRepository.findById(number).orElseThrow(ResourceNotFoundException::new);
//    }

    public List<CreditCardStatisticsResponse> findPaymentStatistics() {
        final String username = accessTokenInfoExtractor.getUsername();
        return creditCardStatisticsRepository.findByUsername(username).stream()
                .map(creditCardMapper::mapToStatisticsResponse)
                .toList();
    }

    private CreditCard save(AddCreditCardRequest request) {
        final CreditCard mappedCreditCard = creditCardMapper.mapToEntity(request);
        return creditCardRepository.save(mappedCreditCard);
    }

    public List<CreditCardResponse> delete(Integer id) {
        final String username = accessTokenInfoExtractor.getUsername();
        final Account account = accountService.findByUsernameLoadCreditCards(username);

        account.getCreditCards().removeIf(creditCard -> Objects.equals(id, creditCard.getId()));
        final Account updatedAccount = accountService.save(account);

        if (creditCardRepository.countSavedCreditCards(id) == 0) {
            creditCardRepository.deleteById(id);
        }

        return updatedAccount.getCreditCards().stream().map(creditCardMapper::mapToResponse).toList();
    }

    public CreditCard findById(Integer id) {
        return creditCardRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
