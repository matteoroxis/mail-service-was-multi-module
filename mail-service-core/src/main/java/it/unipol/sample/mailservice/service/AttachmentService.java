package it.unipol.sample.mailservice.service;

import it.unipol.sample.mailservice.model.Attachment;

import java.util.List;

public interface AttachmentService {

    public Attachment getAttachment(Long id);

    public List<Attachment> getAttachmentByEmail(Long emailId);

    public Attachment getAttachmentByEmailAndId(Long id,Long emailId);

    public void insertAttachment(Attachment attachment);

    public void deleteAttachment(long id);

}
