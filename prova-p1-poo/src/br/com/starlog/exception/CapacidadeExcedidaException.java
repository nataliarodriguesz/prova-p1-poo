package br.com.starlog.exception;

public class CapacidadeExcedidaException extends Exception{

    // Recebe uma mensagem(String) quando lançada a exceção
    public CapacidadeExcedidaException(String message) {
        super(message);
    }
}
