package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES where userid=${userId}")
    List<Note> getNotes(Integer userId);

    @Select("SELECT * FROM NOTES where noteid=${noteId}")
     Note getNotesId(Integer noteId);

    @Insert("INSERT INTO NOTES (noteTitle,noteDescription,userId) Values(#{noteTitle},#{noteDescription},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    Integer createNote(Note note);
    @Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription} " +
            "WHERE noteid = #{noteId}" )
    Integer update(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    void delete(Integer noteId);


}
