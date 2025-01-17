import javax.annotation.processing.ProcessingEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "records.txt";
    public static void main(String[] args) {
        CustomerRecords records = getRecordsFromFile(FILE_NAME);

        records.addCustomer(new Customer("John", LocalDate.of(1990, 1, 1), "New York", 100));
        records.addCustomer(new Customer("John", LocalDate.of(1990, 1, 1), "New York", 40));
        records.addCustomer(new Customer("John", LocalDate.of(1990, 1, 1), "New York", 10020));
        records.addCustomer(new Customer("John", LocalDate.of(1990, 1, 1), "New York", 10));
        records.addCustomer(new Customer("Richard", LocalDate.of(1991, 2, 2), "Los Angeles", 200));

        records.removeCustomer(records.getCustomers().get(records.getCustomers().size()-1));
        writeRecordsToFile(records, FILE_NAME);
        System.out.println(records.getAverageSalesNumberFromCity("New York"));
        System.out.println(records.getCustomerWithSalesNumberGreaterThan(100));
    }

    public static void writeRecordsToFile(CustomerRecords records, String fileName) {
        // Write the records to a file
        try(PrintWriter writer = new PrintWriter(fileName)) {
            for(Customer customer : records.getCustomers()) {
                writer.println(customer);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static CustomerRecords getRecordsFromFile(String fileName) {
        CustomerRecords records = new CustomerRecords();
        try(Scanner sc = new Scanner(fileName)) {
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                new Customer(line);
                records.addCustomer(new Customer(line));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return records;
    }
}