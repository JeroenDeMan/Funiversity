package com.switchfully.funiversity.business.repo;

import com.switchfully.funiversity.business.entity.Professor;
import com.switchfully.funiversity.exception.ProfessorAlreadyExists;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Data
@Repository
public class ProfessorRepository {

    private Map<String, Professor> professors;

    public ProfessorRepository() {
        this.professors = new HashMap<>();
    }

    public Professor save(Professor professor) {
        if (professor == null) throw new IllegalArgumentException("No data provided");
        if(professors.containsValue(professor)) throw new ProfessorAlreadyExists(professor.getFirstName() + " already exists");

        professors.put(professor.getId(), professor);
        return professor;

    }

    public Professor delete(String id) {
        return professors.remove(id);
    }

}
