package service;

import models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleInventory {
      // vehicle type -> List of vehicles
      public  Map<Integer , List<Vehicle > > typeWiseVehicleMap = new HashMap<>();
      List<Vehicle > allVehicles = new ArrayList<>();
      private static VehicleInventory vehicleInventory = new VehicleInventory();
      private VehicleInventory(){}
      public static VehicleInventory getVehicleInventory() {
            return vehicleInventory;
      }
      // Add vehicle
      public  void addVehicle(Vehicle vehicle){
            if(!typeWiseVehicleMap.containsKey(vehicle.vehicleType))
                  typeWiseVehicleMap.put(vehicle.vehicleType.ordinal(), new ArrayList<>());
            typeWiseVehicleMap.get(vehicle.vehicleType.ordinal()).add(vehicle);
            allVehicles.add(vehicle);
      }

      // Remove models.Vehicle
      public  void removeVehicle(String vNumber ){
           for(int type : typeWiseVehicleMap.keySet()){
                 List<Vehicle > vehicles = typeWiseVehicleMap.get(type);
                 for(Vehicle vehicle : vehicles){
                       if(vNumber.equalsIgnoreCase(vehicle.number)){
                           vehicles.remove(vehicle);
                           allVehicles.remove(vehicle);
                           return;
                       }
                 }
           }
      }

      public Vehicle getVehicleByName(String vNumber){
            for(Vehicle vehicle : allVehicles){
                  if(vehicle.number == vNumber)
                        return vehicle;
            }
            return null;
      }
}
