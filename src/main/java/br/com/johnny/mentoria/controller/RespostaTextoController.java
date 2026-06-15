package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.RespostaTextoRequest;
import br.com.johnny.mentoria.dto.RespostaTextoResponse;
import br.com.johnny.mentoria.service.RespostaTextoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/respostas-texto")
@Tag(name = "Respostas de texto")
public class RespostaTextoController extends BaseCrudController<Integer, RespostaTextoRequest, RespostaTextoResponse> {

    public RespostaTextoController(RespostaTextoService service) {
        super(service);
    }
}
