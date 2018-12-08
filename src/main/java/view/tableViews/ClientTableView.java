package view.tableViews;

import dao.entities.ClientEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GenericLabService;

import java.util.Date;

public class ClientTableView implements GenericTableView {

    private GenericLabService<ClientEntity> service;
    private ObservableList<ClientEntity> entities;
    private TableView<ClientEntity> tableView;
    private BarChart barChart;

    public ClientTableView(GenericLabService<ClientEntity> service) {
        this.service = service;
    }

    @SuppressWarnings("unchecked")
    public TableView getTableView() {
        tableView = new TableView<ClientEntity>();
        tableView.setEditable(true);

        entities = FXCollections.observableList(service.getAll());

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

    public BarChart getBarChart() {
        return null;
    }
}
