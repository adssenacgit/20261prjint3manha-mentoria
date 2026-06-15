package br.com.johnny.mentoria.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PublicacaoTecnologiaId implements Serializable {

    @Column(name = "publicacao_id")
    private Integer publicacaoId;

    @Column(name = "tecnologia_id")
    private Integer tecnologiaId;

    public PublicacaoTecnologiaId() {
    }

    public PublicacaoTecnologiaId(Integer publicacaoId, Integer tecnologiaId) {
        this.publicacaoId = publicacaoId;
        this.tecnologiaId = tecnologiaId;
    }

    public Integer getPublicacaoId() {
        return publicacaoId;
    }

    public void setPublicacaoId(Integer publicacaoId) {
        this.publicacaoId = publicacaoId;
    }

    public Integer getTecnologiaId() {
        return tecnologiaId;
    }

    public void setTecnologiaId(Integer tecnologiaId) {
        this.tecnologiaId = tecnologiaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublicacaoTecnologiaId that)) return false;
        return Objects.equals(publicacaoId, that.publicacaoId) && Objects.equals(tecnologiaId, that.tecnologiaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicacaoId, tecnologiaId);
    }
}
