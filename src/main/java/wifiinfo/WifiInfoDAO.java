package wifiinfo;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WifiInfoDAO {
    private static String TABLE= "wifi_info";
    public static int getTableCount(){
        String sql = "select count(*) from "+TABLE; // 현재 테이블 데이터 검사
        Connection con= DatabaseUtil.getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()) {
                String amount = rs.getString(1);
                return Integer.parseInt(amount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1; //error
    }

    public static void main(String[] args){
        System.out.println(getTableCount());
    }

}
