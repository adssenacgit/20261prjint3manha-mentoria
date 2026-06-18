package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.RespostaOpcaoRequest;
import br.com.johnny.mentoria.dto.RespostaOpcaoResponse;
import br.com.johnny.mentoria.service.RespostaOpcaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/respostas-opcao")
@Tag(name = "Respostas de opção")
@CrossOrigin("*")    
public class RespostaOpcaoController extends BaseCrudController<Integer, RespostaOpcaoRequest, RespostaOpcaoResponse> {

    public RespostaOpcaoController(RespostaOpcaoService service) {
        super(service);
    }
}
