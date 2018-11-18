/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.mailservice.controller;

import it.unipol.sample.mailservice.model.Attachment;
import it.unipol.sample.mailservice.model.Email;
import it.unipol.sample.mailservice.repository.EmailRepository;
import it.unipol.sample.mailservice.service.AttachmentService;
import it.unipol.sample.mailservice.service.EmailService;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;

/**
 * @author matt.rossi
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private AttachmentService attachmentService;

    Logger logger = LoggerFactory.getLogger(EmailController.class);

    @GetMapping
    public ResponseEntity<List<Email>> findAll() {
        List<Email> emails = emailService.getAllEmail();
        if (emails!=null){
            return new ResponseEntity<List<Email>>(emails,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> findById(@PathVariable Long id) {
        Email email = emailService.getEmail(id);
        if(email!=null){
            return new ResponseEntity<Email>(email,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        emailService.deleteEmailById(id);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public @ResponseBody
    ResponseEntity<?> insertEmail(
            @RequestParam("attachments") MultipartFile[] uploadFiles,
            @RequestPart Email email
    ) throws Exception {
        logger.info("File Uploaded " + uploadFiles.length);
        if (email != null) {
            if (uploadFiles != null) {
                emailService.insertEmailWithAttachments(email, uploadFiles);
            } else {
                emailService.insertEmail(email);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<?> insertEmail(
            @RequestBody Email email
    ) throws Exception {
        if (email != null) {
            emailService.insertEmail(email);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{emailId}/upload")
    public @ResponseBody
    ResponseEntity<?> uploadAttachments(
            @PathVariable("emailId") long emailId,
            @RequestParam("attachments") MultipartFile[] uploadFiles) throws Exception {
        logger.info("File Uploaded " + uploadFiles.length);
        for (MultipartFile uploadFile : uploadFiles) {
            Attachment attachment = new Attachment(emailId,
                    uploadFile.getOriginalFilename(),
                    uploadFile.getContentType(),
                    uploadFile.getBytes());

            attachmentService.insertAttachment(attachment);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{emailId}/download/{attachmentId}")
    public @ResponseBody
    ResponseEntity<Attachment> downloadAttachment(
            @PathVariable("emailId") Long emailId,
            @PathVariable("attachmentId") Long attachmentId) throws Exception {
        if(emailId != null && attachmentId!=null){
            Attachment attachment = attachmentService.getAttachmentByEmailAndId(attachmentId,emailId);
            if(attachment!=null){
                return new ResponseEntity<>(attachment,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
