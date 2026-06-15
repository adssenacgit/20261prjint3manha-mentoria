package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.PagamentoRequest;
import br.com.johnny.mentoria.dto.PagamentoResponse;
import br.com.johnny.mentoria.entity.MetodoPagamento;
import br.com.johnny.mentoria.entity.Pagamento;
import br.com.johnny.mentoria.entity.RespostaPublicacao;
import br.com.johnny.mentoria.repository.MetodoPagamentoRepository;
import br.com.johnny.mentoria.repository.PagamentoRepository;
import br.com.johnny.mentoria.repository.RespostaPublicacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService extends BaseCrudService<Pagamento, Integer, PagamentoRequest, PagamentoResponse> {

    private final RespostaPublicacaoRepository respostaPublicacaoRepository;
    private final MetodoPagamentoRepository metodoPagamentoRepository;
    private final ReferenceService referenceService;

    public PagamentoService(PagamentoRepository repository, RespostaPublicacaoRepository respostaPublicacaoRepository,
                            MetodoPagamentoRepository metodoPagamentoRepository, ReferenceService referenceService) {
        super(repository, "Pagamento");
        this.respostaPublicacaoRepository = respostaPublicacaoRepository;
        this.metodoPagamentoRepository = metodoPagamentoRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected Pagamento toEntity(PagamentoRequest request) {
        Pagamento pagamento = new Pagamento();
        apply(pagamento, request);
        return pagamento;
    }

    @Override
    protected void updateEntity(Pagamento entity, PagamentoRequest request) {
        apply(entity, request);
    }

    private void apply(Pagamento pagamento, PagamentoRequest request) {
        RespostaPublicacao resposta = referenceService.getRequired(respostaPublicacaoRepository, request.respostaPublicacaoId(), "Resposta de publicação");
        MetodoPagamento metodo = referenceService.getRequired(metodoPagamentoRepository, request.metodoPagamentoId(), "Método de pagamento");
        pagamento.setRespostaPublicacao(resposta);
        pagamento.setMetodoPagamento(metodo);
        if (request.status() != null) pagamento.setStatus(request.status());
    }

    @Override
    protected PagamentoResponse toResponse(Pagamento pagamento) {
        return new PagamentoResponse(pagamento.getId(), pagamento.getRespostaPublicacao().getId(), pagamento.getMetodoPagamento().getId(), pagamento.getStatus());
    }
}
