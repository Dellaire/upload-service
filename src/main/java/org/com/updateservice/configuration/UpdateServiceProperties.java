package org.com.updateservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class UpdateServiceProperties {

	private String fileSystemTarget;

	public String getFileSystemTarget() {
		return fileSystemTarget;
	}

	public void setFileSystemTarget(String fileSystemTarget) {
		this.fileSystemTarget = fileSystemTarget;
	}
}
