package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.PublicacaoTecnologia;
import br.com.johnny.mentoria.id.PublicacaoTecnologiaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacaoTecnologiaRepository extends JpaRepository<PublicacaoTecnologia, PublicacaoTecnologiaId> {
}
