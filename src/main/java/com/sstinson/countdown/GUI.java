package com.sstinson.countdown;
import java.awt.event.*;
import java.awt.*;

public class GUI extends Frame implements ActionListener, WindowListener {

    private Label lblCount;
    private Label lblOutput;
    private TextField tfCount;
    private TextField tfOutput;
    private Button btnCount;
    private int count = 0;

    public GUI(){
        setLayout(new FlowLayout());

        lblCount = new Label("Counter");
        add(lblCount);

        tfCount = new TextField(count + "", 10);
        tfCount.setEditable(true);
        add(tfCount);

        tfCount.addActionListener(this);

        lblOutput = new Label("The Accumulated Sum is: ");  // allocate Label
        add(lblOutput);               // "super" Frame adds Label

        tfOutput = new TextField(10); // allocate TextField
        tfOutput.setEditable(false);  // read-only
        add(tfOutput);
//        btnCount = new Button("Count");
//        add(btnCount);
//
//        btnCount.addActionListener(this);

        setTitle("Countdown Game");
        setSize(360, 640);

        setVisible(true);

        addWindowListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numberIn = Integer.parseInt(tfCount.getText());
        count += numberIn;
        tfCount.setText("");
        tfOutput.setText(count + "");
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
