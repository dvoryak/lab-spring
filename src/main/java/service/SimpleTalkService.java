package service;

import domain.Speaker;
import domain.Talk;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import repository.TalkRepo;

import java.util.*;

@Service("talkService")
public class SimpleTalkService implements TalkService {

    @Autowired
    private TalkRepo talkRepo;
    private Talk talk;

    @Autowired
    public SimpleTalkService(TalkRepo talkRepo, Talk talk) {
        this.talkRepo = talkRepo;
        this.talk = talk;
    }

    public SimpleTalkService() {
    }

    public void setTalkRepo(TalkRepo talkRepo) {
        this.talkRepo = talkRepo;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

    public SimpleTalkService(TalkRepo talkRepo) {
        this.talkRepo = talkRepo;
    }

    @Override
    public void createTalk(String title, Speaker... speakers) {
        Set<Speaker> speakerSet = new HashSet<>();
        speakerSet.addAll(Arrays.asList(speakers));
        //Talk talk = new Talk(title,speakerSet);
        Talk talk = createEmptyTalk();
        talk.setTitle(title);
        talk.setSpeakers(speakerSet);
        talkRepo.save(talk);
    }

    @Lookup
    public Talk createEmptyTalk() {
        return null;
    }

    @Override
    public List<Talk> talks() {
        return talkRepo.talks();
    }
}
