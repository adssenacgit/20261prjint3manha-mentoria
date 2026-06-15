package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.TecnologiaRequest;
import br.com.johnny.mentoria.dto.TecnologiaResponse;
import br.com.johnny.mentoria.entity.Tecnologia;
import br.com.johnny.mentoria.repository.TecnologiaRepository;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService extends BaseCrudService<Tecnologia, Integer, TecnologiaRequest, TecnologiaResponse> {

    public TecnologiaService(TecnologiaRepository repository) {
        super(repository, "Tecnologia");
    }

    @Override
    protected Tecnologia toEntity(TecnologiaRequest request) {
        Tecnologia tecnologia = new Tecnologia();
        apply(tecnologia, request);
        return tecnologia;
    }

    @Override
    protected void updateEntity(Tecnologia entity, TecnologiaRequest request) {
        apply(entity, request);
    }

    private void apply(Tecnologia tecnologia, TecnologiaRequest request) {
        tecnologia.setNome(request.nome());
        if (request.status() != null) tecnologia.setStatus(request.status());
    }

    @Override
    protected TecnologiaResponse toResponse(Tecnologia tecnologia) {
        return new TecnologiaResponse(tecnologia.getId(), tecnologia.getNome(), tecnologia.getStatus());
    }
}
