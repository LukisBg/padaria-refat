
package com.padariacachoeiro.main;

import com.padariacachoeiro.model.Cliente;
import com.padariacachoeiro.service.ClienteService;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        // Cenário 1: Cadastro válido
        Cliente novoCliente = new Cliente();
        novoCliente.setNomeCliente("José da Silva");
        novoCliente.setCpf("12345678901");
        novoCliente.setTelefone("99999-8888");
        novoCliente.setEndereco("Rua das Flores, 123");

        try {
            clienteService.cadastrar(novoCliente);
            System.out.println("SUCESSO: Cliente cadastrado!");
        } catch (Exception e) {
            System.err.println("FALHA: " + e.getMessage());
        }

        // Cenário 2: Tentativa de cadastro com nome inválido
        Cliente clienteInvalido = new Cliente();
        clienteInvalido.setNomeCliente(""); // Nome vazio
        clienteInvalido.setCpf("11122233344");
        
        try {
            clienteService.cadastrar(clienteInvalido);
            System.out.println("SUCESSO: Cliente cadastrado!");
        } catch (Exception e) {
            System.err.println("FALHA ESPERADA: " + e.getMessage());
        }
    }
}