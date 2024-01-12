package edu.northeastern.khoury.ds.mapper;

import edu.northeastern.khoury.ds.domain.dto.AddCreditCardRequest;
import edu.northeastern.khoury.ds.domain.dto.card.CreditCardResponse;
import edu.northeastern.khoury.ds.domain.dto.card.CreditCardStatisticsResponse;
import edu.northeastern.khoury.ds.domain.model.CreditCard;
import edu.northeastern.khoury.ds.domain.view.CreditCardStatistics;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {

    public CreditCardResponse mapToResponse(CreditCard creditCard) {
        final int id = creditCard.getId();
        final String holder = creditCard.getHolder();
        final String number = "*".repeat(4) + " " + creditCard.getNumber().substring(12);
        final String expiration = creditCard.getExpirationMonth() + "/" + creditCard.getExpirationYear();

        return new CreditCardResponse(id, number, holder, expiration);
    }

    public CreditCardStatisticsResponse mapToStatisticsResponse(CreditCardStatistics statistics) {
        final String total = statistics.getTotal();
        final String holder = statistics.getHolder();
        final String expiration = statistics.getExpiration();
        final String number = "*".repeat(4) + " " + statistics.getNumber().substring(12);
        return new CreditCardStatisticsResponse(holder, number, expiration, total);
    }

    public CreditCard mapToEntity(AddCreditCardRequest request) {
        final CreditCard creditCard = new CreditCard();
        creditCard.setExpirationMonth(request.expirationMonth());
        creditCard.setExpirationYear(request.expirationYear());
        creditCard.setHolder(request.holder());
        creditCard.setNumber(request.number());

        return creditCard;
    }
}
