package com.capfer.user_api.dto;

import java.util.Date;

/**
 *
 * @param name
 * @param cpf - Cadastro De Pessoas Fisicas | Individual Taxpayer Registry
 * @param address
 * @param email
 * @param phone
 * @param createdAt
 */
public record UserDTO(
        String name,
        String cpf,
        String address,
        String email,
        String phone,
        Date createdAt
) {
}
