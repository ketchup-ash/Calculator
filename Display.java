import javax.swing.*;
import java.awt.*;

public class Display {
    JFrame frame;
    JPanel top, center, bottom;
    JButton[] bNum = new JButton[10];
    JToggleButton btb;
    JButton[] bOpr = new JButton[6];
    JTextArea t1, t2, t3;
    int width, height;
    String[] oprNames = new String[] {
        "Add", "Sub", "Mul", "Div", "Pow", ""
    };
    Font font;

    Calculations calc = new Calculations(this);
    ToggleEvent togg = new ToggleEvent(this);

    Display() {

    }

    Display(int width, int height) {
        font = new Font("SansSerif", Font.BOLD, 14);
        this.width = width;
        this.height = height;

        BorderLayout bl = new BorderLayout(5, 5);
        // GridLayout gl = new GridLayout();
        // FlowLayout fl = new FlowLayout();

        frame = new JFrame("Calculator!");
        frame.setLayout(bl);



        //Top most contents in this panel like the field for values.
        top = new JPanel();
        top.setLayout(new GridLayout(3, 2, 5, 5));
        int col = width / 32;

        JLabel l1 = new JLabel("First:");
        t1 = new JTextArea(1, col);
        t1.setEnabled(false);
        JScrollPane scrollPane1 = new JScrollPane(t1);
        JLabel l2 = new JLabel("Second:");
        t2 = new JTextArea(1, col);
        t2.setEnabled(false);
        JScrollPane scrollPane2 = new JScrollPane(t2);
        JLabel l3 = new JLabel("Answer:");
        t3 = new JTextArea(1, col);
        t3.setEnabled(false);
        JScrollPane scrollPane3 = new JScrollPane(t3);

        t1.setFont(font);
        t1.setDisabledTextColor(Color.BLACK);
        t2.setFont(font);
        t2.setDisabledTextColor(Color.BLACK);
        t3.setFont(font);
        t3.setDisabledTextColor(Color.BLACK);

        top.add(l1);
        top.add(scrollPane1);
        top.add(l2);
        top.add(scrollPane2);
        top.add(l3);
        top.add(scrollPane3);



        //All the buttons for 1 to 9 are added to this panel and this is placed in the center of the frame.
        center = new JPanel();
        center.setLayout(new GridLayout(4, 3, 2, 2));
        center.setFont(font);
        for(int i = 0; i < 12; i++) {
            if(i == 9) {
                JButton bnu = new JButton("");
                bnu.setEnabled(false);
                center.add(bnu);
            }
            else if(i == 10) {
                bNum[9] = new JButton("0");
                bNum[9].addActionListener(calc);
                center.add(bNum[9]);
            }
            else if(i == 11) {
                btb = new JToggleButton("Change");
                btb.addItemListener(togg);
                center.add(btb);
            }
            else {
                bNum[i] = new JButton("" + (i + 1));
                bNum[i].addActionListener(calc);
                center.add(bNum[i]);
            }
        }



        //All the buttons for operations are situated here eg addition substraction multiplication and division.
        bottom = new JPanel();
        bottom.setLayout(new GridLayout(2, 4, 2, 2));

        for(int i = 0; i < 6; i++) {
            bOpr[i] = new JButton("" + oprNames[i]);
            bottom.add(bOpr[i]);
        }
        

        //Adding all the panels to the main frame.
        frame.add(top, bl.NORTH);
        frame.add(center, bl.CENTER);
        frame.add(bottom, bl.SOUTH);


        //Setting the size of the frame and setting the visiblity of the frame.
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}