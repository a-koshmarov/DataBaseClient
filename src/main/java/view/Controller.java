package view;

import dao.HibernateSessionFactory;
import dao.entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import service.FilmServiceImpl;
import service.GenericFilmService;
import service.GenericLabService;
import service.GenericLabServiceImpl;
import view.tableViews.*;

public class Controller {

    @FXML
    private SplitPane clientPane;

    @FXML
    private SplitPane labPane;

    @FXML
    private SplitPane labOrderPane;

    @FXML
    private SplitPane filmPane;

    @FXML
    private SplitPane employeePane;

    @FXML
    void initialize() {

        // Lab
        GenericLabService<LabEntity> labService = new GenericLabServiceImpl<LabEntity>(
                HibernateSessionFactory.getSessionFactory(), LabEntity.class);

        GenericTableView labView = new LabTableView(labService);
        labPane.getItems().addAll(labView.getTableView(), labView.getChart());


        // Client
        GenericLabService<ClientEntity> clientService = new GenericLabServiceImpl<ClientEntity>(
                HibernateSessionFactory.getSessionFactory(), ClientEntity.class);

        GenericTableView clientView = new ClientTableView(clientService);
        clientPane.getItems().addAll(clientView.getTableView(), clientView.getChart());


        // Film
        GenericFilmService filmService = new FilmServiceImpl(
                HibernateSessionFactory.getSessionFactory(), FilmEntity.class);

        GenericTableView filmView = new FilmTableView(filmService);
        filmPane.getItems().addAll(filmView.getTableView(), filmView.getChart());


        // LabOrder
        GenericLabService<LabOrderEntity> labOrderService = new GenericLabServiceImpl<LabOrderEntity>(
                HibernateSessionFactory.getSessionFactory(), LabOrderEntity.class);

        GenericTableView labOrderView = new LabOrderTableView(labOrderService);
        labOrderPane.getItems().addAll(labOrderView.getTableView(), labOrderView.getChart());


        //Employee
        GenericLabService<EmployeeEntity> employeeService = new GenericLabServiceImpl<EmployeeEntity>(
                HibernateSessionFactory.getSessionFactory(), EmployeeEntity.class);

        GenericTableView employeeView = new EmployeeTableView(employeeService);
        employeePane.getItems().addAll(employeeView.getTableView(), employeeView.getChart());
    }

}
