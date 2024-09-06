
import service.ServicoPessoa;
import model.Pessoa;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        ServicoPessoa servicoPessoa = new ServicoPessoa();
        Pessoa pessoa1 = new Pessoa("Lucas Rcha", "12345678910");
        Pessoa pessoa2 = new Pessoa("Jacinto Ben", "12345678911");

        servicoPessoa.insertPessoa(pessoa1);
        servicoPessoa.insertPessoa(pessoa2);
        System.out.printf(servicoPessoa.selectPessoa(1).toString());
        System.out.printf(servicoPessoa.selectPessoa(2).toString());

        pessoa1.setNome("Lucas Rocha");
        servicoPessoa.updatePessoa(pessoa1);
        servicoPessoa.deletePessoa(2);
        System.out.printf(servicoPessoa.selectPessoa(1).toString());
        System.out.printf(servicoPessoa.selectPessoa(2).toString());
    }
}