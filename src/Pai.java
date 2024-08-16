public class Pai extends Pessoa {

    private String hobby;

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    String getTipoVoz() {
        return "Normal";
    }
}
