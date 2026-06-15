package br.com.johnny.mentoria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario implements SoftDeletable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;

    @Column(name = "usuario_nome", length = 45)
    private String nome;

    @Column(name = "usuario_email", length = 45, unique = true)
    private String email;

    @Column(name = "usuario_senha", length = 45)
    private String senha;

    @Column(name = "usuario_tipo_usuario")
    private Integer tipoUsuario;

    @Column(name = "usuario_data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "usuario_status", nullable = false)
    private Byte status = StatusConstants.ATIVO;

    @PrePersist
    public void prePersist() {
        if (dataCadastro == null) {
            dataCadastro = LocalDate.now();
        }
        status = StatusConstants.normalizar(status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
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
