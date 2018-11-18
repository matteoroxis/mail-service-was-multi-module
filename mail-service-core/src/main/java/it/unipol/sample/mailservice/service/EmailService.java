/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.mailservice.service;

import it.unipol.sample.mailservice.model.Email;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *
 * @author matt.rossi
 */
public interface EmailService {

    public Email getEmail(Long id);

    public List<Email> getAllEmail();

    public void insertEmail(Email email);

    public void insertEmailWithAttachments(Email email, MultipartFile[] uploadFiles);

    public void deleteEmailById(Long id);

    public Email updateEmail(Email email);

}
