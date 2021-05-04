package org.kamil.config;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;

import org.kamil.config.profiles.DevProfile;
import org.kamil.config.profiles.ProdProfile;
import org.springframework.context.annotation.*;

@Configuration
public class Appconfig {

	@Bean
	@DevProfile
	public DatabaseDatasource getH2Datasource() {
		return (() -> Arrays.asList("KasiaTest", "BartekTest", "AniaTest", "KrzysztofTest"));
	}

	@Bean
	@ProdProfile
	public DatabaseDatasource getMysqlDatasource() {

		return new DatabaseDatasource() {

			@Override
			public List<String> getDatabase() {
				try {
					Path filePath = new File(getClass().getResource("/data.txt").toURI()).toPath();
					List<String> allLines = Files.readAllLines(filePath);
					return allLines;
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}

				return new ArrayList<>();
			}

		};
	}

}
