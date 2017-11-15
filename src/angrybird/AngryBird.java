/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybird;

import javax.swing.JFrame;

public class AngryBird extends JFrame {
    
    public AngryBird() {
        initUI();
    }

    
    
    private void initUI() {
        add(new board());
        setSize(1010, 620);
        setTitle("Angry Birb");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        AngryBird ex = new AngryBird();
        ex.setVisible(true);
       
    }
}