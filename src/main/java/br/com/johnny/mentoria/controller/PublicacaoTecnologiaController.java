package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.PublicacaoTecnologiaRequest;
import br.com.johnny.mentoria.dto.PublicacaoTecnologiaResponse;
import br.com.johnny.mentoria.id.PublicacaoTecnologiaId;
import br.com.johnny.mentoria.service.PublicacaoTecnologiaService;
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
@RequestMapping("/api/publicacoes-tecnologias")
@Tag(name = "Publicações tecnologias")
@CrossOrigin("*")    
public class PublicacaoTecnologiaController {

    private final PublicacaoTecnologiaService service;

    public PublicacaoTecnologiaController(PublicacaoTecnologiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<PublicacaoTecnologiaResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{publicacaoId}/{tecnologiaId}")
    public PublicacaoTecnologiaResponse findById(@PathVariable Integer publicacaoId, @PathVariable Integer tecnologiaId) {
        return service.findById(new PublicacaoTecnologiaId(publicacaoId, tecnologiaId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublicacaoTecnologiaResponse create(@Valid @RequestBody PublicacaoTecnologiaRequest request) {
        return service.create(request);
    }

    @PutMapping("/{publicacaoId}/{tecnologiaId}")
    public PublicacaoTecnologiaResponse update(@PathVariable Integer publicacaoId, @PathVariable Integer tecnologiaId,
                                               @Valid @RequestBody PublicacaoTecnologiaRequest request) {
        return service.update(new PublicacaoTecnologiaId(publicacaoId, tecnologiaId), request);
    }

    @DeleteMapping("/{publicacaoId}/{tecnologiaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer publicacaoId, @PathVariable Integer tecnologiaId) {
        service.delete(new PublicacaoTecnologiaId(publicacaoId, tecnologiaId));
    }
}
