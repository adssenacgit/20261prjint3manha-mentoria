package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.PerguntaCadastroRequest;
import br.com.johnny.mentoria.dto.PerguntaCadastroResponse;
import br.com.johnny.mentoria.service.PerguntaCadastroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/perguntas-cadastro")
@Tag(name = "Perguntas de cadastro")
public class PerguntaCadastroController extends BaseCrudController<Integer, PerguntaCadastroRequest, PerguntaCadastroResponse> {

    public PerguntaCadastroController(PerguntaCadastroService service) {
        super(service);
    }
}
