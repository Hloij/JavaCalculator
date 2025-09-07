package com.example.javacalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;




public class HelloController {
    @FXML
    private TextField Zadacha;
    @FXML
    private TextField Otvet;

    private String _chslo = "";

    private double _otvet = 0;
    private boolean Was = false;
    private boolean Was2 = false;


    private String _simvol = "";


    @FXML
    protected void ClickOnAction(/* тут мы прописываем объект, который вызывает событие как в шарпе sender*/javafx.event.ActionEvent actionEvent) {
        Button target = (Button) actionEvent.getTarget();
        if (!Was) {
            switch (target.getText()) {
                case "+":
                    Was2 = false;
                    Zadacha.setText(Zadacha.getText() + " + ");
                    _simvol = "+";
                    _chslo = "";
                    break;
                case "-":
                    Was2 = false;
                    Zadacha.setText(Zadacha.getText() + " - ");
                    _simvol = "-";
                    _chslo = "";
                    break;
                case "*":
                    Was2 = false;
                    Zadacha.setText(Zadacha.getText() + " * ");
                    _simvol = "*";
                    _chslo = "";
                    break;
                case "/":
                    Was2 = false;
                    Zadacha.setText(Zadacha.getText() + " / ");
                    _simvol = "/";
                    _chslo = "";
                    break;
                case ",":
                    if (!Was2) {
                        Zadacha.setText(Zadacha.getText() + ",");
                        String sim = _simvol;
                        _simvol = "-";
                        _otvet = Double.parseDouble(Razchet(String.valueOf(_otvet), _chslo));
                        _simvol = sim;
                        Was2 = true;
                        _chslo += ".";
                    }
                    break;
                case "=":
                    if (Was2)
                        _otvet = (Double.parseDouble(Razchet(String.valueOf(_otvet), _chslo)));
                    Otvet.setText(String.valueOf(_otvet));
                    Was = true;
                    break;
                case "^":
                    Was2 = false;
                    Zadacha.setText(Zadacha.getText() + " ^ ");
                    _simvol = "^";
                    _chslo = "";
                    break;

                case "C":
                    Zadacha.setText("");
                    Was = false;
                    Was2 = false;
                    _chslo = "";
                    _otvet = 0;
                    _simvol = "";
                    break;

            }
        }

    }

    @FXML
    protected void ClickOnNumber(javafx.event.ActionEvent ationEvent) {
        Button target = (Button) ationEvent.getTarget();
        String str = Zadacha.getText();
        if (Was) {
            Zadacha.setText("");
            Was = false;
            Was2 = false;
            _chslo = "";
            _otvet = 0;
            _simvol = "";
        }
        try {
            if (str.charAt(str.length() - 1) != '=') {
                Zadacha.setText(Zadacha.getText() + target.getText());
            } else {
                Zadacha.setText(Zadacha.getText() + " " + target.getText());
            }
        } catch (Exception exception) {
            Zadacha.setText(Zadacha.getText() + target.getText());
        } finally {
            _chslo += target.getText();
            if (!Was2) {
                _otvet = Double.parseDouble(Razchet(String.valueOf(_otvet), _chslo));
            }

        }
    }

    private String Razchet(String chislo1, String chislo2) {//функция расчета
        String rezultat;
        switch (_simvol) {
            case "+":
                rezultat = String.valueOf(Double.parseDouble(chislo1) + Double.parseDouble(chislo2));
                break;
            case "-":
                rezultat = String.valueOf(Double.parseDouble(chislo1) - Double.parseDouble(chislo2));
                break;
            case "*":
                rezultat = String.valueOf(Double.parseDouble(chislo1) * Double.parseDouble(chislo2));
                break;
            case "/":
                rezultat = String.valueOf(Double.parseDouble(chislo1) / Double.parseDouble(chislo2));
                break;
            case "^":
                rezultat = String.valueOf(Math.pow(Double.parseDouble(chislo1) ,Double.parseDouble(chislo2) ));
                break;
            default:
                return chislo2;
        }
        return rezultat;

    }
}


