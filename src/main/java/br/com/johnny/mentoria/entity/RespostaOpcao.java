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
@Table(name = "resposta_opcao")
public class RespostaOpcao implements SoftDeletable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resposta_opcao_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_usuario_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opcao_pergunta_id", nullable = false)
    private OpcaoPergunta opcaoPergunta;

    @Column(name = "resposta_opcao_status", nullable = false)
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public OpcaoPergunta getOpcaoPergunta() {
        return opcaoPergunta;
    }

    public void setOpcaoPergunta(OpcaoPergunta opcaoPergunta) {
        this.opcaoPergunta = opcaoPergunta;
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
