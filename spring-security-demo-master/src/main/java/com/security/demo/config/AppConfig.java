package com.security.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@ComponentScan("com.security.demo")
@EnableWebMvc
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public AppConfig(Environment environment){
        this.environment = environment;
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource securityDataSource(){

        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
            securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
            securityDataSource.setUser(environment.getProperty("jdbc.user"));
            securityDataSource.setPassword(environment.getProperty("jdbc.password"));
        } catch (PropertyVetoException exception) {
            throw new RuntimeException(exception);
        }

        logger.info("=> jdbc.url=" + environment.getProperty("jdbc.driver"));
        logger.info("=> jdbc.user=" + environment.getProperty("jdbc.user"));



        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    private int getIntProperty(String propName){
        String propVal = environment.getProperty(propName);

        return Integer.parseInt(propVal);
    }
}

