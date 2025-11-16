import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRate{

    private static final String API_KEY = "SUA_API_KEY"; // Colocar sua API_KEY recebida no email para utilizar o programa
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public static double getRate(String from, String to) throws Exception {

        String urlString = API_URL + API_KEY + "/latest/" + from;

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        Scanner sc = new Scanner(url.openStream());
        StringBuilder json = new StringBuilder();
        while (sc.hasNext()) {
            json.append(sc.nextLine());
        }
        sc.close();

        Gson gson = new Gson();
        RespostaAPI response = gson.fromJson(json.toString(), RespostaAPI.class);

        if (response.result.equals("success")) {
            return response.conversion_rates.get(to);
        } else {
            throw new RuntimeException("Erro ao consultar a API");
        }
    }
}
