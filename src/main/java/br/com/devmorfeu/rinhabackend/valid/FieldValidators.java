package br.com.devmorfeu.rinhabackend.valid;

import br.com.devmorfeu.rinhabackend.TransactionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FieldValidators {

    public void validateTransactionRequest(TransactionRequest request) {
        if (request.getDescricao().length() > 10) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (request.getTipo() != 'd' && request.getTipo() != 'c') {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (request.getValor() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
