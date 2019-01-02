import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpClient
{

    public void getExchangeRates()
    {
        StringBuilder response = new StringBuilder();
        try
        {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/eur/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            String readedLine = null;
            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                //StringBuffer response = new StringBuffer();
                while ((readedLine = in.readLine()) != null)
                {
                    response.append(readedLine);
                    //System.out.println(response);
                }
                in.close();

                System.out.println("JSON String Result " + response.toString());
            }
            else
            {
                System.out.println("GET NOT WORKED");
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        JSONObject result = new JSONObject(response.toString());

        String code = result.getString("code"); //kod waluty
        System.out.println(code);

        JSONArray rates = result.getJSONArray("rates");

        JSONObject js = rates.getJSONObject(0);

        double sellingRate = js.getDouble("ask"); //kurs sprzedaz
        System.out.println(sellingRate);
        double buyingRate = js.getDouble("bid"); //kurs kupna
        System.out.println(buyingRate);
    }
}
