package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ControlPanelController {
    @FXML
    private ListView<Aktywa> MainListView;

    private Swiat swiat;
    public void initData(Swiat swiat, ObservableList<Aktywa> _list){
        this.swiat=swiat;
        ObservableList<Aktywa> list = _list;
        /*for (int i=0; i<swiat.getListaSpolek().size(); i++){
            list.add(swiat.getListaSpolek().get(i));
        }*/
        MainListView.setItems(list);
    }
}
