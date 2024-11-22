package br.com.fiap.energysaving.services;

import br.com.fiap.energysaving.dto.kid.KidDTO;
import br.com.fiap.energysaving.model.Kid;
import br.com.fiap.energysaving.repository.KidRepository;
import br.com.fiap.energysaving.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KidService {

    @Autowired
    private KidRepository kidRepository;

    @Autowired
    private UserRepository userRepository;

    public Kid createKid(KidDTO kidDTO, Long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Kid kid = new Kid();
        kid.setName(kidDTO.name());
        kid.setBirthDate(kidDTO.birthDate());
        kid.setTotalScore(kidDTO.totalScore());
        kid.setUser(user);

        return kidRepository.save(kid);
    }

    public Kid getKid(Long kidId) {
        return kidRepository.findById(kidId).orElseThrow(() -> new RuntimeException("Kid not found"));
    }

    public Kid updateKid(Long kidId, KidDTO kidDTO) {
        Kid kid = kidRepository.findById(kidId).orElseThrow(() -> new RuntimeException("Kid not found"));

        kid.setName(kidDTO.name());
        kid.setBirthDate(kidDTO.birthDate());
        kid.setTotalScore(kidDTO.totalScore());

        return kidRepository.save(kid);
    }

    public void deleteKid(Long kidId) {
        kidRepository.deleteById(kidId);
    }
}
