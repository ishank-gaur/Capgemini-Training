package post_pre;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Vehicle_Main {
    public static void main(String[] args) {
        // this is using bean factory but it dont have close() method so we use ApplicationContext
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("postPre.xml"));
//        Vehicle vehicle = (Vehicle) beanFactory.getBean("V1");

        // this is using ApplicationContext it have close() method so we use ApplicationContext
        ApplicationContext context =
                new ClassPathXmlApplicationContext("postPre.xml");

        Vehicle v1 = (Vehicle) context.getBean("V1");

        ((ClassPathXmlApplicationContext) context).close();

    }
}
