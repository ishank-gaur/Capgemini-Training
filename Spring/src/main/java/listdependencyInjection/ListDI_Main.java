package listdependencyInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ListDI_Main {
    public static void main(String[] args) {
        BeanFactory beanFactory =new XmlBeanFactory(new ClassPathResource("ListDependencyinjection.xml"));
        Library library= (Library) beanFactory.getBean("L1");
        System.out.println(library);
    }
}
