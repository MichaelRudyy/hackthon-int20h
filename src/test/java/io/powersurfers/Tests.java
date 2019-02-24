package io.powersurfers;

import io.powersurfers.data.DocumentRepo;
import io.powersurfers.data.SectionRepo;
import io.powersurfers.data.UserRepo;
import io.powersurfers.model.User;
import io.powersurfers.model.*;
import io.powersurfers.model.document.Document;
import io.powersurfers.model.document.Section;
import io.powersurfers.model.document.Sentence;
import io.powersurfers.model.document.Thesis;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class Tests {

    @Autowired
    DocumentRepo documentRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    SectionRepo sectionRepo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        User user = new User();
        user.setName("Mike");
        user.setEmail("mcrudyy@gmail.com");

        Document document = new Document();
        document.setTitle("Document Title");

        document.setSections(generateSections(2));
        document.setModificationAt(LocalDateTime.now());

        userRepo.save(user);

        document.setOwner(user);

        System.out.println(document);
        documentRepo.save(document);
    }

    private List<Section> generateSections(int count) {
        List<Section> sections = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            Section section = new Section();
            section.setNumber(i);
            section.setStatus(Section.Status.PASSED);
            section.setTitle("Section " + i);
            section.setSentences(generateSentences(3));
            sections.add(sectionRepo.save(section));
        }
        return sections;
    }

    private List<Sentence> generateSentences(int count) {
        List<Sentence> sentences = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            Thesis thesis = new Thesis();
            thesis.setText("Thesis " + i);
            thesis.setModificatedAt(LocalDateTime.now());
            Sentence sentence = new Sentence();
            sentence.setThesis(thesis);
            sentence.setText("Sentence " + i);
            sentences.add(sentence);
        }
        return sentences;
    }
}
