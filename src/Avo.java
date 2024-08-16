public class Avo extends Pessoa  {

    private Boolean aposentado;

    public Boolean getAposentado() {
        return aposentado;
    }

    public void setAposentado(Boolean aposentado) {
        this.aposentado = aposentado;
    }

    @Override
    String getTipoVoz() {
        return "Grossa";
    }
}
