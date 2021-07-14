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
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class station_db {
    public static void main(String[] args) throws Exception
    {
        createTable();
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
            PreparedStatement statement=con.prepareStatement("SELECT * FROM station");
            ResultSet result=statement.executeQuery();
            
            
            while(result.next())
            {
                //System.out.println(result.getString("first")+"  "+result.getString("last"));
                array.add(result.getString("name"));
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
            PreparedStatement find=con.prepareStatement("SELECT * from station WHERE name='"+var1+"'");
            ResultSet result=find.executeQuery();
            if(!result.next()&&!var1.trim().equals(""))
            {
            PreparedStatement posted=con.prepareStatement("INSERT INTO station(name) VALUES('"+var1+"')");
            posted.executeUpdate();
            //System.out.println("inserted");
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void pathpost(final String var1,final String var2,final int distance,final int time) throws Exception{
        
        try{
            Connection con=getConnection();
            PreparedStatement posted=con.prepareStatement("INSERT INTO path(first,second,distance,time) VALUES('"+var1+"','"+var2+"','"+distance+"','"+time+"')");
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
            PreparedStatement create=con.prepareStatement("CREATE TABLE IF NOT EXISTS station(id int NOT NULL AUTO_INCREMENT,name varchar(255),PRIMARY KEY(id))");
            create.executeUpdate();
           // System.out.println("table is created");
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void createPathTable() throws Exception {
        
        try{
            Connection con=getConnection();
            PreparedStatement create=con.prepareStatement("CREATE TABLE IF NOT EXISTS path(id int NOT NULL AUTO_INCREMENT,first varchar(255),second varchar(255),distance int,time int,PRIMARY KEY(id))");
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
    
    public static int finddistance(ArrayList<String> arr)
    {
        try {
            Connection con=getConnection();
            String first=null;
            String second=null;
            int dis=0;
            PreparedStatement find;
            ResultSet result;
            for(int i=1;i<arr.size();i++)
            {
                first=arr.get(i-1);
                second=arr.get(i);
                find=con.prepareStatement("SELECT distance From path WHERE first='"+first+"' and second='"+second+"' or second='"+first+"' and first='"+second+"'");
                result=find.executeQuery();
                while(result.next())
                {
                    dis=dis+result.getInt("distance");
                }
                
            }
            //System.out.println(dis);
            return dis;
        } catch (Exception ex) {
            Logger.getLogger(station_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return 0;
    }
    
    public static int findtime(ArrayList<String> arr)
    {
        try {
            Connection con=getConnection();
            String first=null;
            String second=null;
            int time=0;
            PreparedStatement find;
            ResultSet result;
            for(int i=1;i<arr.size();i++)
            {
                first=arr.get(i-1);
                second=arr.get(i);
                find=con.prepareStatement("SELECT time From path WHERE first='"+first+"' and second='"+second+"' or second='"+first+"' and first='"+second+"'");
                result=find.executeQuery();
                while(result.next())
                {
                    time=time+result.getInt("time");
                }
                
            }
            return time;
        } catch (Exception ex) {
            Logger.getLogger(station_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    
    public static void addtrain(final String name,ArrayList<String> arr)
    {
        try{
            Connection con=getConnection();
            PreparedStatement create=con.prepareStatement("CREATE TABLE IF NOT EXISTS train(name varchar(255),PRIMARY KEY(name))");
            create.executeUpdate();
            PreparedStatement createroot=con.prepareStatement("CREATE TABLE IF NOT EXISTS roots(id int,train_name varchar(255),station_name varchar(255),PRIMARY KEY(train_name,station_name))");
            createroot.executeUpdate();
            PreparedStatement posted=con.prepareStatement("INSERT INTO train(name) VALUES('"+name+"')");
            posted.executeUpdate();
            String station_name=null;
            for(int i=0;i<arr.size();i++)
            {
                station_name=arr.get(i);
                posted=con.prepareStatement("INSERT INTO roots(id,train_name,station_name) VALUES('"+i+"','"+name+"','"+station_name+"')");
                posted.executeUpdate();
                
            }
            
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static ArrayList<String> findtrain(final String start,final String end)
    {
        ArrayList<String> arr=new ArrayList<String>();
        
        try {
            Connection con=getConnection();
            PreparedStatement find=con.prepareStatement("SELECT train_name FROM roots WHERE station_name='"+start+"' or station_name='"+end+"' GROUP BY train_name HAVING COUNT(train_name)=2");
            ResultSet result=find.executeQuery();
            while(result.next())
            {
                arr.add(result.getString("train_name"));
            }
            return arr;
        } catch (Exception ex) {
            Logger.getLogger(station_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return arr;
    }
    
    public static ArrayList<String> findtrainroot(final String name)
    {
        ArrayList<String> arr=new ArrayList<String>();
        
        try {
            Connection con=getConnection();
            PreparedStatement find=con.prepareStatement("SELECT station_name FROM roots WHERE train_name='"+name+"' ORDER BY id");
            ResultSet result=find.executeQuery();
            while(result.next())
            {
                arr.add(result.getString("station_name"));
            }
            return arr;
        } catch (Exception ex) {
            Logger.getLogger(station_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return arr;
    }
    
    
    public static ArrayList<String> finddadicatedroot(ArrayList<String> arr,final String start,final String end)
    {
        ArrayList<String> rarr=new ArrayList<String>();
        int x=0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).equals(start)||arr.get(i).equals(end))
            {
                x++;
            }
            if(x!=0)
            {
                rarr.add(arr.get(i));
            }
            if(x==2)
            {
                break;
            }
        }
        //System.out.print(rarr);
        
        
        return rarr;
    }
    
    public static ArrayList<String> loadtrains()
    {
        ArrayList<String> arr=new ArrayList<String>();
        try {
            Connection con=getConnection();
            PreparedStatement find=con.prepareStatement("SELECT * FROM train");
            ResultSet result=find.executeQuery();
            while(result.next())
            {
                arr.add(result.getString("name"));
            }
            return arr;
        } catch (Exception ex) {
            Logger.getLogger(station_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return arr;
    }
    
    public static void secheduletrain(final String name,Date date,int seats,int hour,int min)
    {
        try{
            Connection con=getConnection();
            PreparedStatement create=con.prepareStatement("CREATE TABLE IF NOT EXISTS timetable(id int NOT NULL AUTO_INCREMENT,name varchar(255),date Date,hour int,min int,seats int,PRIMARY KEY(id))");
            create.executeUpdate();
           
            java.util.Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, hour);
            cal.set(Calendar.MINUTE,min);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date startdate=cal.getTime();
            java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
            ArrayList<String> arr=station_db.findtrainroot(name);
            int timetaken=station_db.findtime(arr);
            cal.add(Calendar.MINUTE, timetaken);
            Date enddate=cal.getTime();
            
            PreparedStatement search=con.prepareStatement("SELECT * FROM timetable WHERE name='"+name+"'");
            ResultSet result=search.executeQuery();
            boolean isfind=false;
            Date sdate,edate;
            java.util.Calendar cmpcal = Calendar.getInstance();
            while(result.next())
            {
                cmpcal.setTime(result.getDate("date"));
                cmpcal.set(Calendar.HOUR_OF_DAY, result.getInt("hour"));
                cmpcal.set(Calendar.MINUTE,result.getInt("min"));
                sdate=cmpcal.getTime();
                cmpcal.add(Calendar.MINUTE, timetaken);
                edate=cmpcal.getTime();
                
                if((startdate.compareTo(sdate)>=0&&startdate.compareTo(edate)<=0)||(enddate.compareTo(sdate)>=0&&enddate.compareTo(edate)<=0))
                {
                    isfind=true;
                    break;
                }
                
                
            }
         
            


            if(!isfind)
            {
                PreparedStatement posted=con.prepareStatement("INSERT INTO timetable(name,date,hour,min,seats) VALUES('"+name+"','"+sqlDate+"','"+hour+"','"+min+"','"+seats+"')");

                posted.executeUpdate();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Time overlap","invalid",2);
            }
           
            
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    
}
