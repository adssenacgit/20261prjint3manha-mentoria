package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.MetodoPagamentoRequest;
import br.com.johnny.mentoria.dto.MetodoPagamentoResponse;
import br.com.johnny.mentoria.entity.MetodoPagamento;
import br.com.johnny.mentoria.repository.MetodoPagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagamentoService extends BaseCrudService<MetodoPagamento, Integer, MetodoPagamentoRequest, MetodoPagamentoResponse> {

    public MetodoPagamentoService(MetodoPagamentoRepository repository) {
        super(repository, "Método de pagamento");
    }

    @Override
    protected MetodoPagamento toEntity(MetodoPagamentoRequest request) {
        MetodoPagamento metodo = new MetodoPagamento();
        apply(metodo, request);
        return metodo;
    }

    @Override
    protected void updateEntity(MetodoPagamento entity, MetodoPagamentoRequest request) {
        apply(entity, request);
    }

    private void apply(MetodoPagamento metodo, MetodoPagamentoRequest request) {
        metodo.setDescricao(request.descricao());
        if (request.status() != null) metodo.setStatus(request.status());
    }

    @Override
    protected MetodoPagamentoResponse toResponse(MetodoPagamento metodo) {
        return new MetodoPagamentoResponse(metodo.getId(), metodo.getDescricao(), metodo.getStatus());
    }
}
