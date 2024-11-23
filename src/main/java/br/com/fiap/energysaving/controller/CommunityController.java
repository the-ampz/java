package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.community.CommunityDTO;
import br.com.fiap.energysaving.dto.community.CreateCommunityDTO;
import br.com.fiap.energysaving.services.CommunityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communities")
@Tag(name = "Comunidades", description = "Gerenciamento de comunidades.")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @PostMapping
    @Operation(summary = "Criar uma nova comunidade.")
    public CommunityDTO create(@RequestBody @Valid CreateCommunityDTO dto) {
        return communityService.create(dto);
    }

    @GetMapping
    @Operation(summary = "Listar todas as comunidades.")
    public List<CommunityDTO> findAll() {
        return communityService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar uma comunidade pelo ID.")
    public CommunityDTO findById(@PathVariable Long id) {
        return communityService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma comunidade pelo ID.")
    public void delete(@PathVariable Long id) {
        communityService.delete(id);
    }
}
