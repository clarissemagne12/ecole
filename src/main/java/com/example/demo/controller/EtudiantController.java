/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Etudiant;
import com.example.demo.service.EtudiantService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author clarisse
 */
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
  
    private EtudiantService service;
    // permet d'afficher la liste de tous les etudiants
    @GetMapping
    public List<Etudiant> getAll(){
        return service.List();
    }
    
    // permet de retrouver un etudiant à partir de son id
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getById(@PathVariable Long Id){
        Etudiant e=service.findById(Id);
         if(e == null) 
             return ResponseEntity.notFound().build();
         return ResponseEntity.ok(e);
    }
    // permet d'ajouter un etudiant
    @PostMapping
    public Etudiant add(@RequestBody Etudiant e){
        return service.save(e);
    }
    
    // faire la mise à jour sur un etudiant à partir de son id et de l'etudiant
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> update(@PathVariable Long id, @RequestBody Etudiant e) {
        Etudiant existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setNom(e.getNom());
        existing.setPrenom(e.getPrenom());
        Etudiant updated = service.save(existing);
        return ResponseEntity.ok(updated);
    }
//permet de supprimer un etudiant à partir de son identifiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Etudiant existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    
}
