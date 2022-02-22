package ifpr.pgua.eic.atividade3bim.modelos;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    
    public Usuario(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public String getLogin(){
        return login;
    }    

    public int getId(){
        return id;
    }
}
