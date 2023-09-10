import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EstoqueAcessorio implements Serializable {
    private final List<Acessorio> acessorios = new ArrayList<>();

    public void adicionarAcessorio(Acessorio acessorio) {
        acessorios.add(acessorio);
    }

    public void removerAcessorio(Acessorio acessorio) throws IllegalArgumentException {
        if (!acessorios.contains(acessorio)) {
            throw new IllegalArgumentException("O acessório informado não foi encontrado!");
        }
        acessorios.remove(acessorio);
    }

    public Acessorio removerAcessorio(String tipoAcessorio) {
        for (Acessorio acessorio : acessorios) {
            if (acessorio.getTipoAcessorio().equals(tipoAcessorio)) {
                acessorios.remove(acessorio);
                return acessorio;
            }
        }
        return null;
    }

    public Acessorio localizarAcessorio(String tipoAcessorio) {
        for (Acessorio acessorio : acessorios) {
            if (acessorio.getTipoAcessorio().equals(tipoAcessorio)) {
                return acessorio;
            }
        }
        return null;
    }

    public List<String> listarAcessorio() {
        List<String> listaAcessorios = new ArrayList<>();
        listaAcessorios.add("Acessórios");
        for (Acessorio acessorio : acessorios) {
            listaAcessorios.add(acessorio.toString());
        }
        return listaAcessorios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueAcessorio that = (EstoqueAcessorio) o;
        return Objects.equals(acessorios, that.acessorios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acessorios);
    }

    @Override
    public String toString() {
        return "Estoque De Acessórios" + "Acessórios: " + acessorios;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }
}
