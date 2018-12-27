package com.github.Hudic.sys.cas.util;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Hudic
 * Created by Makkah at 2018/12/27 16:44
 */
public class CaptureUtil {
    private static CaptureUtil captureUtil;
    private static final int WIDTH = 140;           // 生成图片的长度
    private static final int HEIGHT = 40;           // 生成图片的高度
    private static final Random r = new Random();   // 唯一变量，可复用，避免每次生成图片都new一个Random对象
    // 设置验证码的文字库
    private static final char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    // 私有化构造函数
    private CaptureUtil() {
    }

    // Singleton
    public static CaptureUtil getInstance() {
        if (captureUtil == null) {
            return new CaptureUtil();
        }
        return captureUtil;
    }

    // 随机拼凑指定字符数的字符串,未指定文字库时，使用类变量的c为作为文字库
    String getRandomStr(int length) {
        return getRandomStr(length, c);
    }

    // 给定字符个数和字符来源库，随机生成指定字符数的字符串
    private String getRandomStr(int length, char[] charArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(charArray.length);
            sb.append(charArray[index]);
        }
        return sb.toString();
    }

    // 限定从一个字符串中取字符随机生成指定长度的字符串
    private String getRandomStr(int length, String str) {
        str = removeSpaces(str);
        char[] charArray = str.toCharArray();
        return getRandomStr(length, charArray);
    }

    // 去除字符串中的全部空格
    private String removeSpaces(String str) {
        return str.replaceAll(" ", "");
    }

    private BufferedImage createImage(HttpSession session, int length) {
        BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        Graphics g = bi.getGraphics();
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, WIDTH, HEIGHT);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(c.length);
            sb.append(c[index]);
            g2D.setFont(new Font("fantasy", r.nextInt(10) > 5 ? Font.ITALIC : Font.BOLD, r.nextInt(5) + 30));
            g2D.setColor(new Color(r.nextInt(150) + 50, r.nextInt(150) + 50, r.nextInt(150) + 50));
            int t = r.nextInt(2);
            t = r.nextBoolean() ? t : -t;
            g2D.rotate(t, (WIDTH / 12) * (2 * i + 1), HEIGHT / 2);
            g2D.drawString(Character.toString(c[index]), i * WIDTH / 6 + 5, r.nextInt(20) + 20);
            g2D.rotate(t * (-1), (WIDTH / 12) * (2 * i + 1), HEIGHT / 2);
            g2D.setFont(new Font("fantasy", Font.PLAIN, r.nextInt(5) + 5));
            g2D.drawLine(0, r.nextInt(HEIGHT), WIDTH, r.nextInt(HEIGHT));
            g2D.draw3DRect(0, 0, i, t, true);
            g2D.drawLine(r.nextInt(WIDTH), 0, r.nextInt(WIDTH), HEIGHT);
            RoundRectangle2D rr = new RoundRectangle2D.Double(r.nextDouble() + r.nextInt(WIDTH / 2),
                    r.nextDouble() + r.nextInt(HEIGHT / 2), r.nextDouble() + r.nextInt(WIDTH),
                    r.nextDouble() + r.nextInt(HEIGHT), r.nextDouble() + 10, r.nextDouble() + 10);
            g2D.draw(rr);

        }
        session.setAttribute("identifier", sb.toString());
        g.dispose();
        return bi;
    }
}
