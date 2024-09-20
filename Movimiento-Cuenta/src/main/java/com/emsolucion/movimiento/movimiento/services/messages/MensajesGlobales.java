package com.emsolucion.movimiento.movimiento.services.messages;

public abstract class MensajesGlobales {
    public static final String MSG_ERROR_ID_INVALIDO = "El identificador es inválido";
    public static final String MSG_ERROR_CUENTA_REQUERIDA = "La cuenta es requerida";
    public static final String MSG_ERROR_SALDO_REQUERIDO = "La saldo es requerido";
    public static final String MSG_ERROR_VALOR_REQUERIDO = "El valor es requerido";
    public static final String MSG_ERROR_TIPO_REQUERIDO = "El tipo es requerido";
    public static final String MSG_ERROR_FECHA_REQUERIDA = "El fecha es requerida";
    public static final String MSG_ERROR_SALDO_INVALIDO = "El saldo no es disponible";
    public static final String MSG_ERROR_FECHA_INVALIDA = "El fecha final no es válida";

    private MensajesGlobales() {
    }
}
