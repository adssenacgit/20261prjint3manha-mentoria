package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.RespostaOpcaoRequest;
import br.com.johnny.mentoria.dto.RespostaOpcaoResponse;
import br.com.johnny.mentoria.entity.Cliente;
import br.com.johnny.mentoria.entity.OpcaoPergunta;
import br.com.johnny.mentoria.entity.RespostaOpcao;
import br.com.johnny.mentoria.repository.ClienteRepository;
import br.com.johnny.mentoria.repository.OpcaoPerguntaRepository;
import br.com.johnny.mentoria.repository.RespostaOpcaoRepository;
import org.springframework.stereotype.Service;

@Service
public class RespostaOpcaoService extends BaseCrudService<RespostaOpcao, Integer, RespostaOpcaoRequest, RespostaOpcaoResponse> {

    private final ClienteRepository clienteRepository;
    private final OpcaoPerguntaRepository opcaoPerguntaRepository;
    private final ReferenceService referenceService;

    public RespostaOpcaoService(RespostaOpcaoRepository repository, ClienteRepository clienteRepository,
                                OpcaoPerguntaRepository opcaoPerguntaRepository, ReferenceService referenceService) {
        super(repository, "Resposta de opção");
        this.clienteRepository = clienteRepository;
        this.opcaoPerguntaRepository = opcaoPerguntaRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected RespostaOpcao toEntity(RespostaOpcaoRequest request) {
        RespostaOpcao resposta = new RespostaOpcao();
        apply(resposta, request);
        return resposta;
    }

    @Override
    protected void updateEntity(RespostaOpcao entity, RespostaOpcaoRequest request) {
        apply(entity, request);
    }

    private void apply(RespostaOpcao resposta, RespostaOpcaoRequest request) {
        Cliente cliente = referenceService.getRequired(clienteRepository, request.clienteUsuarioId(), "Cliente");
        OpcaoPergunta opcao = referenceService.getRequired(opcaoPerguntaRepository, request.opcaoPerguntaId(), "Opção de pergunta");
        resposta.setCliente(cliente);
        resposta.setOpcaoPergunta(opcao);
        if (request.status() != null) resposta.setStatus(request.status());
    }

    @Override
    protected RespostaOpcaoResponse toResponse(RespostaOpcao resposta) {
        return new RespostaOpcaoResponse(resposta.getId(), resposta.getCliente().getUsuarioId(), resposta.getOpcaoPergunta().getId(), resposta.getStatus());
    }
}
