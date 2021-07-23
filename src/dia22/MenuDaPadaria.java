package dia22;

import dia22.dao.ItemVendaDao;
import dia22.dao.ProdutoDao;
import dia22.dao.VendaDao;
import dia22.models.ItemVenda;
import dia22.models.Produto;
import dia22.models.Venda;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuDaPadaria {

    public static void main(String[] args) throws SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection();

        Connection conn = databaseConnection.getConnection();


        ProdutoDao produtoDao = new ProdutoDao(conn);
        VendaDao vendaDao = new VendaDao(conn);
        ItemVendaDao itemVendaDao = new ItemVendaDao(conn);


        // Cadastrei um novo produto
        Produto p = new Produto(
                "Pão Italiano",
                BigDecimal.valueOf(0.7),
                BigDecimal.valueOf(70.0),
                "GR",
                "234",
                BigDecimal.valueOf(1.2)
        );
        p.cadastrarNovoProduto(produtoDao);


        // Inicializei uma nova venda
        Venda v = Venda.inicializarVenda(vendaDao);

        // Busquei um produto por código de barras
        List<Produto> resultadoBuscaProdutos = Produto.buscarProdutos(produtoDao, "234");
        Produto produtoEncontrado = resultadoBuscaProdutos.get(0);

        // Criei um novo item venda
        ItemVenda item = new ItemVenda();
        item.setProduto(produtoEncontrado);
        item.setQuantidade(BigDecimal.valueOf(300));


        v.adicionarItemNaVenda(itemVendaDao, item);

        v.concluirVenda(vendaDao);


        conn.close();

    }

}
