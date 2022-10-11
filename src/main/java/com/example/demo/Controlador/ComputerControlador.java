/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Computer;
import com.example.demo.Servicio.ComputerServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/api/Computer")
@CrossOrigin(origins = "*")

public class ComputerControlador {
     @Autowired
    private ComputerServicio computerService;
    @GetMapping("/all")
    public List<Computer> getComputers(){
        return computerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Computer> getComputer(@PathVariable("id") int computerId) {
        return computerService.getComputer(computerId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer save(@RequestBody Computer computer) {
        return computerService.save(computer);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer update(@RequestBody Computer computer) {
        return computerService.update(computer);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return computerService.deleteComputer(id);
    }
    
  
}
