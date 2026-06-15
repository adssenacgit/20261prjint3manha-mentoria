package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnologiaRepository extends JpaRepository<Tecnologia, Integer> {
}
