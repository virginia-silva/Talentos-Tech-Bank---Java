package dia22.dao;

import dia22.models.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {


    private final Connection conn;

    public ProdutoDao(Connection conn) {
        this.conn = conn;
    }

    public void inserirProduto(Produto produto) throws SQLException {
        String query = "insert into tb_produto values(default, ?, ?, ?, ?, ?, ?)";


        try (PreparedStatement insertProduto = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            int i = 0;
            insertProduto.setString(++i, produto.getDescricao());
            insertProduto.setBigDecimal(++i, produto.getValorDeCusto());
            insertProduto.setBigDecimal(++i, produto.getPesoUnitario());
            insertProduto.setString(++i, produto.getUnidadeMedidaPeso());
            insertProduto.setString(++i, produto.getCodigoDeBarras());
            insertProduto.setBigDecimal(++i, produto.getValorVenda());


            insertProduto.executeUpdate();

            ResultSet rsIdProduto = insertProduto.getGeneratedKeys();
            rsIdProduto.next();
            Long id = rsIdProduto.getLong("id");

            produto.setId(id);

            rsIdProduto.close();
        }


    }

    public Boolean verificarSeProdutoExiste(String codigoDeBarras) throws SQLException {
        String query = "select count(*) > 0 as produto_ja_cadastrado  from tb_produto where codigo_barras = ?";

        try (PreparedStatement selectVerificaProdutoExistente = conn.prepareStatement(query)) {
            selectVerificaProdutoExistente.setString(1, codigoDeBarras);


            ResultSet rs = selectVerificaProdutoExistente.executeQuery();
            rs.next();
            return rs.getBoolean("produto_ja_cadastrado");
        }

    }


    public List<Produto> buscarProdutos(String valorABuscar) throws SQLException {
        String query = "select * from tb_produto where codigo_barras = ? " +
                "union " +
                "select * from tb_produto where descricao ilike ?";

        try (PreparedStatement selectBuscarProduto = conn.prepareStatement(query)) {
            selectBuscarProduto.setString(1, valorABuscar);
            selectBuscarProduto.setString(2, "%" + valorABuscar + "%");


            ResultSet rs = selectBuscarProduto.executeQuery();

            List<Produto> produtos = new ArrayList<>();

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("descricao"),
                        rs.getBigDecimal("valor_custo"),
                        rs.getBigDecimal("peso_unitario"),
                        rs.getString("unidade_medida_peso"),
                        rs.getString("codigo_barras"),
                        rs.getBigDecimal("valor_venda")
                );
                produtos.add(produto);
            }

            return produtos;


        }
    }


}
