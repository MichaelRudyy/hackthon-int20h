package io.powersurfers.service;

import io.powersurfers.data.SectionRepo;
import io.powersurfers.model.Document;
import io.powersurfers.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    private SectionRepo sectionRepo;

    @Autowired
    public SectionService(SectionRepo sectionRepo) {
        this.sectionRepo = sectionRepo;
    }

    public Section getSectionById(String id) {
        return sectionRepo.findById(id).orElse(null);
    }
}
