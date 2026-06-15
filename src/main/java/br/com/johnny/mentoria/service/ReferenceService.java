package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.entity.SoftDeletable;
import br.com.johnny.mentoria.entity.StatusConstants;
import br.com.johnny.mentoria.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReferenceService {

    public <T extends SoftDeletable, ID> T getRequired(JpaRepository<T, ID> repository, ID id, String resourceName) {
        return repository.findById(id)
                .filter(StatusConstants::naoApagado)
                .orElseThrow(() -> new ResourceNotFoundException(resourceName + " não encontrado(a): " + id));
    }
}
