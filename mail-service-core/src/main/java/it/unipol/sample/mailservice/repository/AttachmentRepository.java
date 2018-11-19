package it.unipol.sample.mailservice.repository;

import it.unipol.sample.mailservice.model.Attachment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttachmentRepository {

    @Select("select * from attachment")
    public List<Attachment> findAll();

    @Select("select * from attachment where emailId=#{emailId}")
    public List<Attachment> findByEmail(Long emailId);

    @Select("select * from attachment where emailId=#{emailId} and id=#{id}")
    public Attachment findByEmailAndId(@Param("id") Long id,@Param("emailId")  Long emailId);

    @Select("select id,fileName from attachment where emailId=#{emailId}")
    public List<Attachment> findByEmailOnlyReference(Long emailId);

    @Insert("insert into attachment(emailId,fileName,fileType,content) values(#{emailId},#{fileName},#{fileType},#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Attachment attachment);

}
