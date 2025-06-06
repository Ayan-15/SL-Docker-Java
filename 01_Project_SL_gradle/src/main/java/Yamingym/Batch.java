package Yamingym;

import java.util.ArrayList;

public abstract class Batch {

	private ArrayList<Participant> participants;
	
	public Batch() {
		this.participants = new ArrayList<>(); 
	}
	
	public void SaveParticipants(Participant participant) {
		this.participants.add(participant);
	}
	
	public abstract void SendSMS();
}
