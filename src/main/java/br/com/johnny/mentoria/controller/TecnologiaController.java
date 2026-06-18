package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.TecnologiaRequest;
import br.com.johnny.mentoria.dto.TecnologiaResponse;
import br.com.johnny.mentoria.service.TecnologiaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/tecnologias")
@Tag(name = "Tecnologias")
@CrossOrigin("*")    
public class TecnologiaController extends BaseCrudController<Integer, TecnologiaRequest, TecnologiaResponse> {

    public TecnologiaController(TecnologiaService service) {
        super(service);
    }
}
