package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.auth.RecoverPasswordDTO;
import br.com.fiap.energysaving.dto.auth.ResponseTokenDTO;
import br.com.fiap.energysaving.dto.auth.SignInCredentialsDTO;
import br.com.fiap.energysaving.dto.errors.ValidationErrorDTO;
import br.com.fiap.energysaving.dto.user.CreateUserDTO;
import br.com.fiap.energysaving.dto.user.UserDetailsDTO;
import br.com.fiap.energysaving.model.User;
import br.com.fiap.energysaving.repository.UserRepository;
import br.com.fiap.energysaving.services.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Operações relacionadas à autenticação de usuários.")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @Operation(summary = "Autenticar um usuário", description = "Autentica um usuário na aplicação.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso.", content = @Content(schema = @Schema(implementation = ResponseTokenDTO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(implementation = ValidationErrorDTO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado.", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<ResponseTokenDTO> loginUser(@RequestBody @Valid SignInCredentialsDTO credentialsDTO){
        try {
            var token = new UsernamePasswordAuthenticationToken(credentialsDTO.email(), credentialsDTO.password());
            var authentication = manager.authenticate(token);

            var tokenJwt = tokenService.generateToken((User) authentication.getPrincipal());
            return ResponseEntity.ok(new ResponseTokenDTO(tokenJwt));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    @Transactional
    @Operation(summary = "Cadastrar um novo usuário", description = "Cadastra um novo usuário na aplicação.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso.", content = @Content(schema = @Schema(implementation = UserDetailsDTO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(implementation = ValidationErrorDTO.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "409", description = "Usuário já cadastrado.")
    })
    public ResponseEntity<UserDetailsDTO> CreateUser(@RequestBody @Valid CreateUserDTO userDTO, UriComponentsBuilder uri) {
        var userAlreadyExists = userRepository.findByEmail(userDTO.email());

        if(userAlreadyExists != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        var user = new User(
                userDTO.name(),
                userDTO.email(),
                passwordEncoder.encode(userDTO.password()),
                userDTO.birthDate());

        userRepository.save(user);

        var uriBuilder = uri.path("users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uriBuilder).body(new UserDetailsDTO(user));
    }

}