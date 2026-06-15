package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.OpcaoPerguntaRequest;
import br.com.johnny.mentoria.dto.OpcaoPerguntaResponse;
import br.com.johnny.mentoria.entity.OpcaoPergunta;
import br.com.johnny.mentoria.entity.PerguntaCadastro;
import br.com.johnny.mentoria.repository.OpcaoPerguntaRepository;
import br.com.johnny.mentoria.repository.PerguntaCadastroRepository;
import org.springframework.stereotype.Service;

@Service
public class OpcaoPerguntaService extends BaseCrudService<OpcaoPergunta, Integer, OpcaoPerguntaRequest, OpcaoPerguntaResponse> {

    private final PerguntaCadastroRepository perguntaCadastroRepository;
    private final ReferenceService referenceService;

    public OpcaoPerguntaService(OpcaoPerguntaRepository repository, PerguntaCadastroRepository perguntaCadastroRepository,
                                ReferenceService referenceService) {
        super(repository, "Opção de pergunta");
        this.perguntaCadastroRepository = perguntaCadastroRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected OpcaoPergunta toEntity(OpcaoPerguntaRequest request) {
        OpcaoPergunta opcao = new OpcaoPergunta();
        apply(opcao, request);
        return opcao;
    }

    @Override
    protected void updateEntity(OpcaoPergunta entity, OpcaoPerguntaRequest request) {
        apply(entity, request);
    }

    private void apply(OpcaoPergunta opcao, OpcaoPerguntaRequest request) {
        PerguntaCadastro pergunta = referenceService.getRequired(perguntaCadastroRepository, request.perguntaCadastroId(), "Pergunta de cadastro");
        opcao.setPerguntaCadastro(pergunta);
        opcao.setDescricao(request.descricao());
        if (request.status() != null) opcao.setStatus(request.status());
    }

    @Override
    protected OpcaoPerguntaResponse toResponse(OpcaoPergunta opcao) {
        return new OpcaoPerguntaResponse(opcao.getId(), opcao.getPerguntaCadastro().getId(), opcao.getDescricao(), opcao.getStatus());
    }
}
