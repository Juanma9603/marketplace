package Sales;

import Connect.Conexion;
import dto.Orders;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderDao {
    private static Logger logger=Logger.getLogger(OrderDao.class);
    private Conexion con=Conexion.getInstance();

    /*Singleton*/
    private static OrderDao Instance=null;
    private OrderDao(){}
    public static OrderDao getInstance(){
        if (Instance == null){
            Instance=new OrderDao();
        }
        return Instance;
    }

    public ArrayList<Orders> getlist(int idCustomer)throws SQLException{
        ArrayList<Orders> orders=new ArrayList<Orders>();
        try {
            CallableStatement cs=con.Conectar().prepareCall("{Call sp_reportSalesByClient(?)}");
            cs.setInt(1,idCustomer);
            ResultSet rs=cs.executeQuery();
            while (rs.next()){
                orders.add(new Orders(
                  rs.getString("idSale"),
                  new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(rs.getString("register_date")),
                        rs.getInt("quantity"),
                        rs.getDouble("subtotal"),
                        rs.getDouble("igv"),
                        rs.getDouble("total")
                )
                );
            }
        }catch (SQLException sqlException){
            logger.error("error idCustomer"+sqlException);
        }catch (Exception e){
            logger.error("error al listar orders"+e);
        }finally {
            con.Conectar().close();
            return orders;
        }

    }
}
