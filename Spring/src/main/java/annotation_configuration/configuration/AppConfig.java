package annotation_configuration.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:student.property")//this is used when u don't want to show your essential info
// to the end user you can create a .property file for that field and pass the reference of it here
@Configuration
@ComponentScan(basePackages = "annotation_configuration")
public class AppConfig {
}
