
package com.padariacachoeiro.service;

import com.padariacachoeiro.model.Cliente;
import com.padariacachoeiro.persistence.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrar(Cliente cliente) throws Exception {
        // REGRA 1: Validar campos obrigatórios
        if (cliente == null) {
            throw new Exception("Objeto cliente nulo.");
        }
        if (cliente.getNomeCliente() == null || cliente.getNomeCliente().trim().isEmpty()) {
            throw new Exception("O nome do cliente é obrigatório.");
        }
        if (cliente.getCpf() == null || cliente.getCpf().trim().isEmpty()) {
            throw new Exception("O CPF do cliente é obrigatório.");
        }

        // REGRA 2: O CPF deve ter 11 dígitos (apenas números)
        String cpfNumerico = cliente.getCpf().replaceAll("[^0-9]", "");
        if (cpfNumerico.length() != 11) {
            throw new Exception("Formato de CPF inválido. Deve conter 11 dígitos.");
        }
        
        // Se todas as regras passaram, chama a persistência
        try {
            clienteDAO.salvar(cliente);
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar cliente no banco de dados: " + e.getMessage());
        }
    }

    public void atualizar(Cliente cliente) throws Exception {
        // Validações semelhantes ao cadastro
        if (cliente == null || cliente.getId() <= 0) {
            throw new Exception("ID do cliente é inválido para atualização.");
        }
        // ... outras validações ...

        try {
            clienteDAO.atualizar(cliente);
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar cliente: " + e.getMessage());
        }
    }
    
    public void excluir(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido para exclusão.");
        }
        try {
            clienteDAO.excluir(id);
        } catch (SQLException e) {
            throw new Exception("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    public Cliente consultar(int id) throws Exception {
        try {
            return clienteDAO.consultarPorId(id);
        } catch (SQLException e) {
            throw new Exception("Erro ao consultar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarTodos() throws Exception {
        try {
            return clienteDAO.listarTodos();
        } catch (SQLException e) {
            throw new Exception("Erro ao listar clientes: " + e.getMessage());
        }
    }
}