/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilicom.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ImageLabelExample {
  private static Icon icon = new ImageIcon("1.gif");

  public static void main(String[] args) {
    JLabel[] labels = new JLabel[9];

    labels[0] = makeLabel(JLabel.TOP, JLabel.LEFT);
    labels[1] = makeLabel(JLabel.TOP, JLabel.CENTER);
    labels[2] = makeLabel(JLabel.TOP, JLabel.RIGHT);
    labels[3] = makeLabel(JLabel.CENTER, JLabel.LEFT);
    labels[4] = makeLabel(JLabel.CENTER, JLabel.CENTER);
    labels[5] = makeLabel(JLabel.CENTER, JLabel.RIGHT);
    labels[6] = makeLabel(JLabel.BOTTOM, JLabel.LEFT);
    labels[7] = makeLabel(JLabel.BOTTOM, JLabel.CENTER);
    labels[8] = makeLabel(JLabel.BOTTOM, JLabel.RIGHT);

    labels[0].setEnabled(false);

    labels[1].setDisabledIcon(new ImageIcon(("F:\\SOLR_WORKSPACES\\TNSimulation\\src\\imges\\airport-48.png")));
    labels[1].setEnabled(false);

    labels[2].setIconTextGap(15);
    labels[3].setIconTextGap(0);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = frame.getContentPane();
    c.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
    for (int i = 0; i < 9; i++){
         labels[i].setDisabledIcon(new ImageIcon(("F:\\SOLR_WORKSPACES\\TNSimulation\\src\\imges\\airport-48.png")));
         c.add(labels[i]);
    }
    frame.setSize(350, 150);
    frame.setVisible(true);
  }

  protected static JLabel makeLabel(int vert, int horiz) {
    JLabel l = new JLabel("Smile", icon, SwingConstants.CENTER);
    l.setVerticalTextPosition(vert);
    l.setHorizontalTextPosition(horiz);
    l.setBorder(BorderFactory.createLineBorder(Color.black));
    return l;
  }
}