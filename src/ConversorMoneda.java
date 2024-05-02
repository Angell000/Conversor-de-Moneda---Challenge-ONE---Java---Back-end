public class ConversorMoneda {
    final Moneda monedaBase;

    public ConversorMoneda(String monedaBase) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        this.monedaBase = consulta.buscamoneda(monedaBase);
    }

    public double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        if (!monedaBase.conversion_rates().containsKey(monedaOrigen) ||
                !monedaBase.conversion_rates().containsKey(monedaDestino)) {
            throw new IllegalArgumentException("Moneda no válida");
        }

        double tasaOrigen = monedaBase.conversion_rates().get(monedaOrigen);
        double tasaDestino = monedaBase.conversion_rates().get(monedaDestino);

        return cantidad / tasaOrigen * tasaDestino;
    }
}
