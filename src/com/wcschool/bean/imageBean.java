package com.wcschool.bean;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class imageBean {
	private ByteArrayInputStream inputStream;
	 public String RandomNumber()
     {
    	 String RandomNumber ="";
    	 Random r=new Random();
    	 for(int i=0;i<4;i++)
    	 {
    		RandomNumber+=Integer.toString(r.nextInt(9));
    	 }
    	 return RandomNumber;
     }
     public Color RandomColor()
     {
    	 Random ran=new Random();
    	 int r=ran.nextInt(256);
    	 int g=ran.nextInt(256);
    	 int b=ran.nextInt(256);
    	 return new Color(r,g,b);
     }
     public BufferedImage bufferedimage(String randomnumber)
     {
    	 int width=62;
    	 int height=22;
    	 BufferedImage image = new BufferedImage(width, height,
 				BufferedImage.TYPE_INT_RGB);
    		Graphics g = image.getGraphics();
    		// 设定背景色
    		g.setColor(Color.WHITE);
    		g.fillRect(0, 0, width, height);
    		// 画边框
    		g.setColor(Color.black);
    		g.drawRect(0, 0, width - 1, height - 1);
    		// 将认证码显示到图象中
    		g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
    		// 使用随机颜色
    		g.setColor(this.RandomColor());
    		// 将随机字符串的每个数字分别写到图片上
    		g.drawString(Character.toString(randomnumber.charAt(0)), 8, 17);
    		g.drawString(Character.toString(randomnumber.charAt(1)), 20, 17);
    		g.drawString(Character.toString(randomnumber.charAt(2)), 33, 17);
    		g.drawString(Character.toString(randomnumber.charAt(3)), 45, 17);
    		// 图象生效
    		g.dispose();
    		return image;
     }
  	public ByteArrayInputStream createInputStream() throws Exception {
 		// 获取随机字符串
 		String str = this.RandomNumber();
 		BufferedImage image = this.bufferedimage(str);
 		// 将产生的字符串写入session，供校验时使用
      
 		ByteArrayOutputStream output = new ByteArrayOutputStream();
 		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
 		ImageIO.write(image, "JPEG", imageOut);
 		imageOut.close();
 		ByteArrayInputStream input = new ByteArrayInputStream(output
 				.toByteArray());
 		output.close();
 		return input;
 	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
}
