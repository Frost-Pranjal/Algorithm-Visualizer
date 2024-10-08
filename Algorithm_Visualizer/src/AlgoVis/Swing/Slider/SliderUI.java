
package AlgoVis.Swing.Slider;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class SliderUI extends BasicSliderUI{
    public SliderUI(JSlider slider){
        super(slider);
    }

    @Override
    public void paintFocus(Graphics g) {

    }

    @Override
    protected Dimension getThumbSize() {
        return new Dimension(14, 14);
    }

    @Override
    public void paintThumb(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(slider.getForeground());
        g2.fillOval(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
    }

    @Override
    public void paintTrack(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(slider.getBackground());
        if(slider.getOrientation()==JSlider.VERTICAL){
            g2.fillRoundRect(slider.getWidth()/2-2, 2, 4, slider.getHeight(), 1, 1);
        }
        else {
            g2.fillRoundRect(2, slider.getHeight()/2-2, slider.getWidth()-5, 4, 1, 1);
        }
    }
    
    
}
