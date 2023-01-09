package exercise2;

import java.util.UUID;

public class Customer {
    private final UUID customerId;

    private String name;

    private String email;

    public Customer(String name, String email){
        this.customerId = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", email='" + email + '\'' + "\n" +
                '}';
    }
}
