package com.sstinson.countdown;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame{

    private JLabel lblCount;
    private JLabel lblOutput;
    private JTextField tfOutput;
    private JButton enterButton;
    private ArrayList<JTextField> tfInputs = new ArrayList<>();
    private int count = 0;
    private int numberOfInputs = 6;
    public boolean hasInputs = false;
    private boolean running = false;
    public ArrayList<Double> inputs = new ArrayList<>();
    public CountdownCalculator m = new CountdownCalculator();

    public GUI(){
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        lblCount = new JLabel("Enter an Integer");
        cp.add(lblCount);

        for(int i = 0; i < numberOfInputs; i++){
            tfInputs.add(new JTextField(10));
            tfInputs.get(i).setEditable(true);
            cp.add(tfInputs.get(i));

        }

//        tfInput.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int numberIn = Integer.parseInt(tfInput.getText());
//                count += numberIn;
//                tfInput.setText("");
//                tfOutput.setText(count + "");
//            }
//        });

        enterButton = new JButton("Enter");
        cp.add(enterButton);
        enterButton.addActionListener( new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
//                double sum = 0;
//                boolean goodInput = false;
//
//                    for (JTextField textField : tfInputs) {
//                        try {
//                            sum += Double.parseDouble(textField.getText());
//                            tfOutput.setText(sum + "");
//                            goodInput = true;
//
//                        } catch (NumberFormatException ex) {
//                            goodInput = false;
//                            break;
//                        }
//
//                    }
//                if (goodInput) {
//                    for (JTextField textField : tfInputs) {
//                        inputs.add(Double.parseDouble(textField.getText()));
//                    }
//                    System.out.println(inputs);
//                    tfOutput.setText(sum + "");
//                } else {
//                    tfOutput.setText("Enter proper numbers");
//                }
                if (!running) {

                    Thread worker = new Thread() {
                        public void run() {
                            running = true;
                            for (int i = 0; i <= 30; i++) {

                                try {
                                    tfOutput.setText( i+ "");
                                    System.out.println(i);
                                    Thread.sleep(1000);


                                } catch (InterruptedException e) {
                                    System.out.println("interrupted");
                                }
                            }
                            running = false;
                        }
                    };

                    Thread worker2 = new Thread() {
                        public void run() {
                            m.calculateEveryForPermutation();
                            m.printOutput();
                        }
                    };

                    worker.start();
                    worker2.start();



                }
            }
        });

        lblOutput = new JLabel("The Accumulated Sum is: ");  // allocate Label
        cp.add(lblOutput);               // "super" Frame adds Label

        tfOutput = new JTextField(10); // allocate TextField
        tfOutput.setEditable(false);  // read-only
        cp.add(tfOutput);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Countdown Game");
        setSize(360, 640);

        setVisible(true);


    }



    public static void main(String[] args) {
        // Run the GUI construction in the Event-Dispatching thread for thread-safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI(); // Let the constructor do the job
            }
        });
    }


}
