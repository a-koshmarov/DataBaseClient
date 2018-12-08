package view.tableViews;

import dao.entities.LabEntity;
import dao.entities.LabOrderEntity;
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

public class LabOrderTableView implements GenericTableView {

    private ObservableList<LabOrderEntity> entities;

    public LabOrderTableView(GenericLabService<LabOrderEntity> service){
        this.entities = FXCollections.observableList(service.getAll());
    }
    @SuppressWarnings("unchecked")
    public TableView getTableView() {
        TableView<LabOrderEntity> tableView = new TableView<LabOrderEntity>();
        tableView.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(
                new PropertyValueFactory<LabOrderEntity, Integer>("orderId"));

        TableColumn priceCol = new TableColumn("Price");
        priceCol.setCellValueFactory(
                new PropertyValueFactory<LabOrderEntity, Integer>("price"));

        TableColumn discountedCol = new TableColumn("Discounted");
        discountedCol.setCellValueFactory(
                new PropertyValueFactory<LabOrderEntity, Integer>("discountedPrice"));

        TableColumn purchaseCol = new TableColumn("Date of purchase");
        purchaseCol.setCellValueFactory(
                new PropertyValueFactory<LabOrderEntity, Date>("dateOfPurchase"));

        TableColumn statusCol = new TableColumn("Status");
        statusCol.setCellValueFactory(
                new PropertyValueFactory<LabOrderEntity, Integer>("status"));

        TableColumn completionCol = new TableColumn("Completion time");
        completionCol.setCellValueFactory(
                new PropertyValueFactory<LabOrderEntity, Date>("completionTime"));


        tableView.setItems(entities);
        tableView.getColumns().addAll(idCol, priceCol, discountedCol, purchaseCol, statusCol, completionCol);
        return tableView;
    }

    @SuppressWarnings("unchecked")
    public BarChart getBarChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Order ID");

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount");

        XYChart.Series series = new XYChart.Series();

        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
        for (LabOrderEntity entity : entities){
            series.getData().add(new XYChart.Data(Integer.toString(entity.getOrderId()), entity.getPrice()));
        }
        barChart.getData().addAll(series);
        return barChart;
    }
}
