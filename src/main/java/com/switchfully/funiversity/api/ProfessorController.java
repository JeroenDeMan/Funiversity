package com.switchfully.funiversity.api;

import com.switchfully.funiversity.business.entity.Professor;
import com.switchfully.funiversity.service.ProfessorService;
import com.switchfully.funiversity.service.dto.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "professors")
public class ProfessorController {

    private ProfessorService service;

    @Autowired
    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDTO> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDTO getById(@PathVariable String id) {
        return service.getProfessorById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO addProfessor(@RequestBody ProfessorDTO professorDTO) {
       return service.addProfessor(professorDTO);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDTO updateProfessor(@PathVariable String id, @RequestBody ProfessorDTO professorDTO) {
        return service.updateProfessor(id, professorDTO);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDTO deleteProfessor(@PathVariable String id) {
        return service.deleteProfessor(id);
    }

}
