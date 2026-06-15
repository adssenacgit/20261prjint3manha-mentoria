package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.PublicacaoTecnologiaRequest;
import br.com.johnny.mentoria.dto.PublicacaoTecnologiaResponse;
import br.com.johnny.mentoria.entity.Publicacao;
import br.com.johnny.mentoria.entity.PublicacaoTecnologia;
import br.com.johnny.mentoria.entity.Tecnologia;
import br.com.johnny.mentoria.id.PublicacaoTecnologiaId;
import br.com.johnny.mentoria.repository.PublicacaoRepository;
import br.com.johnny.mentoria.repository.PublicacaoTecnologiaRepository;
import br.com.johnny.mentoria.repository.TecnologiaRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicacaoTecnologiaService extends BaseCrudService<PublicacaoTecnologia, PublicacaoTecnologiaId, PublicacaoTecnologiaRequest, PublicacaoTecnologiaResponse> {

    private final PublicacaoRepository publicacaoRepository;
    private final TecnologiaRepository tecnologiaRepository;
    private final ReferenceService referenceService;

    public PublicacaoTecnologiaService(PublicacaoTecnologiaRepository repository, PublicacaoRepository publicacaoRepository,
                                       TecnologiaRepository tecnologiaRepository, ReferenceService referenceService) {
        super(repository, "Publicação tecnologia");
        this.publicacaoRepository = publicacaoRepository;
        this.tecnologiaRepository = tecnologiaRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected PublicacaoTecnologia toEntity(PublicacaoTecnologiaRequest request) {
        Publicacao publicacao = referenceService.getRequired(publicacaoRepository, request.publicacaoId(), "Publicação");
        Tecnologia tecnologia = referenceService.getRequired(tecnologiaRepository, request.tecnologiaId(), "Tecnologia");
        PublicacaoTecnologia entity = new PublicacaoTecnologia();
        entity.setId(new PublicacaoTecnologiaId(request.publicacaoId(), request.tecnologiaId()));
        entity.setPublicacao(publicacao);
        entity.setTecnologia(tecnologia);
        if (request.status() != null) entity.setStatus(request.status());
        return entity;
    }

    @Override
    protected void updateEntity(PublicacaoTecnologia entity, PublicacaoTecnologiaRequest request) {
        if (request.status() != null) entity.setStatus(request.status());
    }

    @Override
    protected PublicacaoTecnologiaResponse toResponse(PublicacaoTecnologia entity) {
        return new PublicacaoTecnologiaResponse(entity.getId().getPublicacaoId(), entity.getId().getTecnologiaId(), entity.getStatus());
    }
}
