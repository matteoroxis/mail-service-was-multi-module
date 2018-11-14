/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.mailservice.repository;

import it.unipol.sample.mailservice.model.Email;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author matt.rossi
 */
@Mapper
public interface EmailRepository {
    
    @Select("select * from email")
    public List<Email> findAll();
    
    @Insert("insert into email(subject,to,body) values(#{subject},#{to},#{body})")
    public void insert(Email email);
    
    @Delete("delete from email where id=#{id}")
    public void delete(Long id);
    
    
    
}
