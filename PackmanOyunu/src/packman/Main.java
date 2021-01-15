package packman;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new PackmanBoard());
       
        setTitle("Packman");
        pack();
        setSize(336, 419);
        setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

    	EventQueue.invokeLater(() -> {
            	Main ex = new Main();
                ex.setVisible(true);
                ex.setResizable(false);
                
                ImageIcon icon = new ImageIcon("C:\\Users\\Mediha\\eclipse-workspace\\PackmanOyunu\\src\\packman\\packman1sag.png");
                ex.setIconImage(icon.getImage());
           
        });
    }
}

