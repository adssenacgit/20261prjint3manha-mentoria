package br.com.johnny.mentoria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento implements SoftDeletable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagamento_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resposta_publicacao_id", nullable = false)
    private RespostaPublicacao respostaPublicacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pagamento_id", nullable = false)
    private MetodoPagamento metodoPagamento;

    @Column(name = "pagamento_status", nullable = false)
    private Byte status = StatusConstants.ATIVO;

    @PrePersist
    public void prePersist() {
        status = StatusConstants.normalizar(status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RespostaPublicacao getRespostaPublicacao() {
        return respostaPublicacao;
    }

    public void setRespostaPublicacao(RespostaPublicacao respostaPublicacao) {
        this.respostaPublicacao = respostaPublicacao;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    @Override
    public Byte getStatus() {
        return status;
    }

    @Override
    public void setStatus(Byte status) {
        this.status = status;
    }
}
