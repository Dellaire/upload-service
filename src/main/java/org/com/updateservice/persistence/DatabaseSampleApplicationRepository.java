package org.com.updateservice.persistence;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.com.updateservice.data.SampleApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "storage", havingValue = "database")
public class DatabaseSampleApplicationRepository implements SampleApplicationRepository {

	@Override
	public Optional<SampleApplication> getNewerVersion(ZonedDateTime currentVersion) {
		return null;
	}

	@Override
	public void addVersion(ZonedDateTime currentVersion, byte[] application) {
		
	}
}
