package baiThi2.view;

import java.util.Scanner;

public class Menu {
    public static void view() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("* * * * * * * * * * * * *  Chương Trình Quản Lý Danh Bạ * * * * * * * * * * * * * * * * * *");
            System.out.println("*              Chọn chức năng theo số (để tiếp tục) :                         ");
            System.out.println("1.     Xem danh sách                                     ");
            System.out.println("2.     Thêm mới                 ");
            System.out.println("3.     Cập nhật                             ");
            System.out.println("4.     Xóa                       ");
            System.out.println("5.     Tìm kiếm                       ");
            System.out.println("6.     Đọc từ file       ");
            System.out.println("7.     Ghi vào file      ");
            System.out.println("8.     Thoát      ");
            System.out.println("Chọn chức năng:       ");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    DanhBaView.showPhoneList();
                    break;
                case 2:
                    DanhBaView.addPhone();
                    break;
                case 3:
                    DanhBaView.editPhone();
                    break;
                case 4:
                    DanhBaView.removePhone();
                    break;
                case 5:
                    DanhBaView.findPhone();
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        } while (choice != 8);
    }
}
