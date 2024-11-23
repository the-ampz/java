package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.score.CreateScoreDTO;
import br.com.fiap.energysaving.dto.score.ScoreDTO;
import br.com.fiap.energysaving.services.ScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
@Tag(name = "Pontuações", description = "Gerenciamento das pontuações.")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    @Operation(summary = "Criar uma pontuação.")
    public ScoreDTO create(@RequestBody @Valid CreateScoreDTO dto) {
        return scoreService.create(dto);
    }

    @GetMapping
    @Operation(summary = "Listar todas as pontuações.")
    public List<ScoreDTO> findAll() {
        return scoreService.findAll();
    }
}
