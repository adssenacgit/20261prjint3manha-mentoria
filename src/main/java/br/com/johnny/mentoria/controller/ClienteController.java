package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.ClienteRequest;
import br.com.johnny.mentoria.dto.ClienteResponse;
import br.com.johnny.mentoria.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes")
@CrossOrigin("*")
public class ClienteController extends BaseCrudController<Integer, ClienteRequest, ClienteResponse> {

    public ClienteController(ClienteService service) {
        super(service);
    }
}
