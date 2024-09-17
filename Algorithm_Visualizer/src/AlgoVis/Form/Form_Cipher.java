
package AlgoVis.Form;

import AlgoVis.Swing.Notification.Notification;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form_Cipher extends javax.swing.JPanel {

    private String[] cipher={"Caeser", "AtBash", "A1Z26", "Pig-Latin"};
    public Form_Cipher(int index) {
        initComponents();
        init(index);
        //cipherPanel.setCipher(index);
    }

    private void init(int index) {
        subtitle.setText(cipher[index]+" Cipher");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = msgVal.getText().toUpperCase();
                if(msg.length()>50){
                    Notification noti=new Notification(AlgoVis.AlgoVis.getFrame(), Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Input Length Exceeded. Limiting to 50 characters.");
                    noti.showNotification();
                    msg=msg.substring(0,50);
                }
                //cipherPanel.setMsg(msg);
                //if(!cipherPanel.isIsRunning())
                    //cipherPanel.setIsRunning(true);
                //cipherPanel1.animate();
                reset.setEnabled(false);
                start.setEnabled(false);
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset.setEnabled(true);
                start.setEnabled(true);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        subtitle = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        start = new AlgoVis.Swing.ButtonCustom();
        stop = new AlgoVis.Swing.ButtonCustom();
        reset = new AlgoVis.Swing.ButtonCustom();
        msgVal = new AlgoVis.Swing.TextFieldCustom();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1040, 670));

        title.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        title.setText("Cipher");

        subtitle.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        subtitle.setPreferredSize(new java.awt.Dimension(121, 16));

        line.setBackground(new java.awt.Color(13, 13, 13));
        line.setOpaque(true);
        line.setPreferredSize(new java.awt.Dimension(1000, 2));

        start.setBorder(null);
        start.setText("Start");
        start.setColorBorder(new java.awt.Color(0, 197, 141));
        start.setColorOver(new java.awt.Color(102, 220, 187));
        start.setPreferredSize(new java.awt.Dimension(60, 25));
        start.setRadius(25);

        stop.setBorder(null);
        stop.setText("Stop");
        stop.setColorBorder(new java.awt.Color(197, 0, 56));
        stop.setColorOver(new java.awt.Color(220, 102, 136));
        stop.setPreferredSize(new java.awt.Dimension(60, 25));
        stop.setRadius(25);

        reset.setBorder(null);
        reset.setText("Reset");
        reset.setColorBorder(new java.awt.Color(0, 197, 141));
        reset.setColorOver(new java.awt.Color(102, 220, 187));
        reset.setPreferredSize(new java.awt.Dimension(60, 25));
        reset.setRadius(25);

        msgVal.setBackground(new java.awt.Color(245, 245, 245));
        msgVal.setLabelText("Message to Encode");
        msgVal.setLineColor(new java.awt.Color(0, 197, 141));
        msgVal.setSelectionColor(new java.awt.Color(0, 197, 141));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title)
                            .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(msgVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(msgVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(551, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel line;
    private AlgoVis.Swing.TextFieldCustom msgVal;
    private AlgoVis.Swing.ButtonCustom reset;
    private AlgoVis.Swing.ButtonCustom start;
    private AlgoVis.Swing.ButtonCustom stop;
    private javax.swing.JLabel subtitle;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    
}