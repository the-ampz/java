package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.communityParticip.CommunityParticipationDTO;
import br.com.fiap.energysaving.dto.communityParticip.CreateCommunityParticipationDTO;
import br.com.fiap.energysaving.services.CommunityParticipationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community-participations")
@Tag(name = "Participações na Comunidade", description = "Gerenciamento das participações em comunidades.")
public class CommunityParticipationController {

    @Autowired
    private CommunityParticipationService participationService;

    @PostMapping
    @Operation(summary = "Criar uma participação.")
    public CommunityParticipationDTO create(@RequestBody @Valid CreateCommunityParticipationDTO dto) {
        return participationService.create(dto);
    }

    @GetMapping
    @Operation(summary = "Listar todas as participações.")
    public List<CommunityParticipationDTO> findAll() {
        return participationService.findAll();
    }
}
