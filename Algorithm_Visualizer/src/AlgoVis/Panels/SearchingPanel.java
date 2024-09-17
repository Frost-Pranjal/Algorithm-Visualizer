
package AlgoVis.Panels;

import AlgoVis.Searching.Binary;
import AlgoVis.Searching.Linear;
import AlgoVis.Swing.Notification.Notification;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SearchingPanel extends javax.swing.JPanel {

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public double getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(double searchItem) {
        this.searchItem = searchItem;
        linearSearch.setSearch(searchItem);
        binarySearch.setSearch(searchItem);
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public double[] getArray() {
        return array;
    }

    public void setArray() {
        array=new double[length];
        for(int i=0;i<length;i++)
            array[i]=5*((int)(Math.random()*100)+1);
        if(search==1){
            for(int i=1; i<length; i++){
                double val=array[i];
                int j=i-1;
                for( ;j>=0 && array[j]>val; j--)
                    array[j+1]=array[j];
                if(j!=i-1)
                    array[j+1]=val;
            }
        }
        linearSearch = new Linear(array);
        binarySearch = new Binary(array);
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int getSearch() {
        return search;
    }

    public void setSearch(int search) {
        this.search = search;
        
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        this.setArray();
    }

    private double[] array;
    private boolean isRunning,found,isDone;
    private double searchItem;
    private int length, search;
    
    private Linear linearSearch;
    private Binary binarySearch;
    
    public SearchingPanel() {
        initComponents();
    }

    public void animate() throws Exception{

        if (search==0) {
            Timer linearTimer  = new Timer(10, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(isIsDone() || isRunning==false){
                        if(found){
                            String t=(array[linearSearch.getCompareIndex()]==69*5)?"Ah! I see you are a man of culture as well":"Value Found at Index: "+linearSearch.getCompareIndex();
                            Notification noti=new Notification(AlgoVis.AlgoVis.getFrame(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, t);
                            noti.showNotification();
                        }
                        else{
                            Notification noti=new Notification(AlgoVis.AlgoVis.getFrame(), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Value Not Found");
                            noti.showNotification();
                        }
                        isRunning=false;
                        ((Timer)e.getSource()).stop();
                        
                    }
                    else if(isRunning==true){
                        setIsDone(linearSearch.searchItem());
                        if(isIsDone() && linearSearch.getCompareIndex()<array.length)
                            found=true;
                    }
                    repaint();
                }
            });
            linearTimer.start();
        }
        
        if (search==1) {
            Timer binaryTimer  = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(isIsDone() || isRunning==false){
                        if(found){
                            String t=(array[binarySearch.getMid()]==69*5)?"Ah! I see you are a man of culture as well":"Value Found at Index: "+binarySearch.getMid();
                            Notification noti=new Notification(AlgoVis.AlgoVis.getFrame(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, t);
                            noti.showNotification();
                        }
                        else{
                            Notification noti=new Notification(AlgoVis.AlgoVis.getFrame(), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Value Not Found");
                            noti.showNotification();
                        }
                        isRunning=false;
                        ((Timer)e.getSource()).stop();
                        
                    }
                    else if(isRunning==true){
                        setIsDone(binarySearch.searchItem());
                        if(isIsDone() && binarySearch.getB()<=binarySearch.getE())
                            found=true;
                    }
                    repaint();
                }
            });
            binaryTimer.start();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);

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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < length; i++) {
            int val=(int)(array[i]);
            g.setColor(new Color(245, 245, 245));
            g.drawRect(i*(getWidth()/length), 500 - val, (getWidth()/length)-1, val); 
            g.setColor(new Color(0, 197, 141));
            if(search==0){
                if(i==linearSearch.getCompareIndex())
                    g.setColor(found?Color.magenta:Color.red);
            }
            if(search==1){
                if(i>=binarySearch.getB() && i<=binarySearch.getE() && !isDone)
                    g.setColor(Color.blue);
                if(i==binarySearch.getMid())
                    g.setColor(found?Color.magenta:isDone?new Color(0, 197, 141):Color.red);
            }
            g.fillRect(i*(getWidth()/length), 500 - val, (getWidth()/length)-1, val);
            g.setColor(Color.black);
            int fs=20+((length-10)*(-12)/65);
            g.setFont(new java.awt.Font("SansSerif", 0, fs));
            g.drawString((val/5)+"", i*(getWidth()/length), 500-1-val+((val<fs)?0:fs));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
