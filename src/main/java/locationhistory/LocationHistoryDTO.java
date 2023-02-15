package locationhistory;
import lombok.Data;
@Data
public class LocationHistoryDTO {
    private String id;
    private String lat;
    private String lnt;
    private String time_log;


    public LocationHistoryDTO(String id, String lat, String lnt, String time_log) {
        this.id=id;
        this.lat=lat;
        this.lnt=lnt;
        this.time_log=time_log;
    }
}
