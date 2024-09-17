
package AlgoVis.Panels;

import AlgoVis.Cipher.Caeser;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class CipherPanel extends javax.swing.JPanel {

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        caeser = new Caeser(msg);
    }

    public int getCipher() {
        return cipher;
    }

    public void setCipher(int cipher) {
        this.cipher = cipher;
    }

    private int cipher;
    private String msg="";
    private boolean isRunning;
    
    private Caeser caeser;
    
    public CipherPanel() {
        initComponents();
    }

    public void animate()throws Exception {
        if(cipher==0){
            Timer ceaserTimer = new Timer(0, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!isRunning){
                        ((Timer)e.getSource()).stop();
                    }
                    else {
                        caeser.code();
                    }
                }
                
            });
            ceaserTimer.start();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int length=msg.length();
        int size=getWidth()/length;
        for(int i=0;i<length;i++){
            g2.setColor(new Color(0, 197, 141));
            if(i==caeser.getIndex())
                g2.setColor(new Color(197, 141, 0));
            g2.drawRect(i*size,(getHeight()-size)/2,size,size);
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
