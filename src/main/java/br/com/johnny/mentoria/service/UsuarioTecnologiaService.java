package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.UsuarioTecnologiaRequest;
import br.com.johnny.mentoria.dto.UsuarioTecnologiaResponse;
import br.com.johnny.mentoria.entity.Tecnologia;
import br.com.johnny.mentoria.entity.Usuario;
import br.com.johnny.mentoria.entity.UsuarioTecnologia;
import br.com.johnny.mentoria.id.UsuarioTecnologiaId;
import br.com.johnny.mentoria.repository.TecnologiaRepository;
import br.com.johnny.mentoria.repository.UsuarioRepository;
import br.com.johnny.mentoria.repository.UsuarioTecnologiaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioTecnologiaService extends BaseCrudService<UsuarioTecnologia, UsuarioTecnologiaId, UsuarioTecnologiaRequest, UsuarioTecnologiaResponse> {

    private final UsuarioRepository usuarioRepository;
    private final TecnologiaRepository tecnologiaRepository;
    private final ReferenceService referenceService;

    public UsuarioTecnologiaService(UsuarioTecnologiaRepository repository, UsuarioRepository usuarioRepository,
                                    TecnologiaRepository tecnologiaRepository, ReferenceService referenceService) {
        super(repository, "Usuário tecnologia");
        this.usuarioRepository = usuarioRepository;
        this.tecnologiaRepository = tecnologiaRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected UsuarioTecnologia toEntity(UsuarioTecnologiaRequest request) {
        UsuarioTecnologia usuarioTecnologia = new UsuarioTecnologia();
        Usuario usuario = referenceService.getRequired(usuarioRepository, request.usuarioId(), "Usuário");
        Tecnologia tecnologia = referenceService.getRequired(tecnologiaRepository, request.tecnologiaId(), "Tecnologia");
        usuarioTecnologia.setId(new UsuarioTecnologiaId(request.usuarioId(), request.tecnologiaId()));
        usuarioTecnologia.setUsuario(usuario);
        usuarioTecnologia.setTecnologia(tecnologia);
        if (request.status() != null) usuarioTecnologia.setStatus(request.status());
        return usuarioTecnologia;
    }

    @Override
    protected void updateEntity(UsuarioTecnologia entity, UsuarioTecnologiaRequest request) {
        if (request.status() != null) entity.setStatus(request.status());
    }

    @Override
    protected UsuarioTecnologiaResponse toResponse(UsuarioTecnologia entity) {
        return new UsuarioTecnologiaResponse(entity.getId().getUsuarioId(), entity.getId().getTecnologiaId(), entity.getStatus());
    }
}
