package ifpr.pgua.eic.atividade3bim.modelos;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private boolean admin;
    
    public Usuario(int id, String login, boolean admin) {
        this.id = id;
        this.login = login;
        this.admin = admin;
    }


    public boolean isAdmin(){
        return admin;
    }

    public String getLogin(){
        return login;
    }    

    public int getId(){
        return id;
    }
}
