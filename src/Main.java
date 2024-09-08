
import java.util.List;

import model.Pessoa;
import model.TipoConta;
import model.Client;
import model.Conta;

public class Main {
    public static void main(String[] args) {

        // Pessoa
        service.ServicoPessoa servicoPessoa = new service.ServicoPessoa();

        Pessoa pessoa1 = new Pessoa("Lucas Rcha", "12345678910");
        Pessoa pessoa2 = new Pessoa("Jacinto Ben", "12345678911");

        servicoPessoa.insertPessoa(pessoa1);
        servicoPessoa.insertPessoa(pessoa2);
        
        pessoa1 = servicoPessoa.selectPessoa(1);
        pessoa2 = servicoPessoa.selectPessoa(2);

        System.out.printf(pessoa1.toString() + '\n');
        System.out.printf(pessoa2.toString() + '\n');

        pessoa1.setNome("Lucas Rocha");
        servicoPessoa.updatePessoa(pessoa1);
        servicoPessoa.deletePessoa(2);
        System.out.printf(servicoPessoa.selectPessoa(1).toString() + '\n');

        try {
            System.out.printf(servicoPessoa.selectPessoa(2).toString() + '\n');
        } catch (NullPointerException e) {
            System.out.println("Jacinto Ben deletado com sucesso.");
        }

        // TipoConta
        service.ServicoTipoConta servicoTipoConta = new service.ServicoTipoConta();

        TipoConta tipoConta1 = new TipoConta("Conta Corrente");
        TipoConta tipoConta2 = new TipoConta("Conta Poupança");

        servicoTipoConta.insertTipoConta(tipoConta1);
        servicoTipoConta.insertTipoConta(tipoConta2);

        List<TipoConta> tipoContas = servicoTipoConta.selectAllTipoContas();

        for (TipoConta tipoConta : tipoContas) {
            System.out.printf(tipoConta.toString() + '\n');
        }

        servicoTipoConta.deleteTipoConta(2);

        tipoConta1 = servicoTipoConta.selectTipoConta(1);

        System.out.printf(tipoConta1.toString() + '\n');

        // Client
        service.ServicoClient servicoClient = new service.ServicoClient();

        servicoClient.insertClient(new Client("0", 1500, 1));

        Client client1 = servicoClient.selectClient(1);

        System.out.printf(client1.toString() + '\n');

        client1.setRendaMensal(1900);

        servicoClient.updateClient(client1);

        System.out.printf(servicoClient.selectClient(1).toString() + '\n');

        // Conta
        service.ServicoConta servicoConta = new service.ServicoConta();

        servicoConta.inserirConta(new Conta(1000, 100, 1, 1));

        model.Conta conta1 = servicoConta.selectConta(1);

        System.out.printf(conta1.toString() + '\n');

        conta1.setSaldo(1500);

        servicoConta.updateConta(conta1);

        System.out.printf(servicoConta.selectConta(1).toString() + '\n');
    }
}