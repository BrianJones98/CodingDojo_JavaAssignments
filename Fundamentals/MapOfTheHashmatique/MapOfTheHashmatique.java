import java.util.HashMap;
import java.util.Set;

public class MapOfTheHashmatique{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Prayer of the Refugee", "Warm yourself by the fire, son...");
        trackList.put("Savior", "It kills me not to know this...");
        trackList.put("Voices off Camera", "Can you hear the desperate cries...");
        trackList.put("Everchanging", "In the face of change...");

        Set<String> keys = trackList.keySet();

        System.out.println(trackList.get("Savior"));

        for(String key : keys){
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}