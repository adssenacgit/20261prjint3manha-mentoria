package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.OpcaoPerguntaRequest;
import br.com.johnny.mentoria.dto.OpcaoPerguntaResponse;
import br.com.johnny.mentoria.service.OpcaoPerguntaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/opcoes-pergunta")
@Tag(name = "Opções de pergunta")
@CrossOrigin("*")
public class OpcaoPerguntaController extends BaseCrudController<Integer, OpcaoPerguntaRequest, OpcaoPerguntaResponse> {

    public OpcaoPerguntaController(OpcaoPerguntaService service) {
        super(service);
    }
}
