package service;

import models.BookingStatus;
import models.User;
import models.Vehicle;
import models.VehicleBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManager {

    public static BookingManager  bookingManager = new BookingManager();
    List<VehicleBooking> allBookings = new ArrayList<>();
    Map<User, List<VehicleBooking> > userVehicleBooking = new HashMap<>();

    // create a reservation by a user against a vehicle date range  fromdate to todate
    public  synchronized  void  createBooking(User user, int fromDate , int toDate, Vehicle vehicle ){
        VehicleBooking booking = new VehicleBooking();
        booking.setBookingStatus( BookingStatus.BOOKED);
        booking.setUser( user);
        booking.setVehicle(vehicle);
        booking.setFromDate(fromDate);
        booking.setEndDate(toDate);
        allBookings.add(booking);
        if(!userVehicleBooking.containsKey(user)){
            userVehicleBooking.put(user, new ArrayList<>());
        }
        userVehicleBooking.get(user).add(booking);
        VehicleAvailability.getInstance().reserveVehicle(fromDate , toDate, vehicle);
    }

    // get All Booking Made By models.User
    public List<VehicleBooking> getAllBookingsMadeByUser(User user){
        return  userVehicleBooking.get(user);
    }

}
