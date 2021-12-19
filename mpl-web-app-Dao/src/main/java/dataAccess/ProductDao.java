package dataAccess;

import Connect.Conexion;
import Entity.Product;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ProductDao {
    private static Logger logger=Logger.getLogger(ProductDao.class);
    private static ProductDao instance=null;
    private Conexion con=Conexion.getInstance();

    private ProductDao(){

    }

    public static ProductDao getInstance(){
        if (instance==null){
            instance=new ProductDao();
        }
        return instance;
    }

    public ArrayList<Product> list(){
        ArrayList<Product> listproductos=new ArrayList<>();
        try {
            CallableStatement ctm=con.Conectar().prepareCall("{CALL sp_productLIST()}");
            ResultSet rs=ctm.executeQuery();
            while (rs.next()){
                Product objproduct=new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        new Date(),
                        new Date()
                );
                listproductos.add(objproduct);
            }
        }catch (Exception e){
            logger.error("Error al ejecutar sp_productLIST");
        }
        return listproductos;
    }

    public void Aniadir(Product objproduct){
        try {
            CallableStatement ctm=con.Conectar().prepareCall("{CALL sp_productINSERT(?,?,?,?,?)}");


        }catch(SQLException e){

        }
    }
}
