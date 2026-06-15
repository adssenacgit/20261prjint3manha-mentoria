package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.RespostaPublicacaoRequest;
import br.com.johnny.mentoria.dto.RespostaPublicacaoResponse;
import br.com.johnny.mentoria.entity.Mentor;
import br.com.johnny.mentoria.entity.Publicacao;
import br.com.johnny.mentoria.entity.RespostaPublicacao;
import br.com.johnny.mentoria.repository.MentorRepository;
import br.com.johnny.mentoria.repository.PublicacaoRepository;
import br.com.johnny.mentoria.repository.RespostaPublicacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class RespostaPublicacaoService extends BaseCrudService<RespostaPublicacao, Integer, RespostaPublicacaoRequest, RespostaPublicacaoResponse> {

    private final MentorRepository mentorRepository;
    private final PublicacaoRepository publicacaoRepository;
    private final ReferenceService referenceService;

    public RespostaPublicacaoService(RespostaPublicacaoRepository repository, MentorRepository mentorRepository,
                                     PublicacaoRepository publicacaoRepository, ReferenceService referenceService) {
        super(repository, "Resposta de publicação");
        this.mentorRepository = mentorRepository;
        this.publicacaoRepository = publicacaoRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected RespostaPublicacao toEntity(RespostaPublicacaoRequest request) {
        RespostaPublicacao resposta = new RespostaPublicacao();
        apply(resposta, request);
        return resposta;
    }

    @Override
    protected void updateEntity(RespostaPublicacao entity, RespostaPublicacaoRequest request) {
        apply(entity, request);
    }

    private void apply(RespostaPublicacao resposta, RespostaPublicacaoRequest request) {
        Mentor mentor = referenceService.getRequired(mentorRepository, request.usuarioId(), "Mentor");
        Publicacao publicacao = referenceService.getRequired(publicacaoRepository, request.publicacaoId(), "Publicação");
        resposta.setMentor(mentor);
        resposta.setPublicacao(publicacao);
        resposta.setConteudo(request.conteudo());
        if (request.status() != null) resposta.setStatus(request.status());
    }

    @Override
    protected RespostaPublicacaoResponse toResponse(RespostaPublicacao entity) {
        return new RespostaPublicacaoResponse(entity.getId(), entity.getConteudo(), entity.getMentor().getUsuarioId(),
                entity.getPublicacao().getId(), entity.getStatus());
    }
}
