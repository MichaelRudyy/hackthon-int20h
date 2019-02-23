package io.powersurfers;

import io.powersurfers.data.DocumentRepo;
import io.powersurfers.data.UserRepo;
import io.powersurfers.model.Document;
import io.powersurfers.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

    @Autowired
    DocumentRepo documentRepo;

    @Autowired
    UserRepo userRepo;

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

        ArrayList<Document> list = new ArrayList<>();
        list.add(document);

        userRepo.save(user);

        document.setOwner(user);

        documentRepo.save(document);


    }
}
