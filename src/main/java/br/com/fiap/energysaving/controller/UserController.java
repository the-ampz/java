package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.errors.ValidationErrorDTO;
import br.com.fiap.energysaving.dto.user.UpdateUserDTO;
import br.com.fiap.energysaving.dto.user.UserDetailsDTO;
import br.com.fiap.energysaving.model.User;
import br.com.fiap.energysaving.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuários", description = "Operações relacionadas aos usuários.")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    @Operation(summary = "Obter perfil do usuário logado", description = "Obtém os detalhes do perfil do usuário logado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Perfil do usuário obtido com sucesso.", content = @Content(schema = @Schema(implementation = UserDetailsDTO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado.", content = @Content(schema = @Schema(hidden = true)))
    })

    public ResponseEntity<UserDetailsDTO> getMyProfile(){
        try {
            val authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication == null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            return ResponseEntity.ok(new UserDetailsDTO((User) authentication.getPrincipal()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Transactional
    @PutMapping("/me")
    @Operation(summary = "Atualizar perfil do usuário logado", description = "Atualiza os detalhes do perfil do usuário logado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Perfil do usuário atualizado com sucesso.", content = @Content(schema = @Schema(implementation = UserDetailsDTO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(implementation = ValidationErrorDTO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado.", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<UserDetailsDTO> updateProfile(@RequestBody @Valid UpdateUserDTO updateUserDTO) {
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = (User) authentication.getPrincipal();

        user.update(updateUserDTO);

        userRepository.save(user);

        return ResponseEntity.ok(new UserDetailsDTO(user));
    }
}
