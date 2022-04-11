import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpurl_POST {

    public static void main(String[] args) throws IOException {
        String url="https://gorest.co.in/public/v2/users";
        URL object=new URL(url);

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "Bearer c5bffe9dab670c11211e8e2551321374f44f922cc4c0855c2878cb4319926a01");
        con.setRequestMethod("POST");

        JSONObject cred   = new JSONObject();


        cred.put("name","Krishan");
        cred.put("email", "pandeykrishan2001@gmail.com");
        cred.put("gender","Male");
        cred.put("status","active");



        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(cred.toString());
        wr.flush();



        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            System.out.println("" + sb.toString());
        } else {
            System.out.println(con.getResponseMessage());
        }



    }
}