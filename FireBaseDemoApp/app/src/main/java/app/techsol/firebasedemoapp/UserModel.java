package app.techsol.firebasedemoapp;

public class UserModel {

    String phone, address;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserModel() {
    }

    public UserModel(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }
}
