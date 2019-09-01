package ����ͼ����;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.IOException;

public class huidubianhuan {
	 static Image tmp;  
	    static int width,height;//ͼ���ȣ��߶�  
	    static double ma,mi;//���Ա仯�Ҷ�������  
	    static int[] pixels;//ͼ���������ص�  
	    static int[] pixels2;//����pixels�����ڻҶ����Ա仯  
	    static int[] pixels3;//����pixels�����ڻҶ�����  
	    static int[] pixels4;//����pixels������ƽ������
	    static int[] histogram=new int[256];  
	   
	 //�ҶȻ�  
public static BufferedImage grayImage(BufferedImage image) throws IOException, InterruptedException  
	    { 
	        width=image.getWidth();  
	        height=image.getHeight();  
	        pixels=new int[width*height];  
	        pixels2=new int[width*height];  
	        pixels3=new int[width*height];  
	      
	          
	        BufferedImage grayImage=new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);//�޷��� byte �Ҷȼ�ͼ��  
	        for(int i=0;i<width;i++)  
	            for(int j=0;j<height;j++)  
	            {  
	                int rgb=image.getRGB(i, j);  
	                int grey=(int) ((0.3*((rgb&0xff0000)>>16)+0.59*((rgb&0xff00)>>8))+0.11*((rgb&0xff)));  
	                rgb=255<<24|grey<<16|grey<<8|grey;  
	                grayImage.setRGB(i, j, rgb);  
	            }//�����������أ�ת��ͼ���ź�,ʹ��ҶȻ�  
	        tmp=grayImage;  
	        PixelGrabber pg=new PixelGrabber(tmp, 0, 0, width, height, pixels,0,width);  
	        pg.grabPixels();//���ûҶȻ����ͼƬ�������ص����pixels����  
	        PixelGrabber pg2=new PixelGrabber(tmp, 0, 0, width, height, pixels2,0,width);  
	        pg2.grabPixels();  
	        PixelGrabber pg3=new PixelGrabber(tmp, 0, 0, width, height, pixels3,0,width);  
	        pg3.grabPixels();//  
	        return grayImage;
	    }  
	      
//ֱ��ͼ����  
public BufferedImage zhifangtu() throws InterruptedException, IOException  
	    {  
	        //PixelGrabber pg=new PixelGrabber(tmp, 0, 0, iwidth, iheight, pixels,0,iwidth);  
	        //pg.grabPixels();  
	        BufferedImage greyImage=new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);  
	          
	        for(int i=0;i<height-1;i++)  
	            for(int j=0;j<width-1;j++)  
	            {  
	                int grey=pixels[i*width+j]&0xff;  
	                histogram[grey]++;  
	            }//����ÿһ���Ҷȼ���������  
	        double a=(double)255/(width*height);  
	        double[] c=new double[256];  
	        c[0]=(a*histogram[0]);  
	        for(int i=1;i<256;i++)  
	            c[i]=c[i-1]+(int)(a*histogram[i]);//ֱ��ͼ���⻯(��ɢ���)  
	        for(int i=0;i<height;i++)  
	            for(int j=0;j<width;j++)  
	            {  
	                int grey=pixels[i*width+j]&0x0000ff;  
	                int hist=(int)c[grey];  
	                pixels[i*width+j]=255<<24|hist<<16|hist<<8|hist;  
	                greyImage.setRGB(j, i, pixels[i*width+j]);  
	            }  
	        tmp=greyImage;
			return greyImage;  
	        
	    }  
	      
//�Ҷ����Ա任  
public BufferedImage linearConversion() throws IOException  
	    {  
	        int min=255,max=0;  ma=100; mi=0;
	        for(int i=0;i<256;i++)  
	        {  
	            if(histogram[i]>0)  
	            {  
	                if(i<min)  
	                    min=i;  
	                if(i>max)  
	                    max=i;  
	            }  
	        }//�ҳ��Ҷȵ���󼶺���С��  
	        double k=(ma-mi)/(max-min);//����任��  
	        BufferedImage greyImage=new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);  
	        for(int i=0;i<height;i++) 
	            for(int j=0;j<width;j++)  
	            {  
	                int grey=pixels2[i*width+j]&0xff;  
	                grey=(int)(k*(grey-min)+mi);  
	                if(grey>255)  
	                    grey=255;  
	                if(grey<0)  
	                    grey=0;  
	                pixels2[i*width+j]=255<<24|grey<<16|grey<<8|grey;  
	                greyImage.setRGB(j, i, pixels2[i*width+j]);  
	            }
	        //�Ҷ����Ա任  
	        tmp=greyImage;
			return greyImage;
	    }  
	      
 //�Ҷ�����  
public BufferedImage huidulashen() throws IOException  
	    {  
	        int min = 0,max = 1;   ma=255; mi=0;
	        int sum=0;  
	        for(int i=0;i<256;i++)  
	        {  
	            sum+=histogram[i];  
	            if(sum>width*height*0.05)  
	            {  
	                min=i;  
	                break;  
	            }  
	        }//�ҳ��ҶȵĴ󲿷����ط�Χ����С��  
	        sum=0;  
	        for(int i=255;i>=0;i--)  
	        {  
	            sum+=histogram[i];  
	            if(sum>width*height*0.05)  
	            {  
	                max=i;  
	                break;  
	            }  
	        }//�ҳ��ҶȵĴ󲿷����ط�Χ�����  
	        double k=(ma-mi)/(max-min);  
	        BufferedImage greyImage=new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);  
	        for(int i=0;i<height;i++) { 
	            for(int j=0;j<width;j++)  
	            {  
	                int grey=pixels3[i*width+j]&0xff;  
	               
	                if(grey<min)  
	                    grey=(int) mi;//С��min������Ϊ����  
	                else if(grey>=max)  
	                    grey=(int) ma;//����max������Ϊ����  
	                else   
	                {  
	                    grey=(int)(k*(grey-min)+mi);  
	                    if(grey>255)  
	                        grey=255;  
	                    if(grey<0)  
	                        grey=0;  
	                }//�󲿷��������Ա任  
	                  
	                pixels3[i*width+j]=255<<24|grey<<16|grey<<8|grey;  
	                
	                greyImage.setRGB(j, i, pixels3[i*width+j]);  
	            }
	        }//�Ҷ�����  

	        tmp=greyImage;
			return greyImage;
	    }  
//��ֵ��
public static BufferedImage erzhihua() throws IOException, InterruptedException  {  
	pixels4=new int[width*height];
  BufferedImage greyImage=new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);  
    for(int i=0;i<height;i++) 
        for(int j=0;j<width;j++)  
        {  
            int grey=pixels2[i*width+j]&0xff;  
            
            if(grey>100)  
                grey=255; 
            else 
            	grey=0;
            pixels2[i*width+j]=255<<24|grey<<16|grey<<8|grey;  
            greyImage.setRGB(j, i, pixels2[i*width+j]);  
        }
    
    tmp=greyImage;

    PixelGrabber pg4=new PixelGrabber(tmp, 0, 0, width, height, pixels4,0,width);  
    pg4.grabPixels();//
    return greyImage;
}  


}

