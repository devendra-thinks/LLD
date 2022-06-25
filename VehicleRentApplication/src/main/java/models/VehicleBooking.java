package models;

import models.Vehicle;

public class VehicleBooking {
     private User user;
     private Vehicle vehicle;
     private int fromDate , endDate;
     private BookingStatus bookingStatus;

     public User getUser() {
          return user;
     }

     public void setUser(User user) {
          this.user = user;
     }

     public Vehicle getVehicle() {
          return vehicle;
     }

     public void setVehicle(Vehicle vehicle) {
          this.vehicle = vehicle;
     }

     public int getFromDate() {
          return fromDate;
     }

     public void setFromDate(int fromDate) {
          this.fromDate = fromDate;
     }

     public int getEndDate() {
          return endDate;
     }

     public void setEndDate(int endDate) {
          this.endDate = endDate;
     }

     public BookingStatus getBookingStatus() {
          return bookingStatus;
     }

     public void setBookingStatus(BookingStatus bookingStatus) {
          this.bookingStatus = bookingStatus;
     }
}
