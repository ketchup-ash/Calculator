import java.awt.event.*;

public class ToggleEvent implements ItemListener {
    Display display;
    boolean flag = false;
    Calculations calc = new Calculations(this);

    ToggleEvent(Display obj) {
        display = obj;
    }

    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == e.SELECTED) {
            System.out.println("On");
            flag = true;
        }
        else {
            System.out.println("Off");
            flag = false;
        }
    }
}