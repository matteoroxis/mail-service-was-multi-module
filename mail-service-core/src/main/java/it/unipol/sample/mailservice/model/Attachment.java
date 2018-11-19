package it.unipol.sample.mailservice.model;

public class Attachment extends BaseEntity {

    private Long id;
    private Long emailId;
    private String fileName;
    private String fileType;
    private byte[] content;


    public Attachment(Long emailId) {
        super();
    }

    public Attachment(Long emailId, String fileName, String fileType, byte[] content) {
        super();
        this.setEmailId(emailId);
        this.setFileName(fileName);
        this.setFileType(fileType);
        this.setContent(content);
    }

    public Attachment(Long id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public Attachment(Long id, Long emailId, String fileName, String fileType, byte[] content) {
        super();
        this.id = id;
        this.emailId = emailId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.content = content;
    }


    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
