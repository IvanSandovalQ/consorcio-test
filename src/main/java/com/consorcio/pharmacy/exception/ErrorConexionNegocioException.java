package com.consorcio.pharmacy.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorConexionNegocioException extends RuntimeException {

    private static final long serialVersionUID = -4607986199110034184L;
    private final Throwable throwable;
    private final HttpStatus codigo;
    private final String mensajeDebug;

    public ErrorConexionNegocioException(Throwable throwable, HttpStatus codigo) {
        super(throwable);
        this.throwable = throwable;
        this.codigo = codigo;
        this.mensajeDebug = "Exception: "+throwable.getClass().getName()+", cause: "+throwable.getCause() +", message "+throwable.getMessage();
    }

    public ErrorConexionNegocioException(Throwable throwable, HttpStatus codigo, String mensajeDebug) {
        super(throwable);
        this.throwable = throwable;
        this.codigo = codigo;
        this.mensajeDebug = mensajeDebug;
    }

}
