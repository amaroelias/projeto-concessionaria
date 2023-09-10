import java.io.Serializable;
import java.util.Objects;

public abstract class Veiculo implements Serializable {
    private String marcaVeiculo;
    private String categoriaVeiculo;
    private String anoVeiculo;
    private double preco;
    private CalcularValorVenda calcularValorVenda;

    public Veiculo(String marcaVeiculo, String categoriaVeiculo, String anoVeiculo, double preco) throws IllegalArgumentException {
        if (preco < 1) {
            throw new IllegalArgumentException("O preço não pode ser nulo ou negativo!");
        }
        if (anoVeiculo.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("O ano do veículo nçao pode conter letras!");
        }
        if (anoVeiculo.length() != 4) {
            throw new IllegalArgumentException("O ano do veículo precisa ter 4 dígitos! (XXXX)");
        }

        this.marcaVeiculo = marcaVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.categoriaVeiculo = categoriaVeiculo;
        this.preco = preco;
        calcularValorVenda = new CalcularValorVenda();

    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(String categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAnoVeiculo() {
        return anoVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Double.compare(veiculo.preco, preco) == 0 && Objects.equals(marcaVeiculo, veiculo.marcaVeiculo) && Objects.equals(categoriaVeiculo, veiculo.categoriaVeiculo) && Objects.equals(anoVeiculo, veiculo.anoVeiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marcaVeiculo, categoriaVeiculo, anoVeiculo, preco);
    }

    @Override
    public String toString() {
         return  "Veículo" + "\n" +
                "Marca: " + getMarcaVeiculo() + "\n" +
                "Categoria: " + getCategoriaVeiculo() + "\n" +
                "Ano Do Veículo: " + getAnoVeiculo() + "\n" +
                "Preço: " + getPreco() + "\n";

    }

    public void setCalcularValorVenda(CalcularValorVenda calcularValorVenda) {
        this.calcularValorVenda = calcularValorVenda;
    }

    public double calculaPreco(int tipoVenda) {
        if (calcularValorVenda == null) {
            throw new IllegalStateException("Método de calculo não encontrado!");
        }
        return calcularValorVenda.valorVenda(this,tipoVenda);
    }

    public String getCalcularValorVenda() {
        return "";
    }
}
