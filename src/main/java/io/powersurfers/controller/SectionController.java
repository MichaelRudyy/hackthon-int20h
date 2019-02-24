package io.powersurfers.controller;

import io.powersurfers.model.document.Section;
import io.powersurfers.model.document.Thesis;
import io.powersurfers.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (section == null) return new ResponseEntity<>(new Section(), HttpStatus.OK);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    @PatchMapping("/{id}/patchStatus")
    private ResponseEntity changeStatusToPassed(@PathVariable String id, @RequestParam Section.Status to) {
        if (sectionService.changeStatus(id, to)) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}/next")
    @ResponseStatus(HttpStatus.OK)
    private Section goToNextSection(@PathVariable String id) {
        return sectionService.goToNextSection(id, Section.Status.ACTIVE, Section.Status.PASSED);
    }

    //ids = id of sentense
    @PutMapping("/{id}/editThesis/{ids}")
    @ResponseStatus(HttpStatus.OK)
    private Section editThesis(@PathVariable String id, @PathVariable int ids, @RequestBody Thesis thesis) {
        return sectionService.editThesis(id,ids,thesis);
    }

}
