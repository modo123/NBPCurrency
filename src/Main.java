import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Podaj trzyliterowy kod waluty, datę początkową oraz date końcową np.: USD 2017-05-20 2017-07-20");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] parts = input.split(" ");

        HttpConnection httpConnection = new HttpConnection();
        String response = httpConnection.establishConnection(parts[0], parts[1], parts[2]);

        ApiData apiData = new ApiData();
        apiData.getExchangeRates(response);
    }
}
