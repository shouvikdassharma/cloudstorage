package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface FileMapper {
    @Select("SELECT * FROM FILES WHERE userid=#{userId} ")
    List<File> getFiles(Integer userId);
    @Select("SELECT * FROM FILES where fileid=#{fileID}")
    File getFile(Integer fileId);

    @Select("SELECT * FROM FILES where userid=#{userid} AND filename=#{filename}")
    File getFileByNmae(Integer userid,String filename);

    @Insert("INSERT INTO FILES(filename,contenttype,filesize,userid,filedata) VALUES(#{filename},#{contentType},#{fileSize},#{userID},#{fileData})")
    @Options(useGeneratedKeys = true,keyProperty = "fileId")
    int insert(File file);

    @Delete("DELETE FROM FILES WHERE filename=#{fileName}")
    void deleteFile(String fileName);

}
