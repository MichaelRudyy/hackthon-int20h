package io.powersurfers.service;

import io.powersurfers.data.DocumentRepo;
import io.powersurfers.model.Document;
import io.powersurfers.model.Section;
import io.powersurfers.model.response.DocumentResponse;
import io.powersurfers.util.SectionsRestUrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public DocumentResponse convertToResponse(Document document) {
        if (document == null) return null;
        DocumentResponse response = new DocumentResponse();
        response.setId(document.getId());
        response.setTitle(document.getTitle());
        response.setOwner(document.getOwner());
        response.setModificationAt(document.getModificationAt());

        List<DocumentResponse.SectionResponse> sectionResponseList = new LinkedList<>();

        for (int i = 0; i < document.getSections().size(); i++) {
            DocumentResponse.SectionResponse response1 = new DocumentResponse.SectionResponse();

            response1.setTitle(document.getSections().get(i).getTitle());
            response1.setNumber(document.getSections().get(i).getNumber());
            response1.setHref(SectionsRestUrlBuilder.get(document.getId()));
            response1.setStatus(document.getSections().get(i).getStatus());

            sectionResponseList.add(response1);
        }
        return response;
    }
}
