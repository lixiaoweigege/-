package ����ͼ����;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import org.opencv.core.CvType;
import org.opencv.core.Mat;


public class Myframe extends JFrame{
	 File imageFile;
	 int[] pixels;
  /**
	 * 
	 */
	 BufferedImage src;
	private static final long serialVersionUID = 1L;
/**
 * @throws IOException 
	 * 
	 */

public Myframe() throws IOException  {
	  window();
  }
  public void window() throws IOException {
	 
	  setSize(850,500);//���ô�С
	  setLocation(100, 100);//����λ��
	  setLayout(null);
	  setVisible(true);//���ÿɼ���
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���ùرշ�ʽ
	  setTitle("��Сΰ���");
	  JMenuBar menuBar = new JMenuBar(); //��ʼ��һ���˵���
	 add( menuBar);
	//��ʼ���˵�
      JMenu menu1 = new JMenu("�ļ�");
      JMenu menu2 = new JMenu("���α任");
      JMenu menu3 = new JMenu("�Ҷȱ任");
      JMenu menu4 = new JMenu("ƽ������");
      JMenu menu5 = new JMenu("�񻯴���");
      JMenu menu6 = new JMenu("ͼ��ָ�");
      JMenu menu7 = new JMenu("��̬����");
      JMenu menu8 = new JMenu("��ɫͼ����");
      JMenu menu9 = new JMenu("ͼ��ʶ��");
      
      //����Ӳ˵�
      JMenuItem item11=new JMenuItem("��");
      JMenuItem item12=new JMenuItem("����");
      
      
      JMenuItem item21=new JMenuItem("��ת");
      JMenuItem item22=new JMenuItem("��ֱ����");
      JMenuItem item23=new JMenuItem("��С");
      JMenuItem item24=new JMenuItem("ˮƽ����");
    
      JMenuItem item31=new JMenuItem("�ҶȻ�");
      JMenuItem item32=new JMenuItem("ֱ��ͼ");
      JMenuItem item33=new JMenuItem("����ͼ");
      JMenuItem item34=new JMenuItem("����ͼ");
      JMenuItem item35=new JMenuItem("��ֵ��");
      
      JMenuItem item41=new JMenuItem("��������");    
      JMenuItem item43=new JMenuItem("�Ҷ�ƽ��");
      
      JMenuItem item51=new JMenuItem("�ݶ���");
      JMenuItem item52=new JMenuItem("������˹��");
      JMenuItem item53=new JMenuItem("������˹����");
      
      JMenuItem item61=new JMenuItem("������ȡ");
      JMenuItem item62=new JMenuItem("������ȡ");
      
      JMenuItem item71=new JMenuItem("ˮƽ��ʴ");
      JMenuItem item72=new JMenuItem("��ֱ��ʴ");
      JMenuItem item73=new JMenuItem("ȫ�港ʴ");
      JMenuItem item74=new JMenuItem("ȫ������");
      
      JMenuItem item81=new JMenuItem("HSI����");
      JMenuItem item82=new JMenuItem("ƽ������");
      
      JMenuItem item91=new JMenuItem("����ʶ��");
      JMenuItem item92=new JMenuItem("�۾�ʶ��");
      
      //��ʼ��һ��panel
      Panel panel1 = new Panel();
      Panel panel2 = new Panel();
   
      //��panel��ӵ�����
      JSplitPane splitPane=new JSplitPane();//����һ���ָ�������
      splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//���÷ָ��߷��� ����ֲ�
      splitPane.setLeftComponent(panel1);//������ߵ����
      splitPane.setRightComponent(panel2);//�����ұߵ����
      splitPane.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
      splitPane.setContinuousLayout(true);//������ͷ���ػ�ͼ��
      splitPane.setDividerSize(1);//���÷ָ��ߵĴ�С
      splitPane.setDividerLocation(420);//���÷ָ���λ������
      setContentPane(splitPane);
      
    //����ͼ������¼�������
      item11.addActionListener(new ActionListener() {
  	
  	@Override
  	public void actionPerformed(ActionEvent e) {
  		// TODO �Զ����ɵķ������
  		//�����ļ�ѡ����
  		JFileChooser chooser=new JFileChooser();
  		//��ʾ�ļ�ѡ�񴰿�
  	    chooser.showDialog(null, "����ͼƬ");
  	    //����û�ѡ���ͼƬ
  		 imageFile=chooser.getSelectedFile();
  	
  		 try {
  			  src=ImageIO.read(imageFile);
  			
  		     panel1.showImage(src);
  			
  		} catch (IOException e1) {
  			// TODO �Զ����ɵ� catch ��
  			e1.printStackTrace();
  		}
  	}
  });
      
      item21.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			Specialefficiency s21=new Specialefficiency();
			src=s21.rotateImage(src, 90);
			panel2.showImage(src);
		}
    	  
      });
      item22.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  			// TODO �Զ����ɵķ������
  			Specialefficiency s22=new Specialefficiency();
  			src=s22.ImageMirror(src);
  			panel2.showImage(src);
  		}
      	  
        });
      item23.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO �Զ����ɵķ������
    			Specialefficiency s23=new Specialefficiency();
    			src=s23.zoomInImage(src,5);
    			panel2.showImage1(src);
    		}
        	  
          });
      item24.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  			// TODO �Զ����ɵķ������
  			Specialefficiency s24=new Specialefficiency();
  			src=s24.shuipingjingxiang(src);
  			panel2.showImage(src);
  		}
      	  
        });
      
      item31.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  			// TODO �Զ����ɵķ������
  			huidubianhuan s31=new huidubianhuan();
  			try {
				src=s31.grayImage(src);
			} catch (InterruptedException | IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
  			
  		}
      	  });
      item32.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO �Զ����ɵķ������
    			huidubianhuan s32=new huidubianhuan();
    			try {
  				src=s32.zhifangtu();
  			} catch (InterruptedException | IOException e) {
  				// TODO �Զ����ɵ� catch ��
  				e.printStackTrace();
  			}
  			panel2.showImage(src);
    			
    		}
        	  });
      item33.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  			// TODO �Զ����ɵķ������
  			huidubianhuan s33=new huidubianhuan();
  			try {
				src=s33.linearConversion();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
  			
  		}
      	  });
      item34.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO �Զ����ɵķ������
    			huidubianhuan s34=new huidubianhuan();
    			try {
  				src=s34.huidulashen();
  			} catch (IOException e) {
  				// TODO �Զ����ɵ� catch ��
  				e.printStackTrace();
  			}
  			panel2.showImage(src);
    			
    		}
        	  });
      item35.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  			// TODO �Զ����ɵķ������
  			huidubianhuan s35=new huidubianhuan();
  			try {
				src=s35.erzhihua();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
  			
  		}
      	  });
      item41.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO �Զ����ɵķ������
    			Pinghuachuli s41=new Pinghuachuli();
    			try {
  				src=s41.filter(src);
  			} catch (Exception e) {
  				// TODO �Զ����ɵ� catch ��
  				e.printStackTrace();
  			}
  			panel2.showImage(src);
    			
    		}
        	  });
      
      item43.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO �Զ����ɵķ������
    			Pinghuachuli s43=new Pinghuachuli();
    			try {
  				src=s43.filter2(src);
  			} catch (Exception e) {
  				// TODO �Զ����ɵ� catch ��
  				e.printStackTrace();
  			}
  			panel2.showImage(src);
    			
    		}
        	  });
      item51.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  			// TODO �Զ����ɵķ������
  			Ruihua s51=new Ruihua();
  			try {
				src=s51.Tidu(src);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
  			
  		}
      	  });
      item52.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO �Զ����ɵķ������
    			Ruihua s52=new Ruihua();
    			try {
  				src=s52.laplaceProcess(src);
  			} catch (Exception e) {
  				// TODO �Զ����ɵ� catch ��
  				e.printStackTrace();
  			}
  			panel2.showImage(src);
    			
    		}
        	  });
      item53.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  			// TODO �Զ����ɵķ������
  			Ruihua s53=new Ruihua();
  			try {
				src=s53.laplaceAddProcess(src);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
  			
  		}
      	  });
      item61.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO �Զ����ɵķ������
    			Lukuotiqu s61=new Lukuotiqu();
    			try {
  				src=s61.getImg(src);
  			} catch (Exception e) {
  				// TODO �Զ����ɵ� catch ��
  				e.printStackTrace();
  			}
  			panel2.showImage(src);
    			
    		}
        	  });
      item62.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO �Զ����ɵķ������
    			Lukuotiqu s62=new Lukuotiqu();
    			try {
  				src=s62.tezheng(src);
  			} catch (Exception e) {
  				// TODO �Զ����ɵ� catch ��
  				e.printStackTrace();
  			}
  			panel2.showImage(src);
    			
    		}
        	  });
    item71.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			Xingtai s71=new Xingtai();
			try {
				src=s71.Shuipingfushi(src);
			} catch (IOException | InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
		}
	});
 item72.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			Xingtai s72=new Xingtai();
			try {
				src=s72.Chuizhifushi(src);
			} catch (IOException | InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
		}
	});
 item73.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			Xingtai s73=new Xingtai();
			try {
				src=s73.Quanfangwei(src);
			} catch (IOException | InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
		}
	});
 item74.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			Xingtai s74=new Xingtai();
			try {
				src=s74.Quanfangweipengzhang(src);
			} catch (IOException | InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} 
			panel2.showImage(src);
		}
	});
 item81.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			Caisechuli s81=new Caisechuli();
			try {
				src=s81.HSI(src);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
		}
	});
 item82.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			Caisechuli s82=new Caisechuli();
			try {
				src=s82.filter1(src);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			panel2.showImage(src);
			
		}
   	  });
 item91.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			FaceDetect s91=new FaceDetect();
			try {	
				
				s91.renlianshibie("./Resources/"+imageFile.getName());//("C:\\Users\\23132\\Desktop\\ͼƬ\\"+imageFile.getName());
				
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}						
		}
	  });
 item92.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			FaceDetect s92=new FaceDetect();
			try {	
				
				s92.eyeselect("./Resources/"+imageFile.getName());//("C:\\Users\\23132\\Desktop\\ͼƬ\\"+imageFile.getName());
				
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}						
		}
	  });
 
      menu1.add(item11);
      menu1.add(item12);
      
      menu2.add(item21);
      menu2.add(item22);
      menu2.add(item23);
      menu2.add(item24);
      
      menu3.add(item31);
      menu3.add(item32);
      menu3.add(item33);
      menu3.add(item34);
      menu3.add(item35);
      
      menu4.add(item41);     
      menu4.add(item43);
      
      menu5.add(item51);
      menu5.add(item52);
      menu5.add(item53);
      
      menu6.add(item61);
      menu6.add(item62);
      
      menu7.add(item71);
      menu7.add(item72);
      menu7.add(item73);
      menu7.add(item74);
      
      menu8.add(item81);
      menu8.add(item82);
      
      menu9.add(item91);
      menu9.add(item92);
      
    //�Ѳ˵���ӵ��˵���
      menuBar.add(menu1);
      menuBar.add(menu2);
      menuBar.add(menu3);
      menuBar.add(menu4);
      menuBar.add(menu5);
      menuBar.add(menu6);
      menuBar.add(menu7);
      menuBar.add(menu8);
      menuBar.add(menu9);
      
      setJMenuBar(menuBar);//���ò˵���
   
  }
	 
	 
	  
  }

