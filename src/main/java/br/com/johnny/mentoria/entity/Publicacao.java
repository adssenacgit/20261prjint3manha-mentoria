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
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "publicacao")
public class Publicacao implements SoftDeletable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publicacao_id")
    private Integer id;

    @Column(name = "publicacao_titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "publicacao_conteudo", columnDefinition = "TEXT")
    private String conteudo;

    @Column(name = "publicacao_orcamento_min", nullable = false, precision = 10, scale = 2)
    private BigDecimal orcamentoMin = BigDecimal.ZERO;

    @Column(name = "publicacao_orcamento_max", nullable = false, precision = 10, scale = 2)
    private BigDecimal orcamentoMax = BigDecimal.ZERO;

    @Column(name = "publicacao_data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Cliente cliente;

    @Column(name = "publicacao_status", nullable = false)
    private Byte status = StatusConstants.ATIVO;

    @PrePersist
    public void prePersist() {
        if (dataCriacao == null) {
            dataCriacao = LocalDateTime.now();
        }
        if (orcamentoMin == null) {
            orcamentoMin = BigDecimal.ZERO;
        }
        if (orcamentoMax == null) {
            orcamentoMax = BigDecimal.ZERO;
        }
        status = StatusConstants.normalizar(status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public BigDecimal getOrcamentoMin() {
        return orcamentoMin;
    }

    public void setOrcamentoMin(BigDecimal orcamentoMin) {
        this.orcamentoMin = orcamentoMin;
    }

    public BigDecimal getOrcamentoMax() {
        return orcamentoMax;
    }

    public void setOrcamentoMax(BigDecimal orcamentoMax) {
        this.orcamentoMax = orcamentoMax;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
