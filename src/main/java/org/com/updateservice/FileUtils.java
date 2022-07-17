package org.com.updateservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

public class FileUtils {

	public static byte[] readContentFromFile(ResourceLoader resourceLoader, String fileName) throws IOException {

		Resource resource = resourceLoader.getResource(fileName);
		InputStream inputStream = resource.getInputStream();

		byte[] application = null;
		try {
			application = FileCopyUtils.copyToByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return application;
	}
	
	public static void writeContentToFile(String fileName, byte[] content) {
		
		try {

			new File(fileName);

			FileOutputStream outputStream = new FileOutputStream(fileName);
			outputStream.write(content);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
