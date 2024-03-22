package org.example;

import javax.swing.*;
import java.awt.*;



public class PaintApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paint Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PaintPanel paintPanel = new PaintPanel();

            JPanel controlPanel = new JPanel();
            JButton lineButton = new JButton("Line");
            lineButton.addActionListener(e -> paintPanel.setCurrentShapeType(PaintPanel.ShapeType.LINE));
            JButton rectangleButton = new JButton("Rectangle");
            rectangleButton.addActionListener(e -> paintPanel.setCurrentShapeType(PaintPanel.ShapeType.RECTANGLE));
            JButton circleButton = new JButton("Circle");
            circleButton.addActionListener(e -> paintPanel.setCurrentShapeType(PaintPanel.ShapeType.CIRCLE));

            controlPanel.add(lineButton);
            controlPanel.add(rectangleButton);
            controlPanel.add(circleButton);

            frame.getContentPane().add(controlPanel, BorderLayout.NORTH);
            frame.getContentPane().add(paintPanel, BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);
        });
    }
}
