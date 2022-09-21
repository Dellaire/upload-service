package org.com.updateservice.persistence;

import org.com.updateservice.data.SampleApplication;

import java.util.Optional;

public interface SampleApplicationRepository {

    Optional<SampleApplication> getVersion(String version);

    String getLatestVersion();

    void addVersion(String currentVersion, byte[] application);
}
