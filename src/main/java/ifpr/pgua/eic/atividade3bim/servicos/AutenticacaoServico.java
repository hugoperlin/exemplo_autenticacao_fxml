package ifpr.pgua.eic.atividade3bim.servicos;


import ifpr.pgua.eic.atividade3bim.daos.interfaces.AutenticacaoDAO;
import ifpr.pgua.eic.atividade3bim.modelos.Usuario;

public class AutenticacaoServico {
    
    private Usuario logado;
    private AutenticacaoDAO autenticacaoDAO;

    public AutenticacaoServico(AutenticacaoDAO autenticacaoDAO){
        this.autenticacaoDAO = autenticacaoDAO;
    }

    public Usuario logar(String login, String senha) throws Exception{
        this.logado = autenticacaoDAO.login(login, senha);
        return this.logado;
    }

    public void cadastrar(String login, String senha) throws Exception{
        autenticacaoDAO.cadastrar(login, senha);
    }

    public Usuario getLogado(){
        return this.logado;
    }

    public void logout(){
        this.logado = null;
    }

    public boolean estaLogado(){
        return this.logado != null;
    }



}
