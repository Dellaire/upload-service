package org.com.updateservice.persistence;

import java.util.Optional;

import org.com.updateservice.data.SampleApplication;

public interface SampleApplicationRepository {

	Optional<SampleApplication> getVersion(String version);
	
	String getLatestVersion();
	
	void addVersion(String currentVersion, byte[] application);
}
