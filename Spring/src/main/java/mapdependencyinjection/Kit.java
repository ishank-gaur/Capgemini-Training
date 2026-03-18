package mapdependencyinjection;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kit {
    private String Name;
    private  Map<String,Integer> items;
}
