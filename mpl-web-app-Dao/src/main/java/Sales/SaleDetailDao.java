package Sales;

import Connect.Conexion;
import Entity.Product;
import Entity.SaleDetail;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SaleDetailDao {
    private static Logger logger=Logger.getLogger(SaleDetailDao.class);
    private static SaleDetailDao Instance=null;
    private Conexion con=Conexion.getInstance();

    private SaleDetailDao(){

    }

    public static SaleDetailDao getInstance(){
        if (Instance==null){
            Instance=new SaleDetailDao();
        }
        return Instance;
    }


    public boolean Registrar(SaleDetail objSaleDetail,String idSale){
        try {
            CallableStatement stm=con.Conectar().prepareCall("{CALL sp_saledetailregister(?,?,?,?)}");
            stm.setInt(1,objSaleDetail.getObjProduct().getID());
            stm.setInt(2,objSaleDetail.getUnits());
            stm.setDouble(3,objSaleDetail.getUnitPrice());
            stm.setString(4,idSale);
            stm.executeUpdate();
        }catch (SQLException e){
            logger.error("error sp_Saledetailregistrar"+e);
        }catch (Exception er){
            logger.error("error al ingresar un objSaleDetail"+er);
        }
        return true;
    }

    public ArrayList<SaleDetail> get(String idSale){
        ArrayList<SaleDetail> lst=new ArrayList<>();
        try {
            logger.info(idSale.toString());
            CallableStatement cs=con.Conectar().prepareCall("{Call sp_saleDetailget(?)}");
            cs.setString(1,idSale);
            logger.info("obteniendo detail de base de datos");
            ResultSet rs=cs.executeQuery();
            while (rs.next()){
                lst.add(
                        new SaleDetail(
                                rs.getInt("id_SaleDetail"),
                                new Product(
                                        rs.getInt("id_Product"),
                                        rs.getString("name"),
                                        "",
                                        "",
                                        0.0,
                                        0,
                                        new Date(),
                                        new Date()
                                ),
                                rs.getInt("units"),
                                rs.getDouble("unitPrice"),
                                new Date(),
                                new Date()
                        )
                );
            }
            con.Conectar().close();
        }catch (Exception e){
            logger.error("error al obtener la lista final de detalle" +e);
        }
        return lst;
    }
}
