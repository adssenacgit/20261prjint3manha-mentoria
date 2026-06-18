package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.UsuarioTecnologiaRequest;
import br.com.johnny.mentoria.dto.UsuarioTecnologiaResponse;
import br.com.johnny.mentoria.id.UsuarioTecnologiaId;
import br.com.johnny.mentoria.service.UsuarioTecnologiaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios-tecnologias")
@Tag(name = "Usuários tecnologias")
@CrossOrigin("*")    
public class UsuarioTecnologiaController {

    private final UsuarioTecnologiaService service;

    public UsuarioTecnologiaController(UsuarioTecnologiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioTecnologiaResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{usuarioId}/{tecnologiaId}")
    public UsuarioTecnologiaResponse findById(@PathVariable Integer usuarioId, @PathVariable Integer tecnologiaId) {
        return service.findById(new UsuarioTecnologiaId(usuarioId, tecnologiaId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioTecnologiaResponse create(@Valid @RequestBody UsuarioTecnologiaRequest request) {
        return service.create(request);
    }

    @PutMapping("/{usuarioId}/{tecnologiaId}")
    public UsuarioTecnologiaResponse update(@PathVariable Integer usuarioId, @PathVariable Integer tecnologiaId,
                                            @Valid @RequestBody UsuarioTecnologiaRequest request) {
        return service.update(new UsuarioTecnologiaId(usuarioId, tecnologiaId), request);
    }

    @DeleteMapping("/{usuarioId}/{tecnologiaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer usuarioId, @PathVariable Integer tecnologiaId) {
        service.delete(new UsuarioTecnologiaId(usuarioId, tecnologiaId));
    }
}
