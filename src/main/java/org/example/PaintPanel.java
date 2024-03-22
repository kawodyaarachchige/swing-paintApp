package org.example;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintPanel extends JPanel {
    private Color currentColor = Color.BLACK;
    private int startX, startY, endX, endY;

    public PaintPanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.WHITE);

        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                repaint();
            }
        };

        addMouseListener(adapter);
        addMouseMotionListener(adapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        g.drawLine(startX, startY, endX, endY);
    }

    public void setLineColor(Color color) {
        currentColor = color;
    }

    public void clearCanvas() {
        startX = startY = endX = endY = 0;
        repaint();
    }
}
