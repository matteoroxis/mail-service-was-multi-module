/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.mailservice.service;

import it.unipol.sample.mailservice.model.Attachment;
import it.unipol.sample.mailservice.model.Email;
import it.unipol.sample.mailservice.repository.AttachmentRepository;
import it.unipol.sample.mailservice.repository.EmailRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author matt.rossi
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public Email getEmail(Long id) {
        return emailRepository.findById(id);
    }

    @Override
    public List<Email> getAllEmail() {
        return emailRepository.findAll();
    }

    @Override
    public void insertEmail(Email email) {
        emailRepository.insertEmail(email);
    }

    @Override
    public void insertEmailWithAttachments(Email email, MultipartFile[] uploadFiles) {
        List<Attachment> attachmentList = new ArrayList<>();
        emailRepository.insertEmail(email);
        Long emailId = email.getId();
        if (uploadFiles != null) {
            attachmentList = createAttachmentsFromMultipartFile(emailId, uploadFiles);
            for (Attachment attachment : attachmentList) {
                attachmentRepository.insert(attachment);
            }
        }

    }

    private List<Attachment> createAttachmentsFromMultipartFile(Long emailId, MultipartFile[] uploadFiles) {
        List<Attachment> attachmentList = new ArrayList<>();
        for (MultipartFile uploadFile : uploadFiles) {
            Attachment attachment = null;
            try {
                attachment = new Attachment(emailId, uploadFile.getOriginalFilename(), uploadFile.getContentType(), uploadFile.getBytes());
            } catch (IOException e) {
                logger.error((e.getMessage()));
            }
            attachmentList.add(attachment);
        }
        return attachmentList;
    }

    @Override
    public void deleteEmailById(Long id) {
        emailRepository.delete(id);
    }

    @Override
    public Email updateEmail(Email email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
