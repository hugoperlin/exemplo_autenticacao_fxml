package ifpr.pgua.eic.atividade3bim.telas;

import ifpr.pgua.eic.atividade3bim.App;
import ifpr.pgua.eic.atividade3bim.repositorios.RepositorioCarros;
import ifpr.pgua.eic.atividade3bim.servicos.AutenticacaoServico;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Home {
    
    private RepositorioCarros repositorio;
    private AutenticacaoServico autenticacaoServico;
    
    @FXML
    private StackPane painelCentral;

    @FXML
    private BorderPane root;


    public Home(RepositorioCarros repositorio,AutenticacaoServico autenticacaoServico){
        this.repositorio = repositorio;
        this.autenticacaoServico = autenticacaoServico;
    }

    public void initialize(){
        atualizaTela();
    }

    @FXML
    private void loadListas(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxmls/listas.fxml", (o)->new Listas(repositorio)));
    }

    @FXML
    private void loadCadastroCarro(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxmls/cadastro_carro.fxml", (o)->new CadastroCarro(repositorio)));
    }


    //método para deslogar o usuário.
    //Note que o método atualiza é invocado
    //para mostrar novamente o formulário de login.
    @FXML
    private void logout(){
        autenticacaoServico.logout();
        atualizaTela();
    }


    //esse método serve para ajustar a tela de acordo
    //com o resultado da autenticação. Se não houver usuário
    //logado, a parte da esquerda da tela é escondida e 
    //é mostrada na parte central a tela de login.
    //Caso o usuário estiver logado, a tela home é mostrada normalmente.
    //Importante salientar que este método vai depender de como você montar
    //a suas telas.
    @FXML
    public void atualizaTela(){
        if(!autenticacaoServico.estaLogado()){
            root.getLeft().setVisible(false);
            painelCentral.getChildren().clear();
            painelCentral.getChildren().add(App.loadTela("fxmls/login.fxml", a->new Login(autenticacaoServico,this)));
        }else{
            root.getLeft().setVisible(true);
            painelCentral.getChildren().clear();
        }

    }
}
