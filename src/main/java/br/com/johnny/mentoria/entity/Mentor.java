package br.com.johnny.mentoria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "mentor")
public class Mentor implements SoftDeletable {

    @Id
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "mentor_descricao", length = 200)
    private String descricao;

    @Column(name = "mentor_preco_hora")
    private Double precoHora;

    @Column(name = "mentor_media_avaliacao")
    private Double mediaAvaliacao;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "mentor_status", nullable = false)
    private Byte status = StatusConstants.ATIVO;

    @PrePersist
    public void prePersist() {
        status = StatusConstants.normalizar(status);
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }

    public Double getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    public void setMediaAvaliacao(Double mediaAvaliacao) {
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
