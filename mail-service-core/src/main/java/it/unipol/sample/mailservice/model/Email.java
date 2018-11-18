/*
 * toEmail change this license header, choose License Headers in Project Properties.
 * toEmail change this template file, choose toEmailols | Templates
 * and open the template in the editoEmailr.
 */
package it.unipol.sample.mailservice.model;


import java.util.ArrayList;
import java.util.List;

/**
 * @author matt.rossi
 */
public class Email extends BaseEntity {

    private Long id;
    private String subject;
    private String toEmail;
    private String body;
    private List<Attachment> attachments;

    public Email() {
        super();
        this.attachments = new ArrayList<Attachment>();
    }

    public Email(String subject, String toEmail, String body) {
        super();
        this.subject = subject;
        this.toEmail = toEmail;
        this.body = body;
        this.attachments = new ArrayList<Attachment>();
    }

    public Email(String subject, String toEmail, String body,List<Attachment> attachments) {
        super();
        this.subject = subject;
        this.toEmail = toEmail;
        this.body = body;
        this.attachments = attachments;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id toEmail set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject toEmail set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the toEmail
     */
    public String gettoEmail() {
        return toEmail;
    }

    /**
     * @param toEmail the toEmail toEmail set
     */
    public void settoEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body toEmail set
     */
    public void setBody(String body) {
        this.body = body;
    }


    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
