package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.PerguntaCadastroRequest;
import br.com.johnny.mentoria.dto.PerguntaCadastroResponse;
import br.com.johnny.mentoria.entity.PerguntaCadastro;
import br.com.johnny.mentoria.repository.PerguntaCadastroRepository;
import org.springframework.stereotype.Service;

@Service
public class PerguntaCadastroService extends BaseCrudService<PerguntaCadastro, Integer, PerguntaCadastroRequest, PerguntaCadastroResponse> {

    public PerguntaCadastroService(PerguntaCadastroRepository repository) {
        super(repository, "Pergunta de cadastro");
    }

    @Override
    protected PerguntaCadastro toEntity(PerguntaCadastroRequest request) {
        PerguntaCadastro pergunta = new PerguntaCadastro();
        apply(pergunta, request);
        return pergunta;
    }

    @Override
    protected void updateEntity(PerguntaCadastro entity, PerguntaCadastroRequest request) {
        apply(entity, request);
    }

    private void apply(PerguntaCadastro pergunta, PerguntaCadastroRequest request) {
        pergunta.setEnunciado(request.enunciado());
        pergunta.setTipo(request.tipo());
        if (request.status() != null) pergunta.setStatus(request.status());
    }

    @Override
    protected PerguntaCadastroResponse toResponse(PerguntaCadastro pergunta) {
        return new PerguntaCadastroResponse(pergunta.getId(), pergunta.getEnunciado(), pergunta.getTipo(), pergunta.getStatus());
    }
}
