package GieldaSimulator2k18;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MultiLineChartController {
    @FXML
    private ListView<Aktywa> AktywaListView;
    @FXML
    private LineChart<String,Number> AktywaLineChart;

    private ObservableList<Aktywa> listaMain;
    private List<Aktywa> narysowaneAktywa;

    /**
     * Dodanie wybranego aktywu do wykresu jesli jeszcze go tam nie ma
     */

    @FXML
    private void AddAktywaToChart(){
        Aktywa aktywa = AktywaListView.getSelectionModel().getSelectedItem();
        if (aktywa!=null && !narysowaneAktywa.contains(aktywa)) {
            narysowaneAktywa.add(aktywa);
            XYChart.Series series = new XYChart.Series();
            series.setName(aktywa.getNazwa());
            for (int i = 0; i < aktywa.getHistoriaKursu().size(); i++) {
                series.getData().add(new XYChart.Data(aktywa.getHistoriaKursu().get(i).getCzas().format(DateTimeFormatter.ofPattern("dd-MM-yyyy\nHH:mm:ss")), aktywa.getHistoriaKursu().get(i).getKurs()/aktywa.getKursOtwarcia()*100));
            }
            AktywaLineChart.getData().add(series);
        }
    }

    /**
     * Inicjalizacja okna
     *
     * @param listaMain lista aktywow z okna glownego
     */

    public void initData(ObservableList<Aktywa> listaMain){
        this.listaMain = listaMain;
        AktywaListView.setItems(listaMain);
        narysowaneAktywa = new ArrayList<>();
    }
}
