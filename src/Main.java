
import java.util.List;

import model.Pessoa;
import model.Reserva;
import model.TipoBoletoCustomizado;
import model.TipoConta;
import model.BandeiraCartao;
import model.BoletoCustomizado;
import model.CartaoCredito;
import model.CartaoTransacao;
import model.CategoriaCartao;
import model.Client;
import model.Compra;
import model.Conta;
import model.Corretor;
import model.FaturaCartao;
import model.ItensFatura;
import model.MovimentacaoReserva;
import model.Pagamento;
import model.MovimentacaoConta;
import model.MovimentacaoCartao;

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

        Conta conta1 = servicoConta.selectConta(1);

        System.out.printf(conta1.toString() + '\n');

        conta1.setSaldo(1500);

        servicoConta.updateConta(conta1);

        System.out.printf(servicoConta.selectConta(1).toString() + '\n');

        // Reserva
        service.ServicoReserva servicoReserva = new service.ServicoReserva();

        servicoReserva.insertReserva(new Reserva(1000, 100, "Reserva", 1));

        Reserva reserva1 = servicoReserva.selectReserva(1);

        System.out.printf(reserva1.toString() + '\n');

        reserva1.setSaldo(1500);

        servicoReserva.updateReserva(reserva1);

        System.out.printf(servicoReserva.selectReserva(1).toString() + '\n');

        // MovimentacaoReserva
        service.ServicoMovimentacaoReserva servicoMovimentacaoReserva = new service.ServicoMovimentacaoReserva();

        servicoMovimentacaoReserva.insertMovimentacaoReserva(new MovimentacaoReserva(200, "saída", "2021-10-20 14:30:00", 1));
        servicoMovimentacaoReserva.insertMovimentacaoReserva(new MovimentacaoReserva(300, "entrada", "2021-10-21 08:30:00", 1));
        servicoMovimentacaoReserva.insertMovimentacaoReserva(new MovimentacaoReserva(400, "saída", "2021-10-22 10:30:00", 1));

        List<MovimentacaoReserva> movimentacaoReservas = servicoMovimentacaoReserva.selectAllMovimentacaoReserva();

        for (MovimentacaoReserva movimentacaoReserva : movimentacaoReservas) {
            System.out.printf(movimentacaoReserva.toString() + '\n');
        }

        // MovimentacaoConta
        service.ServicoMovimentacaoConta servicoMovimentacaoConta = new service.ServicoMovimentacaoConta();

        servicoMovimentacaoConta.insertMovimentacaoConta(new MovimentacaoConta(200, "saída", "2021-10-20 14:30:00", 1));
        servicoMovimentacaoConta.insertMovimentacaoConta(new MovimentacaoConta(300, "entrada", "2021-10-21 08:30:00", 1));
        servicoMovimentacaoConta.insertMovimentacaoConta(new MovimentacaoConta(400, "saída", "2021-10-22 10:30:00", 1));

        List<MovimentacaoConta> movimentacaoContas = servicoMovimentacaoConta.selectAllMovimentacaoConta();

        for (MovimentacaoConta movimentacaoConta : movimentacaoContas) {
            System.out.printf(movimentacaoConta.toString() + '\n');
        }

        // Categoria Cartão
        service.ServicoCategoriaCartao servicoCategoriaCartao = new service.ServicoCategoriaCartao();

        servicoCategoriaCartao.insertCategoriaCartao(new CategoriaCartao("Alimentação"));
        servicoCategoriaCartao.insertCategoriaCartao(new CategoriaCartao("Transporte"));
        servicoCategoriaCartao.insertCategoriaCartao(new CategoriaCartao("Saúde"));

        List<CategoriaCartao> categoriaCartaos = servicoCategoriaCartao.selectAllCategoriaCartao();

        for (CategoriaCartao categoriaCartao : categoriaCartaos) {
            System.out.printf(categoriaCartao.toString() + '\n');
        }
        
        // Cartão Crédito
        service.ServicoCartaoCredito servicoCartaoCredito = new service.ServicoCartaoCredito();

        servicoCartaoCredito.insertCartaoCredito(new CartaoCredito("2026-02-01 00:00:00", 3000, 1, 1));

        CartaoCredito cartaoCredito1 = servicoCartaoCredito.selectCartaoCredito(1);

        System.out.printf(cartaoCredito1.toString() + '\n');

        // Bandeira Cartão
        service.ServicoBandeiraCartao servicoBandeiraCartao = new service.ServicoBandeiraCartao();

        servicoBandeiraCartao.insertBandeiraCartao(new BandeiraCartao("Mastercard"));
        servicoBandeiraCartao.insertBandeiraCartao(new BandeiraCartao("Visa"));

        List<BandeiraCartao> bandeiraCartaos = servicoBandeiraCartao.selectAllBandeiraCartao();

        for (BandeiraCartao bandeiraCartao : bandeiraCartaos) {
            System.out.printf(bandeiraCartao.toString() + '\n');
        }

        // Cartão Transação
        service.ServicoCartaoTransacao servicoCartaoTransacao = new service.ServicoCartaoTransacao();

        servicoCartaoTransacao.insertCartaoTransacao(new CartaoTransacao("1234567891011121", "123", 1, "Físico", "Lucas Rocha", "Compra", 0, 1));
        servicoCartaoTransacao.insertCartaoTransacao(new CartaoTransacao("1234567891011122", "123", 1, "Virtual", "Lucas Rocha", "Alimentação", 1, 1));

        List<CartaoTransacao> cartaoTransacaos = servicoCartaoTransacao.selectAllCartaoTransacao();

        for (CartaoTransacao cartaoTransacao : cartaoTransacaos) {
            System.out.printf(cartaoTransacao.toString() + '\n');
        }

        // Movimentação Cartão
        service.ServicoMovimentacaoCartao servicoMovimentacaoCartao = new service.ServicoMovimentacaoCartao();

        servicoMovimentacaoCartao.insertMovimentacaoCartao(new MovimentacaoCartao(1, "Saída", 100, ""));
        servicoMovimentacaoCartao.insertMovimentacaoCartao(new MovimentacaoCartao(1, "Saída", 200, ""));
        servicoMovimentacaoCartao.insertMovimentacaoCartao(new MovimentacaoCartao(2, "Saída", 300, ""));

        List<MovimentacaoCartao> movimentacaoCartaos = servicoMovimentacaoCartao.selectAllMovimentacaoCartao();

        for (MovimentacaoCartao movimentacaoCartao : movimentacaoCartaos) {
            System.out.printf(movimentacaoCartao.toString() + '\n');
        }

        // Corretor
        service.ServicoCorretor servicoCorretor = new service.ServicoCorretor();

        servicoCorretor.insertCorretor(new Corretor("Corretor1"));
        servicoCorretor.insertCorretor(new Corretor("Corretor2"));

        List<Corretor> corretores = servicoCorretor.selectAllCorretores();

        for (Corretor corretor : corretores) {
            System.out.printf(corretor.toString() + '\n');
        }

        // Compra
        service.ServicoCompra servicoCompra = new service.ServicoCompra();

        servicoCompra.insertCompra(new Compra(3, 100, 1, 1, 0.05, "Credor1", "2021-10-20 14:30:00"));
        servicoCompra.insertCompra(new Compra(4, 200, 1, 1, 0.1, "Credor2", "2021-10-21 08:30:00"));
        servicoCompra.insertCompra(new Compra(5, 300, 1, 1, 0.15, "Credor3", "2021-10-22 10:30:00"));

        List<Compra> compras = servicoCompra.selectAllCompra();

        for (Compra compra : compras) {
            System.out.printf(compra.toString() + '\n');
        }

        // Fatura Cartão

        service.ServicoFaturaCartao servicoFaturaCartao = new service.ServicoFaturaCartao();

        servicoFaturaCartao.insertFaturaCartao(new FaturaCartao("jan", "2021", 100, 1, "2021-10-20 14:30:00"));
        servicoFaturaCartao.insertFaturaCartao(new FaturaCartao("fev", "2021", 200, 1, "2021-10-21 08:30:00"));
        servicoFaturaCartao.insertFaturaCartao(new FaturaCartao("mar", "2021", 300, 1, "2021-10-22 10:30:00"));

        List<FaturaCartao> faturaCartaos = servicoFaturaCartao.selectAllFaturaCartao();

        for (FaturaCartao faturaCartao : faturaCartaos) {
            System.out.printf(faturaCartao.toString() + '\n');
        }

        // Itens Fatura
        service.ServicoItensFatura servicoItensFatura = new service.ServicoItensFatura();

        servicoItensFatura.insertItensFatura(new ItensFatura("Cavalo", 1));
        servicoItensFatura.insertItensFatura(new ItensFatura("Frango", 1));
        servicoItensFatura.insertItensFatura(new ItensFatura("Leite", 1));

        List<ItensFatura> itensFaturas = servicoItensFatura.selectAllItensFatura();

        for (ItensFatura itensFatura : itensFaturas) {
            System.out.printf(itensFatura.toString() + '\n');
        }

        // Tipo Boleto Customizado
        service.ServicoTipoBoletoCustomizado servicoTipoBoletoCustomizado = new service.ServicoTipoBoletoCustomizado();

        servicoTipoBoletoCustomizado.insertTipoBoletoCustomizado(new TipoBoletoCustomizado("Boleto1"));
        servicoTipoBoletoCustomizado.insertTipoBoletoCustomizado(new TipoBoletoCustomizado("Boleto2"));

        List<TipoBoletoCustomizado> tipoBoletoCustomizados = servicoTipoBoletoCustomizado.selectAllTipoBoletoCustomizado();

        for (TipoBoletoCustomizado tipoBoletoCustomizado : tipoBoletoCustomizados) {
            System.out.printf(tipoBoletoCustomizado.toString() + '\n');
        }

        // Boleto Customizado
        service.ServicoBoletoCustomizado servicoBoletoCustomizado = new service.ServicoBoletoCustomizado();

        servicoBoletoCustomizado.insertBoletoCustomizado(new BoletoCustomizado(100, "2021-10-20 14:30:00", "2021-10-20 14:30:00", "1234567891011121314151617181920212223242526", 1, 1));
        servicoBoletoCustomizado.insertBoletoCustomizado(new BoletoCustomizado(200, "2021-10-21 08:30:00", "2021-10-21 08:30:00", "1234567891011121314151617181920212223242527", 1, 1));
        servicoBoletoCustomizado.insertBoletoCustomizado(new BoletoCustomizado(300, "2021-10-22 10:30:00", "2021-10-22 10:30:00", "1234567891011121314151617181920212223242528", 1, 1));
        
        List<BoletoCustomizado> boletoCustomizados = servicoBoletoCustomizado.selectAllBoletoCustomizado();

        for (BoletoCustomizado boletoCustomizado : boletoCustomizados) {
            System.out.printf(boletoCustomizado.toString() + '\n');
        }

        // Pagamento
        service.ServicoPagamento servicoPagamento = new service.ServicoPagamento();

        servicoPagamento.insertPagamento(new Pagamento(500, "2021-10-20 14:30:00", 1,100, 1));
        servicoPagamento.insertPagamento(new Pagamento(1000, "2021-10-21 08:30:00", 1, 200, 1));
        servicoPagamento.insertPagamento(new Pagamento(1500, "2021-10-22 10:30:00", 1, 300, 1));

        List<Pagamento> pagamentos = servicoPagamento.selectAllPagamento();

        for (Pagamento pagamento : pagamentos) {
            System.out.printf(pagamento.toString() + '\n');
        }
    }
}