package dia22.models;

import java.math.BigDecimal;

public class ItemVenda {


    private Produto produto;

    private BigDecimal quantidade;

    private BigDecimal valorUnitario;

    private BigDecimal valorTotal;

    private String descricao;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.descricao = produto.getDescricao();
        this.valorUnitario = produto.getValorVenda();
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = this.quantidade.multiply(this.valorUnitario);
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }


}
