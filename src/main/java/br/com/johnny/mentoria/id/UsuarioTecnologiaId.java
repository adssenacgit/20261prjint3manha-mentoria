package br.com.johnny.mentoria.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioTecnologiaId implements Serializable {

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "tecnologia_id")
    private Integer tecnologiaId;

    public UsuarioTecnologiaId() {
    }

    public UsuarioTecnologiaId(Integer usuarioId, Integer tecnologiaId) {
        this.usuarioId = usuarioId;
        this.tecnologiaId = tecnologiaId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(o instanceof UsuarioTecnologiaId that)) return false;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(tecnologiaId, that.tecnologiaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, tecnologiaId);
    }
}
