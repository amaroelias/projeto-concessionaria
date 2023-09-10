import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concessionaria implements Serializable{
    private EstoqueAcessorio estoqueAcessorio;
    private EstoqueCarro estoqueCarro;
    private Agendamento agendamento;
    private List<Venda> vendas;

    public Concessionaria() {
        estoqueAcessorio = new EstoqueAcessorio();
        estoqueCarro = new EstoqueCarro();
        agendamento = new Agendamento();
        vendas = new ArrayList<>();
    }

    public EstoqueAcessorio getEstoqueAcessorio() {
        return estoqueAcessorio;
    }

    public EstoqueCarro getEstoqueCarro() {
        return estoqueCarro;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void adicionarCarro(Carro carro) {
        estoqueCarro.adicionarVeiculo(carro);
    }

    public void removerCarro(Carro carro) {
        estoqueCarro.removerVeiculo(carro);
    }

    public void removerCarro(String marca, String categoria) {
        estoqueCarro.removerVeiculo(marca, categoria);
    }

    public Veiculo buscarCarro(String marca, String categoria) {
        return estoqueCarro.localizarVeiculo(marca, categoria);
    }

    public List<String> listarVeiculosDisponiveis() {
        return estoqueCarro.listarVeiculos();
    }

    public void adicionarAcessorio(Acessorio acessorio) {
        estoqueAcessorio.adicionarAcessorio(acessorio);
    }

    public void removerAcessorio(Acessorio acessorio) {
        estoqueAcessorio.removerAcessorio(acessorio);
    }

    public void removerAcessorio(String tipoAcessorio) {
        estoqueAcessorio.removerAcessorio(tipoAcessorio);
    }

    public Acessorio buscarAcessorio(String tipoAcessorio) {
        return estoqueAcessorio.localizarAcessorio(tipoAcessorio);
    }

    public List<String> listarAcessoriosDisponiveis() {
        return estoqueAcessorio.listarAcessorio();
    }

    public void agendarNegociacao(Cliente cliente) {
        agendamento.adicionarAgendamento(cliente);
    }

    public void removerAgendamento(Cliente cliente) {
        agendamento.removerAgendamento(cliente);
    }

    public void removerAgendamento(CPF cpf) {
        agendamento.removerAgendamento(cpf);
    }

    public Cliente buscarAgendamento(CPF cpf) {
        return agendamento.localizarAgendamento(cpf);
    }

    public List<Cliente> listarAgendamentos() {
        return agendamento.getAgendamentos();
    }

    public void realizarVenda(Venda venda) {
        vendas.add(venda);
        estoqueCarro.removerVeiculo(venda.getVeiculo());
    }

    public void cancelarVenda(Venda venda) {
        vendas.remove(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public List<String> listarVendas() {
        List<String> listaVendas = new ArrayList<>();
        listaVendas.add("===== Vendas Realizadas =====");
        for (Venda venda : vendas) {
            listaVendas.add(venda.getDescricaoDaVenda(1));
        }
        return listaVendas;
    }

    public double calcularFaturamento() {
        double faturamentoTotal = 0;
        for (Venda venda : vendas) {
            faturamentoTotal += venda.getValorDaVenda(1);
        }
        return faturamentoTotal;
    }

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("===== Relatório de Vendas =====\\n");
        relatorio.append("Quantidade de Veículos Vendidos: ");

        for (Venda venda : vendas) {
            relatorio.append(venda.getDescricaoDaVenda(1)).append("\n==============================\n");
        }
        relatorio.append("Faturamento Total: ").append(calcularFaturamento()).append("\n");
        return relatorio.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concessionaria that = (Concessionaria) o;
        return Objects.equals(estoqueAcessorio, that.estoqueAcessorio) && Objects.equals(estoqueCarro, that.estoqueCarro) && Objects.equals(agendamento, that.agendamento) && Objects.equals(vendas, that.vendas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estoqueAcessorio, estoqueCarro, agendamento, vendas);
    }

    @Override
    public String toString() {
        return  "Concessionaria{" + "estoqueAcessorio=" + estoqueAcessorio +
                ", estoqueCarro=" + estoqueCarro +
                ", agendamento=" + agendamento +
                ", vendas=" + vendas +
                '}';
    }
    public void salvaDados(String nomeArquivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static Concessionaria carregaDados(String nomeArquivo) {
        Concessionaria concessionaria = null;
        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            concessionaria = (Concessionaria) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
        return concessionaria;
    }

}
