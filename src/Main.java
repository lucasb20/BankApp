
import service.ServicoPessoa;
import model.Pessoa;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        ServicoPessoa servicoPessoa = new ServicoPessoa();
        Pessoa pessoa1 = new Pessoa("Lucas da Rocha Brbosa", "12345678910");
        Pessoa pessoa2 = new Pessoa("Jacinto Ben Agora", "12345678911");

        servicoPessoa.insertPessoa(pessoa1);
        servicoPessoa.insertPessoa(pessoa2);
        System.out.printf(servicoPessoa.selectPessoa(1));
        System.out.printf(servicoPessoa.selectPessoa(2));

        pessoa1.setPessoa()
        servicoPessoa.updatePessoa(pessoa1);
        servicoPessoa.deletePessoa(pessoa2);
        System.out.printf(servicoPessoa.selectPessoa(1));
        System.out.printf(servicoPessoa.selectPessoa(2));
    }
}