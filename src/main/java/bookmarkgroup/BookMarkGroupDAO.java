package bookmarkgroup;

import org.sqlite.SQLiteException;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookMarkGroupDAO {

    public static String TABLE = "BOOKMARKGROUP";

    public ArrayList<String> getBookMarkGroupNames(){ //=> return bookmarkgroup names

        ArrayList<String> names=new ArrayList<>();
        String sql ="select BOOKMARK_GROUP_NM from " +TABLE;

        Connection con=null;
        ResultSet rs=null;
        try{
            con= DatabaseUtil.getConnection();
            rs=con.createStatement().executeQuery(sql);
            while(rs.next()){
                names.add(rs.getString("bookmark_group_nm"));
            }
            return names;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (con != null) try {con.close();con = null;} catch(SQLException ex){ex.printStackTrace();}
            if (rs!= null) try {rs.close(); rs = null;} catch(SQLException ex){ex.printStackTrace();}
        }
        return null; //=> error db
    }


    public int addBookmarkGroup(String BOOKMARK_GROUP_NM,String BOOKMARK_GROUP_SEQ){
        String sql="insert into "+TABLE+"(BOOKMARK_GROUP_NM,BOOKMARK_GROUP_SEQ) VALUES(?,?)";
        Connection con=null;
        PreparedStatement pstmt=null;

        try {
            con=DatabaseUtil.getConnection();
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,BOOKMARK_GROUP_NM);
            pstmt.setString(2,BOOKMARK_GROUP_SEQ);
            pstmt.execute();
            return 1;
        }catch (SQLiteException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){ex.printStackTrace();}
            if (con != null) try {con.close();con = null;} catch(SQLException ex){ex.printStackTrace();}
        }

        return -1;//error
    }


    public static void main(String[] args){
        BookMarkGroupDAO dao=new BookMarkGroupDAO();
        for (String bookMarkGroupName : dao.getBookMarkGroupNames()) {
            System.out.println(bookMarkGroupName);
        }
    }
}
