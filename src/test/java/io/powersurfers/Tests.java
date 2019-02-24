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
}
