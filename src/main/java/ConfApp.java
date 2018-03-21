import domain.Speaker;
import domain.Talk;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.TalkService;

import java.util.Arrays;
import java.util.List;

public class ConfApp {
    public static void main(String[] args) {

        Speaker speaker = new Speaker("Pavel","Dvoryak");

        ConfigurableApplicationContext repoContext =
                new ClassPathXmlApplicationContext("repoContext.xml");

        ConfigurableApplicationContext serviceContext =
                new ClassPathXmlApplicationContext(new String[] {"serviceContext.xml"},repoContext);


        TalkService talkService = (TalkService) serviceContext.getBean("talkService");

        talkService.createTalk("Some talk", speaker);
        List<Talk> talks = talkService.talks();


        System.out.println(talks);


        System.out.println(Arrays.toString(repoContext.getBeanDefinitionNames()));

        System.out.println(repoContext.getBean("speaker"));

        serviceContext.close();
        repoContext.close();



    }
}
