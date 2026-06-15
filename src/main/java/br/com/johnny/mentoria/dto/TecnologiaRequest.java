package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TecnologiaRequest(
        @NotBlank @Size(max = 50) String nome,
        Byte status
) {
}
