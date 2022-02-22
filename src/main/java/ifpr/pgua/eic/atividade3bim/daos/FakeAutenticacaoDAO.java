package ifpr.pgua.eic.atividade3bim.daos;

import java.util.ArrayList;

import ifpr.pgua.eic.atividade3bim.daos.interfaces.AutenticacaoDAO;
import ifpr.pgua.eic.atividade3bim.modelos.Usuario;
import ifpr.pgua.eic.atividade3bim.utils.FabricaConexoes;

public class FakeAutenticacaoDAO implements AutenticacaoDAO {


    @Override
    public Usuario login(String login, String senha) throws Exception {
        //Select * from Usuario where login=? and senha=? and ativo=1
        if(login.equals("Teste") && senha.equals("12345")){
            return new Usuario(1, "Teste",false);
        }else if(login.equals("Admin") && senha.equals("admin")){
            return new Usuario(2, "Admin", true);
        }
        return null;
    }

    @Override
    public boolean cadastrar(String login, String senha) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    
    
}
