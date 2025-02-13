package com.hbm.reserva.dao;

import com.hbm.reserva.ConnectionFactory;
import com.hbm.reserva.dto.ReservaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaDAO {
    ConnectionFactory conexao = new ConnectionFactory();

    public boolean insereReserva (ReservaDTO reserva){

        try{
            PreparedStatement ps = conexao.getConnectionFactory().prepareStatement("INSERT INTO reservas VALUES(?,?,?,?,?,?,?,?)");

            ps.setString(1, null);
            ps.setString(2, reserva.nome());
            ps.setString(3, reserva.email());
            ps.setString(4, reserva.sexo());
            ps.setString(5, reserva.chegada());
            ps.setString(6, reserva.noites());
            ps.setString(7, reserva.hospedes());
            ps.setString(8, reserva.mensagem());

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    public void consultaReserva(){
        try {
            PreparedStatement ps = conexao.getConnectionFactory()
                    .prepareStatement("SELECT * FROM reservas");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReservaDTO p = new ReservaDTO(
                        rs.getString(2), // nome
                        rs.getString(3), // email
                        rs.getString(4), // sexo
                        rs.getString(5), // chegada
                        rs.getString(6), // noites
                        rs.getString(7), // hospedes
                        rs.getString(8) // mensagem
                );
                System.out.println("Nome: " + p.nome());
                System.out.println("Email: " + p.email());
                System.out.println("Sexo: " + p.sexo());
                System.out.println("chegada: " + p.chegada());
                System.out.println("Quantidade de noites: " + p.noites());
                System.out.println("hospedes: " + p.hospedes());
                System.out.println("mensagem: " + p.mensagem());
                System.out.println("----------");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
