
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
 * @author bcaua
 */
public class Rotate {
    public static BufferedImage rotate(BufferedImage image, TypeRotate typeRotate, double custom, JLabel label) {
        double angle_radians = 0;
        
        if(typeRotate == TypeRotate.Left) {
            angle_radians = Math.toRadians(90);
        } else if (typeRotate == TypeRotate.Right) {
            angle_radians = Math.toRadians(-90);
        } else {
            angle_radians = Math.toRadians(custom);
        }

        int height = image.getHeight();
        int width = image.getWidth();
        
        // Cria imagem de saída com mesmas dimensões da original
        BufferedImage saida = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Ponto central para rotação
        double centerX = width / 2.0;
        double centerY = height / 2.0;
            
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                // Transladar para origem
                double translatedX = x - centerX;
                double translatedY = y - centerY;
                    
                // Aplicar rotação
                double rotatedX = translatedX * Math.cos(angle_radians) - translatedY * Math.sin(angle_radians);
                double rotatedY = translatedX * Math.sin(angle_radians) + translatedY * Math.cos(angle_radians);
                    
                // Transladar de volta
                int sourceX = (int)(rotatedX + centerX);
                int sourceY = (int)(rotatedY + centerY);
                    
                // Verificar limites e copiar pixel
                if(sourceX >= 0 && sourceX < width && sourceY >= 0 && sourceY < height) {
                    saida.setRGB(x, y, image.getRGB(sourceX, sourceY));
                }
            }
        }
            
        SwingUtilities.invokeLater(() -> label.setIcon(new ImageIcon(saida)));
        
        return saida;
    }   
}
