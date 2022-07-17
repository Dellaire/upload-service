package org.com.updateservice.persistence;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.com.updateservice.FileUtils;
import org.com.updateservice.configuration.UpdateServiceProperties;
import org.com.updateservice.data.SampleApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "storage", havingValue = "fileSystem")
public class FileSystemSampleApplicationRepository implements SampleApplicationRepository {

	@Autowired
	private UpdateServiceProperties updateServiceProperties;
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public Optional<SampleApplication> getNewerVersion(ZonedDateTime currentVersion) {

		String fileName = this.zonedDateTimeToFileName(currentVersion);
		Optional<SampleApplication> newerVersion = null;
		try {
			
			byte[] applicationContent = FileUtils.readContentFromFile(this.resourceLoader, fileName);
			SampleApplication application = new SampleApplication();
			application.setData(applicationContent);
			application.setId(fileName);
			newerVersion = Optional.of(application);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			newerVersion = Optional.empty();
		}

		return newerVersion;
	}

	@Override
	public void addVersion(ZonedDateTime currentVersion, byte[] application) {

		String fileName = this.zonedDateTimeToFileName(currentVersion);
		FileUtils.writeContentToFile(fileName, application);
	}

	private String zonedDateTimeToFileName(ZonedDateTime currentVersion) {

		return this.updateServiceProperties.getFileSystemTarget()
				+ DateTimeFormatter.ofPattern("yyyy-MM-dd").format(currentVersion) + ".zip";
	}
}
