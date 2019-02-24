package io.powersurfers.service;

import io.powersurfers.data.SectionRepo;
import io.powersurfers.model.document.Document;
import io.powersurfers.model.document.Section;
import io.powersurfers.model.document.Sentence;
import io.powersurfers.model.document.Thesis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class SectionService {

    private SectionRepo sectionRepo;
    private DocumentService documentService;


    @Autowired
    public SectionService(SectionRepo sectionRepo, DocumentService documentService) {
        log.debug("DocService Run");
        this.sectionRepo = sectionRepo;
        this.documentService = documentService;
    }

    public Section getSectionById(String id) {
        log.debug("getSectionById id:" + id);
        return sectionRepo.findById(id).orElse(null);
    }

    public Section editThesis(String id, int ids, Thesis thesis) {
        Section section = sectionRepo.findById(id).orElse(null);
        if (section == null) return null;
        Sentence sentence = section
                .getSentences()
                .stream()
                .filter(p -> p.getNumber() == ids)
                .findFirst()
                .orElse(null);
        thesis.setModificatedAt(LocalDateTime.now());

        sentence.setThesis(thesis);

        sectionRepo.save(section);
        return section;
    }

    @Transactional
    public boolean changeStatus(String id, Section.Status to) {
        Optional<Section> optSection = sectionRepo.findById(id);
        if (!optSection.isPresent()) return false;
        optSection.get().setStatus(to);
        sectionRepo.save(optSection.get());
        return true;
    }

    @Transactional
    public Section goToNextSection(String id, Section.Status from, Section.Status to) {
        Optional<Section> optSection = sectionRepo.findById(id);
        if (!optSection.isPresent()) return null;
        optSection.get().setStatus(to);

        Document document = documentService.getDocumentBySectionContains(optSection.get());

        Section nextSection = document
                .getSections()
                .stream()
                .filter(p -> p.getNumber() == optSection.get().getNumber() + 1)
                .findFirst()
                .orElse(null);

        if (nextSection == null) return null;

        nextSection.setStatus(from);

        System.out.println(nextSection.getNumber());

        sectionRepo.save(optSection.get());
        sectionRepo.save(nextSection);

        return nextSection;
    }
}
