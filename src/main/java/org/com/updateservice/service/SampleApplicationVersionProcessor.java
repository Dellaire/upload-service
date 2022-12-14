package org.com.updateservice.service;

import org.com.updateservice.data.SampleApplication;
import org.com.updateservice.persistence.SampleApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SampleApplicationVersionProcessor {

    @Autowired
    private SampleApplicationRepository sampleApplicationRepository;

    public Optional<SampleApplication> getVersion(String version) {

        return this.sampleApplicationRepository.getVersion(version);
    }

    public String getLatestVersion() {

        return this.sampleApplicationRepository.getLatestVersion();
    }
}
