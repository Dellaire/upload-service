package org.com.updateservice.persistence;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.com.updateservice.data.SampleApplication;

public interface SampleApplicationRepository {

	Optional<SampleApplication> getNewerVersion(ZonedDateTime currentVersion);
	
	void addVersion(ZonedDateTime currentVersion, byte[] application);
}
