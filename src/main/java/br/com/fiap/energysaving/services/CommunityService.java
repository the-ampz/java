package br.com.fiap.energysaving.services;

import br.com.fiap.energysaving.dto.community.CommunityDTO;
import br.com.fiap.energysaving.dto.community.CreateCommunityDTO;
import br.com.fiap.energysaving.model.Community;
import br.com.fiap.energysaving.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    public CommunityDTO create(CreateCommunityDTO dto) {
        Community community = new Community();
        community.setName(dto.name());
        community.setDescription(dto.description());
        community.setTotalPoints(dto.totalPoints());

        communityRepository.save(community);

        return new CommunityDTO(
                community.getIdCommunity(),
                community.getName(),
                community.getDescription(),
                community.getTotalPoints()
        );
    }

    public List<CommunityDTO> findAll() {
        return communityRepository.findAll().stream().map(community -> new CommunityDTO(
                community.getIdCommunity(),
                community.getName(),
                community.getDescription(),
                community.getTotalPoints()
        )).toList();
    }

    public CommunityDTO findById(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Community not found"));

        return new CommunityDTO(
                community.getIdCommunity(),
                community.getName(),
                community.getDescription(),
                community.getTotalPoints()
        );
    }

    public void delete(Long id) {
        communityRepository.deleteById(id);
    }
}
