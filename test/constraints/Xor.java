package constraints;

import constraints.xor.Car;
import constraints.xor.Customer;
import constraints.xor.Motorcycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class Xor {

    private Customer customer;
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    public void load() {
        try {
            car = new Car(4);
            motorcycle = new Motorcycle(240);
            customer = new Customer("Ilya");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test() {
        try {

         customer.rentCar(car);
         car.removeCustomer();
         car.setCustomer(customer);

         customer.returnCar();

         if (customer.getRentedMotorcycle() != null
                 || customer.getRentedCar() != null
                 || car.getCustomer() != null
                 || motorcycle.getCustomer() != null
         )  fail();

         motorcycle.setCustomer(customer);

         if (motorcycle.getCustomer() == null) fail();
         if (customer.getRentedMotorcycle() != motorcycle) fail();

         try {
             customer.rentCar(car);
         } catch (Exception e) {
             if (e == null) {
                 fail();
             }
             e.printStackTrace();
         }

         customer.returnCar();
         motorcycle.setCustomer(customer);
         customer.rentMotorcycle(motorcycle);
         if (motorcycle.getCustomer() == null) fail();
         motorcycle.removeCustomer();
         car.setCustomer(customer);
         if (customer.getRentedCar() != car) fail();
         customer.returnCar();
         if (customer.getRentedCar() != null || car.getCustomer() != null) fail();
         motorcycle.setCustomer(customer);
         customer.returnMotorcycle();

         if (customer.getRentedMotorcycle() != null
                 || customer.getRentedCar() != null
                 || car.getCustomer() != null
                 || motorcycle.getCustomer() != null
         )  fail();


        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
