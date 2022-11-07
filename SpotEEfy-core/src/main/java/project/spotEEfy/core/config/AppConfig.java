package project.spotEEfy.core.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "project.spotEEfy.core.service")
public class AppConfig {

    @Bean
    public Properties dbProperties() throws IOException {
        Properties props = new Properties();
        props.load(Thread.currentThread().getContextClassLoader().getRessourceAsStream("db.properties"));
        return props
    }

}
