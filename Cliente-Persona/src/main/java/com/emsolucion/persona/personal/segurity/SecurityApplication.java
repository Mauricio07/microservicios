package com.emsolucion.persona.personal.segurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityApplication {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Valida la contraseña
     * @param passwordUser Clave sin codificar
     * @param passwordAccess Clave códificada
     * @return true/false
     */
    public Boolean validPassword(String passwordUser, String passwordAccess) {
        return BCrypt.checkpw(passwordUser, passwordAccess);
    }
}
