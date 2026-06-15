package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
