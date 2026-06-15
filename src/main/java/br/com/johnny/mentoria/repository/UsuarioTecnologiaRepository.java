package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.UsuarioTecnologia;
import br.com.johnny.mentoria.id.UsuarioTecnologiaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioTecnologiaRepository extends JpaRepository<UsuarioTecnologia, UsuarioTecnologiaId> {
}
