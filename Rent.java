package by.kursy.model.logic;

public class Rent {

    private String name;
    private String passport;
    private String phone;
    private String color;
    private int price;

    public Rent() {
    }

    public Rent(String name, String passport, String phone, String color, int price) {
        this.name = name;
        this.passport = passport;
        this.phone = phone;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " Rent" + " name = " + name + ", passport = " + passport +  ", phone = " 
                + phone +  ", color = " + color +  ", price = " + price + " ";
    }
  
}
