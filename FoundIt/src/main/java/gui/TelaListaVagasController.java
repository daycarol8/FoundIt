package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.*;
import negocio.ControladorVaga;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class TelaListaVagasController implements Initializable {

    @FXML
    TableView<Vaga> vagasTable;
    @FXML
    TableColumn<Vaga, String> tituloColumn;
    @FXML
    TableColumn<Vaga, String> nivelColumn;
    @FXML
    TableColumn<Vaga, Tecnologias> tecnologiasColumn;
    @FXML
    TableColumn<Vaga, String> contratoColumn;
    @FXML
    TableColumn<Vaga, Empresa> empresaColumn;
    @FXML
    TableColumn<Vaga, String> localColumn;

    @FXML
    TextField filterField;


    ControladorVaga controladorVaga = ControladorVaga.getInstance();

    ObservableList<Vaga> vagas = FXCollections.observableArrayList();

    @FXML
    public void handleClick(MouseEvent event){
        if (event.getClickCount() == 2) {
            TableView.TableViewSelectionModel<Vaga> p = vagasTable.getSelectionModel();
            controladorVaga.setSelectedVaga(p.getSelectedItem());
            System.out.println(controladorVaga.getSelectedVaga());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        vagas.addAll(controladorVaga.listarVagasAtivas());
        System.out.println(vagas);
      //  vagasTable.setItems(vagas);

        tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        nivelColumn.setCellValueFactory(new PropertyValueFactory<>("nivel"));
       tecnologiasColumn.setCellValueFactory(new PropertyValueFactory<>("tags"));
        contratoColumn.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        empresaColumn.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        localColumn.setCellValueFactory(new PropertyValueFactory<>("local"));

        FilteredList<Vaga> filteredList = new FilteredList<>(vagas, b->true);

        filterField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate(vaga -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                for(Tecnologias a : vaga.getTags()){
                    if(a.toString().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }
                }

                if(vaga.getTitulo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(vaga.getNivel().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(vaga.getContrato().toString().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(vaga.getEmpresa().getNomeSocial().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(vaga.getLocal().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return  false;
                }
            });
        });

        SortedList<Vaga> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(vagasTable.comparatorProperty());

        vagasTable.setItems(sortedList);


    }
}
