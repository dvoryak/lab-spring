import benchmark.BenchmarkBeanPostProcessor;
import domain.Speaker;
import domain.Talk;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import repository.InTalkRepoImpl;
import repository.TalkRepo;
import service.SimpleTalkService;
import service.TalkService;

@Configuration
@Import(value = RepoConf.class)

public class ServiceConf {


    @Bean
    public Talk talk() {
        return new Talk();
    }

    @Bean
    public TalkRepo talkRepo() {
        return new InTalkRepoImpl();
    }

    @Bean
    public TalkService talkService() {
        return new SimpleTalkService(talkRepo());
    }

    @Bean
    public BeanPostProcessor benchmarkBeanPostProcessor() {
        return new BenchmarkBeanPostProcessor();
    }


}
