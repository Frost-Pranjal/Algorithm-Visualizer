
package AlgoVis.Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import swing.EventSwitchSelected;

public class Form_Sorting extends javax.swing.JPanel {

    private final String sorts[]={"Bubble","Selection","Insertion","Merge","Quick"};
    
    public Form_Sorting(int index) {
        initComponents();
        init(index);
        sortingPanel.setSort(index);
        sortingPanel.setLength(slider.getValue());
        sortingPanel.repaint();
    }

    private void init(int index) {
        //order.setEnabled(true);
        subtitle.setText(sorts[index]+" Sort");
        slider.addChangeListener(new ChangeListener() {
        @Override
            public void stateChanged(ChangeEvent e) {
                sliderValue.setText("No. of Elements = "+slider.getValue());
                sortingPanel.setLength(slider.getValue());
                sortingPanel.repaint();
            }
        });
        order.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                if(selected){
                    orderValue.setText("Descending");
                    sortingPanel.setOrder(false);
                }
                else{
                    orderValue.setText("Ascending");
                    sortingPanel.setOrder(true);
                }
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    slider.setEnabled(false);
                    order.setEnabled(false);
                    reset.setEnabled(false);
                    if(!sortingPanel.isIsRunning())
                        sortingPanel.setIsRunning(true);
                    sortingPanel.animate();
                    start.setEnabled(false);
                } catch (Exception ex) {}
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset.setEnabled(true);
                start.setEnabled(true);
                sortingPanel.setIsRunning(false);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortingPanel.setLength(slider.getValue());
                slider.setEnabled(true);
                order.setEnabled(true);
                sortingPanel.repaint();
                
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
        order = new AlgoVis.Swing.SwitchCustom();
        orderValue = new javax.swing.JLabel();
        sortingPanel = new AlgoVis.Panels.SortingPanel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1040, 670));

        title.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        title.setText("Sorting");

        subtitle.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        subtitle.setPreferredSize(new java.awt.Dimension(121, 16));

        line.setBackground(new java.awt.Color(13, 13, 13));
        line.setOpaque(true);
        line.setPreferredSize(new java.awt.Dimension(1000, 2));

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

        orderValue.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        orderValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderValue.setText("Ascending");

        javax.swing.GroupLayout sortingPanelLayout = new javax.swing.GroupLayout(sortingPanel);
        sortingPanel.setLayout(sortingPanelLayout);
        sortingPanelLayout.setHorizontalGroup(
            sortingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        sortingPanelLayout.setVerticalGroup(
            sortingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orderValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sortingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sliderValue)
                            .addComponent(orderValue)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(sortingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel line;
    private AlgoVis.Swing.SwitchCustom order;
    private javax.swing.JLabel orderValue;
    private AlgoVis.Swing.ButtonCustom reset;
    private AlgoVis.Swing.Slider.SliderCustom slider;
    private javax.swing.JLabel sliderValue;
    private AlgoVis.Panels.SortingPanel sortingPanel;
    private AlgoVis.Swing.ButtonCustom start;
    private AlgoVis.Swing.ButtonCustom stop;
    private javax.swing.JLabel subtitle;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    
}
