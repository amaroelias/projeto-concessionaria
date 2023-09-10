import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda implements Serializable {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime dataVenda;
    private List<Acessorio> acessoriosVendidos;

    public Venda(Cliente cliente, Veiculo veiculo, LocalDateTime dataVenda) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataVenda = dataVenda;
        acessoriosVendidos = new ArrayList<>();
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public List<Acessorio> getAcessoriosVendidos() {
        return acessoriosVendidos;
    }

    public void adicionarAcessorio(Acessorio acessorio) {
        acessoriosVendidos.add(acessorio);
    }

    public double getValorDaVenda(int tipoVenda) {
        double valorFinal = veiculo.calculaPreco(tipoVenda);
        for (Acessorio acessorio : acessoriosVendidos) {
            valorFinal += acessorio.getPrecoAcessorio();
        }

        return valorFinal;
    }

    public String getDescricaoDaVenda(int tipoVenda) {
        StringBuilder descricao = new StringBuilder();
        descricao.append("===== Venda =====\n");
        descricao.append("Carro:").append(veiculo.getCategoriaVeiculo()).append("\n");
        descricao.append("Marca: ").append(veiculo.getMarcaVeiculo()).append("\n");
        descricao.append("Ano: ").append(veiculo.getAnoVeiculo()).append("\n");
        descricao.append("Cliente:").append(cliente.getNome()).append("\n");
        descricao.append("CPF: ").append(cliente.getCpf()).append("\n");
        descricao.append("Telefone: ").append(cliente.getTelefone()).append("\n");
        descricao.append("Data da Venda: ").append(dataVenda).append("\n");
        descricao.append("Forma de Pagamento: ").append(veiculo.getCalcularValorVenda()).append("\n");
        descricao.append("Acessórios:");
        for (Acessorio acessorio : acessoriosVendidos) {
            descricao.append(acessorio.getTipoAcessorio()).append("\n");
            descricao.append("Preço: ").append(acessorio.getPrecoAcessorio()).append("\n");
        }
        descricao.append("Valor Total: ").append(getValorDaVenda(tipoVenda)).append("\n");
        return descricao.toString();

    }




}
