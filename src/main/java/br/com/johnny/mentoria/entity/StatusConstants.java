package br.com.johnny.mentoria.entity;

public final class StatusConstants {

    public static final byte APAGADO = -1;
    public static final byte INATIVO = 0;
    public static final byte ATIVO = 1;

    private StatusConstants() {
    }

    public static byte normalizar(Byte status) {
        return status == null ? ATIVO : status;
    }

    public static boolean naoApagado(SoftDeletable entity) {
        return entity != null && entity.getStatus() != null && entity.getStatus() != APAGADO;
    }
}
