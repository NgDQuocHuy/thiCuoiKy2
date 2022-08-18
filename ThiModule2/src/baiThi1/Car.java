package baiThi1;

public class Car extends Vihicle implements DopNhienLieu{
    private int seatingCapacity;
    private String engineType;

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Car(int id, String brand, int yearOfManufacture, int price, String color, int type, int seatingCapacity, String engineType) {
        super(id, brand, yearOfManufacture, price, color, type);
        this.seatingCapacity = seatingCapacity;
        this.engineType = engineType;
    }

    public static void moCuaSoTroi() {
        System.out.println("Đã mở cửa sổ trời, mời thưởng thức");
    }

    @Override
    public void showMe() {
        System.out.println(toString());
    }

    @Override
    public void dopNhienLieu() {
        System.out.printf("Đớp %s lít xăng cho 100km", 7);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nSố chỗ ngồi: " + seatingCapacity
                + "\nKiểu động cơ: " + engineType;
    }
}
