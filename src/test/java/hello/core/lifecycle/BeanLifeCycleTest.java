package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
@Test
public void lifeCycleTest() {
    
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    NeworkClient client = ac.getBean(NeworkClient.class);
    ac.close();
}

@Configuration
static class LifeCycleConfig {
    @Bean
    public NeworkClient networkClient() {
        NeworkClient neworkClient = new NeworkClient();
        neworkClient.setUrl("http://naver.com");
        return neworkClient;
    }
}
}
