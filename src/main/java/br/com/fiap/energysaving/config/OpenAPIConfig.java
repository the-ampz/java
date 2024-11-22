package br.com.fiap.energysaving.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Energy Saving",
                version = "1.0",
                description = "Uma plataforma centralizada para gestão de consumo de energia que visa conscientizar e educar crianças a economizar desde pequenas."
        ),
        servers = {
                @Server(description = "Ambiente de Desenvolvimento", url = "http://localhost:8080")
        },
        security = @SecurityRequirement(name = "Bearer Auth")
)
@SecurityScheme(
        name = "Bearer Auth",
        description = "Autenticação básica via Bearer Token JWT.",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenAPIConfig { }
