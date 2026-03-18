package dependencyInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DI_Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("dependencyinjection.xml"));
        Person person = (Person) beanFactory.getBean("D1");
        System.out.println(person);
    }
}
