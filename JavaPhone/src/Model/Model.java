package Model;

import javafx.scene.paint.Color;

public class Model {
private int calculationValue;
private String backgroundColor = "cyan";

public  void addTwoNumbers(int firstNumber, int secondNumber){

    calculationValue = firstNumber + secondNumber;
}

public int getCalculationValue() {
    return calculationValue;
}

public String getBackgroundColor() {
	return backgroundColor;
}

public void setBackgroundColor(String backgroundColor) {
	this.backgroundColor = backgroundColor;
}

}