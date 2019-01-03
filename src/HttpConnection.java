import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpConnection
{

    public String establishConnection(String currencyCode, String startDate, String endDate)
    {
        StringBuilder response = new StringBuilder();
        String readedLine = null;
        try
        {
            String apiAddress = "http://api.nbp.pl/api/exchangerates/rates/c" + "/" + currencyCode + "/" + startDate + "/" + endDate;
            URL url = new URL(apiAddress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((readedLine = in.readLine()) != null)
                {
                    response.append(readedLine); //cala zawartsoc z url w zmiennej response
                }
                in.close();

            }
            else
            {
                System.out.println("Connection failed");
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return response.toString();
    }
}
