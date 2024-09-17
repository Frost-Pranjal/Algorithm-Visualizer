
package AlgoVis.Panels;

import AlgoVis.BackTracking.MazeGen;
import AlgoVis.Model.ModelCell;
import AlgoVis.Swing.Notification.Notification;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MazeGenPanel extends javax.swing.JPanel {

    public ModelCell getCurrent() {
        return current;
    }

    public void setCurrent(ModelCell current) {
        this.current = current;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int getcSize() {
        return cSize;
    }

    public void setcSize(int cSize) {
        this.cSize = cSize;
        maze=new MazeGen(cSize);
    }
    
    private MazeGen maze;
    private int cSize;
    private boolean isRunning;
    public ModelCell current;
    
    public MazeGenPanel() {
        initComponents();
    }
    
    public void animate() throws Exception{
        maze.setCurrent(maze.getBlock()[0]);
        Timer mazeTimer = new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isRunning || maze.getCurrent()==null){
                    isRunning=false;
                    if(maze.getCurrent()==null){
                        Notification noti=new Notification(AlgoVis.AlgoVis.getFrame(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Maze Generated");
                        noti.showNotification();
                    }
                    ((Timer)e.getSource()).stop();
                    maze.setCurrent(null);
                }
                else{
                    current=maze.getCurrent();
                    maze.gen(current);
                }
                repaint();
            }
            
        });
        mazeTimer.start();
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize=maze.getCellSize();
        int xoff=(getWidth()-(979/cellSize)*cellSize)/2;
        int yoff=(getHeight()-(519/cellSize)*cellSize)/2;
        for(ModelCell c:maze.getBlock()){
            int x=xoff+c.getX()*cellSize,y=yoff+c.getY()*cellSize;
            g.setColor(Color.darkGray);
            if(c.isVisited())
                g.setColor(new Color(242, 242, 242));
            if(c==current)
                g.setColor(new Color(197, 0, 56));
            g.fillRect(x,y,cellSize,cellSize);
            g.setColor(new Color(0, 197, 141));
            if(c.getWalls()[0])
                g.drawLine(x,y,x+cellSize-1,y);
            if(c.getWalls()[1])
                g.drawLine(x+cellSize-1,y,x+cellSize-1,y+cellSize-1);
            if(c.getWalls()[2])
                g.drawLine(x,y+cellSize-1,x+cellSize-1,y+cellSize-1);
            if(c.getWalls()[3])
                g.drawLine(x,y,x,y+cellSize-1);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}