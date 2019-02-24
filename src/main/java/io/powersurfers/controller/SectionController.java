package io.powersurfers.controller;

import io.powersurfers.model.document.Section;
import io.powersurfers.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/section")
public class SectionController {

    private SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Section> getSection(@PathVariable String id) {
        Section section = sectionService.getSectionById(id);
        if (section == null) return new ResponseEntity<>(new Section(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(section, HttpStatus.FOUND);
    }

}
