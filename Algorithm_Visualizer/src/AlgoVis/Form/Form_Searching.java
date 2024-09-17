
package AlgoVis.Form;

import AlgoVis.Swing.Notification.Notification;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Form_Searching extends javax.swing.JPanel {

    private final String searches[]={"Linear","Binary"};
    
    public Form_Searching(int index) {
        initComponents();
        init(index);
        searchingPanel.setSearch(index);
        searchingPanel.setLength(slider.getValue());
        searchingPanel.setFound(false);
        searchingPanel.repaint();
    }
    
    private void init(int index) {
        subtitle.setText(searches[index]+" Search");
        slider.addChangeListener(new ChangeListener() {
        @Override
            public void stateChanged(ChangeEvent e) {
                sliderValue.setText("No. of Elements = "+slider.getValue());
                searchingPanel.setLength(slider.getValue());
                searchingPanel.repaint();
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String search=searchVal.getText();
                    if(!isValid(search)){
                        Notification noti=new Notification(AlgoVis.AlgoVis.getFrame(), Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Invalid Search Value");
                        noti.showNotification();
                        return ;
                    }
                    searchingPanel.setSearchItem(Double.parseDouble(search));
                    searchVal.setEditable(false);
                    slider.setEnabled(false);
                    reset.setEnabled(false);
                    if(!searchingPanel.isIsRunning())
                        searchingPanel.setIsRunning(true);
                    searchingPanel.animate();
                    start.setEnabled(false);
                } catch (Exception ex) {}
            }

            private boolean isValid(String search) {
                if(search.equals(""))
                    return false;
                try{
                    double n=Double.parseDouble(search);
                }
                catch(Exception e){return false;}
                return true;
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset.setEnabled(true);
                start.setEnabled(true);
                searchingPanel.setIsRunning(false);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchVal.setEditable(true);
                searchingPanel.setLength(slider.getValue());
                slider.setEnabled(true);
                searchingPanel.setIsDone(false);
                searchingPanel.setFound(false);
                searchingPanel.repaint();
                
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        subtitle = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        slider = new AlgoVis.Swing.Slider.SliderCustom();
        sliderValue = new javax.swing.JLabel();
        start = new AlgoVis.Swing.ButtonCustom();
        stop = new AlgoVis.Swing.ButtonCustom();
        reset = new AlgoVis.Swing.ButtonCustom();
        searchingPanel = new AlgoVis.Panels.SearchingPanel();
        searchVal = new AlgoVis.Swing.TextFieldCustom();

        setOpaque(false);

        title.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        title.setText("Searching");

        subtitle.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        subtitle.setPreferredSize(new java.awt.Dimension(121, 16));

        line.setBackground(new java.awt.Color(13, 13, 13));
        line.setOpaque(true);
        line.setPreferredSize(new java.awt.Dimension(1000, 2));

        slider.setMaximum(75);
        slider.setMinimum(10);
        slider.setValue(10);

        sliderValue.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        sliderValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sliderValue.setText("No. of Elements = 10");

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

        javax.swing.GroupLayout searchingPanelLayout = new javax.swing.GroupLayout(searchingPanel);
        searchingPanel.setLayout(searchingPanelLayout);
        searchingPanelLayout.setHorizontalGroup(
            searchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        searchingPanelLayout.setVerticalGroup(
            searchingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );

        searchVal.setBackground(new java.awt.Color(245, 245, 245));
        searchVal.setLabelText("Search Value");
        searchVal.setLineColor(new java.awt.Color(0, 197, 141));
        searchVal.setSelectionColor(new java.awt.Color(0, 197, 141));

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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sliderValue, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92)
                                .addComponent(searchVal, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderValue))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(searchingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel line;
    private AlgoVis.Swing.ButtonCustom reset;
    private AlgoVis.Swing.TextFieldCustom searchVal;
    private AlgoVis.Panels.SearchingPanel searchingPanel;
    private AlgoVis.Swing.Slider.SliderCustom slider;
    private javax.swing.JLabel sliderValue;
    private AlgoVis.Swing.ButtonCustom start;
    private AlgoVis.Swing.ButtonCustom stop;
    private javax.swing.JLabel subtitle;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
