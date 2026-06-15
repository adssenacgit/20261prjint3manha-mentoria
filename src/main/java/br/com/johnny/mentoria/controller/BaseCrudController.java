package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.service.BaseCrudService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseCrudController<ID, Req, Res> {

    private final BaseCrudService<?, ID, Req, Res> service;

    protected BaseCrudController(BaseCrudService<?, ID, Req, Res> service) {
        this.service = service;
    }

    @GetMapping
    public List<Res> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Res findById(@PathVariable ID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Res create(@Valid @RequestBody Req request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public Res update(@PathVariable ID id, @Valid @RequestBody Req request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
