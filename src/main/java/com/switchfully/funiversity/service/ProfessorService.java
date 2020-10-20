package com.switchfully.funiversity.service;

import com.switchfully.funiversity.business.entity.Professor;
import com.switchfully.funiversity.business.repo.ProfessorRepository;
import com.switchfully.funiversity.exception.ProfessorNotFoundException;
import com.switchfully.funiversity.service.dto.ProfessorDTO;
import com.switchfully.funiversity.service.mapper.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private ProfessorRepository repository;
    private ProfessorMapper mapper;

    @Autowired
    public ProfessorService(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<ProfessorDTO> getAll() {
        return repository.getProfessors()
                .values()
                .stream()
                .map(professor -> mapper.toDTO(professor))
                .collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorById(String id) {
        if (!isProfessorInDatabase(id)) throw new ProfessorNotFoundException(id);
        return mapper.toDTO(repository.getProfessors().get(id));
    }


    public ProfessorDTO addProfessor(ProfessorDTO professorDTO) {

        Professor professor = repository.save(mapper.createProfessor(professorDTO));
        return mapper.toDTO(professor);
    }

    public ProfessorDTO updateProfessor(String id, ProfessorDTO professorDTO) {
        if (!isProfessorInDatabase(id)) throw new ProfessorNotFoundException(id);

        Professor result = repository.getProfessors().get(id);
        result.setFirstName(professorDTO.getFirstName());
        result.setLastName(professorDTO.getLastName());

        return getProfessorById(result.getId());
    }

    public ProfessorDTO deleteProfessor(String id) {
        if (!isProfessorInDatabase(id)) throw new ProfessorNotFoundException(id);
        
        Professor result = repository.delete(id);
        return mapper.toDTO(result);
    }

    private boolean isProfessorInDatabase(String id) {
        return repository.getProfessors().containsKey(id);
    }


}
