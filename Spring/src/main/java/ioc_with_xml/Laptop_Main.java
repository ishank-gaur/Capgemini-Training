package ioc_with_xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Laptop_Main {
    public static void main(String[] args) {
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("BeanConfiguration.xml"));
//        Laptop l2=(Laptop)  beanFactory.getBean("aapna_class");
//        System.out.println(l2);

        //we can only use this when we have only one bean in our configuration file
//        BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("BeanConfiguration.xml"));
//        Laptop l3= beanFactory2.getBean(Laptop.class);
//        System.out.println(l3);

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("BeanConfiguration.xml"));
        Laptop l4=(Laptop)  beanFactory.getBean("b1");
        System.out.println(l4);
    }
}
