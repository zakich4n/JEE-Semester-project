package project.spotEEfy.core.config;


import com.zaxxer.hikari.HikariConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "project.spotEEfy.core.service")
public class AppConfig {


    /*
    @Bean
    public Properties dbProperties() throws IOException {
        Properties props = new Properties();
        props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        return props;
    }
    */

    

    @Bean
    public HikariConfig dbConfiguration() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/spoteefy?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return config;
    }


}
