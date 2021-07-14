/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lockdown.traveller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class jdbc {
    public static void main(String[] args) throws Exception
    {
        //createTable();
        get();
    }
    
    /**
     *
     * @return
     */
    public static ArrayList<String> get() throws Exception{
        ArrayList<String> array=new ArrayList<String>();
        try{
            Connection con=getConnection();
            PreparedStatement statement=con.prepareStatement("SELECT first,last FROM tablename");
            ResultSet result=statement.executeQuery();
            
            
            while(result.next())
            {
                System.out.println(result.getString("first")+"  "+result.getString("last"));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return array;
    }
    
    public static void post(final String var1) throws Exception{
        
        try{
            Connection con=getConnection();
            PreparedStatement posted=con.prepareStatement("INSERT INTO train_name(name) VALUES('"+var1+"')");
            posted.executeUpdate();
            //System.out.println("inserted");
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void createTable() throws Exception {
        
        try{
            Connection con=getConnection();
            PreparedStatement create=con.prepareStatement("CREATE TABLE IF NOT EXISTS train_name(id int NOT NULL AUTO_INCREMENT,name varchar(255),PRIMARY KEY(id))");
            create.executeUpdate();
            //System.out.println("table is created");
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static Connection getConnection() throws Exception
    {
     
        try{
          String driver ="com.mysql.jdbc.Driver";
          String url="jdbc:mysql://localhost:3306/user_db";
          String username="root";
          String password="";
          Class.forName(driver);
          
          Connection conn=DriverManager.getConnection(url,username,password);
          //System.out.println("connected");
          return conn;
          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            return null;
    }
    
}
