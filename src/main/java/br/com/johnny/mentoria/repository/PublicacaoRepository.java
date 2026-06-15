package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer> {
}
