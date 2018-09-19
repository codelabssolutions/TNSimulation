package com.mobilicom.main;

import com.mobilicom.csv.CSVRW;
import com.mobilicom.csv.LinePoint;
import com.mobilicom.csv.RouteDetail;
import com.mobilicom.csv.RouteDrawing;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
public class MapGridView extends JPanel {
   private final MouseHandler mouseHandler = new MouseHandler();
   private Point p1=null ;
   private Point p2=null;
   private Point startPoint=null;
   private Point gcshome1=null; 
   private final boolean removeLine=false;
   private final boolean dragging=true;
   public JPopupMenu popup; 
   public  int gcspoint=1;
   private  boolean gdtLocation=false;
   private Component target;
   private int wayPointCount=1;
   int xPoints[]= new int[20]; 
   int yPoints[] =new int[20];
   public  Boolean drowPath=false;
   public String ROUTE_DETAIL_CSV_FILE_PATH="";
   List<RouteDetail> routeDetails=new ArrayList<>();
   private ArrayList<Line2D> line2ds =new ArrayList<>();
   private ArrayList<Point> gcspoints =new ArrayList<>();
   Line2D line2d;
   Line2D line2d1;
   JLabel designDetailsFile=new JLabel();
   JMenuItem resetMapGridItem ;
   JMenuItem gcsHomeItem ;
   JMenuItem wayPointItem;
   JMenuItem  routesDesignItem;
   JMenuItem saveRouteItem ;
   JMenuItem loadRoute ;
   JMenuItem removeRouteItem ;
   double totalDistance;
   double gcsx;
   double gcsy;
   
