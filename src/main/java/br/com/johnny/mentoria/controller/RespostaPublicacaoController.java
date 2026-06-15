package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.RespostaPublicacaoRequest;
import br.com.johnny.mentoria.dto.RespostaPublicacaoResponse;
import br.com.johnny.mentoria.service.RespostaPublicacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/respostas-publicacoes")
@Tag(name = "Respostas de publicações")
public class RespostaPublicacaoController extends BaseCrudController<Integer, RespostaPublicacaoRequest, RespostaPublicacaoResponse> {

    public RespostaPublicacaoController(RespostaPublicacaoService service) {
        super(service);
    }
}
