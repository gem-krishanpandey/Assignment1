import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URLConnection;

public class httpclient_Delete{
    public static void main(String[] args) {
        try{
            CloseableHttpClient client = HttpClients.createDefault();
            HttpDelete httpdelete = new HttpDelete("https://gorest.co.in/public/v2/users/4153");
            httpdelete.addHeader("Accept","application/json");
            httpdelete.addHeader("Content-Type","application/json");
            httpdelete.addHeader("Authorization","Bearer c5bffe9dab670c11211e8e2551321374f44f922cc4c0855c2878cb4319926a01");
            CloseableHttpResponse response = client.execute(httpdelete);
            System.out.println(EntityUtils.toString(response.getEntity()));
            System.out.println(response.getStatusLine().getStatusCode());
            client.close();
        } catch (Exception e) {

        }
    }
}