package br.com.devmorfeu.rinhabackend.controller;

import br.com.devmorfeu.rinhabackend.TransactionRequest;
import br.com.devmorfeu.rinhabackend.TransactionResponse;
import br.com.devmorfeu.rinhabackend.valid.FieldValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class TransactionsController {

    private final FieldValidators fieldValidators;

    @PostMapping("/clientes/{id}/transacoes")
    public ResponseEntity<TransactionResponse> createTransaction(@PathVariable Long id, @RequestBody TransactionRequest request) {

        fieldValidators.validateTransactionRequest(request);

        validateId(id);

        System.out.println("Criando transação para o cliente " + id + " com os dados: " + request);

        //criar uma classe de transacao com data, valor, tipo, cliente
        //salvar no banco de dados

        return ResponseEntity.ok().body(new TransactionResponse(1000L, 500L));
    }

    @GetMapping("/clientes/{id}/transacoes")
    public void getTransactions(@PathVariable Long id) {

        validateId(id);

        System.out.println("Buscando transações do cliente " + id);
    }

    private void validateId(Long id) {
        if (id < 1 || id > 5) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
