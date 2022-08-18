package baiThi1;

public class MainVehicle {
    public static void main(String[] args) {
        Vihicle car = new Car(101,"Mazda", 2022, 32000, "Red", 0, 4, "V6");
        Vihicle motobike = new Motorbike(101, "Yamaha", 2021,15000, "White and Red", 1, "150cc");
        Vihicle truck = new Truck(103, "Honda", 2019, 48000, "Black", 2, "18 tấn");

//        Car
        System.out.println("Car Show");
        car.showMe();

        Vihicle.show(car);

//        Motobike
        System.out.println("MotoBike Show");
        Vihicle.show(motobike);

//        Truck
        System.out.println("Truck Show");
        Vihicle.show(truck);

    }
}
