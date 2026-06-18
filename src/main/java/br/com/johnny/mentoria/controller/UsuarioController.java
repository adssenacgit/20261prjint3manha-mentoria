package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.UsuarioRequest;
import br.com.johnny.mentoria.dto.UsuarioResponse;
import br.com.johnny.mentoria.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários")
@CrossOrigin("*")    
public class UsuarioController extends BaseCrudController<Integer, UsuarioRequest, UsuarioResponse> {

    public UsuarioController(UsuarioService service) {
        super(service);
    }
}
