package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.MetodoPagamentoRequest;
import br.com.johnny.mentoria.dto.MetodoPagamentoResponse;
import br.com.johnny.mentoria.service.MetodoPagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/metodos-pagamento")
@Tag(name = "Métodos de pagamento")
@CrossOrigin("*")
public class MetodoPagamentoController extends BaseCrudController<Integer, MetodoPagamentoRequest, MetodoPagamentoResponse> {

    public MetodoPagamentoController(MetodoPagamentoService service) {
        super(service);
    }
}
