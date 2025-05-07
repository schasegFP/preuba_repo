/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click DDDnbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import modelo.Extraccion;
import modelo.ExtraccionDAO;


import recursos.Utilidades;

/**
 * FXML Controller class
 *
 * @author d1
 */
public class FormularioController implements Initializable {

    ObservableList<Extraccion> donaciones = FXCollections.observableArrayList();
    
    // Clases de ayuda
    Utilidades ut = new Utilidades();
    ExtraccionDAO dao = new ExtraccionDAO();

    // Variables booleanas para controlar el inicio de sesión
    
    // Variables booleanas para controlar la ventana principal
    BooleanProperty extraccionesCargadas = new SimpleBooleanProperty(false);
    BooleanProperty modoEdicion = new SimpleBooleanProperty(false);
    
    @FXML
    private ToggleGroup traslado;


    // Controles
    @FXML
    private Button btAniadir;
    @FXML
    private Button btEditar;
    @FXML
    private Button btModificar;
    @FXML
    private Button btEliminar;
    @FXML
    private Pane pnDatos;
    @FXML
    private Pane pnPersiana;

    // Inicio de sesión
    @FXML
    private Button btEntrar;
    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField pfPasword;
    
    // Ventana principal
    @FXML
    private TextField tfNumero;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private ComboBox<String> cbLugar;
    @FXML
    private TextField tfDni;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfTelefono;
    @FXML
    private RadioButton rbPositivo;
    @FXML
    private RadioButton rbNegativo;
    @FXML
    private CheckBox cbA;
    @FXML
    private CheckBox cbAB;
    @FXML
    private CheckBox cbB;
    @FXML
    private CheckBox cb0;
    @FXML
    private TextField tfPeso;
    
    
    @FXML
    private TableColumn<Extraccion, Integer> clNumero;
    @FXML
    private TableColumn<Extraccion, String> clDni;
    @FXML
    private TableColumn<Extraccion, String> clNombre;
    @FXML
    private TableColumn<Extraccion, String> clLugar;
    @FXML
    private TableColumn<Extraccion, LocalDate> clFecha;
    @FXML
    private TableColumn<Extraccion, String> clGrupo;
    @FXML
    private TableColumn<Extraccion, String> clRh;
    @FXML
    private TableView<Extraccion> tvExtracciones;

  //</editor-fold>
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            donaciones = FXCollections.observableArrayList(dao.listar());
            cargarTabla();
            extraccionesCargadas.set(true);
        } catch (SQLException ex) {
            ut.mensajeError(ex.getMessage());
        }
        
        // Reglas inicio sesión
        
        // Usuarios no cargados

        // Modo edición
        btModificar.disableProperty().bind(modoEdicion.not());
        btEditar.disableProperty().bind(modoEdicion);
        btAniadir.disableProperty().bind(modoEdicion);
        btEliminar.disableProperty().bind(modoEdicion);
        
    } //fin initialize

    private void cargarTabla(){
        clNumero.setCellValueFactory(new PropertyValueFactory("numero"));
        clDni.setCellValueFactory(new PropertyValueFactory("dni"));
        clNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        clLugar.setCellValueFactory(new PropertyValueFactory("lugar"));
        clFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        clGrupo.setCellValueFactory(new PropertyValueFactory("grupo"));
        clRh.setCellValueFactory(new PropertyValueFactory("rh"));
        tvExtracciones.setItems(donaciones);
    }
    
    @FXML
    private void btAñadirClic(ActionEvent event) {
        if(!extraccionesCargadas.get()){
            ut.mensajeError("No se han podido cargar las extracciones");
            return;
        }

        
    }

    @FXML
    private void btEditarClic(ActionEvent event) {
        if(!extraccionesCargadas.get()){
            ut.mensajeError("No se han podido cargar las extracciones");
            return;
        }
        
        Extraccion seleccionada = tvExtracciones.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void btModificarClic(ActionEvent event) {
        if(!extraccionesCargadas.get()){
            ut.mensajeError("No se han podido cargar las extracciones");
            return;
        }

        Extraccion seleccionada = tvExtracciones.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void btEliminarClic(ActionEvent event) {
        if(!extraccionesCargadas.get()){
            ut.mensajeError("No se han podido cargar las extracciones");
            return;
        }
        
        Extraccion seleccionada = tvExtracciones.getSelectionModel().getSelectedItem();
        
        
        
        try {
            dao.delete(seleccionada);
        } catch (SQLException ex) {
            ut.mensajeError(ex.getMessage());
        }
    }

    private void actualizarTabla() {



    }

    /**
     * Este metodo hace algo?? al pulsar la tecla escape
     * @param event 
     */
    @FXML
    private void esc(KeyEvent event) {

      if (event.getCode() == KeyCode.ESCAPE) {
        //codificar que debe pasar cuando se pulsa  la tecla esc

      }
    }  

    private void limpiarCampos() {


    }

    @FXML
    private void btEntrarClic(ActionEvent event) {


    }

  
} // fin de la clase

