package view;

import dao.HibernateSessionFactory;
import dao.entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
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
        labPane.getItems().addAll(labView.getTableView(), labView.getBarChart());


        // Client
        GenericLabService<ClientEntity> clientService = new GenericLabServiceImpl<ClientEntity>(
                HibernateSessionFactory.getSessionFactory(), ClientEntity.class);

        GenericTableView clientView = new ClientTableView(clientService);
        clientPane.getItems().addAll(clientView.getTableView(), clientView.getBarChart());


        // Film
        GenericLabService<FilmEntity> filmService = new GenericLabServiceImpl<FilmEntity>(
                HibernateSessionFactory.getSessionFactory(), FilmEntity.class);

        GenericTableView filmView = new FilmTableView(filmService);
        filmPane.getItems().addAll(filmView.getTableView(), filmView.getBarChart());


        // LabOrder
        GenericLabService<LabOrderEntity> labOrderService = new GenericLabServiceImpl<LabOrderEntity>(
                HibernateSessionFactory.getSessionFactory(), LabOrderEntity.class);

        GenericTableView labOrderView = new LabOrderTableView(labOrderService);
        labOrderPane.getItems().addAll(labOrderView.getTableView(), labOrderView.getBarChart());


        //Employee
        GenericLabService<EmployeeEntity> employeeService = new GenericLabServiceImpl<EmployeeEntity>(
                HibernateSessionFactory.getSessionFactory(), EmployeeEntity.class);

        GenericTableView employeeView = new EmployeeTableView(employeeService);
        employeePane.getItems().addAll(employeeView.getTableView(), employeeView.getBarChart());
    }

}
