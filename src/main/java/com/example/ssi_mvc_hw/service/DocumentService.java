package com.example.ssi_mvc_hw.service;

import com.example.ssi_mvc_hw.model.Document;
import com.example.ssi_mvc_hw.model.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component(value = "todoService")
public class DocumentService {

    @Autowired
    private Dao<Document> documentDao;

    public Collection<Document> getAllDocument() {
        return documentDao.getAll();
    }

    public int saveDocument(Document document) {
        return documentDao.save(document);
    }

    public Optional<Document> getDocument(Integer id) {
        return documentDao.get(id);
    }

    public boolean deleteDocument(Integer id){
        boolean flag = documentDao.exist(id) ? true : false;
        documentDao.delete(id);
        return flag;
    }

    public boolean checkDocumentExist(Integer id) {
        return documentDao.exist(id);
    }
}
