package com.tarena.netctoss.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public final class VerificationCodeUtil {
	private static final String SRC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "abcdefghijklmnopqrstuvwxyz" + "0123456789";
	private static final int SIZE = 4;
	private static final int LINES = 5;
	private static final int WIDTH = 70;
	private static final int HEIGHT = 30;
	private static final int FONT_SIZE = 20;

	public static Map<String, BufferedImage> createImage() {
		StringBuffer sb = new StringBuffer();
		// step1,BufferedImage 内存映象对象
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		// step2,获得画笔
		Graphics graphic = image.getGraphics();
		// step3,设置背景颜色（给笔设置颜色）
		graphic.setColor(getRandomColor(192, 256));
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		Random ran = new Random();
		// 画随机字符
		for (int i = 1; i <= SIZE; i++) {
			int r = ran.nextInt(SRC.length());
			graphic.setColor(getRandomColor(128));
			graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			graphic.drawString(SRC.charAt(r) + "", (i - 1) * WIDTH / SIZE,
					FONT_SIZE);
			sb.append(SRC.charAt(r));// 将字符保存，存入Session
		}
		// 画干扰线
		for (int i = 1; i <= LINES; i++) {
			graphic.setColor(getRandomColor(256));
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),
					ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		map.put(sb.toString(), image);
		return map;
	}

	public static Color getRandomColor(int num) {
		return getRandomColor(0, num);
	}

	public static Color getRandomColor(int begin, int end) {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(end - begin) + begin,
				ran.nextInt(end - begin) + begin, ran.nextInt(end - begin)
						+ begin);
		return color;
	}

	public static InputStream getInputStream(BufferedImage image)
			throws IOException {
		// 字节数组输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
		encoder.encode(image);
		byte[] imageBts = baos.toByteArray();
		InputStream in = new ByteArrayInputStream(imageBts);
		return in;
	}
}
