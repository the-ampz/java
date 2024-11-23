package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.challengegoal.ChallengeGoalDTO;
import br.com.fiap.energysaving.dto.challengegoal.CreateChallengeGoalDTO;
import br.com.fiap.energysaving.services.ChallengeGoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge-goals")
@Tag(name = "Desafios e Metas", description = "Gerenciamento de desafios e suas metas.")
public class ChallengeGoalController {

    @Autowired
    private ChallengeGoalService challengeGoalService;

    @PostMapping
    @Operation(summary = "Criar um novo desafio com metas.")
    public ChallengeGoalDTO create(@RequestBody @Valid CreateChallengeGoalDTO dto) {
        return challengeGoalService.create(dto);
    }

    @GetMapping
    @Operation(summary = "Listar todos os desafios com metas.")
    public List<ChallengeGoalDTO> findAll() {
        return challengeGoalService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um desafio pelo ID.")
    public ChallengeGoalDTO findById(@PathVariable Long id) {
        return challengeGoalService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um desafio pelo ID.")
    public void delete(@PathVariable Long id) {
        challengeGoalService.delete(id);
    }
}
