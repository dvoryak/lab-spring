package repository;

import domain.Talk;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Repository("talkRepo")
public class InTalkRepoImpl implements TalkRepo {
    private List<Talk> talks = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void close() {
        System.out.println("close");
    }

    @Override
    public List<Talk> talks() {
        return talks;
    }

    @Override
    public void save(Talk talk) {
        talks.add(talk);
    }
}
