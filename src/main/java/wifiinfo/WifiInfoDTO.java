package wifiinfo;

import lombok.Data;

@Data
public class WifiInfoDTO {


    private String MGRNo ;
    private String WIFI_NAME;
    private  String REGION;
    private  String ADDRESS;
    private  String DETAIL_ADDRESS;
    private  String INSTALL_LOC;
    private  String INSTALL_INSTITUTION;
    private  String SERVICE;
    private  String NETWORK_TYPE;
    private String INSTALL_YEAR;
    private   String IN_OUT;
    private  String WIFI_ENV;
    private  String LNT;
    private  String LAT;
    private  String OPERATION_DATE ;

    public WifiInfoDTO(String MGRNo, String WIFI_NAME, String REGION, String ADDRESS, String DETAIL_ADDRESS, String INSTALL_LOC, String INSTALL_INSTITUTION, String SERVICE, String NETWORK_TYPE, String INSTALL_YEAR, String IN_OUT, String WIFI_ENV, String LNT, String LAT, String OPERATION_DATE) {
        this.MGRNo = MGRNo;
        this.WIFI_NAME = WIFI_NAME;
        this.REGION = REGION;
        this.ADDRESS = ADDRESS;
        this.DETAIL_ADDRESS = DETAIL_ADDRESS;
        this.INSTALL_LOC = INSTALL_LOC;
        this.INSTALL_INSTITUTION = INSTALL_INSTITUTION;
        this.SERVICE = SERVICE;
        this.NETWORK_TYPE = NETWORK_TYPE;
        this.INSTALL_YEAR = INSTALL_YEAR;
        this.IN_OUT = IN_OUT;
        this.WIFI_ENV = WIFI_ENV;
        this.LNT = LNT;
        this.LAT = LAT;
        this.OPERATION_DATE = OPERATION_DATE;
    }

}
