package br.com.johnny.mentoria.entity;

import br.com.johnny.mentoria.id.PublicacaoTecnologiaId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "publicacao_tecnologia")
public class PublicacaoTecnologia implements SoftDeletable {

    @EmbeddedId
    private PublicacaoTecnologiaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("publicacaoId")
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tecnologiaId")
    @JoinColumn(name = "tecnologia_id")
    private Tecnologia tecnologia;

    @Column(name = "publicacao_tecnologia_status", nullable = false)
    private Byte status = StatusConstants.ATIVO;

    @PrePersist
    public void prePersist() {
        status = StatusConstants.normalizar(status);
    }

    public PublicacaoTecnologiaId getId() {
        return id;
    }

    public void setId(PublicacaoTecnologiaId id) {
        this.id = id;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
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
