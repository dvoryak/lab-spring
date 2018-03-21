package repository;

import domain.Talk;

import java.util.List;

public interface TalkRepo {

    List<Talk> talks();

    void save(Talk talk);
}
