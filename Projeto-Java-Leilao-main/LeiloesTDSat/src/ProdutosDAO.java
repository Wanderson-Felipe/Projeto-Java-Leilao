
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

public class ProdutosDAO {

    private Connection conn;

    public ProdutosDAO() {
        this.conn = new conectaDAO().connectDB();
    }

    public int cadastrarProduto(ProdutosDTO produto) {
        conn = new conectaDAO().connectDB();
        int status;
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)");
            st.setString(1, produto.getNome());
            st.setInt(2, produto.getValor());
            st.setString(3, produto.getStatus());

            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public List<ProdutosDTO> listarProdutos() {

        String sql = "SELECT * FROM produtos";
        List<ProdutosDTO> listagem = new ArrayList<>();
        try {

            PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ProdutosDTO produtosdto = new ProdutosDTO();
                produtosdto.setId(rs.getInt("id"));
                produtosdto.setNome(rs.getString("Nome"));
                produtosdto.setValor(rs.getInt("Valor"));
                produtosdto.setStatus(rs.getString("Status"));
                listagem.add(produtosdto);
            }
        } catch (SQLException e) {
            System.out.println("erro:" + e.getMessage());
        }
        return listagem;
    }

    public void desconectar() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Desconectar " + ex.getMessage());
        }
    }
}
