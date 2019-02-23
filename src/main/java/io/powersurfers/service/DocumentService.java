package io.powersurfers.service;

import io.powersurfers.data.DocumentRepo;
import io.powersurfers.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private DocumentRepo documentRepo;

    @Autowired
    public DocumentService(DocumentRepo documentRepo) {
        this.documentRepo = documentRepo;
    }

    public Document getDocumentById(String id) {
        return documentRepo.findById(id).orElse(null);
    }

    public Document addDocument(Document document) {
        System.out.println(document);
        return documentRepo.save(document);
    }
}
