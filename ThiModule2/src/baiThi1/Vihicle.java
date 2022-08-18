package baiThi1;

public abstract class Vihicle {
    private int id;
    private String brand;
    private int yearOfManufacture;
    private int price;
    private String color;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Vihicle(int id, String brand, int yearOfManufacture, int price, String color, int type) {
        this.id = id;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public abstract void showMe();

    public static void show(Vihicle vihicle) {
        if (vihicle instanceof Car) {
            vihicle.showMe();
            Car.moCuaSoTroi();
            ((Car) vihicle).dopNhienLieu();
            System.out.println();
            return;
        }
        if (vihicle instanceof Motorbike) {
            vihicle.showMe();
            Motorbike.bocDau();
            ((Motorbike) vihicle).dopNhienLieu();
            System.out.println();
            return;
        }
        if (vihicle instanceof Truck) {
            vihicle.showMe();
            Truck.goHang();
            ((Truck) vihicle).dopNhienLieu();
            return;
        }
    }

    @Override
    public String toString() {
        return "Id: " + id
                + "\nBrand: " + brand
                + "\nYear: " + yearOfManufacture
                + "\nPrice: " + price
                + "\nColor: " + color
                + "\nType: " + type;
    }
}
