package br.com.johnny.mentoria.service;

import br.com.johnny.mentoria.dto.UsuarioRequest;
import br.com.johnny.mentoria.dto.UsuarioResponse;
import br.com.johnny.mentoria.entity.Usuario;
import br.com.johnny.mentoria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseCrudService<Usuario, Integer, UsuarioRequest, UsuarioResponse> {

    public UsuarioService(UsuarioRepository repository) {
        super(repository, "Usuário");
    }

    @Override
    protected Usuario toEntity(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        apply(usuario, request);
        return usuario;
    }

    @Override
    protected void updateEntity(Usuario entity, UsuarioRequest request) {
        apply(entity, request);
    }

    private void apply(Usuario usuario, UsuarioRequest request) {
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());
        usuario.setTipoUsuario(request.tipoUsuario());
        usuario.setDataCadastro(request.dataCadastro());
        if (request.status() != null) usuario.setStatus(request.status());
    }

    @Override
    protected UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
                usuario.getTipoUsuario(), usuario.getDataCadastro(), usuario.getStatus());
    }
}
