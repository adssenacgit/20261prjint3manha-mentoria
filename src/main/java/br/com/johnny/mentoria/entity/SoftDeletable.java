package br.com.johnny.mentoria.entity;

public interface SoftDeletable {
    Byte getStatus();
    void setStatus(Byte status);
}
