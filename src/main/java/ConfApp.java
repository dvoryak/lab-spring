import domain.Speaker;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.TalkService;

import java.util.Arrays;
import java.util.List;

public class ConfApp {
    public static void main(String[] args) {

        Speaker speaker = new Speaker("Pavel","Dvoryak");


        ConfigurableApplicationContext serviceContext =
                new AnnotationConfigApplicationContext(ServiceConf.class);


        TalkService talkService = (TalkService) serviceContext.getBean("talkService");


        talkService.createTalk("titlte",speaker);

        talkService.talks();
        talkService.talks();
        talkService.talks();

        talkService.sayHello();

       // ((SimpleTalkService) talkService).sayHello();

        System.out.println(Arrays.toString(serviceContext.getBeanDefinitionNames()));

        serviceContext.close();



    }
}
