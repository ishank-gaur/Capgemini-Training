package ioc_with_xml;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Laptop {
private int LaptopID;
private String LaptopName;

    public int getLaptopID() {
        return LaptopID;
    }

    public void setLaptopID(int laptopID) {
        LaptopID = laptopID;
    }

    public String getLaptopName() {
        return LaptopName;
    }

    public void setLaptopName(String laptopName) {
        LaptopName = laptopName;
    }
}
