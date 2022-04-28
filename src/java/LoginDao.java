
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @author adrianadewunmi
 * 
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adrianadewunmi
 */
public class LoginDao {
    
    public static boolean validate(String User_Name, String User_Password) throws SQLException{
        boolean status = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conURL = DriverManager.getConnection("jdbc:mysql://localhost:3306/EventlyDB", "root", "abc")) {
                PreparedStatement preparedStatement = 
                        conURL.prepareStatement("select * from plogindetails where User_Name=? and User_Password=?");
                preparedStatement.setString(1, User_Name);
                preparedStatement.setString(2, User_Password);
                ResultSet resultSet = preparedStatement.executeQuery();
                status = resultSet.next();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
}
