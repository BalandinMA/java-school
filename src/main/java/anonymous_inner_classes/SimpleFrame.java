package anonymous_inner_classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Evgeny Borisov
 */
public class SimpleFrame extends JFrame {

    public SimpleFrame(String title, int counter) throws HeadlessException {
        int arr[] = new int[1];
        arr[0]=counter;
        JButton button = new JButton("click to RED");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(title);
                System.out.println(arr[0]++);
                getContentPane().setBackground(Color.RED);
            }
        });
        getContentPane().add(button, BorderLayout.NORTH);
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SimpleFrame("JAVA",1);
    }
}
