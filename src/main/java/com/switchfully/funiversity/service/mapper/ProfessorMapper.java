package com.switchfully.funiversity.service.mapper;

import com.switchfully.funiversity.business.entity.Professor;
import com.switchfully.funiversity.service.dto.ProfessorDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor createProfessor(ProfessorDTO professorDTO) {
        return new Professor(
                professorDTO.getFirstName(),
                professorDTO.getLastName());
    }

    public ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO result = new ProfessorDTO();
        result.setId(professor.getId());
        result.setFirstName(professor.getFirstName());
        result.setLastName(professor.getLastName());

        return result;
    }

}
