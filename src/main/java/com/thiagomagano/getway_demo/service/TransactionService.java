package com.thiagomagano.getway_demo.service;

import com.thiagomagano.getway_demo.domain.entity.Transaction;
import com.thiagomagano.getway_demo.domain.enums.PaymentMethod;
import com.thiagomagano.getway_demo.domain.enums.TransactionStatus;
import com.thiagomagano.getway_demo.dto.TransactionRequest;
import com.thiagomagano.getway_demo.dto.TransactionResponse;
import com.thiagomagano.getway_demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public TransactionResponse process(TransactionRequest request) {
        Transaction transaction = Transaction.builder()
            .merchantId(request.merchantId())
            .amount(request.amount())
            .currency(request.currency())
            .paymentMethod(PaymentMethod.valueOf(request.paymentMethod()))
            .cardLast4(
                request
                    .card()
                    .number()
                    .substring(request.card().number().length() - 4)
            )
            .cardHolderName(request.card().holderName())
            .status(TransactionStatus.APPROVED)
            .authorizationCode("TEST1234")
            .nsu("123456")
            .build();

        repository.save(transaction);

        return new TransactionResponse(
            transaction.getId(),
            transaction.getStatus(),
            "Transação Recebibida com sucesso",
            transaction.getNsu(),
            transaction.getAuthorizationCode()
        );
    }
}
