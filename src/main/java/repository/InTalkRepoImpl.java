package repository;

import domain.Talk;

import java.util.ArrayList;
import java.util.List;

public class InTalkRepoImpl implements TalkRepo {
    private List<Talk> talks = new ArrayList<>();

    @Override
    public List<Talk> talks() {
        return talks;
    }

    @Override
    public void save(Talk talk) {
        talks.add(talk);
    }
}
