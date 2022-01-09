package dataAccess;

import Connect.Conexion;
import Entity.Sale;
import Entity.SaleDetail;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

public class SaleDao {
    private static Logger logger=Logger.getLogger(SaleDao.class);
    private static SaleDao Instance=null;
    private Conexion con=Conexion.getInstance();


    private SaleDao(){

    }

    public static SaleDao getInstance(){
        if (Instance==null){
            Instance=new SaleDao();
        }
        return Instance;
    }

    public boolean Registrar(Sale objSale){
        try {
            String UUID = java.util.UUID.randomUUID().toString();
            logger.info("realizando UUID"+UUID);
            Calendar cal=Calendar.getInstance();
            cal.setTime(objSale.getRegisterDatetime());
            cal.set(Calendar.MILLISECOND,0);
            CallableStatement stm=con.Conectar().prepareCall("{CALL sp_saleregister(?,?)}");
            stm.setString(1,UUID);
            stm.setInt(2,objSale.getObjpersona().getID());
            stm.executeUpdate();

            for (SaleDetail saleDetail:objSale.getListSaleDetails()){
                SaleDetailDao.getInstance().Registrar(saleDetail,UUID);
            }
        }catch (SQLException er){
            logger.error("error SQL sp_saleregister"+er);
        }catch (Exception e){
            logger.error("error registrar"+e);
        }

        return true;
    }
}
