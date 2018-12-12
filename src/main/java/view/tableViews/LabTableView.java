package view.tableViews;

import dao.entities.LabEntity;
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


public class LabTableView implements GenericTableView {

    private ObservableList<LabEntity> entities;

    public LabTableView(GenericLabService<LabEntity> service){
        this.entities = FXCollections.observableList(service.getAll());
    }

    @SuppressWarnings("unchecked")
    public TableView getTableView() {
        TableView<LabEntity> tableView = new TableView<LabEntity>();
        tableView.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(
                new PropertyValueFactory<LabEntity, Integer>("labId"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<LabEntity, String>("labName"));

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setCellValueFactory(
                new PropertyValueFactory<LabEntity, String>("labAddress"));

        TableColumn employeesCol = new TableColumn("Employee Count");
        employeesCol.setCellValueFactory(
                new PropertyValueFactory<LabEntity, Integer>("employeesNumber"));

        TableColumn hoursCol = new TableColumn("Working hours");
        hoursCol.setCellValueFactory(
                new PropertyValueFactory<LabEntity, String>("workingHours"));

        tableView.setItems(entities);
        tableView.getColumns().addAll(idCol, nameCol, addressCol, employeesCol, hoursCol);
        return tableView;
    }
    @SuppressWarnings("unchecked")
    public BarChart getChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Laboratory name");

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of employees");

        XYChart.Series series = new XYChart.Series();

        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
        for (LabEntity entity : entities){
            series.getData().add(new XYChart.Data(entity.getLabName(), entity.getEmployeesNumber()));
        }
        barChart.getData().addAll(series);
        return barChart;
    }
}
