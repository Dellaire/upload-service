package org.com.updateservice.controller;

import java.util.Optional;

import org.com.updateservice.data.SampleApplication;
import org.com.updateservice.service.SampleApplicationVersionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampleapplication/versions")
public class SampleApplicationController {

	@Autowired
	private SampleApplicationVersionProcessor sampleApplicationVersionProcessor;

	@GetMapping("/{version:\\d{4}\\-\\d{2}\\-\\d{2}}")
	public ResponseEntity<byte[]> getVersion(@PathVariable("version") String version) {

		Optional<SampleApplication> newerSampleApplication = this.sampleApplicationVersionProcessor.getVersion(version);

		if (newerSampleApplication.isPresent()) {
			return ResponseEntity.ok(newerSampleApplication.get().getData());
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/latest")
	public ResponseEntity<String> getLatestVersion() {

		String latestVersion = this.sampleApplicationVersionProcessor.getLatestVersion();

		return ResponseEntity.ok(latestVersion);
	}
}
