package com.example.ssi_mvc_hw.controller;


import com.example.ssi_mvc_hw.model.Document;
import com.example.ssi_mvc_hw.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/document/{id}")
    ResponseEntity<Object> get(@PathVariable Integer id){
        // successfully get and return 200
        Optional<Document> optionalDocument = documentService.getDocument(id);
        if (optionalDocument.isPresent()){
            return ResponseEntity.ok(optionalDocument.get());
        }
        // not found and return 200
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/document")
    Collection<Document> getList(){
        return documentService.getAllDocument();
    }

    @PostMapping("/document")
    ResponseEntity<Object> post(@RequestBody Document document){
        // already exist and return 409
        if (documentService.checkDocumentExist(document.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        // create successfully and return 200
        documentService.saveDocument(document);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/document/{id}")
    ResponseEntity<Object> put(@PathVariable Integer id, @RequestBody Document document){
        Optional<Document> optionalDocument = documentService.getDocument(id);
        if (optionalDocument.isPresent() && id == document.getId()){
            documentService.saveDocument(document);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/document/{id}")
    ResponseEntity<Object> delete(@PathVariable Integer id){
        // successfully delete and return 204
        if (documentService.deleteDocument(id)){
            return ResponseEntity.noContent().build();
        }
        // not found and return 404
        return  ResponseEntity.notFound().build();
    }


}
