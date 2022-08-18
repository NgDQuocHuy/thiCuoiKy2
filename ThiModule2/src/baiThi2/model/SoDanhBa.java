package baiThi2.model;

import java.util.List;
import java.util.Objects;

public class SoDanhBa {
    private String numberPhone;
    private String nhomDanhBa;
    private String fullName;
    private String gioiTinh;
    private String address;
    private String birthDate;
    private String email;

    public List<SoDanhBa> soDanhBa;
    public SoDanhBa() {}

    public SoDanhBa(String numberPhone, String nhomDanhBa, String fullName, String gioiTinh, String address, String birthDate, String email) {
        this.numberPhone = numberPhone;
        this.nhomDanhBa = nhomDanhBa;
        this.fullName = fullName;
        this.gioiTinh = gioiTinh;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }

    public static SoDanhBa parseDanhBa(String rawDanhBa) {
        String[] array = rawDanhBa.split(",");
        SoDanhBa soDanhBa = new SoDanhBa();
        soDanhBa.setNumberPhone(array[0]);
        soDanhBa.setNhomDanhBa(array[1]);
        soDanhBa.setFullName(array[2]);
        soDanhBa.setGioiTinh(array[3]);
        soDanhBa.setAddress(array[4]);
        soDanhBa.setBirthDate(array[5]);
        soDanhBa.setEmail(array[6]);
        return soDanhBa;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getNhomDanhBa() {
        return nhomDanhBa;
    }

    public void setNhomDanhBa(String nhomDanhBa) {
        this.nhomDanhBa = nhomDanhBa;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                numberPhone,
                nhomDanhBa,
                fullName,
                gioiTinh,
                address,
                birthDate,
                email);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SoDanhBa soDanhBa = (SoDanhBa) obj;
        return numberPhone.equals(soDanhBa.numberPhone);
    }

    public int hashCode() {
        return Objects.hashCode(numberPhone);
    }
}
