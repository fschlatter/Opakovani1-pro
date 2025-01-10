import java.util.ArrayList;
import java.util.List;

public class CustomerRecords {
    private List<Customer> customers;

    public CustomerRecords() {
        this.customers = new ArrayList<>();
    }

    public CustomerRecords(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public List<Customer> getCustomerWithSalesNumberGreaterThan(int salesNumber) {
        List<Customer> customersWithSalesNumberGreaterThan = new ArrayList<>();
        for(Customer customer : customers) {
            if(customer.getSalesNumber()>salesNumber) {
                customersWithSalesNumberGreaterThan.add(customer);
            }
        }
        return customersWithSalesNumberGreaterThan;
    }
    public int getAverageSalesNumberFromCity(String city) {
        int totalSalesNumber = 0;
        int numberOfCustomersFromCity = 0;
        for(Customer customer : customers) {
            if(customer.getCity().equals(city)) {
                totalSalesNumber+=customer.getSalesNumber();
                numberOfCustomersFromCity++;
            }
        }
        return totalSalesNumber/numberOfCustomersFromCity;
    }
}
