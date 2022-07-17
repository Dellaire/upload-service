package org.com.updateservice.service;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.com.updateservice.data.SampleApplication;
import org.com.updateservice.persistence.SampleApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleApplicationVersionProcessor {

	@Autowired
	private SampleApplicationRepository sampleApplicationRepository;
	
	public Optional<SampleApplication> getNewerVersion(ZonedDateTime currentVersion) {
		
		return this.sampleApplicationRepository.getNewerVersion(currentVersion);
	}
}
