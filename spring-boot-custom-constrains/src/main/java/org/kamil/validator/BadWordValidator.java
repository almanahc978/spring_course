package org.kamil.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kamil.common.Lang;
import org.kamil.constraint.NotBadWord;

public class BadWordValidator implements ConstraintValidator<NotBadWord, String> {

	private Lang[] languages;

	@Override
	public void initialize(NotBadWord annotation) {
		this.languages = annotation.lang();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean valid = true;
		for (Lang lang : languages) {
			if (lang == Lang.PL) {
				valid &= plFilter(value);
			}
			if (lang == Lang.EN) {
				valid &= enFilter(value);
			}
		}
		return valid;
	}

	private boolean enFilter(String value) {
		List<String> badWords = Arrays.asList("fak");

		return generalFilter(value, badWords);
	}

	private boolean plFilter(String value) {
		List<String> badWords = Arrays.asList("kurka", "cholercia");

		return generalFilter(value, badWords);
	}

	private boolean generalFilter(String value, List<String> badWords) {
		List<String> found = badWords.stream().filter(word -> value.toLowerCase().contains(word))
				.collect(Collectors.toList());

		return found.isEmpty();
	}

}
