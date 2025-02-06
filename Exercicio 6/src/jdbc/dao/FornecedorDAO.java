    package jdbc.dao;
import java.util.ArrayList;
import jdbc.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedorDAO implements IDao {
private Connection conn;
public FornecedorDAO(){
conn = new ConnectionFactory().getConnection();
}
@Override
public ArrayList<Fornecedor>consultar(){
ArrayList<Fornecedor>lstFornecedores = new ArrayList<>();
String sql = "select * from Fornecedor";
PreparedStatement comando;
ResultSet resultado;
try {
            comando = conn.prepareStatement(sql);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setId(resultado.getInt("id"));
                forn.setNome(resultado.getString("nome"));
                forn.setCnpj(resultado.getString("cnpj"));
                forn.setEmail(resultado.getString("email"));
                forn.setTelefone(resultado.getString("telefone"));
                forn.setCelular(resultado.getString("celular"));
                forn.setCep(resultado.getString("cep"));
                forn.setEndereco(resultado.getString("endereco"));
                forn.setNumero(resultado.getString("numero"));
                forn.setComplemento(resultado.getString("complemento"));
                forn.setBairro(resultado.getString("bairro"));
                forn.setCidade(resultado.getString("cidade"));
                forn.setEstado(resultado.getString("estado"));
                lstFornecedores.add(forn);
            }
            return lstFornecedores;

}
catch (Exception e) {
            throw new RuntimeException(e.getMessage());
}
}
@Override
public Fornecedor consultar(int id){
Fornecedor forn = new Fornecedor();
String sql = "select * from fornecedor where id = ?";
PreparedStatement comando;
ResultSet resultado;
try {
            comando = conn.prepareStatement(sql);
            comando.setInt(1, id);
            resultado = comando.executeQuery();
            if (resultado.next()) {
                forn.setId(resultado.getInt("id"));
                forn.setNome(resultado.getString("nome"));
                forn.setCnpj(resultado.getString("cnpj"));
                forn.setEmail(resultado.getString("email"));
                forn.setTelefone(resultado.getString("telefone"));
                forn.setCelular(resultado.getString("celular"));
                forn.setCep(resultado.getString("cep"));
                forn.setEndereco(resultado.getString("endereco"));
                forn.setNumero(resultado.getString("numero"));
                forn.setComplemento(resultado.getString("complemento"));
                forn.setBairro(resultado.getString("bairro"));
                forn.setCidade(resultado.getString("cidade"));
                forn.setEstado(resultado.getString("estado"));
            }
            return forn;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
}
        public ArrayList<Fornecedor> consultar(String nome) {
        ArrayList<Fornecedor> lista = new ArrayList<>();
        String sql = "select * from fornecedor where nome like ?";
        PreparedStatement comando;
        ResultSet resultado;
        try {
            comando = conn.prepareStatement(sql);
            comando.setString(1, nome);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setId(resultado.getInt("id"));
                forn.setNome(resultado.getString("nome"));
                forn.setCnpj(resultado.getString("cnpj"));
                forn.setEmail(resultado.getString("email"));
                forn.setTelefone(resultado.getString("telefone"));
                forn.setCelular(resultado.getString("celular"));
                forn.setCep(resultado.getString("cep"));
                forn.setEndereco(resultado.getString("endereco"));
                forn.setNumero(resultado.getString("numero"));
                forn.setComplemento(resultado.getString("complemento"));
                forn.setBairro(resultado.getString("bairro"));
                forn.setCidade(resultado.getString("cidade"));
                forn.setEstado(resultado.getString("estado"));
                lista.add(forn);
            }
            return lista;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
  @Override
    public Fornecedor cadastrar(Fornecedor fornecedor) {
                String query = "insert into fornecedor (nome, cnpj, email, telefone, celular, cep, endereco, numero,\n"
                + "complemento, bairro, cidade, estado) \n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        ResultSet resultado = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fornecedor.getNome());
            preparedStatement.setString(2, fornecedor.getCnpj());
            preparedStatement.setString(3, fornecedor.getEmail());
            preparedStatement.setString(4, fornecedor.getTelefone());
            preparedStatement.setString(5, fornecedor.getCelular());
            preparedStatement.setString(6, fornecedor.getCep());
            preparedStatement.setString(7, fornecedor.getEndereco());
            preparedStatement.setString(8, fornecedor.getNumero());
            preparedStatement.setString(9, fornecedor.getComplemento());
            preparedStatement.setString(10, fornecedor.getBairro());
            preparedStatement.setString(11, fornecedor.getCidade());
            preparedStatement.setString(12, fornecedor.getEstado());
            preparedStatement.executeUpdate();
            resultado = preparedStatement.getGeneratedKeys();
            if (resultado.next()) {
                fornecedor.setId(resultado.getInt(1));
            }
            return fornecedor;

        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }

    }
     @Override
    public boolean excluir(int id) {
        String sql = "delete from fornecedor where id = ?";
        PreparedStatement comando;
        try {
            comando = conn.prepareStatement(sql);
            comando.setInt(1, id);
            if (comando.executeUpdate() > 0) {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
             throw new RuntimeException(e.getMessage());
        }
    }
        @Override
    public boolean alterar(Fornecedor fornecedor, int id) {
        String query = "update fornecedor  set nome = ?, cnpj =?, email = ?, "
                + "telefone = ?, celular = ?, cep = ?, endereco = ?, numero = ?, "
                + "complemento = ?, bairro = ?, cidade = ?, estado = ? "
                + " where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = conn.prepareCall(query);
            preparedStatement.setString(1, fornecedor.getNome());
            preparedStatement.setString(2, fornecedor.getCnpj());
            preparedStatement.setString(3, fornecedor.getEmail());
            preparedStatement.setString(4, fornecedor.getTelefone());
            preparedStatement.setString(5, fornecedor.getCelular());
            preparedStatement.setString(6, fornecedor.getCep());
             preparedStatement.setString(7, fornecedor.getEndereco());
            preparedStatement.setString(8, fornecedor.getNumero());
            preparedStatement.setString(9, fornecedor.getComplemento());
            preparedStatement.setString(10, fornecedor.getBairro());
            preparedStatement.setString(11, fornecedor.getCidade());
            preparedStatement.setString(12, fornecedor.getEstado());
            preparedStatement.setInt(13, id);
            
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
            else{
                return false;
            }
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }


    }

}
