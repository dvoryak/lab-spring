import domain.Speaker;
import domain.Talk;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.TalkService;

import java.util.List;

public class ConfApp {
    public static void main(String[] args) {

        Speaker speaker = new Speaker("Pavel","Dvoryak");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TalkService talkService = (TalkService) context.getBean("talkService");

        talkService.createTalk("Some talk", speaker);
        List<Talk> talks = talkService.talks();

        System.out.println(talks);



    }
}
