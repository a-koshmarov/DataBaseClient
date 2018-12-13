package view.tableViews;

import dao.entities.FilmEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GenericFilmService;
import service.GenericLabService;

import java.util.ArrayList;

public class FilmTableView implements GenericTableView {

    private ObservableList<FilmEntity> entities;
    private GenericFilmService service;

    public FilmTableView(GenericFilmService service){
        this.entities = FXCollections.observableList(service.getAll());
        this.service = service;
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
    public PieChart getChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Integer iso : service.getIsos()){
            pieChartData.add(new PieChart.Data("ISO "+iso+": "+service.getShotsPerIso(iso), service.getShotsPerIso(iso)));
        }
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Shots per ISO");
        pieChart.setLabelLineLength(30);
        pieChart.setLegendSide(Side.LEFT);
        return pieChart;
    }


}