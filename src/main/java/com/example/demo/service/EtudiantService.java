package com.example.demo.service;
import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clarisse
 */
@Service
public class EtudiantService {
    
    @Autowired
    private EtudiantRepository repo;
    
    public List<Etudiant> List(){
        return repo.findAll();
    }
    
    public Etudiant save(Etudiant e){
        return repo.save(e);
        
    }
    
    public void delete(Long id){
         repo.deleteById(id);
    }
    
    public Etudiant findById(Long id){
        return repo.findById(id).orElse(null);
    }
    
}
