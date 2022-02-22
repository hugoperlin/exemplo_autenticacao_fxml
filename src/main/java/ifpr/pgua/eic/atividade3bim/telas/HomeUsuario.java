package ifpr.pgua.eic.atividade3bim.telas;

import javafx.fxml.FXML;

public class HomeUsuario {
    

    private Home homeController;

    public HomeUsuario(Home homeController){
        System.out.println("Home usuario");
        this.homeController = homeController;
    }

    @FXML
    public void logout(){
        homeController.logout();
    }


}
