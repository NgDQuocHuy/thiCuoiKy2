package baiThi1;

public class Motorbike extends Vihicle implements DopNhienLieu{
    private String cc;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Motorbike(int id, String brand, int yearOfManufacture, int price, String color, int type, String cc) {
        super(id, brand, yearOfManufacture, price, color, type);
        this.cc = cc;
    }

    public static void bocDau() {
        System.out.println("Bốc đầu zui ghê.");
    }

    @Override
    public void showMe() {
        System.out.println(toString());
    }

    @Override
    public void dopNhienLieu() {
        System.out.printf("Đớp %s lít xăng cho 100km", 1,5);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPhân khối: " + cc;
    }
}
