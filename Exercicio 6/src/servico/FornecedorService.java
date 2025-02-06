package servico;

import com.mysql.cj.xdevapi.Client;
import java.util.ArrayList;
import jdbc.dao.FornecedorDAO;
import jdbc.model.Fornecedor;
public class FornecedorService {
    private FornecedorDAO fornDao;

    public FornecedorService() {
        fornDao = new FornecedorDAO();
    }
    public ArrayList<Fornecedor> consultar(){
        return fornDao.consultar();
    }
    public ArrayList<Fornecedor> consultar(String nome){
        return fornDao.consultar(nome);
    }
    public Fornecedor consultar(int id){
        return fornDao.consultar(id);
    }
    public Fornecedor inserir(Fornecedor fornecedor){
        return fornDao.cadastrar(fornecedor);
    }
    public boolean alterar(int id, Fornecedor forn){
        return fornDao.alterar(forn, id);
    }
    public boolean excluir(int id){
        return fornDao.excluir(id);
    }    
}
