import domain.Speaker;
import domain.Talk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.TalkService;

import java.util.Arrays;
import java.util.List;

public class ConfApp {
    public static void main(String[] args) {

        Speaker speaker = new Speaker("Pavel","Dvoryak");

        ConfigurableApplicationContext repoContext =
                new AnnotationConfigApplicationContext(RepoConf.class);

        AnnotationConfigApplicationContext serviceContext =
                new AnnotationConfigApplicationContext();
        serviceContext.setParent(repoContext);
        serviceContext.register(ServiceConf.class);
        serviceContext.refresh();



        TalkService talkService = (TalkService) serviceContext.getBean("talkService");

//        ((SimpleTalkService) talkService).setContext(serviceContext);

        talkService.createTalk("Title1", speaker);
        talkService.createTalk("Title2", speaker);

       // System.out.println(talkService.getClass());

        List<Talk> talks = talkService.talks();


        System.out.println(talks);



        //System.out.println(Arrays.toString(serviceContext.getBeanDefinitionNames()));
        System.out.println(serviceContext.getBeanDefinition("talkService"));

       // System.out.println(repoContext.getBean("speaker"));

        System.out.println(serviceContext.getBean(ServiceConf.class).getClass());

        serviceContext.close();
        repoContext.close();



    }
}
