package baiThi2.service;

import baiThi2.model.SoDanhBa;
import baiThi2.untils.CSVUntils;

import java.util.ArrayList;
import java.util.List;

public class DanhBaService {
    public final static String PATH = "C:\\Users\\huynd\\OneDrive\\Desktop\\ThiModule2\\thiCuoiKy2\\ThiModule2\\src\\baiThi2\\data\\danhBa.csv";
    private static DanhBaService instance;

    public static DanhBaService getInstance() {
        if (instance == null) {
            instance = new DanhBaService();
        }
        return instance;
    }

    public List<SoDanhBa> findAll() {
        List<SoDanhBa> danhBa = new ArrayList<>();
        List<String> records = CSVUntils.read(PATH);
        for (String record : records) {
            danhBa.add(SoDanhBa.parseDanhBa(record));
        }
        return danhBa;
    }

    public void addDanhBa(SoDanhBa soDanhBa) {
        List<SoDanhBa> danhBa = findAll();
        danhBa.add(soDanhBa);
        CSVUntils.write(PATH, danhBa);
    }

    public void editDanhBa(SoDanhBa newDanhBa) {
        List<SoDanhBa> danhBa = findAll();
        for (SoDanhBa oldSoDanhBa : danhBa) {
            if (oldSoDanhBa.getNumberPhone().equals(newDanhBa.getNumberPhone())) {
                String nhom = newDanhBa.getNhomDanhBa();
                if (nhom != null && !nhom.isEmpty()) {
                    oldSoDanhBa.setNhomDanhBa(nhom);
                }
                String fullName = newDanhBa.getFullName();
                if (fullName != null && !fullName.isEmpty()) {
                    oldSoDanhBa.setFullName(fullName);
                }
                String gioiTinh = newDanhBa.getGioiTinh();
                if (gioiTinh != null && !gioiTinh.isEmpty()) {
                    oldSoDanhBa.setGioiTinh(gioiTinh);
                }
                String address = newDanhBa.getAddress();
                if (address != null && !address.isEmpty()) {
                    oldSoDanhBa.setAddress(address);
                }
                String birthDate = newDanhBa.getBirthDate();
                if (birthDate != null && !birthDate.isEmpty()) {
                    oldSoDanhBa.setBirthDate(birthDate);
                }
                String email = newDanhBa.getEmail();
                if (email != null && !email.isEmpty()) {
                    oldSoDanhBa.setEmail(email);
                }
                CSVUntils.write(PATH, danhBa);
            }
        }
    }

    public void remove(String numberPhone) {
        List<SoDanhBa> danhBa = findAll();
        danhBa.removeIf(number -> number.getNumberPhone().equals(numberPhone));
        CSVUntils.write(PATH, danhBa);
    }

    public SoDanhBa findPhone(String numberPhone) {
        List<SoDanhBa> danhBa = findAll();
        for (SoDanhBa soDanhBa : danhBa) {
            if (soDanhBa.getNumberPhone().equals(numberPhone)) {
                return soDanhBa;
            }
        }
        return null;
    }

    public boolean exitsPhone(String numberPhone) {
        return findPhone(numberPhone) != null;
    }
}
