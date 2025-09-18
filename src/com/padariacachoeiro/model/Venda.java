package com.padariacachoeiro.model;

public class Venda {
    
    String produtoVenda;
    double valorPdtVenda;
    String pagamento;

    public String getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(String produtoVenda) {
        this.produtoVenda = produtoVenda;
    }

    public double getValorPdtVenda() {
        return valorPdtVenda;
    }

    public void setValorPdtVenda(double valorPdtVenda) {
        this.valorPdtVenda = valorPdtVenda;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
}