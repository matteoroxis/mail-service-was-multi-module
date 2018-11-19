package it.unipol.sample.mailservice.service;

import it.unipol.sample.mailservice.model.Attachment;
import it.unipol.sample.mailservice.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    public Attachment getAttachment(Long id) {
        return null;
    }

    @Override
    public List<Attachment> getAttachmentByEmail(Long emailId) {
        return attachmentRepository.findByEmail(emailId);
    }

    @Override
    public Attachment getAttachmentByEmailAndId(Long id, Long emailId) {
        return attachmentRepository.findByEmailAndId(id,emailId);
    }

    @Override
    public void insertAttachment(Attachment attachment) {
        attachmentRepository.insert(attachment);
    }

    @Override
    public void deleteAttachment(long id) {

    }
}
