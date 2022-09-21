package org.com.updateservice.configuration;

import com.mongodb.ClientSessionOptions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "storage", havingValue = "fileSystem")
public class MongoDBConfiguration {

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory() {

        return new MongoDatabaseFactory() {

            @Override
            public MongoDatabase getMongoDatabase() throws DataAccessException {
                return null;
            }

            @Override
            public MongoDatabase getMongoDatabase(String dbName) throws DataAccessException {
                return null;
            }

            @Override
            public PersistenceExceptionTranslator getExceptionTranslator() {

                return new PersistenceExceptionTranslator() {

                    @Override
                    public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
                        return null;
                    }
                };
            }

            @Override
            public ClientSession getSession(ClientSessionOptions options) {
                return null;
            }

            @Override
            public MongoDatabaseFactory withSession(ClientSession session) {
                return null;
            }
        };
    }
}
