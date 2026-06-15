package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.AvaliacaoRequest;
import br.com.johnny.mentoria.dto.AvaliacaoResponse;
import br.com.johnny.mentoria.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avaliacoes")
@Tag(name = "Avaliações")
public class AvaliacaoController extends BaseCrudController<Integer, AvaliacaoRequest, AvaliacaoResponse> {

    public AvaliacaoController(AvaliacaoService service) {
        super(service);
    }
}
