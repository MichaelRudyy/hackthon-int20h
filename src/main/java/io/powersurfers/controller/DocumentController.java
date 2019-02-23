package io.powersurfers.controller;

import io.powersurfers.model.Document;
import io.powersurfers.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Document> getDocumentById(@PathVariable String id) {
        Document document = documentService.getDocumentById(id);
        if (document == null) return new ResponseEntity<>(new Document(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(document, HttpStatus.FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Document addDocument(@RequestBody Document document) {
        return documentService.addDocument(document);
    }
}
