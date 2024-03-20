package com.nerdoteca.api.dao;

import com.nerdoteca.api.connection.Conexao;
import com.nerdoteca.api.domain.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDAO {

    private Connection conexao;

    public EnderecoDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, "Não foi possivel instabelecer conexão", ex);
        }
    }

    public void salvar(Endereco endereco){
        String sql = "INSERT INTO endereco VALUES ();";
    }

    public void alterar(Endereco endereco) throws Exception {
        try {

            String sql = "DELETE FROM enderecos WHERE end_id = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);

            ps.setInt(1, (int) endereco.getId());
            ps.execute();

            conexao.commit();

        } catch (SQLException e) {
            conexao.rollback();
            throw new Exception(e);
        }
    }

    public void deletar(Endereco endereco){

    }

    public void consultarPorId(Endereco endereco) throws Exception {
        try {

            String sql = "SELECT * FROM enderecos WHERE end_id = ?;";

            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, (int) endereco.getId());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                endereco.setId(rs.getLong("end_id"));
                endereco.setNomeEndereco(rs.getString("end_nome"));
                endereco.setTipoEndereco("end_tipo_residencial");
            }

            conexao.commit();

        } catch (SQLException e) {
            conexao.commit();
            throw new Exception(e);
        }
    }

    public void consultarEnderecos(Endereco endereco){

    }


}