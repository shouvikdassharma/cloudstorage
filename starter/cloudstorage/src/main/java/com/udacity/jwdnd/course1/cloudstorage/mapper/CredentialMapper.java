package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {
    @Select("SELECT * FROM CREDENTIALS WHERE USERID=#{userId}")
    List<Credential> getCredentials(Integer userid);

    @Select("SELECT * FROM CREDNTIAL WHERE credentialid=#{credentialId}")
    Credential getCredential(Integer credentialId);

    @Insert("INSERT INTO CREDENTIALS (url,username,key,password,userid) Values(#{url},#{usereName},#{key},#{password},#{userId})")
    @Options(useGeneratedKeys = true,keyProperty = "credentialId")
    Integer insert(Credential credential);
    @Update("UPDATE CREDENTIALS SET url = #{url}, username = #{username}, key = #{key}, password = #{password} " +
            "WHERE credentialid = #{credentialId}")
    Integer update(Credential credential);

    @Delete("DELET FROM CREDENTIAL WHERE credentialid=#{credentialId}")
    void delete(Integer credentialId);





}
