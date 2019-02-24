package io.powersurfers.data;

import io.powersurfers.model.document.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepo extends MongoRepository<Section,String> {
    Optional<Section> findById(String id);

    Section findByNumber(int number);
}
