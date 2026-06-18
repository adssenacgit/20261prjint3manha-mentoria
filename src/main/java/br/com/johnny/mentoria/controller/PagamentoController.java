package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.PagamentoRequest;
import br.com.johnny.mentoria.dto.PagamentoResponse;
import br.com.johnny.mentoria.service.PagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
@Tag(name = "Pagamentos")
@CrossOrigin("*")    
public class PagamentoController extends BaseCrudController<Integer, PagamentoRequest, PagamentoResponse> {

    public PagamentoController(PagamentoService service) {
        super(service);
    }
}
