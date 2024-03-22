package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaintPanel extends JPanel {
    private Color currentColor = Color.BLACK;
    private int startX, startY, endX, endY;
    private ShapeType currentShapeType = ShapeType.LINE;

    public PaintPanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.WHITE);

        MouseAdapter adapter = new PaintMouseListener();
        addMouseListener(adapter);
        addMouseMotionListener(adapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(currentColor);
        switch (currentShapeType) {
            case LINE:
                g2d.drawLine(startX, startY, endX, endY);
                break;
            case RECTANGLE:
                g2d.drawRect(Math.min(startX, endX), Math.min(startY, endY),
                        Math.abs(endX - startX), Math.abs(endY - startY));
                break;
            case CIRCLE:
                g2d.drawOval(Math.min(startX, endX), Math.min(startY, endY),
                        Math.abs(endX - startX), Math.abs(endY - startY));
                break;
        }
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void setCurrentShapeType(ShapeType shapeType) {
        this.currentShapeType = shapeType;
    }

    public enum ShapeType {
        LINE,
        RECTANGLE,
        CIRCLE
    }

    private class PaintMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
            endX = startX;
            endY = startY;
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            repaint();
        }
    }
}
