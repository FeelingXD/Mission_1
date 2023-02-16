package util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.TestOnly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpenApiUtil {
    static String ORIGIN ="http://openapi.seoul.go.kr:8088";
    static String SERVICE ="TbPublicWifiInfo";
    static String KEY="4362434564776c6135327572784859"; //privated key.
    static String TYPE="json";


    public static void checkState(){

    }
    public static int getTotalAmount(){ // API 최신값 검사하기
        try {
            OkHttpClient client = new OkHttpClient();
            Request request= new Request.Builder()
                    .url(ORIGIN+"/"+KEY+"/"+TYPE+"/"+SERVICE+"/1"+"/1")
                    .build();
            Response res= client.newCall(request).execute();
            String message= res.body().string();

            JsonParser parser = new JsonParser();
            JsonElement element=parser.parse(message);

            JsonObject info = element.getAsJsonObject().get(SERVICE).getAsJsonObject();
            int ret = info.getAsJsonObject().get("list_total_count").getAsInt();

            return ret;

        } catch (Exception e) {
            e.printStackTrace();

        }
       return -1;
    }




    @TestOnly
    public static void main(String[] args){
        System.out.println(getTotalAmount());
    }
}
