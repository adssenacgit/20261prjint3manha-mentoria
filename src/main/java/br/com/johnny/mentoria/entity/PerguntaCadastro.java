package br.com.johnny.mentoria.entity;

import br.com.johnny.mentoria.enums.PerguntaCadastroTipo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "pergunta_cadastro")
public class PerguntaCadastro implements SoftDeletable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pergunta_cadastro_id")
    private Integer id;

    @Column(name = "pergunta_cadastro_enunciado", nullable = false, length = 200)
    private String enunciado;

    @Enumerated(EnumType.STRING)
    @Column(name = "pergunta_cadastro_tipo", nullable = false, columnDefinition = "ENUM('texto', 'multipla_escolha')")
    private PerguntaCadastroTipo tipo;

    @Column(name = "pergunta_cadastro_status", nullable = false)
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

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public PerguntaCadastroTipo getTipo() {
        return tipo;
    }

    public void setTipo(PerguntaCadastroTipo tipo) {
        this.tipo = tipo;
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
