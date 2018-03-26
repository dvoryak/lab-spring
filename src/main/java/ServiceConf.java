import domain.Speaker;
import domain.Talk;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import service.SimpleTalkService;
import service.TalkService;

@Configuration
//@Component
//@ComponentScan(basePackages = "service")

public class ServiceConf {


    @Bean()
    @Scope("prototype")
    public Talk talk() {
        return new Talk();
    }


    @Bean
    public TalkService talkService() {
        SimpleTalkService simpleTalkService = new SimpleTalkService() {
            @Override
            public Talk createEmptyTalk() {
                return talk();
            }
        };

        return simpleTalkService;
    }

}
