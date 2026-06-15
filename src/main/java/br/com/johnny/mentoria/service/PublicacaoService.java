package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.PublicacaoRequest;
import br.com.johnny.mentoria.dto.PublicacaoResponse;
import br.com.johnny.mentoria.entity.Cliente;
import br.com.johnny.mentoria.entity.Publicacao;
import br.com.johnny.mentoria.repository.ClienteRepository;
import br.com.johnny.mentoria.repository.PublicacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicacaoService extends BaseCrudService<Publicacao, Integer, PublicacaoRequest, PublicacaoResponse> {

    private final ClienteRepository clienteRepository;
    private final ReferenceService referenceService;

    public PublicacaoService(PublicacaoRepository repository, ClienteRepository clienteRepository, ReferenceService referenceService) {
        super(repository, "Publicação");
        this.clienteRepository = clienteRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected Publicacao toEntity(PublicacaoRequest request) {
        Publicacao publicacao = new Publicacao();
        apply(publicacao, request);
        return publicacao;
    }

    @Override
    protected void updateEntity(Publicacao entity, PublicacaoRequest request) {
        apply(entity, request);
    }

    private void apply(Publicacao publicacao, PublicacaoRequest request) {
        Cliente cliente = referenceService.getRequired(clienteRepository, request.usuarioId(), "Cliente");
        publicacao.setCliente(cliente);
        publicacao.setTitulo(request.titulo());
        publicacao.setConteudo(request.conteudo());
        publicacao.setOrcamentoMin(request.orcamentoMin());
        publicacao.setOrcamentoMax(request.orcamentoMax());
        publicacao.setDataCriacao(request.dataCriacao());
        if (request.status() != null) publicacao.setStatus(request.status());
    }

    @Override
    protected PublicacaoResponse toResponse(Publicacao publicacao) {
        return new PublicacaoResponse(publicacao.getId(), publicacao.getTitulo(), publicacao.getConteudo(),
                publicacao.getOrcamentoMin(), publicacao.getOrcamentoMax(), publicacao.getDataCriacao(),
                publicacao.getCliente().getUsuarioId(), publicacao.getStatus());
    }
}
