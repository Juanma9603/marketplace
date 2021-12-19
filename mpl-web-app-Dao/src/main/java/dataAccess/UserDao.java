package dataAccess;

import Connect.Conexion;
import Entity.Persona;
import Entity.User;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Date;

public class UserDao {
    private static Logger logger=Logger.getLogger(UserDao.class);
    private static UserDao Instance=null;
    private Conexion con=Conexion.getInstance();

    private UserDao() {
    }

    public static UserDao getInstance(){
        if (Instance==null){
            Instance=new UserDao();
        }
        return Instance;
    }

    public void Registrar(Persona objPersona){
        try {
            CallableStatement ctm=con.Conectar().prepareCall("{CALL sp_registerUserNEW(?,?,?,?,?,?)}");
            ctm.setString(1,objPersona.getObjUser().getUsername());
            ctm.setString(2,objPersona.getObjUser().getPassword());
            ctm.setString(3,objPersona.getFirstname());
            ctm.setString(4,objPersona.getLastname());
            ctm.setString(5,objPersona.getBirthday());
            ctm.setString(6,objPersona.getEmail());
            ctm.execute();
        }catch (Exception e){
            logger.error("Error sp_registarusuarioNEW"+e);
        }
    }

    public Persona Autentication(User objUser){
        Persona objPersona=new Persona();
        try {
            CallableStatement ctm=con.Conectar().prepareCall("{CALL sp_autentication(?,?)}");
            ctm.setString(1,objUser.getUsername());
            ctm.setString(2,objUser.getPassword());
            ResultSet rs=ctm.executeQuery();
            while (rs.next()){
                objPersona =new Persona(
                        rs.getInt("id_Persona"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        "",
                        rs.getString("email"),
                        new Date(),
                        new Date(),
                        new User(
                                rs.getInt("id_User"),
                                rs.getString("username"),
                                "",
                                0,
                                new Date(),
                                new Date()
                        )
                );
            }
        }catch (Exception e){
            logger.error("error sp_autentication");
        }
        return objPersona;
    }

}
