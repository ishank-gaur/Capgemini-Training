package annotation_configuration.primary_qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "goat")
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting");
    }
}
