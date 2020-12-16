package main;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class GUI{
    private int count;
    private JPanel setResolutionPanel;
    private JPanel makeObjectPanel;
    private JPanel viewChoosePanel;
    private JPanel fileNameChoosePanel;
    private JFrame frame;
    private JLabel fileNamelabel;
    private JTextField fileNameField;
    private JButton submitButton;
    private JLabel viewLabel;
    private JComboBox<String> viewBox;
    private JTable objects;
    private JLabel heightLabel;
    private JLabel widthLabel;
    private JTextField heightField;
    private JTextField widthField;
    private JButton addObjButton;
    private JScrollPane scrollPane;
    private Renderer renderer;

    public GUI() {
        //inititalize element list
        scrollPane = new JScrollPane();
        setResolutionPanel = new JPanel();
        makeObjectPanel = new JPanel();
        viewChoosePanel = new JPanel();
        fileNameChoosePanel = new JPanel();
        frame = new JFrame();
        fileNamelabel = new JLabel("FileName:");
        fileNameField = new JTextField("render");
        viewLabel = new JLabel("Select View:");
        viewBox = new JComboBox<String>();
        // objects = new JTable();
        submitButton = new JButton("Render");
        heightLabel = new JLabel("Height:");
        widthLabel = new JLabel("Width:");
        heightField = new JTextField("920");
        widthField = new JTextField("1280");


        //set up elements
        //viewChoosePanel
        viewBox.addItem("Perspective");
        viewBox.addItem("Orthagonal");
        viewChoosePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        viewChoosePanel.add(viewLabel);
        viewChoosePanel.add(viewBox);

        //
        setResolutionPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        setResolutionPanel.setLayout(new GridLayout(1,4));
        setResolutionPanel.add(heightLabel);
        setResolutionPanel.add(heightField);
        setResolutionPanel.add(widthLabel);
        setResolutionPanel.add(widthField);
        

        //submit Button
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                renderer = new Renderer();
                renderer.render();
            }
            
        });

        //scrollPane
        scrollPane.add(setResolutionPanel);
        scrollPane.add(viewChoosePanel);


        // panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        // panel.setLayout(new GridLayout(0,1));
        // panel.add(submitButton);

        //add to frame 
        frame.add(viewChoosePanel);
        frame.add(submitButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("RayTracer");
        frame.pack();
        frame.setVisible(true);
    }


}