package com.example.privatmr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrivatMRController {

    @FXML
    private Button btCalculate;

    @FXML
    private TextField tfMonths;

    @FXML
    private TextField tfSum;

    @FXML
    private Text txtMonPay;

    @FXML
    private Text txtNumOfPays;

    @FXML
    private Text txtTotal;

    @FXML
    private Text txtTotalOverpay;

    @FXML
    void btClicked(ActionEvent event) {
        String _sum = tfSum.getText();
        double numSum = 0;
        try {
            numSum = Double.parseDouble(_sum);
            if (numSum <= 0) {
                numSum = 1;
                tfSum.setPromptText("0.00");
            }
        } catch (NumberFormatException ex) {
            tfSum.setPromptText("помилка");
        }

        String _months = tfMonths.getText();
        double numMonths = 0;
        try {
            numMonths = Double.parseDouble(_months);
            if (numMonths <= 0) {
                numMonths = 1;
                tfMonths.setPromptText("1");
            }
        } catch (NumberFormatException ex) {
            tfMonths.setPromptText("помилка");
        }

        int formattedNumOfPays = ((int) ++numMonths);
        double formattedOverpay = (numSum / 100 * 1.9) + ((numSum / 100 * 4) * formattedNumOfPays);
        double formattedTotal = numSum + formattedOverpay;
        double formattedMonPay = formattedTotal / numMonths;

        txtNumOfPays.setText(String.valueOf(formattedNumOfPays));
        txtTotalOverpay.setText(String.format("%.2f", formattedOverpay) + " грн");
        txtMonPay.setText(String.format("%.2f", formattedMonPay) + " грн");
        txtTotal.setText(String.format("%.2f", formattedTotal) + " грн");

    }
}
