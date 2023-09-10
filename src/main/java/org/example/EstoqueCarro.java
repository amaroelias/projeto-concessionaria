import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EstoqueCarro implements Serializable {
    private final List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) throws IllegalArgumentException {
        if (!veiculos.contains(veiculo)) {
            throw new IllegalArgumentException("O veículo informado não foi encontrado!");
        }
        veiculos.remove(veiculo);
    }

    public Veiculo removerVeiculo(String marca, String categoria) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMarcaVeiculo().equals(marca) && veiculo.getCategoriaVeiculo().equals(categoria)) {
                veiculos.remove(veiculo);
                return veiculo;
            }
        }
        return null;
    }

    public Veiculo localizarVeiculo(String marca, String categoria) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMarcaVeiculo().equals(marca) && veiculo.getCategoriaVeiculo().equals(categoria)) {
                return veiculo;
            }
        }
        return null;
    }

    public List<String> listarVeiculos() {
        List<String> listaVeiculos = new ArrayList<>();
        listaVeiculos.add("Veículos:");
        for (Veiculo veiculo : veiculos) {
            listaVeiculos.add(veiculo.toString());
        }
        return listaVeiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueCarro that = (EstoqueCarro) o;
        return Objects.equals(veiculos, that.veiculos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(veiculos);
    }

    @Override
    public String toString() {
        return "EstoqueCarro:" + "Veiculo" + veiculos;

    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}