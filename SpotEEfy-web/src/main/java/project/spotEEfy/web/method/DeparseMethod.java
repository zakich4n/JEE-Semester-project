package project.spotEEfy.web.method;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DeparseMethod {


    private final static Logger log = LoggerFactory.getLogger(DeparseMethod.class);

    public List<List<String>> deparseSongList(String json){
        String title = null;
        String author = null;
        String url_photo = null;
        List<List<String>> list = null;

        String jsonString = json.toString() ; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("items");
        for (int i = 0; i < arr.length(); i++) {
            title = arr.getJSONObject(i).getJSONObject("track").getString("name");
            JSONArray author_arr = arr.getJSONObject(i).getJSONArray("artists");
            for (int n = 0; n < author_arr.length(); n++) {
                if (n == 0) {
                    author = author_arr.getJSONObject(n).getString("name");
                }
            }
            JSONArray photo_url_arr = arr.getJSONObject(i).getJSONArray("images");
            for (int n = 0; n < photo_url_arr.length(); n++) {
                if (n == 1) {
                    url_photo = photo_url_arr.getJSONObject(n).getString("url");
                }
            }
            log.warn("result of the songs list call of index "+ i +" : " + title + " " + author + " "
                    + url_photo );

            List<String> listTmp = null;
            listTmp.add(title);
            listTmp.add(author);
            listTmp.add(url_photo);
            list.add(listTmp);
        }

        return list;
    }
}
