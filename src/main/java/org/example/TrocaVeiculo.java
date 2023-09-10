import java.io.Serializable;

public class TrocaVeiculo implements Serializable {
    final int aVista = 1, financiamento = 2;

    public double valorVenda(Veiculo veiculoLoja, Carro veiculoCliente, int tipoVenda){
        double valorFinalVeiculo = 0;
        if(tipoVenda == aVista){
            valorFinalVeiculo = (veiculoLoja.getPreco() - veiculoCliente.getPreco()) * 0.95;
        }
        if(tipoVenda == financiamento){
            valorFinalVeiculo = (veiculoLoja.getPreco() - veiculoCliente.getPreco()) * 1.50;
        }
        return valorFinalVeiculo;
    }

    public String exibirValorVenda(Veiculo veiculoLoja, Carro veiculoCliente, int tipoVenda){
        String mensagemVenda = "";
        if(tipoVenda == aVista){
            mensagemVenda = "Valor do veiculo a vista: R$ "+valorVenda(veiculoLoja, veiculoCliente, tipoVenda);
        }
        if(tipoVenda == financiamento){
            mensagemVenda = "Valor Parcelas do veiculo financiado: \n" +
                    "48x de R$ "+valorVenda(veiculoLoja, veiculoCliente, tipoVenda) / 48+" \n"+
                    "36x de R$ "+valorVenda(veiculoLoja, veiculoCliente, tipoVenda) / 36+" \n"+
                    "24x de R$ "+valorVenda(veiculoLoja, veiculoCliente, tipoVenda) / 24+" \n"+
                    "12x de R$ "+valorVenda(veiculoLoja, veiculoCliente, tipoVenda) / 12+" \n";
        }
        return mensagemVenda;
    }
}
