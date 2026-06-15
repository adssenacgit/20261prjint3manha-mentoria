package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.entity.SoftDeletable;
import br.com.johnny.mentoria.entity.StatusConstants;
import br.com.johnny.mentoria.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseCrudService<T extends SoftDeletable, ID, Req, Res> {

    private final JpaRepository<T, ID> repository;
    private final String resourceName;

    protected BaseCrudService(JpaRepository<T, ID> repository, String resourceName) {
        this.repository = repository;
        this.resourceName = resourceName;
    }

    @Transactional(readOnly = true)
    public List<Res> findAll() {
        return repository.findAll()
                .stream()
                .filter(StatusConstants::naoApagado)
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public Res findById(ID id) {
        return toResponse(getExistingEntity(id));
    }

    @Transactional
    public Res create(Req request) {
        T entity = toEntity(request);
        entity.setStatus(StatusConstants.normalizar(entity.getStatus()));
        return toResponse(repository.save(entity));
    }

    @Transactional
    public Res update(ID id, Req request) {
        T entity = getExistingEntity(id);
        updateEntity(entity, request);
        entity.setStatus(StatusConstants.normalizar(entity.getStatus()));
        return toResponse(repository.save(entity));
    }

    @Transactional
    public void delete(ID id) {
        T entity = getExistingEntity(id);
        entity.setStatus(StatusConstants.APAGADO);
        repository.save(entity);
    }

    protected T getExistingEntity(ID id) {
        return repository.findById(id)
                .filter(StatusConstants::naoApagado)
                .orElseThrow(() -> new ResourceNotFoundException(resourceName + " não encontrado(a): " + id));
    }

    protected abstract T toEntity(Req request);

    protected abstract void updateEntity(T entity, Req request);

    protected abstract Res toResponse(T entity);
}
