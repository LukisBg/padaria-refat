
package com.padariacachoeiro.service;

import com.padariacachoeiro.model.Usuario;
import com.padariacachoeiro.persistence.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrar(Usuario usuario) throws Exception {

        if (usuario == null) {
            throw new Exception("Objeto usuário nulo.");
        }
        if (usuario.getNomeUser() == null || usuario.getNomeUser().trim().isEmpty()) {
            throw new Exception("O nome de usuário é obrigatório.");
        }
        if (usuario.getSenhaUser() == null || usuario.getSenhaUser().isEmpty()) {
            throw new Exception("A senha é obrigatória.");
        }

       
        if (usuario.getSenhaUser().length() < 6) {
            throw new Exception("A senha deve ter no mínimo 6 caracteres.");
        }
        

        try {
            usuarioDAO.salvar(usuario);
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar usuário: " + e.getMessage());
        }
    }


    public List<Usuario> listarTodos() throws Exception {
        try {
            return usuarioDAO.listarTodos();
        } catch (SQLException e) {
            throw new Exception("Erro ao listar usuários: " + e.getMessage());
        }
    }
}