package io.powersurfers;

import io.powersurfers.data.DocumentRepo;
import io.powersurfers.data.SectionRepo;
import io.powersurfers.data.UserRepo;
import io.powersurfers.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

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
        document.setTitle("title");

        Thesis thesis = new Thesis();
        thesis.setText("thesis1");
        thesis.setModificatedAt(LocalDateTime.now());

        Sentence sentence1 = new Sentence();
        sentence1.setText("sentence1");
        sentence1.setThesis(thesis);

        ArrayList<Sentence> sentences = new ArrayList<>();

        sentences.add(sentence1);
        sentences.add(sentence1);
        sentences.add(sentence1);
        sentences.add(sentence1);

        Section section = new Section();
        Section section1 = new Section();
        section.setSentences(sentences);
        section1.setSentences(sentences);

        ArrayList<Section> sectionArrayList = new ArrayList<>();

        sectionArrayList.add(section);
        sectionArrayList.add(section1);

        document.setSections(sectionArrayList);

        userRepo.save(user);

        document.setOwner(user);

        sectionRepo.save(section);
        sectionRepo.save(section1);

        System.out.println(document);
        documentRepo.save(document);


    }
}
