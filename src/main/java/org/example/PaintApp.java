package org.example;


import javax.swing.*;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paint Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PaintPanel paintPanel = new PaintPanel();

            JPanel controlPanel = new JPanel();
            JButton redButton = new JButton("Red");
            redButton.addActionListener(e -> paintPanel.setLineColor(Color.RED));
            JButton blueButton = new JButton("Blue");
            blueButton.addActionListener(e -> paintPanel.setLineColor(Color.BLUE));
            JButton blackButton = new JButton("Black");
            blackButton.addActionListener(e -> paintPanel.setLineColor(Color.BLACK));
            JButton clearButton = new JButton("Clear");
            clearButton.addActionListener(e -> paintPanel.clearCanvas());

            controlPanel.add(redButton);
            controlPanel.add(blueButton);
            controlPanel.add(blackButton);
            controlPanel.add(clearButton);

            frame.getContentPane().add(controlPanel, BorderLayout.NORTH);
            frame.getContentPane().add(paintPanel, BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);
        });
    }
}
