package ����ͼ����;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;
/**
 * ��������壬����ͼƬ
 * @author 23132
 * @param <BufferedImage>
 *
 */

public class Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
	java.awt.image.BufferedImage bufferedImage;
	
   public Panel() throws IOException {
	   //����С
	   setSize(400,500);
	    }
   public void paint(Graphics g) {
	   //������ͼ���Ƶ������
	   g.drawImage(image, 0, 0, null);
	   
   }
   public void showImage(BufferedImage image2) {
	   bufferedImage=image2;
	   image=bufferedImage.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
	   repaint();
   }
   public void showImage1(BufferedImage image2) {
	   bufferedImage=image2;
	   image=bufferedImage.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
	   repaint();
   }
}
