package baiThi1;

public interface DopNhienLieu {
    default void dopNhienLieu() {
        System.out.println("Đớp %s nhiên liệu cho 100km");
    };
}
