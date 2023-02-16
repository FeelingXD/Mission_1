package wifiinfo;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.jetbrains.annotations.TestOnly;
import util.DatabaseUtil;
import util.OpenApiUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WifiInfoDAO {
    private static String TABLE= "wifi_info";

    public static int TABLECOUNT=getTableCount();
    private static int getTableCount(){
        String sql = "select count(*) from "+TABLE; // 현재 테이블 데이터 검사
        Connection con= null;
        ResultSet rs=null;
        try {
            con=DatabaseUtil.getConnection();
            rs = con.createStatement().executeQuery(sql);
            while(rs.next()) {
                String amount = rs.getString(1);
                return Integer.parseInt(amount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(con!=null){
                try {
                    con.close();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1; //error
    }

    private void initTable(){



    }

    public void getDataFromApi(){
        //Todo api util 에서 1000개씩 데이터 가져와서 db에 반영하기
        int start=TABLECOUNT+1;
        int limit = OpenApiUtil.getTotalAmount();
        OpenApiUtil oau= new OpenApiUtil();

    }

    public int insert(JsonArray ja){
        String sql="INSERT INTO "+TABLE +"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            con=DatabaseUtil.getConnection();

            for (JsonElement e : ja) {
//                pstmt.setString(,e.getAsJsonObject().get("").getAsString());
            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }


        return -1;
    }

    @TestOnly
    public static ArrayList<WifiInfoDTO> returnAllData(){
        ArrayList<WifiInfoDTO> list=new ArrayList<>();
        String sql="select * from "+TABLE;
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con=DatabaseUtil.getConnection();
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                 String X_SWIFI_MGR_NO =rs.getString("X_SWIFI_MGR_NO");
                 String X_SWIFI_MAIN_NM=rs.getString("X_SWIFI_MAIN_NM");
                 String X_SWIFI_WRDOFC=rs.getString("X_SWIFI_WRDOFC");
                 String X_SWIFI_ADRES1=rs.getString("X_SWIFI_ADRES1");
                 String X_SWIFI_ADRES2=rs.getString("X_SWIFI_ADRES2");
                 String X_SWIFI_INSTL_MBY=rs.getString("X_SWIFI_INSTL_MBY");
                 String X_SWIFI_INSTL_TY=rs.getString("X_SWIFI_INSTL_TY");
                 String X_SWIFI_SVC_SE=rs.getString("X_SWIFI_SVC_SE");
                 String X_SWIFI_CMCWR=rs.getString("X_SWIFI_CMCWR");
                 String X_SWIFI_CNSTC_YEAR=rs.getString("X_SWIFI_CNSTC_YEAR");
                 String X_SWIFI_INOUT_DOOR=rs.getString("X_SWIFI_INOUT_DOOR");
                 String X_SWIFI_REMARS3=rs.getString("X_SWIFI_REMARS3");
                 String LNT=rs.getString("LNT");
                 String LAT=rs.getString("LAT");
                 String WORK_DTTM =rs.getString("WORK_DTTM");
                 list.add(new WifiInfoDTO( X_SWIFI_MGR_NO,  X_SWIFI_MAIN_NM, X_SWIFI_WRDOFC,  X_SWIFI_ADRES1,  X_SWIFI_ADRES2,  X_SWIFI_INSTL_MBY,  X_SWIFI_INSTL_TY,  X_SWIFI_SVC_SE,  X_SWIFI_CMCWR,  X_SWIFI_CNSTC_YEAR,  X_SWIFI_INOUT_DOOR,  X_SWIFI_REMARS3, LNT, LAT, WORK_DTTM));
                 return list;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                try {
                    con.close();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(pstmt!=null){
                try {
                    pstmt.close();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null; // error
    }

    @TestOnly
    public static void testPrint(ArrayList<WifiInfoDTO> list){
        for (WifiInfoDTO dto : list) {
            System.out.print(dto.getX_SWIFI_MGR_NO()+" ");
            System.out.println(dto.getX_SWIFI_MAIN_NM()+" ");
            System.out.println(dto.getX_SWIFI_WRDOFC()+" ");
            System.out.println(dto.getX_SWIFI_ADRES1()+" ");
            System.out.println(dto.getX_SWIFI_ADRES2()+" ");
            System.out.println(dto.getX_SWIFI_REMARS3()+" ");
        }
    }

    @TestOnly
    public static void main(String[] args){
        System.out.println(getTableCount());
        testPrint(returnAllData());
    }

}
