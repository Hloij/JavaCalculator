package com.example.javacalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class HelloController {
    @FXML
    private TextField Zadacha;
    @FXML
    private TextField Otvet;
    @FXML
    Button btn;
    private String _chslo = "0";
    private String _chslo2 = "";

    @FXML
    protected void ClickOnAction(javafx.event.ActionEvent actionEvent) {
        Button target = (Button) actionEvent.getTarget();
        boolean Was = false;
        switch (target.getText()) {
            case "+":
                if (Zadacha.getText() == "") {
                    Zadacha.setText("0 + ");
                } else {
                    Zadacha.setText(Zadacha.getText() + " + ");
                }
                Otvet.setText(String.valueOf(Double.parseDouble(_chslo) + Double.parseDouble(_chslo2)));
                Was = true;
                break;
            case "-":
                if (Zadacha.getText() == "") {
                    Zadacha.setText("0 - ");
                } else {
                    Zadacha.setText(Zadacha.getText() + " - ");
                }
                Otvet.setText(String.valueOf(Double.parseDouble(_chslo) - Double.parseDouble(_chslo2)));
                Was = true;
                break;
            case "*":
                if (Zadacha.getText() == "") {
                    Zadacha.setText("0 * ");
                } else {
                    Zadacha.setText(Zadacha.getText() + " * ");
                }
                Otvet.setText(String.valueOf(Double.parseDouble(_chslo) * Double.parseDouble(_chslo2)));
                Was = true;
                break;
            case "/":
                if (Zadacha.getText() == "") {
                    Zadacha.setText("0 / ");
                } else {
                    Zadacha.setText(Zadacha.getText() + " / ");
                }
                Otvet.setText(String.valueOf(Double.parseDouble(_chslo) / Double.parseDouble(_chslo2)));
                Was = true;
                break;
            case ",":
                if (Zadacha.getText() == "") {
                    Zadacha.setText("0,");
                } else {
                    Zadacha.setText(Zadacha.getText() + ",");
                }
                break;
        }
        if (Was) {
            _chslo = Otvet.getText();
            _chslo2 = "";
        }
    }

    @FXML
    protected void ClickOnNumber(javafx.event.ActionEvent ationEvent) {
        Button target = (Button) ationEvent.getTarget();
        String str = Zadacha.getText();
        try {
            if (str.charAt(str.length() - 1) != '=') {
                Zadacha.setText(Zadacha.getText() + target.getText());
            } else {
                Zadacha.setText(Zadacha.getText() + " " + target.getText());
            }
        } catch (Exception exception) {
            Zadacha.setText(Zadacha.getText() + target.getText());
        } finally {
            _chslo2 += target.getText();
        }
    }

}


