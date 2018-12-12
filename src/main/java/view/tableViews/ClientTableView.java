package view.tableViews;

import dao.entities.ClientEntity;
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

public class ClientTableView implements GenericTableView {

    private ObservableList<ClientEntity> entities;

    public ClientTableView(GenericLabService<ClientEntity> service){
        this.entities = FXCollections.observableList(service.getAll());
    }

    @SuppressWarnings("unchecked")
    public TableView getTableView() {
        TableView<ClientEntity> tableView = new TableView<ClientEntity>();
        tableView.setEditable(true);

        TableColumn idCol = new TableColumn("Card number");
        idCol.setCellValueFactory(
                new PropertyValueFactory<ClientEntity, Integer>("cardNumber"));

        TableColumn nameCol = new TableColumn("Full name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<ClientEntity, String>("fullName"));

        TableColumn phoneCol = new TableColumn("Phone number");
        phoneCol.setCellValueFactory(
                new PropertyValueFactory<ClientEntity, String>("phone"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setCellValueFactory(
                new PropertyValueFactory<ClientEntity, String>("email"));

        TableColumn receivedCol = new TableColumn("Received");
        receivedCol.setCellValueFactory(
                new PropertyValueFactory<ClientEntity, Date>("dateRecieved"));

        TableColumn birthCol = new TableColumn("Date of birth");
        birthCol.setCellValueFactory(
                new PropertyValueFactory<ClientEntity, Date>("dateOfBirth"));

        TableColumn discountCol = new TableColumn("Discount");
        discountCol.setCellValueFactory(
                new PropertyValueFactory<ClientEntity, Integer>("discount"));


        tableView.setItems(entities);
        tableView.getColumns().addAll(idCol, nameCol, phoneCol, emailCol, receivedCol, birthCol, discountCol);
        return tableView;
    }

    @SuppressWarnings("unchecked")
    public BarChart getChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Full name");

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Discount amount, %");

        XYChart.Series series = new XYChart.Series();

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        for (ClientEntity entity : entities){
            series.getData().add(new XYChart.Data(entity.getFullName(), entity.getDiscount()));
        }

        barChart.getData().addAll(series);
        return barChart;
    }
}
