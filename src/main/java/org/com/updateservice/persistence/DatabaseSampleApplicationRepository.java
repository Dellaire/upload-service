package org.com.updateservice.persistence;

import org.com.updateservice.data.SampleApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ConditionalOnProperty(name = "storage", havingValue = "database")
public class DatabaseSampleApplicationRepository implements SampleApplicationRepository {

    @Override
    public Optional<SampleApplication> getVersion(String version) {
        return null;
    }

    @Override
    public String getLatestVersion() {
        return null;
    }

    @Override
    public void addVersion(String version, byte[] application) {

    }
}
