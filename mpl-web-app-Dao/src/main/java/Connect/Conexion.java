package Connect;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion Instance=null;
    private static Logger logger=Logger.getLogger(Conexion.class);

    private Conexion (){

    }

    public static Conexion getInstance(){
        if (Instance==null){
            Instance=new Conexion();
        }
        return Instance;
    }

    public Connection Conectar(){
        PropertyConfigurator.configure("/usr/local/tomcat/conf/logs.properties");
        Connection c=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://172.17.0.3:3306/marketplace","root","pass");
        }catch (SQLException ex){
            logger.error("error en sql"+ex);
        }catch (Exception e){
            logger.error("error conectar"+e);
        }

        return c;
    }
}
