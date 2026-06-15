package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
