package baiThi2.untils;


import java.text.DecimalFormat;
import java.util.Scanner;

public class AppUtils {
    static Scanner scanner = new Scanner(System.in);

    public static int retryChoose(int min, int max) {
        int option;
        do {
            System.out.print(" ⭆ ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (true);
        return option;
    }

    public static int retryParseInt() {
        int result;
        do {
            System.out.print(" ⭆ ");
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (true);
    }

    public static String retryString(String fieldName) {
        String result;
        System.out.print(" ⭆ ");
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.printf("%s không được để trống\n", fieldName);
            System.out.print(" ⭆ ");
        }
        return result;
    }

    public static double retryParseDouble() {
        double result;
        do {
            System.out.print(" ⭆ ");
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (true);
    }

    public static String doubleToVND(double value) {
        String patternVND = ",###₫";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }



    public static void exit() {
        System.out.println("\tTạm biệt. Hẹn gặp lại!");
        System.exit(5);
    }
}
