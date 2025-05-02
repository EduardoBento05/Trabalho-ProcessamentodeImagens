
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bcaua
 */
public class SegmentarPorCor {
    public static void Segmentar(BufferedImage img1, int targetR, int targetG, int targetB, JLabel label) throws IOException {
        BufferedImage saida = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        
        new Thread(() -> {
            for(int y = 0; y < img1.getHeight(); y++) {
                for(int x = 0; x < img1.getWidth(); x++) {
                    Color cor = new Color(img1.getRGB(x, y));
                    int r = cor.getRed();
                    int g = cor.getGreen();
                    int b = cor.getBlue();

                    if (r == targetR && g == targetG && b == targetB) {
                        saida.setRGB(x, y, new Color(r, g, b).getRGB());
                    } else {
                        saida.setRGB(x, y, Color.black.getRGB());
                    }
                }
            }

            SwingUtilities.invokeLater(() -> label.setIcon(new ImageIcon(saida)));
        }).start();

    }
}
