package io.powersurfers.datarest;

import io.powersurfers.model.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "Section", path = "sections")
public interface SectionRepoRest extends MongoRepository<Section,String> {
    Optional<Section> findById(String id);
}
