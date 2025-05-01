
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


/**
 *
 * @author eduardobento
 */
public class TranparenciaSobreImagem {
    
    static float alpha = 1.0f;
    
    
   public static BufferedImage aplicarTransparenciaAnimada(BufferedImage imagemOriginal, JLabel jLabel) {
    
    int width = imagemOriginal.getWidth();
    int height = imagemOriginal.getHeight();

    // Cria uma imagem nova com fundo preto e canal alpha
    BufferedImage overlay = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    // Pinta tudo de preto opaco (alpha = 255)
    for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
            
            Color preto = new Color(0, 0, 0, 255);
            
            overlay.setRGB(i, j, preto.getRGB());
            
        }
    }

    new Thread(() -> {
        
        //inicia alpha com 1
        float alpha = 1.0f;

        while (alpha >= 0.0f) {
            
            BufferedImage combinada = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    
                    // Pega o pixel da imagem original
                    Color corOriginal = new Color(imagemOriginal.getRGB(i, j), true);

                    // Pega o pixel preto com alpha atual
                    Color pretoComAlpha = new Color(0, 0, 0, (int)(alpha * 255));

                    // Combina os dois manualmente: preto por cima da imagem original
                    int r = (pretoComAlpha.getAlpha() * pretoComAlpha.getRed() + (255 - pretoComAlpha.getAlpha()) * corOriginal.getRed()) / 255;
                    int g = (pretoComAlpha.getAlpha() * pretoComAlpha.getGreen() + (255 - pretoComAlpha.getAlpha()) * corOriginal.getGreen()) / 255;
                    int b = (pretoComAlpha.getAlpha() * pretoComAlpha.getBlue() + (255 - pretoComAlpha.getAlpha()) * corOriginal.getBlue()) / 255;

                    Color resultante = new Color(r, g, b);
                    combinada.setRGB(i, j, resultante.getRGB());
                }
            }

            // Atualiza o JLabel com a imagem combinada
            SwingUtilities.invokeLater(() -> jLabel.setIcon(new ImageIcon(combinada)));

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            alpha -= 0.05f;
        }
    }).start();

    return imagemOriginal; // A imagem original não muda, só o efeito visual
}



  
                      
   
}
