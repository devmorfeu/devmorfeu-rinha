package br.com.devmorfeu.rinhabackend;


import lombok.Getter;

@Getter
public class TransactionRequest {

    private Long valor;
    private char tipo;
    private String descricao;

}
