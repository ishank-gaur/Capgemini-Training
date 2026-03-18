package mapdependencyinjection;

import listdependencyInjection.Library;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class KitDI_Main {
    public static void main(String[] args) {

            BeanFactory beanFactory =new XmlBeanFactory(new ClassPathResource("MapDependencyInjection.xml"));
            Kit kit= (Kit) beanFactory.getBean("Kit1");
            System.out.println(kit);
        }
    }

