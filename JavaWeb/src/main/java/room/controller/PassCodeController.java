package room.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

// 可以自動生成 PassCode
@WebServlet("/passcode")
public class PassCodeController extends HttpServlet {
	
	
	// 產生4個數字的圖檔 (BufferedImage)
	private BufferedImage getPassCodeImage(String passCode) {
		int w = 80; // 圖寬
		int h = 30; // 圖高
		// 建立圖像暫存區
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		// 建立畫布
		Graphics g = img.getGraphics();
		// 設定顏色
		g.setColor(Color.YELLOW);
		// 塗滿背景
		g.fillRect(0, 0, w, h);
		// 繪製文字
		g.setColor(Color.RED); // 設定顏色
		g.setFont(new Font("新細明體", Font.BOLD, 30)); // 設定字型
		g.drawString(passCode, 10, 25);
		// 加入干擾線
		g.setColor(Color.GRAY); 
		Random random = new Random();
		for(int i=1;i<=10;i++) {
			int x1 = random.nextInt(w);
			int y1 = random.nextInt(h);
			int x2 = random.nextInt(w);
			int y2 = random.nextInt(h);
			g.drawLine(x1, y1, x2, y2);
		}
		return img;
	}
	
	
}
