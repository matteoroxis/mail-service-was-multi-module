/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.mailservice.service;

import it.unipol.sample.mailservice.model.Email;
import java.util.List;

/**
 *
 * @author matt.rossi
 */
public interface EmailService {

    public Email getEmail();

    public List<Email> getAllEmail();

    public Email saveEmail(Email email);

    public void deleteEmailById(Long id);

    public Email updateEmail(Email email);

}
