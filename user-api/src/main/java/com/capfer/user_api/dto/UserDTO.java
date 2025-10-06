package com.capfer.user_api.dto;

import com.capfer.user_api.mapper.UserMapper;
import com.capfer.user_api.model.User;

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

    // Temporary Fix - better use
    @Override
    public Date createdAt() {
        return createdAt == null ? new Date() : createdAt;
    }
}
