package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
}
