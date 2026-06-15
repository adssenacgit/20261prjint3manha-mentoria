package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.AvaliacaoRequest;
import br.com.johnny.mentoria.dto.AvaliacaoResponse;
import br.com.johnny.mentoria.entity.Avaliacao;
import br.com.johnny.mentoria.entity.Cliente;
import br.com.johnny.mentoria.entity.Mentor;
import br.com.johnny.mentoria.entity.Publicacao;
import br.com.johnny.mentoria.repository.AvaliacaoRepository;
import br.com.johnny.mentoria.repository.ClienteRepository;
import br.com.johnny.mentoria.repository.MentorRepository;
import br.com.johnny.mentoria.repository.PublicacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService extends BaseCrudService<Avaliacao, Integer, AvaliacaoRequest, AvaliacaoResponse> {

    private final ClienteRepository clienteRepository;
    private final MentorRepository mentorRepository;
    private final PublicacaoRepository publicacaoRepository;
    private final ReferenceService referenceService;

    public AvaliacaoService(AvaliacaoRepository repository, ClienteRepository clienteRepository, MentorRepository mentorRepository,
                            PublicacaoRepository publicacaoRepository, ReferenceService referenceService) {
        super(repository, "Avaliação");
        this.clienteRepository = clienteRepository;
        this.mentorRepository = mentorRepository;
        this.publicacaoRepository = publicacaoRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected Avaliacao toEntity(AvaliacaoRequest request) {
        Avaliacao avaliacao = new Avaliacao();
        apply(avaliacao, request);
        return avaliacao;
    }

    @Override
    protected void updateEntity(Avaliacao entity, AvaliacaoRequest request) {
        apply(entity, request);
    }

    private void apply(Avaliacao avaliacao, AvaliacaoRequest request) {
        Cliente cliente = referenceService.getRequired(clienteRepository, request.clienteUsuarioId(), "Cliente");
        Mentor mentor = referenceService.getRequired(mentorRepository, request.mentorUsuarioId(), "Mentor");
        Publicacao publicacao = referenceService.getRequired(publicacaoRepository, request.publicacaoId(), "Publicação");
        avaliacao.setCliente(cliente);
        avaliacao.setMentor(mentor);
        avaliacao.setPublicacao(publicacao);
        avaliacao.setValor(request.valor());
        avaliacao.setComentario(request.comentario());
        if (request.status() != null) avaliacao.setStatus(request.status());
    }

    @Override
    protected AvaliacaoResponse toResponse(Avaliacao avaliacao) {
        return new AvaliacaoResponse(avaliacao.getId(), avaliacao.getCliente().getUsuarioId(), avaliacao.getMentor().getUsuarioId(),
                avaliacao.getValor(), avaliacao.getComentario(), avaliacao.getPublicacao().getId(), avaliacao.getStatus());
    }
}
