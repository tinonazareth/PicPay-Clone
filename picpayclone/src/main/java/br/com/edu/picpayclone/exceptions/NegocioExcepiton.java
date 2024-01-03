package br.com.edu.picpayclone.exceptions;

import java.io.Serial;

public class NegocioExcepiton extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public NegocioExcepiton(String mensagem) {
        super(mensagem);
    }

    public NegocioExcepiton(String mensagem, Exception exception) {
        super(mensagem, exception);
    }
}
