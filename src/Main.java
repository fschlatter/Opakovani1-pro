import javax.annotation.processing.ProcessingEnvironment;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Main {

    private static final String FILE_NAME = "records.txt";
    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("John", LocalDate.of(1990, 1, 1), "New York", 100));
        records.addCustomer(new Customer("John", LocalDate.of(1990, 1, 1), "New York", 40));
        records.addCustomer(new Customer("John", LocalDate.of(1990, 1, 1), "New York", 10020));
        records.addCustomer(new Customer("John", LocalDate.of(1990, 1, 1), "New York", 10));
        records.addCustomer(new Customer("Richard", LocalDate.of(1991, 2, 2), "Los Angeles", 200));

        records.removeCustomer(records.getCustomers().get(records.getCustomers().size()-1));
        writeRecordsToFile(records);
        System.out.println(records.getAverageSalesNumberFromCity("New York"));
        System.out.println(records.getCustomerWithSalesNumberGreaterThan(100));
    }

    public static void writeRecordsToFile(CustomerRecords records) {
        // Write the records to a file
        try(PrintWriter writer = new PrintWriter(FILE_NAME)) {
            for(Customer customer : records.getCustomers()) {
                writer.println(customer);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}