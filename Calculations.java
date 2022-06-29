import java.awt.event.*;
import javax.swing.*;


public class Calculations implements ActionListener {
    Display display;
    String data1 = "", data2 = "";

    Calculations(Display obj) {
        display = obj;
    }

    public void actionPerformed(ActionEvent e) {
        String test = ((JButton) e.getSource()).getText().strip();
        if(display.flag) {
            if(test == "1" || test == "2" || test == "3" || test == "4" || test == "5" || test == "6" || test == "7" || test == "8" || test == "9" || test == "0") {
                data1 += test;
            }
            else {
                Calculate(test);
            }
            display.t2.setText(data1);
        }
        else {
            if(test == "1" || test == "2" || test == "3" || test == "4" || test == "5" || test == "6" || test == "7" || test == "8" || test == "9" || test == "0") {
                data2 += test;
            }
            else {
                Calculate(test);
            }
            display.t1.setText(data2);
        }
    }

    void Calculate(String op) {
        int y = Integer.parseInt(data1);
        int x = Integer.parseInt(data2);
        switch(op) {
            case "Add":
            display.t3.setText("" + (x + y));
            break;

            case "Sub":
            display.t3.setText("" + (x - y));
            break;

            case "Mul":
            display.t3.setText("" + (x * y));
            break;

            case "Div":
            display.t3.setText("" + (x / y));
            break;

            case "Pow":
            display.t3.setText("" + (Math.pow(x, y)));
            break;

            case "Mod":
            display.t3.setText("" + (x % y));
            break;

            case "Clear":
            data1 = "";
            data2 = "";
            y = 0;
            x = 0;
            display.t1.setText(data2);
            display.t2.setText(data1);
            display.t3.setText("");
            break;
        }
    }
}