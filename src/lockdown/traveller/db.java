/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lockdown.traveller;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class db {
    private static String server="localhost";
    private static String username="root";
    private static String dbname="user_db";
    private static Integer portno=3306;
    private static String password="";
    
    public static Connection getConnection()
    {
        Connection cnx=null;
        
        MysqlDataSource datasource=new MysqlDataSource();
        
        datasource.setServerName(server);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portno);
        
        try {
            cnx=datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnx;
    }
    
}
