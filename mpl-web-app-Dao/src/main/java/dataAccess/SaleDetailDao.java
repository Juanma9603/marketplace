package dataAccess;

import Connect.Conexion;
import Entity.SaleDetail;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.SQLException;

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


    public boolean Registrar(SaleDetail objSaleDetail){
        try {
            CallableStatement stm=con.Conectar().prepareCall("{CALL sp_saledetailregister(?,?,?)}");
            stm.setInt(1,objSaleDetail.getObjProduct().getID());
            stm.setInt(2,objSaleDetail.getUnits());
            stm.setDouble(3,objSaleDetail.getUnitPrice());
            stm.executeUpdate();
        }catch (SQLException e){
            logger.error("error sp_Saledetailregistrar"+e);
        }catch (Exception er){
            logger.error("error al ingresas un objSaleDetail"+er);
        }
        return true;
    }
}
