package view.tableViews;

import dao.entities.EmployeeEntity;
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

import java.util.Date;

public class EmployeeTableView implements GenericTableView {

    private ObservableList<EmployeeEntity> entities;

    public EmployeeTableView(GenericLabService<EmployeeEntity> service){
        this.entities = FXCollections.observableList(service.getAll());
    }

    @SuppressWarnings("unchecked")
    public TableView getTableView() {
        TableView<EmployeeEntity> tableView = new TableView<EmployeeEntity>();
        tableView.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(
                new PropertyValueFactory<EmployeeEntity, Integer>("employeeId"));

        TableColumn nameCol = new TableColumn("Full name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<EmployeeEntity, String>("fullName"));

        TableColumn dateOfEmploymentCol = new TableColumn("Date of employment");
        dateOfEmploymentCol.setCellValueFactory(
                new PropertyValueFactory<EmployeeEntity, Date>("dateOfEmployment"));

        TableColumn positionCol = new TableColumn("Position");
        positionCol.setCellValueFactory(
                new PropertyValueFactory<EmployeeEntity, String>("position"));

        TableColumn orderCountCol = new TableColumn("Order Count");
        orderCountCol.setCellValueFactory(
                new PropertyValueFactory<EmployeeEntity, Integer>("orderCount"));

        tableView.setItems(entities);
        tableView.getColumns().addAll(idCol, nameCol, dateOfEmploymentCol, positionCol, orderCountCol);
        return tableView;
    }

    @SuppressWarnings("unchecked")
    public BarChart getBarChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Full name");

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Order count");

        XYChart.Series series = new XYChart.Series();

        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
        for (EmployeeEntity entity : entities) {
            series.getData().add(new XYChart.Data(entity.getFullName(), entity.getOrderCount()));
        }

        barChart.getData().addAll(series);
        return barChart;
    }
}
