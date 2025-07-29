package com.ms.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(
    @NotBlank(message = "Nome é obrigatório") String name, 
    @NotBlank(message = "Email é obrigatório") @Email String email) {
}
