package domain;

public class ConfferenceManager {
    private Speaker speaker;
    private Talk talk;

    public ConfferenceManager() {
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }
}
