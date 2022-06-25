import models.User;
import models.Vehicle;
import models.VehicleBooking;
import models.VehicleType;
import service.BookingManager;
import service.VehicleAvailability;
import service.VehicleInventory;

import java.util.List;

public class VehicleRentApplication {
  public static void main(String[] args) {
    //create Vehicle
    Vehicle biCycle = new Vehicle("1234-5678", VehicleType.BICYCLE);
    Vehicle truck = new Vehicle("1234-5678", VehicleType.TRUCK);

    VehicleInventory.getVehicleInventory().addVehicle(biCycle);
    VehicleInventory.getVehicleInventory().addVehicle(truck);

    User user = new User();
    user.setAdharNumber("1234");
    user.setName("Devendra");
    user.setPassword("xxxyyyxxx");

    int  fromDate , toDate;
    fromDate = 20220626;
    toDate = 20220628;
    List<Vehicle > vehicleList = VehicleAvailability
            .getInstance()
            .getAvailableVehicles(fromDate, toDate, VehicleType.BICYCLE.ordinal());

    // Available vehicles are
    for(Vehicle vehicle : vehicleList ){
        System.out.println(String.format("Available vehicle  fromDate : %d , toDate : %d , is %s",fromDate, toDate, vehicle.number ));
    }

    // Reserve vehicle
    Vehicle toBeReservedVehicle = vehicleList.get(0);

    BookingManager.bookingManager.createBooking(user, fromDate, toDate, toBeReservedVehicle);

    List<Vehicle > vehicleList1  = VehicleAvailability
            .getInstance()
            .getAvailableVehicles(fromDate, toDate, VehicleType.BICYCLE.ordinal());

    // Available vehicles are
    for(Vehicle vehicle : vehicleList1 ){
      System.out.println(String.format("Available vehicle  fromDate : %d , toDate : %d , is %d",fromDate, toDate, vehicle.number ));
    }

    // List User Booking
    List<VehicleBooking > bookings = BookingManager.bookingManager.getAllBookingsMadeByUser(user);

    for(VehicleBooking vehicleBooking : bookings){
      System.out.print(String.format("Booking made by user : %s of vehicle : %s  fromDate : %d , toDate : %d",
              vehicleBooking.getUser().getName(), vehicleBooking.getVehicle().number ,  fromDate, toDate ));
    }
  }
}
