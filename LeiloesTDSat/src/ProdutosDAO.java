/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    conectaDAO conexao;
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
     public boolean conectar() {
        this.conexao = new conectaDAO();
        this.conn = this.conexao.getConnectDB();
        if (this.conn == null) {
            return false;
        } else {
            return true;
        }
    
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
        
    
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