   CSVRW csvrw =null;
   public MapGridView() {
        setBackground(Color.white);
        csvrw =new CSVRW();
        popup = new JPopupMenu();
        ActionListener menuListener = new ActionListener() {
            
        @Override
        public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("1")){  
                javax.swing.JLabel GDTLocation = new javax.swing.JLabel();     
                //common  code
                int x=GDTLocation.getX();
                int y=GDTLocation.getY();
                JTextField fieldIP = new JTextField();
                fieldIP.setText("110.72.169.43");
                JTextField field1 = new JTextField();
                field1.setText("110");
                JTextField field2 = new JTextField();
                field2.setText("130");
                JTextField field3 = new JTextField();
                JTextField field4 = new JTextField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                //panel.add(combo);
                panel.add(new JLabel("IP"));
                panel.add(fieldIP);
                panel.add(new JLabel("Latitude "));
                panel.add(field1);
                panel.add(new JLabel("Longitude"));
                panel.add(field2);
                panel.add(new JLabel("Height"));
                panel.add(field3);
                panel.add(new JLabel("Speed"));
                panel.add(field4);
                int result = JOptionPane.showConfirmDialog(null, panel, "GCS Setting", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                       //GDTLocation.setHorizontalAlignment(SwingConstants.LEFT); 
                        GDTLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imges/rss-house _64.png"))); // NOI18N
                       //GDTLocation.setHorizontalAlignment(JLabel.LEFT);
                        GDTLocation.setVerticalTextPosition(JLabel.TOP);
                        GDTLocation.setHorizontalTextPosition(JLabel.CENTER);
                        GDTLocation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        if(!"".equals(field1.getText())&&!"".equals(field2.getText())){
                             GDTLocation.setBounds(110, 130, 150, 160);
                         } 
                        GDTLocation.setText("<html><div style=\"background:#D3D3D3;\">Base Station#"+gcspoint+"<br>IP:"+fieldIP.getText()+"<br>Latitude:110.999 <br>Longitude:130.99<br> Height:"+field3.getText()+"<br> Speed:"+field4.getText()+"</div></html>");
                        GDTLocation.setName("cgshome"+gcspoint);
                        repaint();
                        add(GDTLocation);
                        gcspoint=gcspoint+1;
                       
                } else {
                    System.out.println("Cancelled");
                }
                
        }
          if(event.getActionCommand().equals("2"))  {  
                javax.swing.JLabel wayPoint = new javax.swing.JLabel();
                wayPoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imges/airport-48.png"))); // NOI18N
                wayPoint.setHorizontalAlignment(JLabel.CENTER);
                wayPoint.setBounds(220, 320, 64, 64);
                wayPoint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                wayPoint.setText(wayPointCount+"");
                //wayPoint.setToolTipText("WayPoint No : "+wayPointCount);
                wayPoint.setTransferHandler(null);
                wayPoint.setName("wayPoint"+wayPointCount);
                //ToolTipManager.sharedInstance().registerComponent(wayPoint);
                wayPointCount=wayPointCount+1;
                add(wayPoint);
                repaint();
        }
        //Route Design 
        if(event.getActionCommand().equals("3")){ 
           routeDesigns();
        }
       // Remove route
        if(event.getActionCommand().equals("4"))  { 
                   routesDesignItem.setEnabled(true); 
                   removeRouteItem.setEnabled(false);
                   line2ds.removeAll(line2ds);
                   startPoint=null;
                   // startPoint1=null;
                   p1=null;
                   p2=null;
                   repaint();
      
        }
        // Reset map grid view 
        if(event.getActionCommand().equals("5"))  {
             gdtLocation=true;
             line2ds.removeAll(line2ds);
             removeAll();
             repaint();
        }
       }};
        //JMenuItem item ;
        gcsHomeItem = new JMenuItem("Add GCS(Home)", new ImageIcon("/imges/rss-house_16.png"));
        gcsHomeItem.setActionCommand("1");
        gcsHomeItem.setName("cgshome");
        popup.add(gcsHomeItem);
        gcsHomeItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        gcsHomeItem.addActionListener(menuListener);
        wayPointItem = new JMenuItem("Add WayPoint ", new ImageIcon(""));
        wayPointItem.setActionCommand("2");
        popup.add(wayPointItem);
        wayPointItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        wayPointItem.addActionListener(menuListener);
        routesDesignItem = new JMenuItem("Draw Route", new ImageIcon(""));
        routesDesignItem.setActionCommand("3");
        popup.add(routesDesignItem);
        routesDesignItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        routesDesignItem.addActionListener(menuListener);
        popup.addSeparator();
        removeRouteItem = new JMenuItem("Remove Route", new ImageIcon(""));
        removeRouteItem.setActionCommand("4");
        removeRouteItem.setEnabled(false);
        popup.add(removeRouteItem);
        resetMapGridItem = new JMenuItem("Reset GridView Map", new ImageIcon("/imges/rss-house_16.png"));
        resetMapGridItem.setActionCommand("5");
        popup.add(resetMapGridItem);
        resetMapGridItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        resetMapGridItem.addActionListener(menuListener);
        removeRouteItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        removeRouteItem.addActionListener(menuListener);
        popup.setBorder(new BevelBorder(BevelBorder.RAISED));
        popup.addPopupMenuListener(new PopupPrintListener());
        this.setPreferredSize(new Dimension(1024, 700));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
       
    }
     public void gdtLocation(MouseEvent evt){
         //System.out.println("mousePressed--------------------------+"+evt.getX());
   }
      public void wayPoint(MouseEvent evt){
        // System.out.println("mousePressed--------------------------+"+evt.getX());
   }
   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Grid start
        g.setColor(Color.lightGray);
        int sideLength = 20;
        int nRowCount = getHeight() / sideLength;
        int currentX = sideLength;
        boolean firstRow=true;
        for (int i = 0; i < nRowCount; i++) {
            g.drawLine(0, currentX, getWidth(), currentX);
            currentX = currentX + sideLength;
            if(firstRow){
                firstRow=false;
               g.drawString(TOOL_TIP_TEXT_KEY, currentX, currentX);
            }
        }

        int nColumnCount = getWidth() / sideLength;
        int currentY = sideLength;
        for (int i = 0; i < nColumnCount; i++) {
            g.drawLine(currentY, 0, currentY, getHeight());
            currentY = currentY + sideLength;
        }
        //Grid end
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(8,BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        for (Line2D line2d : line2ds) {
           g2d.draw(line2d);
        }
        g2d.setColor(Color.green);
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        for (Component c : getComponents()) {
                if(c.getName()!=null&&c.getLocation().getX()!=0){ 
                     if(c.getName().equals("airfan")){
                                Point point= Utility.nearestGCSPoint(c.getLocation(), gcspoints);
                                line2d1 = new Line2D.Double(new Point(point.x-20,point.y-31),new Point(c.getLocation().x+20,c.getLocation().y+25));
                                g2d.draw(line2d1);
                          }
                   }  
             }
      }
     public void routeDesigns(){
           routesDesignItem.setEnabled(false);
           removeRouteItem.setEnabled(true);
            Point endPoint=null;
             for (Component c : getComponents()) {
                   if(c.getName()!=null&&c.getLocation().getX()!=0){
                         if(p1==null && c.getName().equals("cgshome1")){
                           Point point=new Point();
                           point.setLocation(c.getX()+90,c.getY()+140);
                           gcshome1=point;
                           p1=point;
                           startPoint=p1;
                           gcspoints.add(startPoint);
                          }else{
                           Point point=new Point();
                           if(!c.getName().contains("cgshome")){
                                point.setLocation(c.getX()+32,c.getY()+32);
                                p2=point; 
                                line2d = new Line2D.Double(p1,p2);
                                line2ds.add(line2d);
                                p1=p2;
                                endPoint=point;
                           }else{
                               point.setLocation(c.getX()+32,c.getY()+32);
                               gcspoints.add(point);
                           }
                       }
                   }
                
             }
           line2ds.add(new Line2D.Double(endPoint,startPoint));
           repaint();   
    }   
   private class MouseHandler extends MouseAdapter {
       @Override
       public void mousePressed(MouseEvent evt) {
          if(drowPath){
                p1 = evt.getPoint();
                p2 = p1;
           }
        }
        @Override
        public void mouseClicked(MouseEvent evt) {
          MapGridView mapGridView =((MapGridView)evt.getSource());
          try {
              //Detete object from gridview panel
              if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                   JLabel  jLabel=(JLabel)mapGridView.getComponentAt(evt.getPoint());
                   if(null!=jLabel){
                      int dialogButton = JOptionPane.YES_NO_OPTION;
                      int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to delete?","Warning",dialogButton);
                      if(dialogResult == JOptionPane.YES_OPTION){
                         remove(jLabel);
                         repaint();
                      }
                   }
               } 
          }catch(HeadlessException ex){
         } 
       }  
        @Override
        public void mouseReleased(MouseEvent evt) {
            checkPopup(evt);
            
        }

        @Override
        public void mouseDragged(MouseEvent evt) {
            
            evt.getComponent();
        } 
     
        private void checkPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
              System.out.println("isPopupTrigger");
              popup.show(MapGridView.this, e.getX(), e.getY());
      }
    }
    }
   
     // An inner class to show when popup events occur
  class PopupPrintListener implements PopupMenuListener {
    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
      System.out.println("Popup menu will be visible!");
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
      System.out.println("Popup menu will be invisible!");
    }

    public void popupMenuCanceled(PopupMenuEvent e) {
      System.out.println("Popup menu is hidden!");
    }
  }
}