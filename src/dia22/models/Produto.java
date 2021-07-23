package dia22.models;

import dia22.dao.ProdutoDao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class Produto {

    private Long id;

    private String descricao;

    private BigDecimal valorDeCusto;

    private BigDecimal pesoUnitario;

    private String unidadeMedidaPeso;

    private String codigoDeBarras;

    private BigDecimal valorVenda;


    public Produto(String descricao,
                   BigDecimal valorDeCusto,
                   BigDecimal pesoUnitario,
                   String unidadeMedidaPeso,
                   String codigoDeBarras,
                   BigDecimal valorVenda) {
        this.descricao = descricao;
        this.valorDeCusto = valorDeCusto;
        this.pesoUnitario = pesoUnitario;
        this.unidadeMedidaPeso = unidadeMedidaPeso;
        this.codigoDeBarras = codigoDeBarras;
        this.valorVenda = valorVenda;
    }

    public Produto(Long id,
                   String descricao,
                   BigDecimal valorDeCusto,
                   BigDecimal pesoUnitario,
                   String unidadeMedidaPeso,
                   String codigoDeBarras,
                   BigDecimal valorVenda) {
        this.id = id;
        this.descricao = descricao;
        this.valorDeCusto = valorDeCusto;
        this.pesoUnitario = pesoUnitario;
        this.unidadeMedidaPeso = unidadeMedidaPeso;
        this.codigoDeBarras = codigoDeBarras;
        this.valorVenda = valorVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }


    public BigDecimal getValorDeCusto() {
        return valorDeCusto;
    }


    public BigDecimal getPesoUnitario() {
        return pesoUnitario;
    }


    public String getUnidadeMedidaPeso() {
        return unidadeMedidaPeso;
    }


    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }


    public BigDecimal getValorVenda() {
        return valorVenda;
    }


    public void cadastrarNovoProduto(ProdutoDao dao) throws SQLException {

        if (this.id == null && !Boolean.TRUE.equals(dao.verificarSeProdutoExiste(this.codigoDeBarras))) {
            dao.inserirProduto(this);
        }
    }


    public static List<Produto> buscarProdutos(ProdutoDao dao, String filtro) throws SQLException {
        return dao.buscarProdutos(filtro);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valorDeCusto=" + valorDeCusto +
                ", pesoUnitario=" + pesoUnitario +
                ", unidadeMedidaPeso='" + unidadeMedidaPeso + '\'' +
                ", codigoDeBarras='" + codigoDeBarras + '\'' +
                ", valorVenda=" + valorVenda +
                '}';
    }
}
