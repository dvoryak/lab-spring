package service;

import domain.Speaker;
import domain.Talk;

import java.util.List;

public interface TalkService {

    void createTalk(String title, Speaker... speakers);

    List<Talk> talks();

}
