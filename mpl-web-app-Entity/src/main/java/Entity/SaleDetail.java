package Entity;

import java.util.ArrayList;
import java.util.Date;

public class SaleDetail {
    private int id;
    private Product objProduct;
    private int units;
    private double unitPrice;
    private double subTotal;
    private Date registerDatetime;
    private Date updateDatetime;

    public SaleDetail(){
        this.id=0;
        this.objProduct =new Product();
        this.units=0;
        this.unitPrice=0.00;
        this.subTotal=0.00;
        this.registerDatetime=new Date();
        this.updateDatetime=new Date();
    }

    public SaleDetail(int id, Product objProduct, int units, double unitPrice, Date registerDatetime, Date updateDatetime) {
        this.id = id;
        this.objProduct = objProduct;
        this.units = units;
        this.unitPrice = unitPrice;
        this.registerDatetime = registerDatetime;
        this.updateDatetime = updateDatetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getObjProduct() {
        return objProduct;
    }

    public void setObjProduct(Product objProduct) {
        this.objProduct = objProduct;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(Date registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "SaleDetail{" +
                "id=" + id +
                ", objProduct=" + objProduct +
                ", units=" + units +
                ", unitPrice=" + unitPrice +
                ", registerDatetime=" + registerDatetime +
                ", updateDatetime=" + updateDatetime +
                '}';
    }
}
