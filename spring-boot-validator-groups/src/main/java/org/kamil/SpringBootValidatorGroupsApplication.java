package org.kamil;

import java.time.Instant;
import java.util.Date;

import org.kamil.model.Project;
import org.kamil.service.ProjectService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootValidatorGroupsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootValidatorGroupsApplication.class, args);
		ProjectService projectService = ctx.getBean(ProjectService.class);

		// na razie nie przypisujemy jego właściciela, bo go nie znamy
		// opis również jest opcjonalny
		Project project = new Project();
		project.setTitle("Prototyp samochodu"); /* tytul jest wymagany, jezeli go nie podamy to otrzymamy 2xFALSE */
		project.setDate(Date.from(Instant.now()));

		boolean validateDraft = projectService.validateDraft(project);
		System.out.println("Draft project valid? " + validateDraft);

		// uzupełniamy projekt o wszystkie informacje
		project.setOwner("John Doe");
		project.setDescription("Trójkołowy samochód elektryczny");

		boolean validateFull = projectService.validateFull(project);
		System.out.println("Full Project valid? " + validateFull);
	}

}
