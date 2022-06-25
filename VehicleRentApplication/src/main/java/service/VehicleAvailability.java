package service;

import models.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class VehicleAvailability {
    // day -> vehicleType -> available vehicles
    static Map<Integer , Map<Integer,  List<Vehicle >  > > vehicleTypeMap  = new HashMap<>();

    public static VehicleAvailability vehicleAvailability = new VehicleAvailability();
    private VehicleAvailability(){}

    public static  VehicleAvailability getInstance(){
        return  vehicleAvailability;
    }

    static{
        // booking till  next  week
        List<Integer  > nextDays = Arrays.asList(20220625, 20220626 ,20220627 , 20220628, 20220629, 20220630,  20220631);

        for(int i = 0 ; i < nextDays.size() ; i++ ){
            vehicleTypeMap.put(nextDays.get(i), VehicleInventory.getVehicleInventory().typeWiseVehicleMap);
        }
    }
    // fromDate
    // toDate
    // type
    // get Available vehicles fromDate to toDate of type
    // complexity -  O(range*vehicle*log(vehicle))
    public synchronized List<Vehicle> getAvailableVehicles(int fromDate , int toDate, int type){
        Set<String > availableVehicles = null ;
        List<Vehicle > res = new ArrayList<>();
        for(int i  = fromDate  ; i <=  toDate  ; ++i){
            if(vehicleTypeMap.get(i).get(type).size() > 0 )
            {
                List<Vehicle > vehicles = vehicleTypeMap.get(i).get(type);
                Set<String > numbers = vehicles.stream().map(vehicle -> vehicle.number).collect(Collectors.toSet());
                if(availableVehicles == null ){
                    availableVehicles = numbers;
                }else{
                    availableVehicles.retainAll(numbers);
                }
            }
        }
        if(availableVehicles == null || availableVehicles.isEmpty()){
            return res;
        }
        for(String vNumber : availableVehicles) {
            res.add( VehicleInventory.getVehicleInventory().getVehicleByName(vNumber));
        }
        return res;
    }

    private  void printMap(int date ){
        Map<Integer,  List<Vehicle >> map = vehicleTypeMap.get(date);
        System.out.print(String.format("Availability Map for date : %d \n", date));
        for(int vehicleType : map.keySet()){
             List<Vehicle > vehicles = map.get(vehicleType);
             System.out.println(String.format("VehicleType : %d ", vehicleType));
             for(Vehicle vehicle : vehicles){
                   System.out.print(vehicle.number + "  ");
             }
             System.out.println();
        }
    }

    public synchronized  void  reserveVehicle(int fromDate , int toDate, Vehicle vehicle){
        for(int i  = fromDate  ; i <=  toDate  ; ++i ){
            vehicleTypeMap.get(i).get(vehicle.vehicleType.ordinal()).remove(vehicle);
        }
    }
}
