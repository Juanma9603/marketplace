package dataAccess;

import Connect.Conexion;
import Entity.Sale;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

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
            logger.info("realizando ingreso de Dao");
            CallableStatement stm=con.Conectar().prepareCall("{CALL sp_saleregister(?,?)}");
            stm.setInt(1,objSale.getObjpersona().getID());
            stm.setDate(2,(Date) objSale.getRegisterDatetime());
            stm.executeUpdate();
        }catch (SQLException er){
            logger.error("error SQL"+er);
        }catch (Exception e){
            logger.error("error registrar"+e);
        }

        return true;
    }
}
