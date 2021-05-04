package org.kamil.component;

import java.util.LinkedList;
import java.util.List;

import org.kamil.model.Participant;
import org.springframework.stereotype.Component;

@Component
public class EventHolder {

	public List<Participant> participants;

	public EventHolder() {
		participants = new LinkedList<>();
	}

	public void addPatricipant(Participant participant) {
		participants.add(participant);
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public boolean checkRegistartion(Participant participant) {
		return participants.contains(participant);
	}
}
