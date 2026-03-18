package listdependencyInjection;
import lombok.Data;
import java.util.List;

@Data
public class Library {
    private int id;
    private String name;
    private List<Books> books;
}
