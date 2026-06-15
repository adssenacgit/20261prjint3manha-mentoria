package br.com.johnny.mentoria.dto;

public record OpcaoPerguntaResponse(
        Integer id,
        Integer perguntaCadastroId,
        String descricao,
        Byte status
) {
}
