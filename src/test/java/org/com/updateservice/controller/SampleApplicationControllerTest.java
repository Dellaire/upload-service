package org.com.updateservice.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.com.updateservice.data.SampleApplication;
import org.com.updateservice.exceptions.VersionNotFoundException;
import org.com.updateservice.service.SampleApplicationVersionProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SampleApplicationController.class)
public class SampleApplicationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SampleApplicationVersionProcessor sampleApplicationVersionProcessor;

	@Test
	public void getLatestVersion() throws Exception {

		this.mockMvc.perform(get("/sampleapplication/versions/latest")).andDo(print()).andExpect(status().isOk());

		verify(this.sampleApplicationVersionProcessor, times(1)).getLatestVersion();
	}

	@Test
	public void getVersion() throws Exception {

		when(this.sampleApplicationVersionProcessor.getVersion(anyString()))
				.thenReturn(Optional.of(new SampleApplication()));

		this.mockMvc.perform(get("/sampleapplication/versions/2022-08-01")).andDo(print()).andExpect(status().isOk());

		verify(this.sampleApplicationVersionProcessor, times(1)).getVersion("2022-08-01");
	}

	@Test
	public void handleInvalidVersionString() throws Exception {

		when(this.sampleApplicationVersionProcessor.getVersion(anyString()))
				.thenReturn(Optional.of(new SampleApplication()));

		this.mockMvc.perform(get("/sampleapplication/versions/2022-08-01!")).andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	public void handleVersionNotFound() throws Exception {

		when(this.sampleApplicationVersionProcessor.getVersion(anyString())).thenThrow(new VersionNotFoundException());

		this.mockMvc.perform(get("/sampleapplication/versions/2022-08-01")).andDo(print())
				.andExpect(status().isNotFound());
	}
}
