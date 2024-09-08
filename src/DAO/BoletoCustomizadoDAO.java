package DAO;

import model.BoletoCustomizado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoletoCustomizadoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO boleto_customizado (valor, dt_vencimento, dt_geracao, codigo_barras, tipo_boleto_customizado_id, fatura_cartao_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM boleto_customizado WHERE id = ?";
    private static final String UPDATE = "UPDATE boleto_customizado SET valor = ?, dt_vencimento = ?, dt_geracao = ?, codigo_barras = ?, tipo_boleto_customizado_id = ?, fatura_cartao_id = ? WHERE id = ?";
    private static final String SELECT_ID = "SELECT * FROM boleto_customizado WHERE id = ?";
    private static final String TOTAL = "SELECT COUNT(1) FROM boleto_customizado";
    private static final String SELECT = "SELECT * FROM boleto_customizado";

    public int count() {
        int count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insert(BoletoCustomizado boletoCustomizado) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setDouble(1, boletoCustomizado.getValor());
            preparedStatement.setString(2, boletoCustomizado.getDtVencimento());
            preparedStatement.setString(3, boletoCustomizado.getDtGeracao());
            preparedStatement.setString(4, boletoCustomizado.getCodigoBarras());
            preparedStatement.setInt(5, boletoCustomizado.getTipoBoletoCustomizadoId());
            preparedStatement.setInt(6, boletoCustomizado.getFaturaCartaoId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BoletoCustomizado> select() {
        List<BoletoCustomizado> boletoCustomizados = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                double valor = rs.getDouble("valor");
                String dt_vencimento = rs.getString("dt_vencimento");
                String dt_geracao = rs.getString("dt_geracao");
                String codigo_barras = rs.getString("codigo_barras");
                int tipo_boleto_customizado_id = rs.getInt("tipo_boleto_customizado_id");
                int fatura_cartao_id = rs.getInt("fatura_cartao_id");

                boletoCustomizados.add(new BoletoCustomizado(id, valor, dt_vencimento, dt_geracao, codigo_barras, tipo_boleto_customizado_id, fatura_cartao_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return boletoCustomizados;
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = prepararSQL(DELETE)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(BoletoCustomizado boletoCustomizado) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE)) {
            preparedStatement.setDouble(1, boletoCustomizado.getValor());
            preparedStatement.setString(2, boletoCustomizado.getDtVencimento());
            preparedStatement.setString(3, boletoCustomizado.getDtGeracao());
            preparedStatement.setString(4, boletoCustomizado.getCodigoBarras());
            preparedStatement.setInt(5, boletoCustomizado.getTipoBoletoCustomizadoId());
            preparedStatement.setInt(6, boletoCustomizado.getFaturaCartaoId());
            preparedStatement.setInt(7, boletoCustomizado.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public BoletoCustomizado select(int id) {
        BoletoCustomizado boletoCustomizado = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                double valor = rs.getDouble("valor");
                String dt_vencimento = rs.getString("dt_vencimento");
                String dt_geracao = rs.getString("dt_geracao");
                String codigo_barras = rs.getString("codigo_barras");
                int tipo_boleto_customizado_id = rs.getInt("tipo_boleto_customizado_id");
                int fatura_cartao_id = rs.getInt("fatura_cartao_id");

                boletoCustomizado = new BoletoCustomizado(id, valor, dt_vencimento, dt_geracao, codigo_barras, tipo_boleto_customizado_id, fatura_cartao_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return boletoCustomizado;
    }
}