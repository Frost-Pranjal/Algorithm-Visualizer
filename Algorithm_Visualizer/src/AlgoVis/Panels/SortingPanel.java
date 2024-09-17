package AlgoVis.Panels;

import AlgoVis.Sorting.Bubble;
import AlgoVis.Sorting.Insertion;
import AlgoVis.Sorting.Quick;
import AlgoVis.Sorting.Selection;
import AlgoVis.Swing.Notification.Notification;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SortingPanel extends javax.swing.JPanel {

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        this.setArray();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray() {
        array=new int[length];
        for(int i=0;i<length;i++)
            array[i]=(int)(Math.random()*451)+50;
        bubbleSort = new Bubble(array);
        selectionSort = new Selection(array);
        insertionSort = new Insertion(array);
        
        quickSort = new Quick(array);
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    private int[] array;
    private boolean isRunning;
    private int sort;
    private boolean order;
    private int length;
    
    private Bubble bubbleSort;
    private Insertion insertionSort;
    private Selection selectionSort;
    private Quick quickSort;
    
    public SortingPanel() {
        initComponents();
    }

    public boolean isSorted() {
        for (int i = 0; i < getArray().length - 1; i++) {
            if (getArray()[i] > getArray()[i + 1]) {
                return false; 
            }
        }
        Notification noti=new Notification(AlgoVis.AlgoVis.getFrame(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Sorting Completed");
        noti.showNotification();
        return true;
    }
    
    public void animate() throws Exception{

        if (sort==0) {
            bubbleSort.setCompareIndex(0);
            Timer bubbleTimer  = new Timer(0, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isSorted() || isRunning == false) {
                        bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                        isRunning = false;
                        ((Timer)e.getSource()).stop();
                    } 
                    else if (isRunning == true)
                            array = bubbleSort.sortOnlyOneItem();
                    repaint();
                }
            });
            bubbleTimer.start();
        }
        
        if (sort==1) {
            selectionSort.setArrayIndex(0);
            selectionSort.setCompareIndex(1);
            selectionSort.setMinIdx(0);
            Timer selectionTimer  = new Timer(0, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        selectionSort.setCompareIndex(Integer.MAX_VALUE);
                        selectionSort.setArrayIndex(Integer.MAX_VALUE);
                        selectionSort.setMinIdx(Integer.MAX_VALUE);
                        isRunning = false;
                        ((Timer)e.getSource()).stop();
                    } 
                    else if (isRunning == true)
                            array = selectionSort.sortOnlyOneItem();
                    repaint();
                }
            });

            selectionTimer.start();
        }
        
        if (sort==2) {

            insertionSort.setArrayIndex(1);

            Timer insertionTimer  = new Timer(0, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        insertionSort.setCompareIndex(Integer.MAX_VALUE);
                        insertionSort.setArrayIndex(Integer.MAX_VALUE);
                        insertionSort.setStartOfIteration(false);
                        isRunning = false;
                        ((Timer)e.getSource()).stop();
                    } 
                    else if (isRunning == true)
                            array = insertionSort.sortOnlyOneItem();
                    repaint();
                }
            });

            insertionTimer.start();
        }
        
        if (sort==4) {

            Timer quickTimer  = new Timer(0, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        quickSort.setSP(-1);
                        quickSort.push(0);
                        quickSort.push(length-1);
                        quickSort.setArrayIndex(Integer.MAX_VALUE);
                        quickSort.setCompareIndex(Integer.MAX_VALUE);
                        quickSort.setPartition(-1);
                        quickSort.setIsPartioning(false);
                        isRunning = false;
                        ((Timer)e.getSource()).stop();
                        
                    } 

                    else if (isRunning == true)
                            array = quickSort.sortOnlyOneItem();
                    repaint();
                }
            });

            quickTimer.start();
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
            int w=getWidth()/length , offset=(getWidth()-(w*length))/2;
            g.setColor(new Color(245, 245, 245));
            g.drawRect(offset+(i*w), 500 - array[i], (getWidth()/length)-1, array[i]); 
            g.setColor(new Color(0, 197, 141));
            if (sort==0) {
                if(i == bubbleSort.getCompareIndex())
                    g.setColor(Color.red);
                if(i == (bubbleSort.getCompareIndex() + 1))
                    g.setColor(Color.blue);
            }
            if (sort==1) {
                if(i==selectionSort.getCompareIndex())
                    g.setColor(Color.blue);
                if(i==selectionSort.getMinIdx())
                    g.setColor(new Color(160, 32, 240));
                if(i==selectionSort.getArrayIndex())
                    g.setColor(Color.red);
            }
            if (sort==2) {

                if (i == insertionSort.getCompareIndex() || i == (insertionSort.getCompareIndex() + 1))
                    g.setColor(Color.blue);
                if (i == insertionSort.getArrayIndex())
                    g.setColor(Color.red);
            }

            if (sort==4) {
                
                if (i == quickSort.getArrayIndex()) {
                    g.setColor(Color.red);
                }

                if (i == quickSort.getCompareIndex()) {
                    g.setColor(Color.blue);
                }

                if (i == quickSort.getPartition())
                    g.setColor(Color.magenta);
            }
            g.fillRect(offset+(i*w), getHeight()-10 - getArray()[i], w-1, getArray()[i]);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
