/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.mailservice.repository;

import it.unipol.sample.mailservice.model.Attachment;
import it.unipol.sample.mailservice.model.Email;
import java.util.List;

import org.apache.ibatis.annotations.*;

/**
 *
 * @author matt.rossi
 */
@Mapper
public interface EmailRepository {
    
    @Select("select * from email")
    public List<Email> findAll();

    @Select("select * from email where id=#{id}")
    @Results({@Result(property = "id", column = "id"),
            @Result(property = "attachments", javaType = List.class, column = "id",
                    many = @Many(select = "it.unipol.sample.mailservice.repository.AttachmentRepository.findByEmail"))})
    public Email findById(Long id);

    @Select("select * from email where id=#{id}")
    @Results({@Result(property = "id", column = "id"),
            @Result(property = "attachments", javaType = List.class, column = "id",
                    many = @Many(select = "it.unipol.sample.mailservice.repository.AttachmentRepository.findByEmailOnlyReference"))})
    public Email findByIdWithAttachmentsReference(Long id);

    @Insert({"insert into email(subject,toEmail,body) values(#{subject},#{toEmail},#{body})"})
    @Options(useGeneratedKeys=true,keyProperty="id", keyColumn="id")
    public void insertEmail(Email email);

    @Delete("delete from email where id=#{id}")
    public void delete(Long id);
    
    
    
}
