import java.io.*;
import java.net.*;
import java.util.*;

import org.json.*;

public class TopArticles {
    public static void main(String[] args) {
        System.out.println(getTopArticles(5));
    };

    public static List<String> getTopArticles(int k){
        try{
            URL url = new URL("https://jsonmock.hackerrank.com/api/articles?page=");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
            connection.setReadTimeout(30000);
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException();
            }
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inline = inputReader.readLine();
            inputReader.close();
            JSONObject jsonObject = new JSONObject(inline);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            ArrayList<JSONObject> arrayList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++){
                arrayList.add(jsonArray.getJSONObject(i));
            }
            arrayList.sort((o1, o2) -> (JSONObject.NULL.equals(o2.get("num_comments")))
                    ? ( JSONObject.NULL.equals(o1.get("num_comments")) ? 0 : -1)
                    : ( JSONObject.NULL.equals(o1.get("num_comments")) ? 1 :
                    (int)o2.get("num_comments") - (int)o1.get("num_comments")));
            List<String> ans = new ArrayList<>();
            for (JSONObject obj : arrayList) {
                if(k > 0){
                    if(!JSONObject.NULL.equals(obj.get("title"))){
                        ans.add((String)obj.get("title"));
                        k--;
                    }else if(!JSONObject.NULL.equals(obj.get("story_title"))){
                        ans.add((String)obj.get("story_title"));
                        k--;
                    }
                }
            }
            return ans;
        }catch(IOException e){
            List<String> io = new ArrayList<>();
            io.add(e.getMessage());
            return io;
        }
    }
}

