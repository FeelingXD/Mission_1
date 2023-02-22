package util;


import org.jetbrains.annotations.TestOnly;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtil {
    private  static Connection con= null;
    private static String dbLoc="C://DB/mission1.sqlite";

    public static Connection getConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            con= DriverManager.getConnection("jdbc:sqlite:" + dbLoc);
            return con;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    static {

    }
    @TestOnly
    public static void testQuery(Connection con){
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("Select * from \"TEST\" ");

            while(rs.next()){
                String id= rs.getString("ID");
                String name=rs.getString("TEST_CODE");
                System.out.println(id+"           "+ name );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @TestOnly
    public static void main(String[] args){
        // test Query
        testQuery(getConnection());
    }


}
