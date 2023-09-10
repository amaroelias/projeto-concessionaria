import java.io.Serializable;

public class Carro extends Veiculo implements Serializable {

    public Carro(String marcaVeiculo, String categoriaVeiculo, String anoVeiculo, double preco) throws IllegalArgumentException {
        super(marcaVeiculo, categoriaVeiculo, anoVeiculo, preco);
        if (!categoriaVeiculo.equals("Sedã") && !categoriaVeiculo.equals("Suv") && !categoriaVeiculo.equals("Hatch")){
            throw new IllegalArgumentException("A categoria do carro precisa ser Sedã, Suv ou Hatch!");
        }
    }
}
