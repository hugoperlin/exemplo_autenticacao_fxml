package ifpr.pgua.eic.atividade3bim.telas;

import ifpr.pgua.eic.atividade3bim.servicos.AutenticacaoServico;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Login {
    

    @FXML
    private TextField tfUsuario;

    @FXML
    private TextField tfSenha;

    @FXML
    private Button btLogar;

    @FXML
    private Pane rootPane;

    private AutenticacaoServico autenticacaoServico;
    private Home homeControler;


    public Login(AutenticacaoServico autenticacaoServico, Home homeControler){
        this.autenticacaoServico = autenticacaoServico;
        this.homeControler = homeControler;
    }

    @FXML
    public void logar(){
        String usuario = tfUsuario.getText();
        String senha = tfSenha.getText();

        try{
            autenticacaoServico.logar(usuario, senha);
            if(autenticacaoServico.estaLogado()){
                homeControler.atualizaTela();
            }
        }catch(Exception e){

        }
        
    }


}
