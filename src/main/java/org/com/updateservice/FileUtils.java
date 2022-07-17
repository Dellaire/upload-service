package org.com.updateservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

public class FileUtils {

	public static byte[] readContentFromClasspathFile(ResourceLoader resourceLoader, String fileName) {

		byte[] application = null;
		try {

			Resource resource = resourceLoader.getResource(fileName);
			InputStream inputStream = resource.getInputStream();
			application = FileCopyUtils.copyToByteArray(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return application;
	}

	public static byte[] readContentFromFile(String fileName) {

		byte[] application = null;
		try {

			Resource resource = new FileSystemResource(fileName);
			InputStream inputStream = resource.getInputStream();
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
