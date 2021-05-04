package org.kamil.model;

import javax.validation.constraints.NotNull;

import org.kamil.common.Lang;
import org.kamil.constraint.NotBadWord;

public class Message {

	@NotNull
	private String title;
	@NotBadWord(lang = { Lang.PL, Lang.EN })
	private String content;

	public Message() {

	}

	public Message(@NotNull String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
