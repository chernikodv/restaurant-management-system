package edu.northeastern.khoury.ds.controller;

import edu.northeastern.khoury.ds.domain.dto.AddCreditCardRequest;
import edu.northeastern.khoury.ds.domain.dto.card.CreditCardResponse;
import edu.northeastern.khoury.ds.domain.dto.card.CreditCardStatisticsResponse;
import edu.northeastern.khoury.ds.domain.view.CreditCardStatistics;
import edu.northeastern.khoury.ds.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/credit-cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @GetMapping
    public List<CreditCardResponse> find() {
        return creditCardService.find();
    }

    @GetMapping(path = "/statistics")
    public List<CreditCardStatisticsResponse> findStatistics() {
        return creditCardService.findPaymentStatistics();
    }

    @PostMapping
    public CreditCardResponse add(@RequestBody AddCreditCardRequest request) {
        return creditCardService.add(request);
    }

    @DeleteMapping(path = "/{id}")
    public List<CreditCardResponse> remove(@PathVariable Integer id) {
        return creditCardService.delete(id);
    }
}
