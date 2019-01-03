import org.json.JSONArray;
import org.json.JSONObject;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ApiData
{
    public void getExchangeRates(String response)
    {
        JSONObject result = new JSONObject(response);

//        String code = result.getString("code"); //kod waluty
//        System.out.println(code);

        JSONArray rates = result.getJSONArray("rates");

//      JSONObject js = rates.getJSONObject(0);
//      double sellingRate = js.getDouble("ask"); //kurs sprzedazy
//      System.out.println(sellingRate);
//      double buyingRate = js.getDouble("bid"); //kurs kupna
//      System.out.println(buyingRate);

        int count = rates.length();
        double sum = 0;
        for (int i = 0; i < count; i++)
        {
            sum += rates.getJSONObject(i).getDouble("bid");
        }

        double averageBid = sum/count; //sredni kurs kupna waluty currencyCode z okresu startDate - endDate
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        System.out.println(decimalFormat.format(averageBid));
    }

}
