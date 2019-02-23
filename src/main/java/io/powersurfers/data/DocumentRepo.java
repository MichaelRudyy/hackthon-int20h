package io.powersurfers.data;

import io.powersurfers.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DocumentRepo extends MongoRepository<Document, String> {
    Optional<Document> findById(String id);
}
