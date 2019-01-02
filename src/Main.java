public class Main
{
    public static void main(String[] args)
    {
        //System.out.println("Podaj kod waluty, datę początkową i końcową. ");
        HttpClient hc = new HttpClient();
        hc.getExchangeRates();
    }
}
