import java.awt.event.*;
import javax.swing.*;

public class Calculations implements ActionListener {
    Display display;
    ToggleEvent toggleEvent;
    String data1 = "", data2 = "";

    Calculations(ToggleEvent obj) {
        System.out.println("toggle created.");
        toggleEvent = obj;
    }

    Calculations(Display obj) {
        display = obj;
    }

    public void actionPerformed(ActionEvent e) {
        int test = Integer.parseInt(((JButton) e.getSource()).getText());
        if(toggleEvent.flag) {
            if(test <= 9 && test >=0) {
                data1 += test;
            }
            display.t1.setText(data1);
        }
        else {
            if(test <= 9 && test >=0) {
                data2 += test;
            }
            display.t2.setText(data2);
        }
    }
}