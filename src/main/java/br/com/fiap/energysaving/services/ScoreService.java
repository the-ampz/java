package br.com.fiap.energysaving.services;

import br.com.fiap.energysaving.dto.kid.KidDTO;
import br.com.fiap.energysaving.dto.score.CreateScoreDTO;
import br.com.fiap.energysaving.dto.score.ScoreDTO;
import br.com.fiap.energysaving.model.Kid;
import br.com.fiap.energysaving.model.Score;
import br.com.fiap.energysaving.repository.KidRepository;
import br.com.fiap.energysaving.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private KidRepository kidRepository;

    public ScoreDTO create(CreateScoreDTO dto) {
        Kid kid = kidRepository.findById(dto.kidId())
                .orElseThrow(() -> new RuntimeException("Kid not found"));

        Score score = new Score();
        score.setKid(kid);
        score.setIdChallenge(dto.challengeId());
        score.setVlPoints(dto.points());
        score.setDtCompletion(dto.completionDate());

        scoreRepository.save(score);

        return new ScoreDTO(
                score.getIdScore(),
                new KidDTO(
                        kid.getIdKid(),
                        kid.getName(),
                        kid.getBirthDate(),
                        kid.getTotalScore()
                ),
                score.getIdChallenge(),
                score.getVlPoints(),
                score.getDtCompletion()
        );
    }

    public List<ScoreDTO> findAll() {
        return scoreRepository.findAll().stream().map(score -> new ScoreDTO(
                score.getIdScore(),
                new KidDTO(
                        score.getKid().getIdKid(),
                        score.getKid().getName(),
                        score.getKid().getBirthDate(),
                        score.getKid().getTotalScore()
                ),
                score.getIdChallenge(),
                score.getVlPoints(),
                score.getDtCompletion()
        )).toList();
    }
}
