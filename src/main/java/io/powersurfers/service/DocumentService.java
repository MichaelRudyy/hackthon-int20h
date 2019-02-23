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

        for (Section section : document.getSections()) {
            DocumentResponse.SectionResponse response1 = new DocumentResponse.SectionResponse();

            response1.setTitle(section.getTitle());
            response1.setNumber(section.getNumber());
            response1.setHref(SectionsRestUrlBuilder.get(section.getId()));
            response1.setStatus(section.getStatus());

            sectionResponseList.add(response1);
        }
        response.setSectionHrefs(sectionResponseList);
        return response;
    }
}
