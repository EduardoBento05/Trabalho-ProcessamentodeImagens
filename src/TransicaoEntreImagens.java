
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eduardobento
 */
public class TransicaoEntreImagens {
    
    public static void transicao(BufferedImage img1, BufferedImage img2, JLabel label) {
    int width = img1.getWidth();
    int height = img1.getHeight();

    new Thread(() -> {
        float alpha = 0.0f;
        
        while (alpha <= 1.0f) {
            BufferedImage combinada = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    
                    Color c1 = new Color(img1.getRGB(i, j));
                    Color c2 = new Color(img2.getRGB(i, j));

                    int r = (int)((1 - alpha) * c1.getRed() + alpha * c2.getRed());
                    int g = (int)((1 - alpha) * c1.getGreen() + alpha * c2.getGreen());
                    int b = (int)((1 - alpha) * c1.getBlue() + alpha * c2.getBlue());

                    Color interpolado = new Color(r, g, b);
                    combinada.setRGB(i, j, interpolado.getRGB());
                }
            }

            SwingUtilities.invokeLater(() -> label.setIcon(new ImageIcon(combinada)));

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            alpha += 0.05f;
        }
    }).start();
}

    
}
