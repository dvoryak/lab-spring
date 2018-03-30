package service;

import benchmark.Benchmark;
import domain.Speaker;
import domain.Talk;
import org.springframework.beans.factory.annotation.Lookup;
import repository.TalkRepo;

import java.util.*;

public class SimpleTalkService implements TalkService {

    private TalkRepo talkRepo;

    public SimpleTalkService(TalkRepo talkRepo) {
        this.talkRepo = talkRepo;
    }


    @Override
    public void createTalk(String title, Speaker... speakers) {
        Set<Speaker> speakerSet = new HashSet<>(Arrays.asList(speakers));
        Talk talk = new Talk(title,speakerSet);
        talkRepo.save(talk);
        System.out.println("Create talk method processing ..");
    }

    @Benchmark
    public void sayHello() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }

    @Override
    public Talk getTalk() {
        return null;
    }

    @Benchmark
    @Override
    public List<Talk> talks() {
        System.out.println("talks method processing ..");
        return talkRepo.talks();
    }
}
