package ifpr.pgua.eic.atividade3bim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

import ifpr.pgua.eic.atividade3bim.daos.FakeAutenticacaoDAO;
import ifpr.pgua.eic.atividade3bim.daos.FakeCarroDao;
import ifpr.pgua.eic.atividade3bim.daos.interfaces.AutenticacaoDAO;
import ifpr.pgua.eic.atividade3bim.daos.interfaces.CarroDAO;
import ifpr.pgua.eic.atividade3bim.repositorios.RepositorioCarros;
import ifpr.pgua.eic.atividade3bim.servicos.AutenticacaoServico;
import ifpr.pgua.eic.atividade3bim.telas.Home;
import ifpr.pgua.eic.atividade3bim.utils.FabricaConexoes;

/**
 * JavaFX App
 */
public class App extends Application {

    FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();

    
    //DESCOMENTAR PARA RESOLVER O EXERCÍCIO
    //CarroDAO carroDAO = new JDBCCarroDAO(fabricaConexoes);

    //COMENTAR PARA RESOLVER O EXERCÍCIO

    
    private static final CarroDAO carroDAO = new FakeCarroDao();
    private static final AutenticacaoDAO autenticacaoDAO = new FakeAutenticacaoDAO();


    private static final RepositorioCarros repositorio = new RepositorioCarros(carroDAO);
    private static final AutenticacaoServico autenticacaoServico = new AutenticacaoServico(autenticacaoDAO);
    
    

    @Override
    public void start(Stage stage) throws IOException {
        
        //Scene scene = new Scene(loadTela("fxmls/home.fxml", o->new Home(repositorio,autenticacaoServico)), 640, 480);
        
        Scene scene = new Scene(loadTela("fxmls/home.fxml", o->new Home(repositorio, autenticacaoServico)), 640, 480);
        
        stage.setScene(scene);
        stage.show();
    }

    
    public static Parent loadTela(String fxml, Callback controller){
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource(fxml));
            loader.setControllerFactory(controller);

            root = loader.load();
            
        }catch (Exception e){
            System.out.println("Problema no arquivo fxml. Está correto?? "+fxml);
            e.printStackTrace();
            System.exit(0);
        }
        return root;   
    }
 

    public static void main(String[] args) {
        launch();
    }

}