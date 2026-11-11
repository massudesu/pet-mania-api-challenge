package com.dt2.petmania.controllers;

import com.dt2.petmania.entities.Pet;
import com.dt2.petmania.repositories.PetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/pets")
public class PetController {

    private final PetRepository repository;
    public PetController(PetRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pet> mostrar(){
        return repository.findAll();
    }
    @PostMapping
    public String criar(@RequestBody Pet p){
        try {
            repository.save(p);
            return "Criado com sucesso!";
        }
        catch (Exception e){
            return "Não foi possivel criar o pet!";
        }
    }

    //CRIE O DELETE
    @DeleteMapping("/{id}")
    public String DELETE(@PathVariable int id){
        try {
            repository.deleteById(id);
            return "Pet excluido com sucesso!";
        }
        catch (Exception e){
        return "Não foi possivel exluir o pet!";
        }
    }

}
