package org.com.updateservice.controller;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.com.updateservice.data.SampleApplication;
import org.com.updateservice.service.SampleApplicationVersionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampleapplication")
public class SampleApplicationController {

	@Autowired
	private SampleApplicationVersionProcessor sampleApplicationVersionProcessor;

	@GetMapping
	public ResponseEntity<byte[]> getNewerVersion(
			@RequestParam("currentVersion") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime currentVersion) {

		Optional<SampleApplication> newerSampleApplication = this.sampleApplicationVersionProcessor
				.getNewerVersion(currentVersion);

		if (newerSampleApplication.isPresent()) {
			return ResponseEntity.ok(newerSampleApplication.get().getData());
		}
		return ResponseEntity.noContent().build();
	}
}
