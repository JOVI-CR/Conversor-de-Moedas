import com.google.gson.Gson;

public class AnalisadorJson {

    public Moeda analisar(String json) {
        Gson gson = new Gson();

        Moeda moeda = gson.fromJson(json, Moeda.class);

        return moeda;
    }
}
