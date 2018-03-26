import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import repository.InTalkRepoImpl;
import repository.TalkRepo;

@Configuration
@ComponentScan(basePackages = "repository")
public class RepoConf {

    @Bean
    public TalkRepo talkRepo() {
        return new InTalkRepoImpl();
    }
}
