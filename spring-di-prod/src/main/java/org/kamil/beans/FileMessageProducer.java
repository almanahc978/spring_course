package org.kamil.beans;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.kamil.beans.Message.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* @FileMessage - trzeba tworzyć adnotacje to każdej implementacji */
@Component
@Message(type = MessageType.FILE)
public class FileMessageProducer implements MessageProducer {

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	@Autowired
	public void setFileName(@Value("$messageFileProperty") String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getMessage() {
		List<String> lines = null;

		try {
			Path path = new File(getClass().getResource("/message.txt").toURI()).toPath();
			lines = Files.readAllLines(path);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		String result = "";
		if (lines != null) {
			result = lines.stream().reduce(result, (a, b) -> a + b);
		}
		return result;

	}
}
