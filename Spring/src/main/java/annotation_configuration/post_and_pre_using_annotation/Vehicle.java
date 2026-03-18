package annotation_configuration.post_and_pre_using_annotation;

import annotation_configuration.configuration.AppConfig;
import annotation_configuration.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Vehicle {
    public Vehicle() {
        System.out.println("Vehicle Constructor");
    }
    @PostConstruct
    public void moving(){
        System.out.println("moving");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("life of every one gone");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        Vehicle vehicle=applicationContext.getBean(Vehicle.class);
        ((AnnotationConfigApplicationContext)applicationContext).close();

    }
}
