import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, String> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put("C001", "Ayush Sharma");
        customers.put("C002", "Gracy Patel");
    }

    @Override
    public String findCustomerById(String id) {
        return customers.getOrDefault(id, "Customer not found");
    }
}