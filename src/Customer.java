import java.time.LocalDate;

public class Customer {
    private String name;
    private LocalDate dateOfBirth;
    private String city;
    private int salesNumber;
    private final Character DELIMITER = ':';

    public Customer(String name, LocalDate dateOfBirth, String city, int salesNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.salesNumber = salesNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }

    public void incrementSalesNumber(int salesNumberIncrement) {
        if(salesNumberIncrement>0)salesNumber+=salesNumberIncrement;
        else throw new IllegalArgumentException("Sales number increment must be positive");
    }

    @Override
    public String toString() {
        return getName()+DELIMITER+getDateOfBirth().toString()+DELIMITER+getCity()+DELIMITER+getSalesNumber();
    }
}
