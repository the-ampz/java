package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.kid.KidDTO;
import br.com.fiap.energysaving.model.Kid;
import br.com.fiap.energysaving.services.KidService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kids")
public class KidController {

    @Autowired
    private KidService kidService;

    @Operation(summary = "Criar uma nova criança associada a um usuário", description = "Este endpoint cria uma criança associada a um usuário existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criança criada com sucesso", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Kid createKid(@PathVariable Long userId, @RequestBody KidDTO kidDTO) {
        return kidService.createKid(kidDTO, userId);
    }

    @Operation(summary = "Buscar uma criança por ID", description = "Este endpoint retorna as informações de uma criança pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Criança encontrada com sucesso", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Criança não encontrada", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/{kidId}")
    public KidDTO getKid(@PathVariable Long kidId) {
        Kid kid = kidService.getKid(kidId);
        return new KidDTO(
                kid.getIdKid(),
                kid.getName(),
                kid.getBirthDate(),
                kid.getTotalScore()
        );
    }

    @Operation(summary = "Atualizar uma criança", description = "Este endpoint atualiza as informações de uma criança existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Criança atualizada com sucesso", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Criança não encontrada", content = @Content(mediaType = "application/json"))
    })
    @PutMapping("/{kidId}")
    public Kid updateKid(@PathVariable Long kidId, @RequestBody KidDTO kidDTO) {
        return kidService.updateKid(kidId, kidDTO);
    }

    @Operation(summary = "Deletar uma criança", description = "Este endpoint deleta uma criança pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Criança deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Criança não encontrada")
    })
    @DeleteMapping("/{kidId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKid(@PathVariable Long kidId) {
        kidService.deleteKid(kidId);
    }
}
