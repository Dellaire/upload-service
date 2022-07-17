package org.com.updateservice.persistence;

import org.com.updateservice.data.SampleApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "storage", havingValue = "database")
public interface MongoDBSampleApplicationRepository extends MongoRepository<SampleApplication, String> {

}
