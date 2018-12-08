package view.tableViews;

import dao.entities.FilmEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GenericLabService;

public class FilmTableView implements GenericTableView {
    
    private GenericLabService<FilmEntity> service;
    private ObservableList<FilmEntity> entities;
    private TableView<FilmEntity> tableView;

    public FilmTableView(GenericLabService<FilmEntity> service){
        this.service = service;
    }

    @SuppressWarnings("unchecked")
    public TableView getTableView() {
        tableView = new TableView<FilmEntity>();
        tableView.setEditable(true);

        entities = FXCollections.observableList(service.getAll());

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

    public BarChart getBarChart() {
        return null;
    }
}
