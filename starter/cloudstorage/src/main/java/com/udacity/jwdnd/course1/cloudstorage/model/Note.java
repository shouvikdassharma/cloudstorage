package com.udacity.jwdnd.course1.cloudstorage.model;



public class Note {
    private Integer userId;
    private Integer noteId;
    private String noteDescription;
    private String noteTitle;

    public  Note()
    {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public Note(Integer userId, Integer noteId, String noteDescription, String noteTitle) {
        this.userId = userId;
        this.noteId = noteId;
        this.noteDescription = noteDescription;
        this.noteTitle = noteTitle;
    }
}
