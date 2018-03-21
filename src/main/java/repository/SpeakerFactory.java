package repository;

import domain.Speaker;

public class SpeakerFactory {

    public Speaker create(String name) {
        return new Speaker(name,"Anon");
    }


}
