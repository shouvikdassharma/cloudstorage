package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper)
    {
        this.fileMapper=fileMapper;
    }
    public boolean fileAvailable(Integer userId,String filename)
    {
        return fileMapper.getFileByName(userId,filename)==null;
    }
    public Integer uploadFile(File file)
    {
        return fileMapper.insert(file);
    }
    public void deleteFile(String filename)
    {
         fileMapper.deleteFile(filename);
    }
    public List<File> getFiles(Integer userId)
    {
        return fileMapper.getFiles(userId);
    }
    public File getFile(Integer fileId) {
        return fileMapper.getFile(fileId);
    }
}
