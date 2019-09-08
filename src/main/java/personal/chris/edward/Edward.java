package personal.chris.edward;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import personal.chris.edward.services.ArgumentParser;

@Configuration
@ComponentScan
public class Edward {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Edward.class);
        ArgumentParser parser = applicationContext.getBean(ArgumentParser.class);
        try {
            parser.parseArgs(args);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
