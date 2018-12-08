package view.tableViews;

import dao.entities.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GenericLabService;

import java.util.Date;

public class EmployeeTableView implements GenericTableView{

    private GenericLabService<EmployeeEntity> service;
    private ObservableList<EmployeeEntity> entities;
    private TableView<EmployeeEntity> tableView;

    public EmployeeTableView(GenericLabService<EmployeeEntity> service){
        this.service = service;
    }

    @SuppressWarnings("unchecked")
    public TableView getTableView() {
        tableView = new TableView<EmployeeEntity>();
        tableView.setEditable(true);

        entities = FXCollections.observableList(service.getAll());

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

    public BarChart getBarChart() {
        return null;
    }
}
