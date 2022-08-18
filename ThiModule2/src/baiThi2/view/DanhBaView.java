package baiThi2.view;

import baiThi2.model.SoDanhBa;
import baiThi2.service.DanhBaService;
import baiThi2.untils.AppUtils;
import baiThi2.untils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class DanhBaView {
    public List<SoDanhBa> soDanhBa;
    private static DanhBaService danhBaService = new DanhBaService();
    static Scanner input = new Scanner(System.in);

    public static void addPhone() {
        boolean flag = true;
        do {
            System.out.println();
            System.out.println("Thêm danh bạ");
            String numberPhone = inputPhoneNumber(ChoiceStatus.ADD);
            String nhom = inputNhom(ChoiceStatus.ADD);
            String fullName = inputFullName(ChoiceStatus.ADD);
            String gioiTinh = inputGioiTinh(ChoiceStatus.ADD);
            String address = inputDiaChi(ChoiceStatus.ADD);
            String birthDate = inputBirthDate(ChoiceStatus.ADD);
            String email = inputEmail(ChoiceStatus.ADD);
            System.out.println("Bạn đã thêm thành công");
            SoDanhBa soDanhBa = new SoDanhBa(numberPhone, nhom, fullName, gioiTinh, address, birthDate, email);
            danhBaService.addDanhBa(soDanhBa);
            Menu.view();
        } while (!flag);
    }

    public static void removePhone() {
        try {
            boolean flag = true;

            String phone = inputPhoneNumber(ChoiceStatus.REMOVE);
            danhBaService.remove(phone);
            System.out.println("Số điện thoại đã xóa");
            Menu.view();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void showPhoneList() {
        System.out.println("═══════════════════════════════════════════════════════════════════════════════ Danh Sách Users ════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Phone Number", "Nhóm", "Tên", "Giới Tính", "Địa chỉ", "BirthDay", "Email");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (SoDanhBa soDanhBa : danhBaService.findAll()) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    soDanhBa.getNumberPhone(),
                    soDanhBa.getNhomDanhBa(),
                    soDanhBa.getFullName(),
                    soDanhBa.getGioiTinh(),
                    soDanhBa.getAddress(),
                    soDanhBa.getBirthDate(),
                    soDanhBa.getEmail());
        }
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    public static void editPhone() {
        try {
            showPhoneList();
            System.out.println("Nhập số điện thoại cần sửa");
            System.out.print("=> ");
            String phone = input.nextLine().trim();
            if (danhBaService.exitsPhone(phone)) {
                String nhom = inputNhom(ChoiceStatus.ADD);
                String fullName = inputFullName(ChoiceStatus.ADD);
                String gioiTinh = inputGioiTinh(ChoiceStatus.ADD);
                String address = inputDiaChi(ChoiceStatus.ADD);
                String birthDate = inputBirthDate(ChoiceStatus.ADD);
                String email = inputEmail(ChoiceStatus.ADD);
                SoDanhBa soDanhBa = new SoDanhBa(phone, nhom, fullName, gioiTinh, address, birthDate, email);
                danhBaService.editDanhBa(soDanhBa);
                System.out.println("Số điện thoại đã được cập nhập");
            } else {
                System.out.println("Không tìm thấy ID sản phầm.");
                editPhone();
            }
            Menu.view();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void findPhone() {
        System.out.println("Nhập số điện thoại cần tìm");
        String phone = input.nextLine().trim();
        SoDanhBa soDanhBa = danhBaService.findPhone(phone);
        System.out.println("═══════════════════════════════════════════════════════════════════════════════ Danh Sách Users ════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Phone Number", "Nhóm", "Tên", "Giới Tính", "Địa chỉ", "BirthDay", "Email");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                soDanhBa.getNumberPhone(),
                soDanhBa.getNhomDanhBa(),
                soDanhBa.getFullName(),
                soDanhBa.getGioiTinh(),
                soDanhBa.getAddress(),
                soDanhBa.getBirthDate(),
                soDanhBa.getEmail());
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    public static String inputPhoneNumber(ChoiceStatus status) {
        String phoneNumber;
        switch (status) {
            case REMOVE:
            case ADD:
                System.out.println("Nhập số điện thoại của bạn: ");
                break;
            case EDIT:
                System.out.println("Nhập số điện thoại mới của bạn: ");
                break;
        }
        System.out.print("=> ");
        boolean flagInputTitle = true;
        do {
            phoneNumber = input.nextLine().trim();
            if (!ValidateUtils.isPhoneValid(phoneNumber)) {
                System.out.println("Số " + phoneNumber + " của bạn không đúng. Vui lòng nhập lại. (Số điện thoại bao gồm 10 -> 11 số và bắt đầu là số 0)");
                System.out.println("Nhập số điện thoại (VD: 0397502235)");
                System.out.print("=> ");
                continue;
            }
            break;
        } while (flagInputTitle);
        return phoneNumber;
    }

    public static String inputNhom(ChoiceStatus status) {
        String nhom;
        switch (status) {
            case ADD:
                System.out.println("Nhập nhóm của bạn: ");
                break;
            case EDIT:
                System.out.println("Nhập nhóm mới của bạn: ");
                break;
        }
        System.out.print("=> ");
        nhom = input.nextLine();
        return nhom;
    }

    public static String inputFullName(ChoiceStatus status) {
        String fullName;
        switch (status) {
            case ADD:
                System.out.println("Nhập tên: ");
                break;
            case EDIT:
                System.out.println("Nhập tên mới: ");
                break;
        }
        System.out.print("=> ");
        fullName = input.nextLine().trim();
        return fullName;
    }

    public static String inputGioiTinh(ChoiceStatus status) {
        String gioiTinh;
        switch (status) {
            case ADD:
                System.out.println("Nhập giới tính: ");
                break;
            case EDIT:
                System.out.println("Nhập giới tính mới: ");
                break;
        }
        System.out.print("=> ");
        gioiTinh = input.nextLine().trim();
        return gioiTinh;
    }

    public static String inputDiaChi(ChoiceStatus status) {
        String address;
        switch (status) {
            case ADD:
                System.out.println("Nhập địa chỉ: ");
                break;
            case EDIT:
                System.out.println("Nhập địa chỉ mới: ");
                break;
        }
        System.out.print("=> ");
        address = input.nextLine().trim();
        return address;
    }


    public static String inputBirthDate(ChoiceStatus status) {
        String birthDate;
        switch (status) {
            case ADD:
                System.out.println("Nhập ngày sinh: ");
                break;
            case EDIT:
                System.out.println("Nhập ngày sinh mới: ");
                break;
        }
        System.out.print("=> ");
            birthDate = input.nextLine().trim();
        return birthDate;
    }

    public static String inputEmail(ChoiceStatus status) {
        String email;
        switch (status) {
            case ADD:
                System.out.println("Nhập Email của bạn: ");
                break;
            case EDIT:
                System.out.println("Nhập Email mới của bạn: ");
                break;
        }
        System.out.print("=> ");
        boolean flagInputTitle = true;
        do {
            if (!ValidateUtils.isEmailValid(email = input.nextLine())) {
                System.out.println("Email " + email + "của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.println("Nhập email (VD: ngdquochuy241@gmail.com)");
                System.out.print("=> ");
                continue;
            }
            break;
        } while (flagInputTitle);
        return email;
    }
}
