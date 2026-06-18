package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.PublicacaoRequest;
import br.com.johnny.mentoria.dto.PublicacaoResponse;
import br.com.johnny.mentoria.service.PublicacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/publicacoes")
@Tag(name = "Publicações")
@CrossOrigin("*")    
public class PublicacaoController extends BaseCrudController<Integer, PublicacaoRequest, PublicacaoResponse> {

    public PublicacaoController(PublicacaoService service) {
        super(service);
    }
}
