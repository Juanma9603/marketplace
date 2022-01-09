package Entity;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    private int idSale;
    private Persona objpersona;
    private Date registerDatetime;
    private double igv;
    private double Total;
    private Boolean status;
    private ArrayList<SaleDetail> listSaleDetails;

    public Sale(){
        this.idSale=0;
        this.objpersona= new Persona();
        this.registerDatetime= new Date();
        this.igv=18.5;
        this.status = false;
        this.listSaleDetails=new ArrayList<SaleDetail>();
    }

    public Sale(int idSale,Persona objpersona, Date registerDatetime,double igv, Boolean status, ArrayList<SaleDetail> listSaleDetails){
        this.idSale=idSale;
        this.objpersona=objpersona;
        this.registerDatetime=registerDatetime;
        this.igv=igv;
        this.status=status;
        this.listSaleDetails = listSaleDetails;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public Persona getObjpersona() {
        return objpersona;
    }

    public void setObjpersona(Persona objpersona) {
        this.objpersona = objpersona;
    }

    public Date getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(Date registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public ArrayList<SaleDetail> getListSaleDetails() {
        return listSaleDetails;
    }

    public void setListSaleDetails(ArrayList<SaleDetail> listSaleDetails) {
        this.listSaleDetails = listSaleDetails;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", objpersona=" + objpersona +
                ", registerDatetime=" + registerDatetime +
                ", status=" + status +
                '}';
    }
}
