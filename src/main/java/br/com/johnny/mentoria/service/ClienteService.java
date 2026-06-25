package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.ClienteRequest;
import br.com.johnny.mentoria.dto.ClienteResponse;
import br.com.johnny.mentoria.entity.Cliente;
import br.com.johnny.mentoria.entity.Usuario;
import br.com.johnny.mentoria.repository.ClienteRepository;
import br.com.johnny.mentoria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseCrudService<Cliente, Integer, ClienteRequest, ClienteResponse> {

    private final UsuarioRepository usuarioRepository;
    private final ReferenceService referenceService;

    public ClienteService(ClienteRepository repository, UsuarioRepository usuarioRepository, ReferenceService referenceService) {
        super(repository, "Cliente");
        this.usuarioRepository = usuarioRepository;
        this.referenceService = referenceService;
    }

    @Override
    protected Cliente toEntity(ClienteRequest request) {
        Cliente cliente = new Cliente();
        apply(cliente, request);
        return cliente;
    }

    @Override
    protected void updateEntity(Cliente entity, ClienteRequest request) {
        apply(entity, request);
    }

    private void apply(Cliente cliente, ClienteRequest request) {
        Usuario usuario = referenceService.getRequired(usuarioRepository, request.usuarioId(), "Usuário");
        cliente.setUsuario(usuario);
        cliente.setStack(request.stack());
        cliente.setDescricao(request.descricao());
        if (request.status() != null) cliente.setStatus(request.status());
    }

    @Override
    protected ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getUsuarioId(), cliente.getStack(), cliente.getDescricao(), cliente.getOnboardingConcluido(),cliente.getStatus());
    }
}
