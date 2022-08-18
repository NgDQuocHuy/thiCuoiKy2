package baiThi1;

public class Truck extends Vihicle implements DopNhienLieu{
    private String tonnage;

    public Truck(int id, String brand, int yearOfManufacture, int price, String color, int type, String tonnage) {
        super(id, brand, yearOfManufacture, price, color, type);
        this.tonnage = tonnage;

    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    public static void goHang() {
        System.out.println("Đang gỡ hàng xuống.");
    }

    @Override
    public void showMe() {
        System.out.println(toString());
    }

    @Override
    public void dopNhienLieu() {
        System.out.printf("Đớp %s lít dầu cho 100km", 6);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTrọng tải: " + tonnage;
    }
}
