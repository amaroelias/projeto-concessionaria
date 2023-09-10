import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private String nome;
    private CPF Cpf;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public CPF getCpf() {
        return Cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(Cpf, cliente.Cpf) && Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, Cpf, telefone);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente" + "\n" +
                "Nome: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Telefone: " + getTelefone() + "\n";
    }

    public Cliente(String nome, CPF Cpf, String telefone) {
        if (nome.matches(".*\\d.*")) {
            throw new IllegalArgumentException("O nome não pode conter números");
        }
        if (telefone.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("O telefone não pode conter letras");
        }
        if (telefone.length() != 11) {
            throw new IllegalArgumentException("O numero de telefone precisa ter 11 dígitos!(DDD9XXXXXXXX)");
        }
        this.Cpf = Cpf;
        this.nome = nome;
        this.telefone = telefone;

    }

}
