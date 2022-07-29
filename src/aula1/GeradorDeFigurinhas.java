package aula1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class GeradorDeFigurinhas {
	
		// leitura da imagem
	
		public void cria() throws Exception {
		BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg")); 
	
		// criar nova imagem em memoria com transparencia e com tamanho novo
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar imagem original para nova imagem (em memoria)
	
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// escrever uam frase na nova imagem
	
		// escrever a nova imagem em um arquivo
		
		ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
		
		}
		
		public static void main(String[] args) throws Exception {
			var geradora = new GeradorDeFigurinhas();
			geradora.cria();
		}
}
