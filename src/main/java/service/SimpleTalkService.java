package service;

import domain.Speaker;
import domain.Talk;
import repository.TalkRepo;

import java.util.*;

public class SimpleTalkService implements TalkService {

    private TalkRepo talkRepo;

    public SimpleTalkService(TalkRepo talkRepo) {
        this.talkRepo = talkRepo;
    }



    @Override
    public void createTalk(String title, Speaker... speakers) {
        Set<Speaker> speakerSet = new HashSet<>();
        speakerSet.addAll(Arrays.asList(speakers));
        Talk talk = new Talk(title,speakerSet);
        talkRepo.save(talk);
    }

    @Override
    public List<Talk> talks() {
        return talkRepo.talks();
    }
}
