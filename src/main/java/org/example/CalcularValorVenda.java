import java.io.Serializable;

public class CalcularValorVenda implements Serializable {

    private static final double DESCONTO_A_VISTA = 0.10;
    private static final double JUROS_FINANCIAMENTO = 0.40;

    public double valorVenda(Veiculo veiculo, int tipoVenda){

        if(tipoVenda == 1){
            double preco = veiculo.getPreco();
            return preco - (preco * DESCONTO_A_VISTA);
        }else {
            double preco = veiculo.getPreco();
            double precoJuros = preco * JUROS_FINANCIAMENTO;
            return preco + precoJuros;
        }

    }

    public String exibirValorVenda(Veiculo veiculo, int tipoVenda){
        if(tipoVenda == 1){
            return "Valor do veiculo a vista : R$ " + valorVenda(veiculo,tipoVenda);
        } else {
            return "Valor Parcelas do veiculo financiado: \n" +
                    "48x de R$ " + valorVenda(veiculo,tipoVenda) / 48 + " \n" +
                    "36x de R$ " + valorVenda(veiculo,tipoVenda) / 36 + " \n" +
                    "24x de R$ " + valorVenda(veiculo,tipoVenda) / 24 + " \n" +
                    "12x de R$ " + valorVenda(veiculo,tipoVenda) / 12 + " \n";
        }

    }
}
