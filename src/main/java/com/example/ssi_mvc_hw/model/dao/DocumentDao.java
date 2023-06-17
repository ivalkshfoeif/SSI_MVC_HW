package com.example.ssi_mvc_hw.model.dao;

import com.example.ssi_mvc_hw.model.Document;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DocumentDao implements Dao<Document>{

    private Map<Integer, Document> documentMap = new HashMap<>();

    @Override
    public Optional<Document> get(int id) {
        return Optional.ofNullable(documentMap.get(id));
    }

    @Override
    public Collection<Document> getAll() {
        return new ArrayList(documentMap.values());
    }

    @Override
    public int save(Document document) {
        documentMap.put(document.getId(), document);
        return document.getId();
    }

    @Override
    public void update(Document document) {
        documentMap.put(document.getId(), document);
    }

    @Override
    public void delete(Integer id) {
        documentMap.remove(id);
    }

    @Override
    public boolean exist(Integer id){
        return documentMap.containsKey(id);
    }
}
