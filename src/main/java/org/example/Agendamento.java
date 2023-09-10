import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Agendamento implements Serializable{
    private List<Cliente> agendamentos = new ArrayList<>();


    public void adicionarAgendamento(Cliente cliente) {
        agendamentos.add(cliente);
    }

    public void removerAgendamento(Cliente cliente) throws IllegalArgumentException {
        if (!agendamentos.contains(cliente)) {
            throw new IllegalArgumentException("O cliente informado não foi encontrado para ser removido!");
        }
        agendamentos.remove(cliente);
    }

    public Cliente localizarAgendamento(CPF cpf) {
        for (Cliente cliente : agendamentos) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente removerAgendamento(CPF cpf) {
        for (Cliente cliente : agendamentos) {
            if (cliente.getCpf().equals(cpf)) {
                agendamentos.remove(cliente);
                return cliente;
            }
        }
        return null;
    }


    public List<Cliente> getAgendamentos() {
        return agendamentos;
    }

    public List<String> listarAgendamentos() {
        List<String> listaClientes = new ArrayList<>();
        listaClientes.add("Clientes:");
        for (Cliente cliente : agendamentos) {
            listaClientes.add(cliente.toString());
        }
        return listaClientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agendamentos:\n");

        for (Cliente cliente : agendamentos) {
            sb.append(cliente.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(agendamentos, that.agendamentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agendamentos);
    }
}





