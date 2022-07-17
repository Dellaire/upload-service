package org.com.updateservice;

import java.time.ZonedDateTime;

import org.com.updateservice.persistence.SampleApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "importTestData", havingValue = "true")
public class TestDataImporter implements CommandLineRunner {

	@Autowired
	private SampleApplicationRepository sampleApplicationRepository;

	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public void run(String... args) throws Exception {

		byte[] application = FileUtils.readContentFromClasspathFile(resourceLoader, "classpath:nodepad.zip");
		this.sampleApplicationRepository.addVersion(ZonedDateTime.now(), application);
	}
}
