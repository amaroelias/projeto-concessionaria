import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AgendamentoTestes {
    private Agendamento agendamento;


    @BeforeEach
    void setUp() {
        agendamento = new Agendamento();
    }

    @Test
    void adicionarAgendamento() {
        CPF cpf = new CPF("12345678901");
        Cliente cliente = new Cliente("Carlos", cpf, "83981228753");
        agendamento.adicionarAgendamento(cliente);

        List<Cliente> agendamentos = agendamento.getAgendamentos();
        Assertions.assertEquals(1, agendamentos.size());
        Assertions.assertTrue(agendamentos.contains(cliente));
    }

    @Test
    void removerAgendamento() {
        CPF cpf2 = new CPF("32453665788");
        Cliente clienteDeveSerremovido = new Cliente("Amaro", cpf2, "21999876543");
        agendamento.adicionarAgendamento(clienteDeveSerremovido);

        agendamento.removerAgendamento(clienteDeveSerremovido);

        List<Cliente> agendamentos = agendamento.getAgendamentos();
        Assertions.assertEquals(0, agendamentos.size());
        Assertions.assertFalse(agendamentos.contains(clienteDeveSerremovido));

    }

    @Test
    void removerAgendamentoLancarExcecao() {
        Cliente clienteDeveLancarExcecao = new Cliente("Scorpion", new CPF("32165487987"), "21983231144");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> agendamento.removerAgendamento(clienteDeveLancarExcecao));
    }

    @Test
    void localizarAgendamento() {
        Cliente clienteDeveSerLocalizado = new Cliente("Joao", new CPF("34575686872"), "23982113244");
        agendamento.adicionarAgendamento(clienteDeveSerLocalizado);

        Cliente clienteEncontrado = agendamento.localizarAgendamento(new CPF("34575686872"));

        Assertions.assertEquals(clienteDeveSerLocalizado, clienteEncontrado);
    }

    @Test
    void localizarAgendamentoDeveRetornaNull() {
        Cliente clienteDeveRetornaNull = new Cliente("João", new CPF("12345678901"), "83981332588");
        agendamento.adicionarAgendamento(clienteDeveRetornaNull);

        Cliente clienteEncontrado = agendamento.localizarAgendamento(new CPF("98765432109"));

        Assertions.assertNull(clienteEncontrado);
    }




    @Test
    void RemoverAgendamentoPeloCpf() {
        Cliente cliente = new Cliente("Kratos", new CPF("12345678901"), "83987654323");
        agendamento.adicionarAgendamento(cliente);

        Cliente clienteRemovido = agendamento.removerAgendamento(new CPF("12345678901"));

        List<Cliente> agendamentos = agendamento.getAgendamentos();
        Assertions.assertEquals(0, agendamentos.size());
        Assertions.assertFalse(agendamentos.contains(cliente));
        Assertions.assertEquals(cliente, clienteRemovido);

    }

    @Test
    void getAgendamentosDeveRetornaListaVazia() {
        List<Cliente> agendamentos = agendamento.getAgendamentos();

        Assertions.assertNotNull(agendamentos);
        Assertions.assertTrue(agendamentos.isEmpty());

    }
    @Test
    void getAgendamentosDeveRetornaALista(){
        Cliente cliente1 = new Cliente("Leonidas", new CPF("12345678901"), "83983421323");
        Cliente cliente2 = new Cliente("Odin", new CPF("98765432109"), "83982135465");

        agendamento.adicionarAgendamento(cliente1);
        agendamento.adicionarAgendamento(cliente2);

        List<Cliente> agendamentos = agendamento.getAgendamentos();

        Assertions.assertEquals(2, agendamentos.size());
        Assertions.assertTrue(agendamentos.contains(cliente1));
        Assertions.assertTrue(agendamentos.contains(cliente2));
    }

    @Test
    void listarAgendamentosFormatados() {
        Cliente cliente1 = new Cliente("Atreus", new CPF("12345678991"), "83982135532");
        Cliente cliente2 = new Cliente("BiHan", new CPF("98765432109"), "83981324354");

        agendamento.adicionarAgendamento(cliente1);
        agendamento.adicionarAgendamento(cliente2);

        List<String> listaAgendamentos = agendamento.listarAgendamentos();

        Assertions.assertEquals(3, listaAgendamentos.size());
        Assertions.assertEquals("Clientes:", listaAgendamentos.get(0));
        Assertions.assertEquals(cliente1.toString(), listaAgendamentos.get(1));
        Assertions.assertEquals(cliente2.toString(), listaAgendamentos.get(2));

    }


    @Test
    void EqualsDoisAgendamentosIguais() {
        Agendamento agendamento1 = new Agendamento();
        Agendamento agendamento2 = new Agendamento();

        Assertions.assertEquals(agendamento1, agendamento2);
    }

    @Test
    void EqualsDoisAgendamentosDiferentes() {
        Cliente cliente1 = new Cliente("João", new CPF("12349678971"), "83966532211");
        Cliente cliente2 = new Cliente("Maria", new CPF("98765433109"), "83966332211");

        agendamento.adicionarAgendamento(cliente1);

        Agendamento outroAgendamento = new Agendamento();
        outroAgendamento.adicionarAgendamento(cliente2);

        Assertions.assertNotEquals(agendamento, outroAgendamento);
    }


    @Test
    void testHashCode() {
        Agendamento agendamento1 = new Agendamento();
        Agendamento agendamento2 = new Agendamento();

        Assertions.assertEquals(agendamento1.hashCode(), agendamento2.hashCode());
    }
}