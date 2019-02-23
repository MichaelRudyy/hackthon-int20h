package io.powersurfers.datarest;

import io.powersurfers.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "Documents", path = "documents")
public interface DocumentRepoRest extends MongoRepository<Document, String> {
    Optional<Document> findById(String id);
}
