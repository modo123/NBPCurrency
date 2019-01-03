import org.json.JSONArray;
import org.json.JSONObject;

import javax.naming.ldap.ManageReferralControl;
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
        double bidSum = 0;
        for (int i = 0; i < count; i++)
        {
            bidSum += rates.getJSONObject(i).getDouble("bid");
        }

        double averageBid = bidSum/count; //sredni kurs kupna waluty currencyCode z okresu startDate - endDate
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        System.out.println(decimalFormat.format(averageBid));

        double askSum = 0;
        for (int i = 0; i < count; i++)
        {
            askSum += rates.getJSONObject(i).getDouble("ask");
        }

        double averageAsk = askSum/count; //sredni kurs sprzedazy waluty currencyCode z okresu startDate - endDate

        double variance = 0;
        for (int i = 0; i < count; i++)
        {
            variance += Math.pow((rates.getJSONObject(i).getDouble("ask") - averageAsk), 2);
        }

        variance = variance/count; //wariancja
        double standardDeviation = Math.sqrt(variance); //odchylenie standardowe = pierwiastek z wariancji

        System.out.println(decimalFormat.format(standardDeviation));
    }

}
