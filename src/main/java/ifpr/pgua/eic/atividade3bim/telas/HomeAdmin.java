package ifpr.pgua.eic.atividade3bim.telas;

import javafx.fxml.FXML;

public class HomeAdmin {
    

    private Home homeController;

    public HomeAdmin(Home homeController){
        System.out.println("Home admin");
        this.homeController = homeController;
    }

    @FXML
    public void logout(){
        homeController.logout();
    }


}
