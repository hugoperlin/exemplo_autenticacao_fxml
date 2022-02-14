package ifpr.pgua.eic.atividade3bim.daos;

import java.util.ArrayList;

import ifpr.pgua.eic.atividade3bim.daos.interfaces.CarroDAO;
import ifpr.pgua.eic.atividade3bim.modelos.Carro;

public class FakeCarroDao implements CarroDAO {

    private ArrayList<Carro> lista;


    public FakeCarroDao(){
        lista = new ArrayList<>();

        lista.add(new Carro(1, "Corsa", "Chevrolet", "AAA-1111", "Amarelo", 2001, 2001, 890.0, 125000));
        lista.add(new Carro(2, "Fusca", "Volkswagen", "BBB-2222", "Preto", 1968, 1969, 590.0, 250000));
        lista.add(new Carro(3, "Uno", "Fiat", "CCC-3333", "Vermelho", 1998, 1998, 789.0, 300000));
        
    }

    @Override
    public boolean cadastrar(Carro carro) throws Exception {
        lista.add(carro);
        carro.setId(lista.size()+1);
        return true;
    }

    @Override
    public boolean atualizar(int id, Carro carro) throws Exception {
        Carro c = lista.stream().filter(item -> item.getId()==id).findFirst().orElse(null);
        if(c!=null){
            int idx = lista.indexOf(c);
            lista.set(idx, carro);
            return true;
        }
        return false;
    }

    @Override
    public boolean remover(Carro carro) throws Exception {
        lista.remove(carro);
        return true;
    }

    @Override
    public ArrayList<Carro> listar() throws Exception {
        return lista;
    }
    
}
