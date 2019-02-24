package io.powersurfers.model.response;

import io.powersurfers.model.document.Section;
import io.powersurfers.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
public class DocumentResponse {
    private String id;

    private String title;

    private LocalDateTime modificationAt;

    private User owner;

    @Data
    @RequiredArgsConstructor
    public static class SectionResponse {
        private String title;
        private int number;
        private Section.Status status;
        private String href;
    }

    private Iterable<SectionResponse> sectionHrefs;
}
