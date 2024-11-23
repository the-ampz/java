package br.com.fiap.energysaving.services;

import br.com.fiap.energysaving.dto.challengegoal.ChallengeGoalDTO;
import br.com.fiap.energysaving.dto.challengegoal.CreateChallengeGoalDTO;
import br.com.fiap.energysaving.model.Challenge;
import br.com.fiap.energysaving.model.Community;
import br.com.fiap.energysaving.repository.ChallengeGoalRepository;
import br.com.fiap.energysaving.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeGoalService {

    @Autowired
    private ChallengeGoalRepository challengeGoalRepository;

    @Autowired
    private CommunityRepository communityRepository;

    public ChallengeGoalDTO create(CreateChallengeGoalDTO dto) {
        Community community = communityRepository.findById(dto.idCommunity())
                .orElseThrow(() -> new RuntimeException("Community not found"));

        Challenge challengeGoal = new Challenge();
        challengeGoal.setDescription(dto.description());
        challengeGoal.setScore(dto.score());
        challengeGoal.setStartDate(dto.startDate());
        challengeGoal.setEndDate(dto.endDate());
        challengeGoal.setEnergyRequired(dto.energyRequired());
        challengeGoal.setCommunity(community);

        challengeGoalRepository.save(challengeGoal);

        return new ChallengeGoalDTO(
                challengeGoal.getIdChallenge(),
                challengeGoal.getDescription(),
                challengeGoal.getScore(),
                challengeGoal.getStartDate(),
                challengeGoal.getEndDate(),
                challengeGoal.getEnergyRequired(),
                challengeGoal.getCommunity().getIdCommunity()
        );
    }

    public List<ChallengeGoalDTO> findAll() {
        return challengeGoalRepository.findAll().stream().map(challengeGoal -> new ChallengeGoalDTO(
                challengeGoal.getIdChallenge(),
                challengeGoal.getDescription(),
                challengeGoal.getScore(),
                challengeGoal.getStartDate(),
                challengeGoal.getEndDate(),
                challengeGoal.getEnergyRequired(),
                challengeGoal.getCommunity().getIdCommunity()
        )).toList();
    }

    public ChallengeGoalDTO findById(Long id) {
        Challenge challengeGoal = challengeGoalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Challenge Goal not found"));

        return new ChallengeGoalDTO(
                challengeGoal.getIdChallenge(),
                challengeGoal.getDescription(),
                challengeGoal.getScore(),
                challengeGoal.getStartDate(),
                challengeGoal.getEndDate(),
                challengeGoal.getEnergyRequired(),
                challengeGoal.getCommunity().getIdCommunity()
        );
    }

    public void delete(Long id) {
        challengeGoalRepository.deleteById(id);
    }
}
