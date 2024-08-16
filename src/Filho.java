public class Filho extends Pessoa  {

    private String serieEscolar;

    public String getSerieEscolar() {
        return serieEscolar;
    }

    public void setSerieEscolar(String serieEscolar) {
        this.serieEscolar = serieEscolar;
    }

    @Override
    String getTipoVoz() {
        return "Fina";
    }
}
