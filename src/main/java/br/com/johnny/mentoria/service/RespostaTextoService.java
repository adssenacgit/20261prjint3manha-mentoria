package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.RespostaTextoRequest;
import br.com.johnny.mentoria.dto.RespostaTextoResponse;
import br.com.johnny.mentoria.entity.Cliente;
import br.com.johnny.mentoria.entity.PerguntaCadastro;
import br.com.johnny.mentoria.entity.RespostaTexto;
import br.com.johnny.mentoria.repository.ClienteRepository;
import br.com.johnny.mentoria.repository.PerguntaCadastroRepository;
import br.com.johnny.mentoria.repository.RespostaTextoRepository;
import org.springframework.stereotype.Service;

@Service
public class RespostaTextoService extends BaseCrudService<RespostaTexto, Integer, RespostaTextoRequest, RespostaTextoResponse> {

    private final ClienteRepository clienteRepository;
    private final PerguntaCadastroRepository perguntaCadastroRepository;
    private final ReferenceService referenceService;

    public RespostaTextoService(RespostaTextoRepository repository, ClienteRepository clienteRepository,
                                PerguntaCadastroRepository perguntaCadastroRepository, ReferenceService referenceService) {
        super(repository, "Resposta de texto");
        this.clienteRepository = clienteRepository;
        this.perguntaCadastroRepository = perguntaCadastroRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected RespostaTexto toEntity(RespostaTextoRequest request) {
        RespostaTexto resposta = new RespostaTexto();
        apply(resposta, request);
        return resposta;
    }

    @Override
    protected void updateEntity(RespostaTexto entity, RespostaTextoRequest request) {
        apply(entity, request);
    }

    private void apply(RespostaTexto resposta, RespostaTextoRequest request) {
        Cliente cliente = referenceService.getRequired(clienteRepository, request.clienteUsuarioId(), "Cliente");
        PerguntaCadastro pergunta = referenceService.getRequired(perguntaCadastroRepository, request.perguntaCadastroId(), "Pergunta de cadastro");
        resposta.setCliente(cliente);
        resposta.setPerguntaCadastro(pergunta);
        resposta.setConteudo(request.conteudo());
        if (request.status() != null) resposta.setStatus(request.status());
    }

    @Override
    protected RespostaTextoResponse toResponse(RespostaTexto resposta) {
        return new RespostaTextoResponse(resposta.getId(), resposta.getCliente().getUsuarioId(), resposta.getPerguntaCadastro().getId(),
                resposta.getConteudo(), resposta.getStatus());
    }
}
