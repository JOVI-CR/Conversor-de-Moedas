public class CalcularConversao {
    public double calcular(Moeda moeda, String moedaDestino, double valor) {
        double taxa = moeda.conversion_rates().get(moedaDestino);

        return valor * taxa;
    }
}
