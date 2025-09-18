package com.padariacachoeiro.service;

import com.padariacachoeiro.model.Produto;
import com.padariacachoeiro.persistence.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

public class ProdutoService {

    private final ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void cadastrar(Produto produto) throws Exception {
        // REGRA 1: Validar campos
        if (produto == null) {
            throw new Exception("Objeto produto nulo.");
        }
        if (produto.getNomeProduto() == null || produto.getNomeProduto().trim().isEmpty()) {
            throw new Exception("O nome do produto é obrigatório.");
        }

        // REGRA 2: O valor do produto não pode ser negativo
        if (produto.getValorProduto() < 0) {
            throw new Exception("O valor do produto não pode ser negativo.");
        }

        try {
            produtoDAO.salvar(produto);
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar produto: " + e.getMessage());
        }
    }

    public void atualizar(Produto produto) throws Exception {
        if (produto == null || produto.getId() <= 0) {
            throw new Exception("ID do produto é inválido para atualização.");
        }
        // ... outras validações ...
         if (produto.getValorProduto() < 0) {
            throw new Exception("O valor do produto não pode ser negativo.");
        }

        try {
            produtoDAO.atualizar(produto);
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar produto: " + e.getMessage());
        }
    }
    
    public void excluir(int id) throws Exception {
         if (id <= 0) {
            throw new Exception("ID inválido para exclusão.");
        }
        try {
            produtoDAO.excluir(id);
        } catch (SQLException e) {
            throw new Exception("Erro ao excluir produto: " + e.getMessage());
        }
    }

    public List<Produto> listarTodos() throws Exception {
        try {
            return produtoDAO.listarTodos();
        } catch (SQLException e) {
            throw new Exception("Erro ao listar produtos: " + e.getMessage());
        }
    }
}
