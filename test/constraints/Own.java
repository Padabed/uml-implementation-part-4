package constraints;

import constraints.own.Delivery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

public class Own {

    private LocalDate startDate;
    private LocalDate endDate;
    private Delivery delivery;

    @BeforeEach
    public void load() {
        startDate = LocalDate.of(2023, 01, 01);
        endDate = LocalDate.of(2023, 02, 01);
    }

    @Test
    public void test() {
        try {

            // start != null : end != null : isArrived = true
            delivery = new Delivery("Alaska", startDate, true, endDate);
            delivery.setArrived(false);
            if (delivery.getEndDate() != null) fail();
            delivery.setArrived(true);
            if (delivery.getEndDate() == null) fail();

            // start != null : end != null : isArrived = false
            delivery = new Delivery("Alaska", startDate, false, endDate);
            if (delivery.getEndDate() != null) fail();
            delivery.setArrived(true);
            if (delivery.getEndDate() == null) fail();
            delivery.setArrived(false);
            if (delivery.getEndDate() != null) fail();

            // start != null : end == null : isArrived = false
            delivery = new Delivery("Alaska", startDate, false, null);
            if (delivery.getEndDate() != null) fail();
            delivery.setArrived(true);
            if (delivery.getEndDate() == null) fail();
            delivery.setArrived(false);
            if (delivery.getEndDate() != null) fail();

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
