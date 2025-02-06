
package jdbc.dao;
import java.util.ArrayList;
import jdbc.model.Fornecedor;


public interface IDao {
    public ArrayList<Fornecedor> consultar();
    public Fornecedor consultar(int id);
    public Fornecedor cadastrar(Fornecedor cliente);
    public boolean excluir(int id);
    public boolean alterar(Fornecedor fornecedor, int id);
    
}