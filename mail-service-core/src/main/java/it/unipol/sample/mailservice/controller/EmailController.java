/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.mailservice.controller;

import it.unipol.sample.mailservice.model.Email;
import it.unipol.sample.mailservice.repository.EmailRepository;
import it.unipol.sample.mailservice.service.EmailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matt.rossi
 */
@RestController
@RequestMapping("/email")
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
    @GetMapping
    public List<Email> findAll(){
        return emailService.getAllEmail();
    }
    
    @PostMapping
    public Email saveEmail(Email email){
      return emailService.saveEmail(email);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        emailService.deleteEmailById(id);
    }
    
}
