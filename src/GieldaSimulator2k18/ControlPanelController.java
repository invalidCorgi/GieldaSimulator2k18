package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ControlPanelController {
    @FXML
    private ListView<String> MainListView;

    private Swiat swiat;
    public void initData(Swiat swiat, ObservableList<String> _list){
        this.swiat=swiat;
        ObservableList<String> list = _list;
        for (int i=0; i<swiat.getListaWalut().size(); i++){
            list.add(swiat.getListaWalut().get(i).getNazwa());
        }
        MainListView.setItems(list);
    }
}
