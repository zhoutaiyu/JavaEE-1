package cn.qdgxy.shop.utils.verifycode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 获得验证码
 * 
 * @author 李欣
 *
 */
public class VerifyCodeUtils {

	private int w = 70; // 宽度
	private int h = 35; // 高度
	private Random r = new Random();
	private String[] fontNames = { "宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312" }; // 字体
	private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ"; // 验证码字母
	private Color bgColor = new Color(255, 255, 255); // 背景颜色
	private String text; // 验证码

	/**
	 * 随机生成颜色
	 * 
	 * @return
	 */
	private Color randomColor() {
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		return new Color(red, green, blue);
	}

	/**
	 * 随机生成字体样式
	 * 
	 * @return
	 */
	private Font randomFont() {
		int index = r.nextInt(fontNames.length);
		String fontName = fontNames[index];
		int style = r.nextInt(4);
		int size = r.nextInt(5) + 24;
		return new Font(fontName, style, size);
	}

	/**
	 * 随机生成3条线
	 * 
	 * @param image
	 */
	private void drawLine(BufferedImage image) {
		int num = 3;

		Graphics2D g2 = (Graphics2D) image.getGraphics();
		for (int i = 0; i < num; i++) {
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h);
			g2.setStroke(new BasicStroke(1.5F));
			g2.setColor(Color.BLUE);
			g2.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * 随机生成一位字母或数字
	 * 
	 * @return
	 */
	private char randomChar() {
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}

	/**
	 * 创建验证码背景图片
	 * 
	 * @return
	 */
	private BufferedImage createImage() {
		BufferedImage image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(this.bgColor);
		g2.fillRect(0, 0, w, h);
		return image;
	}

	/**
	 * 生成验证码图片
	 * 
	 * @return
	 */
	public BufferedImage getImage() {
		BufferedImage image = createImage();
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		StringBuilder sb = new StringBuilder();
		// 向图片中画4个字符
		for (int i = 0; i < 4; i++) {
			String s = randomChar() + "";
			sb.append(s);
			float x = i * 1.0F * w / 4;
			g2.setFont(randomFont());
			g2.setColor(randomColor());
			g2.drawString(s, x, h - 5);
		}
		this.text = sb.toString();
		drawLine(image);
		return image;
	}

	/**
	 * 获得验证码
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * 输出验证码
	 * 
	 * @param image
	 *            验证码图片
	 * @param out
	 *            输出位置
	 * @throws IOException
	 */
	public static void output(BufferedImage image, OutputStream out)
			throws IOException {
		ImageIO.write(image, "JPEG", out);
	}

}
