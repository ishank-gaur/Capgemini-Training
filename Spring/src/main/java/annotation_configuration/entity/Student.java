package annotation_configuration.entity;

import annotation_configuration.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;



@Data
@Component
public class Student {

   // @Value("100")
    @Value("${id}")
    private int id;
    //@Value(value="ABC")
    @Value("${name}")
    private String name;
   // @Value("20010")
   @Value("${roll_no}")
    private int roll_no;


    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        Student student=applicationContext.getBean(Student.class);
        System.out.println(student);
    }
}
