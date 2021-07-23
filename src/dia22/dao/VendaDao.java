package dia22.dao;

import dia22.models.Venda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;

public class VendaDao {


    private final Connection conn;

    public VendaDao(Connection conn) {
        this.conn = conn;
    }


    public Venda inicializarVenda() throws SQLException {
        // String query = "insert into tb_venda (data_hora) values(CURRENT_TIMESTAMP) returning id";
        String query = "insert into tb_venda (data_hora) values(?) returning id";

        try (PreparedStatement insertVenda = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            Venda venda = new Venda();

            insertVenda.setTimestamp(1, Timestamp.valueOf(venda.getDataHora()));
            insertVenda.executeUpdate();

            ResultSet rsIdVenda = insertVenda.getGeneratedKeys();
            rsIdVenda.next();
            Long id = rsIdVenda.getLong("id");

            rsIdVenda.close();

            venda.setId(id);

            return venda;
        }
    }

    public void finalizarVenda(Venda venda) throws SQLException {
        String query = "update tb_venda set valor = (select sum(valor_total) from tb_item_venda where id_venda = ?) where id = ?";


        try (PreparedStatement updateVenda = conn.prepareStatement(query)) {
            int i = 0;
            updateVenda.setLong(++i, venda.getId());
            updateVenda.setLong(++i, venda.getId());

            updateVenda.executeUpdate();
        }
    }

    public void finalizarVendaSemSQL(Venda venda) throws SQLException {
        String query = "update tb_venda set valor = ? where id = ?";


        try (PreparedStatement updateVenda = conn.prepareStatement(query)) {
            int i = 0;
            updateVenda.setBigDecimal(++i, venda.getValor());
            updateVenda.setLong(++i, venda.getId());

            updateVenda.executeUpdate();
        }
    }

    public void cancelarVenda(Venda venda) throws SQLException {
        String query = "delete from tb_item_venda where id = ?; delete from tb_venda where id = ?";


        try (PreparedStatement updateVenda = conn.prepareStatement(query)) {
            int i = 0;
            updateVenda.setLong(++i, venda.getId());
            updateVenda.setLong(++i, venda.getId());

            updateVenda.executeUpdate();
        }
    }

}
