import java.util.Objects;

public class Acessorio {
    private String tipoAcessorio;
    private double precoAcessorio;

    public Acessorio(String tipoAcessorio, double precoAcessorio) throws IllegalArgumentException {
        if (!tipoAcessorio.equals("Vidro elétrico") && !tipoAcessorio.equals("Direção hidráulica") && !tipoAcessorio.equals("Som") && !tipoAcessorio.equals("Ar condicionado")) {
            throw new IllegalArgumentException("O tipo de acessório precisa ser Vidro elétrico, Direção hidráulica, Som ou Ar condicionado!");
        }
        if (precoAcessorio < 1) {
            throw new IllegalArgumentException("O preço do acessório não pode ser menor que 1!");
        }
        this.tipoAcessorio = tipoAcessorio;
        this.precoAcessorio = precoAcessorio;
    }

    public String getTipoAcessorio() {
        return tipoAcessorio;
    }

    public void setTipoAcessorio(String tipoAcessorio) {
        this.tipoAcessorio = tipoAcessorio;
    }

    public double getPrecoAcessorio() {
        return precoAcessorio;
    }

    public void setPrecoAcessorio(double precoAcessorio) {
        this.precoAcessorio = precoAcessorio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acessorio acessorio = (Acessorio) o;
        return Double.compare(acessorio.precoAcessorio, precoAcessorio) == 0 && Objects.equals(tipoAcessorio, acessorio.tipoAcessorio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoAcessorio, precoAcessorio);
    }

    @Override
    public String toString() {
        return  "Acessório" + "\n" +
                "Tipo de Acessório: " + getTipoAcessorio() + "\n" +
                "Preço do Acessório: " + getPrecoAcessorio() + "\n";

    }
}
