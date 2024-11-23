package br.com.fiap.energysaving.services;

import br.com.fiap.energysaving.dto.communityParticip.CommunityParticipationDTO;
import br.com.fiap.energysaving.dto.communityParticip.CreateCommunityParticipationDTO;
import br.com.fiap.energysaving.dto.kid.KidDTO;
import br.com.fiap.energysaving.model.CommunityParticipation;
import br.com.fiap.energysaving.model.Kid;
import br.com.fiap.energysaving.repository.CommunityParticipationRepository;
import br.com.fiap.energysaving.repository.KidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityParticipationService {

    @Autowired
    private CommunityParticipationRepository participationRepository;

    @Autowired
    private KidRepository kidRepository;

    public CommunityParticipationDTO create(CreateCommunityParticipationDTO dto) {
        Kid kid = kidRepository.findById(dto.kidId())
                .orElseThrow(() -> new RuntimeException("Kid not found"));

        CommunityParticipation participation = new CommunityParticipation();
        participation.setKid(kid);
        participation.setIdCommunity(dto.communityId());
        participation.setPoints(dto.points());

        participationRepository.save(participation);

        return new CommunityParticipationDTO(
                participation.getIdParticipation(),
                new KidDTO(
                        kid.getIdKid(),
                        kid.getName(),
                        kid.getBirthDate(),
                        kid.getTotalScore()
                ),
                participation.getIdCommunity(),
                participation.getPoints()
        );
    }

    public List<CommunityParticipationDTO> findAll() {
        return participationRepository.findAll().stream().map(participation -> new CommunityParticipationDTO(
                participation.getIdParticipation(),
                new KidDTO(
                        participation.getKid().getIdKid(),
                        participation.getKid().getName(),
                        participation.getKid().getBirthDate(),
                        participation.getKid().getTotalScore()
                ),
                participation.getIdCommunity(),
                participation.getPoints()
        )).toList();
    }
}
