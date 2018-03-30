import domain.Speaker;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.TalkService;

import java.util.Arrays;


public class ConfApp {
    public static void main(String[] args) {

        Speaker speaker = new Speaker("Pavel","Dvoryak");


        ConfigurableApplicationContext serviceContext =
                new ClassPathXmlApplicationContext("serviceContext.xml");


        TalkService talkService = (TalkService) serviceContext.getBean("service");


//        talkService.createTalk("titlte",speaker);

        talkService.talks();
        talkService.talks();
        talkService.talks();

        talkService.sayHello();

       // ((SimpleTalkService) talkService).sayHello();

       // System.out.println(Arrays.toString(serviceContext.getBeanDefinitionNames()));

        serviceContext.close();



    }
}
