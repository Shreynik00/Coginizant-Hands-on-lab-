package Week1_Fundamentals;

// 2. Define Repository Interface
interface CustomerRepository {
    String findCustomerById(String id);
}

// 3. Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // Mimicking a mock data fetch
        if ("C001".equals(id)) {
            return "John Doe";
        }
        return "Customer Not Found";
    }
}

// 4. Define Service Class
class CustomerService {
    private final CustomerRepository customerRepository;

    // 5. Implement Dependency Injection via Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void showCustomerDetails(String id) {
        String name = customerRepository.findCustomerById(id);
        System.out.println("Customer Profile Details (ID: " + id + "): " + name);
    }
}

// 6. Test the Dependency Injection Implementation
public class DependencyInjectionExample {
    public static void main(String[] args) {
        System.out.println("--- Testing Dependency Injection ---");

        // Instantiate the dependency object manually (composition root)
        CustomerRepository repo = new CustomerRepositoryImpl();

        // Inject the repository dependency into the service layer
        CustomerService service = new CustomerService(repo);

        // Execute service operations
        service.showCustomerDetails("C001");
        service.showCustomerDetails("C999");
    }
}