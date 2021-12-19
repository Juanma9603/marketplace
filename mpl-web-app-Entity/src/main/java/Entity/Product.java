package Entity;

import java.util.Date;

public class Product {
    private int ID;
    private String Name;
    private String TradeMark;
    private String Description;
    private double Price;
    private int Stock;
    private Date timestamp_register;
    private Date timestamp_update;

    public Product() {
        this.ID = 0;
        Name = "";
        TradeMark = "";
        Description = "";
        Price = 0.0;
        Stock = 0;
        this.timestamp_register = new Date();
    }

    public Product(int ID, String name, String tradeMark, String description, double price, int stock, Date timestamp_register, Date timestamp_update) {
        this.ID = ID;
        Name = name;
        TradeMark = tradeMark;
        Description = description;
        Price = price;
        Stock = stock;
        this.timestamp_register = timestamp_register;
        this.timestamp_update = timestamp_update;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTradeMark() {
        return TradeMark;
    }

    public void setTradeMark(String tradeMark) {
        TradeMark = tradeMark;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public Date getTimestamp_register() {
        return timestamp_register;
    }

    public void setTimestamp_register(Date timestamp_register) {
        this.timestamp_register = timestamp_register;
    }

    public Date getTimestamp_update() {
        return timestamp_update;
    }

    public void setTimestamp_update(Date timestamp_update) {
        this.timestamp_update = timestamp_update;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", TradeMark='" + TradeMark + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", Stock=" + Stock +
                ", timestamp_register=" + timestamp_register +
                ", timestamp_update=" + timestamp_update +
                '}';
    }
}
