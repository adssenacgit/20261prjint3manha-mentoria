package br.com.johnny.mentoria.repository;

import br.com.johnny.mentoria.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
