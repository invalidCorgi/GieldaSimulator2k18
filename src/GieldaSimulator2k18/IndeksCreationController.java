package GieldaSimulator2k18;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class IndeksCreationController {
    @FXML
    private ListView<GieldaPapierowWartosciowych> gieldyListView;
    @FXML
    private ListView<Spolka> spolkiListView;
    @FXML
    private ListView<Spolka> wybraneSpolkiListView;
    @FXML
    private CheckBox najwiekszeSpolkiCheckBox;
    @FXML
    private TextField najwiekszeSpolkiTextField;

    private Swiat swiat;
    private ObservableList<GieldaPapierowWartosciowych> gieldyListViewObservableList;
    private ObservableList<Spolka> spolkiListViewObservableList;
    private ObservableList<Spolka> wybraneSpolkiListViewObservableList;
    private ObservableList<Object> controlPanelListViewObservableList;
    private GieldaPapierowWartosciowych wybranaGielda;

    @FXML
    private void najwiekszeSpolkiCheckBoxClicked(){

    }

    /**
     * stworz indeks wybranych lub najwiekszych spolek w zaleznosci od zaznaczenia checkboxa
     */

    @FXML
    private void stworzIndeks(){
        if (wybranaGielda != null){
            try {
                Indeks indeks;
                if (najwiekszeSpolkiCheckBox.isSelected()) {
                    int ilosc = Integer.parseInt(najwiekszeSpolkiTextField.getText());
                    indeks = new IndeksNajwiekszychSpolek(wybranaGielda, ilosc);
                } else {
                    indeks = new Indeks(wybraneSpolkiListViewObservableList, wybranaGielda);
                }
                wybranaGielda.getListaIndeksow().add(indeks);
                swiat.getListaIndeksow().add(indeks);
                controlPanelListViewObservableList.add(indeks);
            }
            catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wprowadź liczbę w polu tekstowym");
                alert.show();
            }
        }
    }

    /**
     * pokaz spolki gieldy po jej wybraniu
     */

    @FXML
    private void wybierzGielde(){
        GieldaPapierowWartosciowych gielda = gieldyListView.getSelectionModel().getSelectedItem();
        if (gielda!=null) {
            spolkiListViewObservableList.clear();
            wybraneSpolkiListViewObservableList.clear();
            spolkiListViewObservableList.addAll(gielda.getListaSpolek());
            wybranaGielda = gielda;
        }
    }

    /**
     * dodaj do wybranych spolek kliknieta na listboxie
     */

    @FXML
    private void wybierzSpolke(){
        Spolka spolka = spolkiListView.getSelectionModel().getSelectedItem();
        if (spolka!=null && !wybraneSpolkiListViewObservableList.contains(spolka)){
            wybraneSpolkiListViewObservableList.add(spolka);
        }
    }

    /**
     * odznacz spolke wybrana z listboxa wybranych spolek
     */

    @FXML
    private void odznaczSpolke(){
        Spolka spolka = wybraneSpolkiListView.getSelectionModel().getSelectedItem();
        if (spolka != null){
            wybraneSpolkiListViewObservableList.remove(spolka);
        }
    }

    /**
     * Inicjalizacja okna tworzenia indeksów
     *
     * @param swiat swiat symulacji
     * @param objectObservableList lista obiektow z panelu kontrolnego
     */

    public void initData(Swiat swiat, ObservableList<Object> objectObservableList){
        this.swiat = swiat;
        gieldyListViewObservableList = FXCollections.observableArrayList();
        spolkiListViewObservableList = FXCollections.observableArrayList();
        wybraneSpolkiListViewObservableList = FXCollections.observableArrayList();
        gieldyListViewObservableList.addAll(swiat.getListaGield());
        gieldyListView.setItems(gieldyListViewObservableList);
        spolkiListView.setItems(spolkiListViewObservableList);
        wybraneSpolkiListView.setItems(wybraneSpolkiListViewObservableList);
        controlPanelListViewObservableList = objectObservableList;
    }
}
