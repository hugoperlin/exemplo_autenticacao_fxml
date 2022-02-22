package ifpr.pgua.eic.atividade3bim.daos.interfaces;

import ifpr.pgua.eic.atividade3bim.modelos.Usuario;

public interface AutenticacaoDAO {
    Usuario login(String login,String senha) throws Exception;
    boolean cadastrar(String login, String senha) throws Exception;
}
