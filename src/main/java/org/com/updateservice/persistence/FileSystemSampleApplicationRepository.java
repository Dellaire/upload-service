package org.com.updateservice.persistence;

import java.util.List;
import java.util.Optional;

import org.com.updateservice.FileUtils;
import org.com.updateservice.configuration.UpdateServiceProperties;
import org.com.updateservice.data.SampleApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "storage", havingValue = "fileSystem")
public class FileSystemSampleApplicationRepository implements SampleApplicationRepository {

	@Autowired
	private UpdateServiceProperties updateServiceProperties;

	@Override
	public Optional<SampleApplication> getVersion(String version) {

		byte[] applicationContent = FileUtils.readContentFromFile(this.updateServiceProperties.getFileSystemTarget() + version);

		if (applicationContent == null) {
			return Optional.empty();
		}

		SampleApplication application = new SampleApplication();
		application.setData(applicationContent);
		application.setId(version);
		Optional<SampleApplication> newerVersion = Optional.of(application);

		return newerVersion;
	}

	@Override
	public void addVersion(String version, byte[] application) {

		FileUtils.writeContentToFile(this.updateServiceProperties.getFileSystemTarget() + version, application);
	}

	@Override
	public String getLatestVersion() {

		List<String> versions = FileUtils.getFileNames(this.updateServiceProperties.getFileSystemTarget());
		versions.sort((v1, v2) -> v1.compareTo(v2));

		return versions.get(0);
	}
}
