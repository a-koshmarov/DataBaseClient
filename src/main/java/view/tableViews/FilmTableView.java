package view.tableViews;

import dao.entities.FilmEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GenericLabService;

import java.util.ArrayList;

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
    public PieChart getChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Integer iso : getIsos()){
            pieChartData.add(new PieChart.Data("ISO "+iso+": "+getShotsPerIso(iso), getShotsPerIso(iso)));
        }
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Shots per ISO");
        pieChart.setLabelLineLength(30);
        pieChart.setLegendSide(Side.LEFT);
        return pieChart;
    }

    private ArrayList<Integer> getIsos(){
        ArrayList<Integer> isos = new ArrayList<>();
        for (FilmEntity entity : entities){
            if (!isos.contains(entity.getIso())){
                isos.add(entity.getIso());
            }
        }
        return isos;
    }

    private int getShotsPerIso(Integer iso){
        int count = 0;
        for(FilmEntity entity : entities){
            if (entity.getIso().equals(iso)){
                count+=entity.getShots();
            }
        }
        return count;
    }
}