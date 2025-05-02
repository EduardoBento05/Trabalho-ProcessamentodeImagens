
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eduardobento
 */
public class LeituraPGM2 {
    
    public static BufferedImage lerPGM_P2(File arquivo) throws IOException {
    
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

    // Lê tipo do arquivo
    do {
        linha = br.readLine();
    } while (linha != null && linha.startsWith("#"));

    if (!linha.equals("P2")) throw new IOException("Formato inválido, esperado P2.");

    // Lê dimensões
    do {
        linha = br.readLine();
    } while (linha != null && linha.startsWith("#"));
    String[] dimensoes = linha.trim().split("\\s+");
    int largura = Integer.parseInt(dimensoes[0]);
    int altura = Integer.parseInt(dimensoes[1]);

    // Lê valor máximo de cinza
    do {
        linha = br.readLine();
    } while (linha != null && linha.startsWith("#"));
    int max = Integer.parseInt(linha.trim());

    BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

    int x = 0, y = 0;
    while ((linha = br.readLine()) != null) {
        
        if (linha.startsWith("#") || linha.trim().isEmpty()) continue;

        String[] valores = linha.trim().split("\\s+");
       
        for (String val : valores) {
            int cinza = Integer.parseInt(val);
            int cor = (cinza * 255) / max; // normaliza para 0–255
            int rgb = new Color(cor, cor, cor).getRGB();
            imagem.setRGB(x, y, rgb);

            x++;
            if (x == largura) {
                x = 0;
                y++;
            }
        }
    }

    br.close();
    return imagem;
}

    
}
