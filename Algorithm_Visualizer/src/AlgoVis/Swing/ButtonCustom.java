
package AlgoVis.Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ButtonCustom extends JButton{

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorBorder() {
        return colorBorder;
    }

    public void setColorBorder(Color colorBorder) {
        this.colorBorder = colorBorder;
    }
    
    public ButtonCustom(){
        setColor(new Color(255, 255, 255));
        setFocusable(false);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorBorder);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(getBackground()!=colorBorder){
                    setBackground(colorOver);
                    over=true;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(getBackground()!=colorBorder){
                    over=false;
                    setBackground(color);
                }
            }
        });
        repaint();
        revalidate();
    }
    
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorBorder;
    private int radius = 0;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(colorBorder);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        g2.fillRoundRect(2, 2, getWidth()-4, getHeight()-4, radius, radius);
        super.paintComponent(g);
    }
    
}
