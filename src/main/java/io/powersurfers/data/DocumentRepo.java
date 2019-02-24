package io.powersurfers.data;

import io.powersurfers.model.User;
import io.powersurfers.model.document.Document;
import io.powersurfers.model.document.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepo extends MongoRepository<Document, String> {
    Optional<Document> findById(String id);

    List<Document> findByOwner(User user);

    Document findBySectionsContaining(Section section);
}
