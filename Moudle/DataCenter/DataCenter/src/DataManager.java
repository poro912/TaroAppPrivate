import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// json 데이터를 불러오거나 저장하는 데이터 매니저
public class DataManager {
    public static Dack loadDecks()
    {
        return null;
    }

    public static Spread loadSpread()
    {
        return null;
    }

    public static boolean saveDecks(JSONObject json)
    {
        return false;
    }

    public static boolean saveSpread(JSONObject json)
    {

        return false;
    }

    public static void test()
    {
        JSONObject obj = new JSONObject();
        obj.put("name", "mine-it-record");
        obj.put("mine", "GN");
        obj.put("year", 2021);

        try {
            FileWriter file = new FileWriter("./mine.json");
            System.out.println(file.toString());
            File file2 = new File("./mine.json");
            file.write(file2.getAbsoluteFile().getPath());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(obj);
    }
}
