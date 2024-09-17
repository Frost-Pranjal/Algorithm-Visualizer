package AlgoVis;

import AlgoVis.Component.Header;
import AlgoVis.Component.Menu;
import AlgoVis.Event.EventMenuSelected;
import AlgoVis.Event.EventShowPopupMenu;
import AlgoVis.Form.Form_Cipher;
import AlgoVis.Form.Form_Home;
import AlgoVis.Form.Form_MazeGen;
import AlgoVis.Form.Form_Searching;
import AlgoVis.Form.Form_Sorting;
import AlgoVis.Form.MainForm;
import AlgoVis.Swing.MenuItem;
import AlgoVis.Swing.PopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class AlgoVis extends javax.swing.JFrame {
    
    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    
    public AlgoVis() {
        initComponents();
        init();
    }

    private void init(){
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        background.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                if(menuIndex==0){
                    main.showForm(new Form_Home());
                }
                if(menuIndex==1 && subMenuIndex>-1){
                    main.showForm(new Form_Sorting(subMenuIndex));
                }
                if(menuIndex==2 && subMenuIndex>-1){
                    main.showForm(new Form_Searching(subMenuIndex));
                }
                if(menuIndex==3){
                    if(subMenuIndex==0)
                        main.showForm(new Form_MazeGen());
                }
                if(menuIndex==6 && subMenuIndex>-1){
                    main.showForm(new Form_Cipher(subMenuIndex));
                }
                if(menuIndex==8){
                    boolean max=AlgoVis.this.getExtendedState()== MAXIMIZED_BOTH;
                    AlgoVis.this.setExtendedState(max?NORMAL:MAXIMIZED_BOTH);
                }
                if(menuIndex==9){
                    System.exit(0);
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu(){
            @Override
            public void showPopup(Component com) {
                MenuItem item=(MenuItem)com;
                PopupMenu popup=new PopupMenu(AlgoVis.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x=AlgoVis.this.getX() + 52;
                int y=AlgoVis.this.getY() + com.getY() +86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        background.add(menu, "w 240!, spany 2");    // Span Y 2cell
        background.add(header, "h 50!, wrap");
        background.add(main, "w 100%, h 100%");
        TimingTarget target=new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                double width;
                if(menu.isShowMenu()){
                    width=60 + (180 * (1f - fraction));
                }
                else{
                    width=60 + (180 * fraction);
                }
                layout.setComponentConstraints(menu, "w "+width+"!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }
        };
        animator=new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animator.isRunning()){
                    animator.start();
                }
                menu.setEnableMenu(false);
                if(menu.isShowMenu()){
                    menu.hideAllMenu();
                }
            }
        });
        main.showForm(new Form_Home());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(245, 245, 245));
        background.setOpaque(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fram=new AlgoVis();
                new splashscreen.SplashScreen().setVisible(true);
            }
        });
    }
    
    private static JFrame fram;
    
    public static JFrame getFrame(){
        return fram;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    // End of variables declaration//GEN-END:variables
}
