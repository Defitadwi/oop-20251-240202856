package com.upb.agripos.controller;

import com.upb.agripos.dao.JdbcProductDAO;
import com.upb.agripos.model.Product;
import com.upb.agripos.model.CartItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PosController {
    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, String> colId, colName, colCategory;
    @FXML private TableColumn<Product, Double> colPrice;
    @FXML private TableColumn<Product, Integer> colStock;

    @FXML private TableView<CartItem> cartTable;
    @FXML private TableColumn<CartItem, String> colCartItem;
    @FXML private TableColumn<CartItem, Integer> colCartQty;
    @FXML private TableColumn<CartItem, Double> colCartSubtotal;

    @FXML private TextField txtId, txtName, txtCategory, txtPrice, txtStock, txtQty;
    @FXML private Label lblTotal;

    private JdbcProductDAO dao = new JdbcProductDAO();
    private ObservableList<CartItem> cartData = FXCollections.observableArrayList();
    private double grandTotal = 0;

    @FXML
    public void initialize() {
        // Mapping Tabel Produk
        colId.setCellValueFactory(d -> d.getValue().idProperty());
        colName.setCellValueFactory(d -> d.getValue().nameProperty());
        colCategory.setCellValueFactory(d -> d.getValue().categoryProperty());
        colPrice.setCellValueFactory(d -> d.getValue().priceProperty().asObject());
        colStock.setCellValueFactory(d -> d.getValue().stockProperty().asObject());

        // Mapping Tabel Keranjang
        colCartItem.setCellValueFactory(d -> d.getValue().itemProperty());
        colCartQty.setCellValueFactory(d -> d.getValue().qtyProperty().asObject());
        colCartSubtotal.setCellValueFactory(d -> d.getValue().subtotalProperty().asObject());

        // Klik tabel untuk isi form
        productTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtId.setText(newVal.getId());
                txtName.setText(newVal.getName());
                txtCategory.setText(newVal.getCategory());
                txtPrice.setText(String.valueOf(newVal.getPrice()));
                txtStock.setText(String.valueOf(newVal.getStock()));
            }
        });
        loadData();
    }

    private void loadData() {
        productTable.setItems(FXCollections.observableArrayList(dao.getAll()));
    }

    @FXML private void handleSimpan() {
        dao.insert(new Product(txtId.getText(), txtName.getText(), txtCategory.getText(), 
                   Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtStock.getText())));
        loadData();
        handleReset();
    }

    @FXML private void handleUpdate() {
        dao.update(new Product(txtId.getText(), txtName.getText(), txtCategory.getText(), 
                   Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtStock.getText())));
        loadData();
    }

    @FXML private void handleHapus() {
        dao.delete(txtId.getText());
        loadData();
        handleReset();
    }

    @FXML private void handleReset() {
        txtId.clear(); txtName.clear(); txtCategory.clear(); txtPrice.clear(); txtStock.clear();
        txtQty.setText("1");
    }

    @FXML private void handleMasukKeranjang() {
        Product s = productTable.getSelectionModel().getSelectedItem();
        if (s != null) {
            int q = Integer.parseInt(txtQty.getText());
            double sub = s.getPrice() * q;
            cartData.add(new CartItem(s.getName(), q, sub));
            cartTable.setItems(cartData);
            grandTotal += sub;
            lblTotal.setText("Total: Rp " + String.format("%,.0f", grandTotal));
        }
    }

    @FXML private void handleKosongkanKeranjang() {
        cartData.clear();
        grandTotal = 0;
        lblTotal.setText("Total: Rp 0");
    }

    @FXML private void handleBayar() {
        if (cartData.isEmpty()) {
            showAlert("Peringatan", "Keranjang masih kosong!");
            return;
        }
        
        // Logika bayar sederhana: Tampilkan struk/konfirmasi
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Transaksi Berhasil");
        alert.setHeaderText("Pembayaran Sukses!");
        alert.setContentText("Total Bayar: Rp " + String.format("%,.0f", grandTotal) + "\nTerima kasih telah berbelanja!");
        alert.showAndWait();
        
        handleKosongkanKeranjang();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}