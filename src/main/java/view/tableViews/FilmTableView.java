package view.tableViews;

import dao.entities.FilmEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GenericLabService;

public class FilmTableView implements GenericTableView {

    private ObservableList<FilmEntity> entities;

    public FilmTableView(GenericLabService<FilmEntity> service){
        this.entities = FXCollections.observableList(service.getAll());
    }

    @SuppressWarnings("unchecked")
    public TableView getTableView() {
        TableView<FilmEntity> tableView = new TableView<FilmEntity>();
        tableView.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(
                new PropertyValueFactory<FilmEntity, Integer>("filmId"));

        TableColumn manufacturerCol = new TableColumn("Manufacturer");
        manufacturerCol.setCellValueFactory(
                new PropertyValueFactory<FilmEntity, String>("manufacturer"));

        TableColumn isoCol = new TableColumn("ISO");
        isoCol.setCellValueFactory(
                new PropertyValueFactory<FilmEntity, Integer>("iso"));

        TableColumn shotsCol = new TableColumn("Number of shots");
        shotsCol.setCellValueFactory(
                new PropertyValueFactory<FilmEntity, Integer>("shots"));

        TableColumn developmentCol = new TableColumn("Development method");
        developmentCol.setCellValueFactory(
                new PropertyValueFactory<FilmEntity, String>("developmentMethod"));

        tableView.setItems(entities);
        tableView.getColumns().addAll(idCol, manufacturerCol, isoCol, shotsCol, developmentCol);
        return tableView;
    }

    @SuppressWarnings("unchecked")
    public BarChart getBarChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Film ID");

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("number of shots");

        XYChart.Series series = new XYChart.Series();

        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
        for (FilmEntity entity : entities){
            series.getData().add(new XYChart.Data(Integer.toString(entity.getFilmId()), entity.getShots()));
        }

        barChart.getData().addAll(series);
        return barChart;
    }
}
