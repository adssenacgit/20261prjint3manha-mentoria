package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.MentorRequest;
import br.com.johnny.mentoria.dto.MentorResponse;
import br.com.johnny.mentoria.entity.Mentor;
import br.com.johnny.mentoria.entity.Usuario;
import br.com.johnny.mentoria.repository.MentorRepository;
import br.com.johnny.mentoria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class MentorService extends BaseCrudService<Mentor, Integer, MentorRequest, MentorResponse> {

    private final UsuarioRepository usuarioRepository;
    private final ReferenceService referenceService;

    public MentorService(MentorRepository repository, UsuarioRepository usuarioRepository, ReferenceService referenceService) {
        super(repository, "Mentor");
        this.usuarioRepository = usuarioRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected Mentor toEntity(MentorRequest request) {
        Mentor mentor = new Mentor();
        apply(mentor, request);
        return mentor;
    }

    @Override
    protected void updateEntity(Mentor entity, MentorRequest request) {
        apply(entity, request);
    }

    private void apply(Mentor mentor, MentorRequest request) {
        Usuario usuario = referenceService.getRequired(usuarioRepository, request.usuarioId(), "Usuário");
        mentor.setUsuario(usuario);
        mentor.setDescricao(request.descricao());
        mentor.setPrecoHora(request.precoHora());
        mentor.setMediaAvaliacao(request.mediaAvaliacao());
        mentor.setOnboardingConcluido(request.onboardingConcluido());
        if (request.status() != null) mentor.setStatus(request.status());
    }

    @Override
    protected MentorResponse toResponse(Mentor mentor) {
        return new MentorResponse(mentor.getUsuarioId(), mentor.getDescricao(), mentor.getPrecoHora(), mentor.getMediaAvaliacao(), mentor.getOnboardingConcluido(), mentor.getStatus());
    }
}
