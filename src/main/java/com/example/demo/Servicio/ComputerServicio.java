/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Computer;
import com.example.demo.Repositorio.ComputerRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service

public class ComputerServicio {
       @Autowired
    private ComputerRepositorio computerRepository;

    public List<Computer> getAll(){
        return computerRepository.getAll();
    }

    public Optional<Computer> getComputer(int computerId) {
        return computerRepository.getComputer(computerId);
    }

    public Computer save(Computer computer){
        if(computer.getId()==null){
            return computerRepository.save(computer);
        }else{
            Optional<Computer>e= computerRepository.getComputer(computer.getId());
            if(e.isEmpty()){
                return computerRepository.save(computer);
            }else{
                return computer;
            }
        }
    }
    
       public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> e= computerRepository.getComputer(computer.getId());
            if(!e.isEmpty()){
                if(computer.getName()!=null){
                    e.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    e.get().setBrand(computer.getBrand());
                }
                if(computer.getYear()!=null){
                    e.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    e.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    e.get().setCategory(computer.getCategory());
                }
                computerRepository.save(e.get());
                return e.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }

    
    
      public boolean deleteComputer (int id){
        Boolean d = getComputer(id).map(computer -> {
            computerRepository.delete(computer);
            return true;
        }).orElse(false);
        return d;
    }
    
    
}
