/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.ComputerInterface;
import com.example.demo.Modelo.Computer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository

public class ComputerRepositorio {
    @Autowired
    private ComputerInterface computerCrudRepository;
    
      public List<Computer> getAll(){
        return (List<Computer>) computerCrudRepository.findAll();
    }
    
    public Optional<Computer> getComputer(int id){
        return computerCrudRepository.findById(id);
    }

    public Computer save(Computer computer){
        return computerCrudRepository.save(computer);
    }
    
     public void delete(Computer computer){
        computerCrudRepository.delete(computer);
    }
    
     
    
}
