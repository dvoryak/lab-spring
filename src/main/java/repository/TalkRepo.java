package repository;

import domain.Talk;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TalkRepo {

    List<Talk> talks();

    void save(Talk talk);
}
