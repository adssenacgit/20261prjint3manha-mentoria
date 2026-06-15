package br.com.johnny.mentoria.dto;

public record UsuarioTecnologiaResponse(
        Integer usuarioId,
        Integer tecnologiaId,
        Byte status
) {
}
