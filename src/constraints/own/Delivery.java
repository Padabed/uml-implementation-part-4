package constraints.own;

import java.time.LocalDate;
import java.time.Period;

public class Delivery {

    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isArrived;

    public Delivery(String destination, LocalDate startDate, boolean isArrived, LocalDate endDate) {
        setDestination(destination);
        setStartDate(startDate);
        setArrived(isArrived);
        if (isArrived) {
            setEndDate(endDate);
        }
    }

    public int calculateDeliveryDays() {
        if (!isArrived) {
            throw new IllegalArgumentException("Not yet delivered");
        }
        return Period.between(startDate, endDate).getDays();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Destination is required");
        }
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null");
        }
        if (endDate != null && startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Something was messed up");
        }
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate == null) {
            if (isArrived) {
                throw new IllegalArgumentException("End date must be provided");
            }
            return;
        }
        if (startDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Something was messed up");
        }
        isArrived = true;
        this.endDate = endDate;
    }

    public boolean getArrived() {
        return isArrived;
    }

    public void setArrived(boolean arrived) {
        if (arrived) {
            setEndDate(LocalDate.now());
        } else {
            endDate = null;
        }
        isArrived = arrived;
    }
}
