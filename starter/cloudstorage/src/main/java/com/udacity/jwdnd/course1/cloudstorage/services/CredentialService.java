package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {
    public CredentialService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

    public CredentialMapper credentialMapper;

    public Integer insert(Credential credential)
    {
        return credentialMapper.insert(credential);
    }
    public List<Credential> getCredentials(Integer userId)
    {
        return credentialMapper.getCredentials(userId);
    }
    public  Credential getCredential(Integer credentialId)
    {
        return credentialMapper.getCredential(credentialId);
    }
    public  Integer update(Credential credential)
    {
        return credentialMapper.update(credential);
    }
    public void delete(Integer credentialId)
    {
        credentialMapper.delete(credentialId);
    }

}
