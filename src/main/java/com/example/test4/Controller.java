package com.example.test4;

import com.example.test4.entities.Array;
import com.example.test4.entities.DisplayThread;
import com.example.test4.entities.SearchingThread;
import com.example.test4.entities.SortingThread;
import com.example.test4.service.FileIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public Button selectInput;
    @FXML
    private TextField searchField;

    @FXML
    private TextField fileInput;

    @FXML
    private TextArea resultView;


    private SortingThread sortingThread;

    private SearchingThread searchingThread;

    private DisplayThread displayThread;

    private File fileArray;

    private File fileSearch;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        sortingThread = new SortingThread();
        searchingThread = new SearchingThread();
        displayThread = new DisplayThread();

        sortingThread.addSearchThread(searchingThread);
        searchingThread.addDisplayThread(displayThread);
        displayThread.setViewArea(resultView);

        sortingThread.start();
        searchingThread.start();
        displayThread.start();
    }


    @FXML
    void selectInput(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileInput.clear();
        fileArray = fileChooser.showOpenDialog(new Stage());
        if (fileArray != null) {
            fileInput.setText(fileArray.getAbsolutePath());
            int[] arr = FileIO.readArrayToFile(fileArray.getAbsolutePath());
            Array myArray = new Array(arr,arr.length);
            sortingThread.addInput(myArray);
        }
    }

    @FXML
    void selectSearch(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        searchField.clear();
        fileSearch = fileChooser.showOpenDialog(new Stage());
        if (fileSearch != null) {
            searchField.setText(fileSearch.getAbsolutePath());
            List<Integer> listSearch = FileIO.readSearchFile(fileSearch.getAbsolutePath());
            searchingThread.addSearchInput(listSearch);
        }
    }


}
