package com.github.Hudic.sys.cas.util;

/**
 * Hudic
 * 创建随机验证码图片
 * Created by Makkah at 2018/12/27 16:36
 */

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class ImageUtil {

    private static int WIDTH = 120;  //生成图片的宽度

    private static int HEIGHT = 35; //生成图片的高度

    private static int length;

    private static final Random random = new Random();

    private static final String DIRECTORY = "../polarisCache/"; // 图片存放的临时地址

    private ImageUtil() {
    }          // 私有化构造器

    public static final FileInputStream getImageInputStream(String url) {
        File file = new File(DIRECTORY + url);
        if (!file.exists()) return null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }


    /**
     * 创建随机验证码图片
     *
     * @param session        会话变量   把随机验证码放在里面方便检验 （提示：verifier 是从会话中获取验证码的key）
     * @param createTypeFlag 随机验证码的类型 ：ch(汉字) nl(数字和字母组合) n(纯数字) l(纯字母)
     * @param length         随机字符串的长度
     * @return 创建好的验证码图片
     */
    public static final BufferedImage createVerifierImage(HttpSession session, String createTypeFlag, int length) {
        WIDTH = length * 35;  //根据需要的字符长度设置宽度
        ImageUtil.length = length;
        //在内存中创建一张图片
        BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //从画像上得到画笔
        Graphics g = bi.getGraphics();
        //设置图片的 背景色
        setBackGround(g);
        //设置图片的边框
        setBorder(g);
        //在图片上画干扰线条
        drawRandomLine(g);
        //根据传入的createTypeFlag标识符生成验证码图片
        String randomStr = drawRandomNum((Graphics2D) g, createTypeFlag);
        drawRandomLine(g);
        //将随机字符串存在session中，方便以后的验证
        session.setAttribute("verifier", randomStr);
        //关闭画笔
        g.dispose();
        //返回图片
        return bi;
    }

    /**
     * 设置图片的背景色
     *
     * @param g
     */
    private static void setBackGround(Graphics g) {
        //设置颜色
        g.setColor(Color.PINK);
        //填充区域
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    /**
     * 设置边框颜色
     *
     * @param g
     */
    private static void setBorder(Graphics g) {
        //设置边框的颜色
        g.setColor(Color.BLUE);
        //边框区域
        g.drawRect(1, 1, WIDTH - 1, HEIGHT - 1);
    }

    /**
     * 设置随即线条（干扰线条）
     *
     * @param g
     */
    private static void drawRandomLine(Graphics g) {
        //设置颜色
        g.setColor(Color.YELLOW);
        //设置线条个数并画线
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 创建随机字符串图片
     *
     * @param g
     * @param createTypeFlag
     * @return
     */
    private static String drawRandomNum(Graphics2D g, String createTypeFlag) {
        //设置颜色
        g.setColor(Color.RED);
        //设置字体
        g.setFont(new Font("微软雅黑", Font.BOLD, (random.nextInt(8) + 15)));
        //常用的中国汉字
        String baseChineseChar = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66\u53ea\u4ee5\u4e3b\u4f1a\u6837\u5e74\u60f3\u751f\u540c\u8001\u4e2d\u5341\u4ece\u81ea\u9762\u524d\u5934\u9053\u5b83\u540e\u7136\u8d70\u5f88\u50cf\u89c1\u4e24\u7528\u5979\u56fd\u52a8\u8fdb\u6210\u56de\u4ec0\u8fb9\u4f5c\u5bf9\u5f00\u800c\u5df1\u4e9b\u73b0\u5c71\u6c11\u5019\u7ecf\u53d1\u5de5\u5411\u4e8b\u547d\u7ed9\u957f\u6c34\u51e0\u4e49\u4e09\u58f0\u4e8e\u9ad8\u624b\u77e5\u7406\u773c\u5fd7\u70b9\u5fc3\u6218\u4e8c\u95ee\u4f46\u8eab\u65b9\u5b9e\u5403\u505a\u53eb\u5f53\u4f4f\u542c\u9769\u6253\u5462\u771f\u5168\u624d\u56db\u5df2\u6240\u654c\u4e4b\u6700\u5149\u4ea7\u60c5\u8def\u5206\u603b\u6761\u767d\u8bdd\u4e1c\u5e2d\u6b21\u4eb2\u5982\u88ab\u82b1\u53e3\u653e\u513f\u5e38\u6c14\u4e94\u7b2c\u4f7f\u5199\u519b\u5427\u6587\u8fd0\u518d\u679c\u600e\u5b9a\u8bb8\u5feb\u660e\u884c\u56e0\u522b\u98de\u5916\u6811\u7269\u6d3b\u90e8\u95e8\u65e0\u5f80\u8239\u671b\u65b0\u5e26\u961f\u5148\u529b\u5b8c\u5374\u7ad9\u4ee3\u5458\u673a\u66f4\u4e5d\u60a8\u6bcf\u98ce\u7ea7\u8ddf\u7b11\u554a\u5b69\u4e07\u5c11\u76f4\u610f\u591c\u6bd4\u9636\u8fde\u8f66\u91cd\u4fbf\u6597\u9a6c\u54ea\u5316\u592a\u6307\u53d8\u793e\u4f3c\u58eb\u8005\u5e72\u77f3\u6ee1\u65e5\u51b3\u767e\u539f\u62ff\u7fa4\u7a76\u5404\u516d\u672c\u601d\u89e3\u7acb\u6cb3\u6751\u516b\u96be\u65e9\u8bba\u5417\u6839\u5171\u8ba9\u76f8\u7814\u4eca\u5176\u4e66\u5750\u63a5\u5e94\u5173\u4fe1\u89c9\u6b65\u53cd\u5904\u8bb0\u5c06\u5343\u627e\u4e89\u9886\u6216\u5e08\u7ed3\u5757\u8dd1\u8c01\u8349\u8d8a\u5b57\u52a0\u811a\u7d27\u7231\u7b49\u4e60\u9635\u6015\u6708\u9752\u534a\u706b\u6cd5\u9898\u5efa\u8d76\u4f4d\u5531\u6d77\u4e03\u5973\u4efb\u4ef6\u611f\u51c6\u5f20\u56e2\u5c4b\u79bb\u8272\u8138\u7247\u79d1\u5012\u775b\u5229\u4e16\u521a\u4e14\u7531\u9001\u5207\u661f\u5bfc\u665a\u8868\u591f\u6574\u8ba4\u54cd\u96ea\u6d41\u672a\u573a\u8be5\u5e76\u5e95\u6df1\u523b\u5e73\u4f1f\u5fd9\u63d0\u786e\u8fd1\u4eae\u8f7b\u8bb2\u519c\u53e4\u9ed1\u544a\u754c\u62c9\u540d\u5440\u571f\u6e05\u9633\u7167\u529e\u53f2\u6539\u5386\u8f6c\u753b\u9020\u5634\u6b64\u6cbb\u5317\u5fc5\u670d\u96e8\u7a7f\u5185\u8bc6\u9a8c\u4f20\u4e1a\u83dc\u722c\u7761\u5174\u5f62\u91cf\u54b1\u89c2\u82e6\u4f53\u4f17\u901a\u51b2\u5408\u7834\u53cb\u5ea6\u672f\u996d\u516c\u65c1\u623f\u6781\u5357\u67aa\u8bfb\u6c99\u5c81\u7ebf\u91ce\u575a\u7a7a\u6536\u7b97\u81f3\u653f\u57ce\u52b3\u843d\u94b1\u7279\u56f4\u5f1f\u80dc\u6559\u70ed\u5c55\u5305\u6b4c\u7c7b\u6e10\u5f3a\u6570\u4e61\u547c\u6027\u97f3\u7b54\u54e5\u9645\u65e7\u795e\u5ea7\u7ae0\u5e2e\u5566\u53d7\u7cfb\u4ee4\u8df3\u975e\u4f55\u725b\u53d6\u5165\u5cb8\u6562\u6389\u5ffd\u79cd\u88c5\u9876\u6025\u6797\u505c\u606f\u53e5\u533a\u8863\u822c\u62a5\u53f6\u538b\u6162\u53d4\u80cc\u7ec6";
        //数字和字符组合
        String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZ";
        //纯数字
        String baseNum = "0123456789";
        //纯字母
        String baseLetter = "ABCDEFGHJKLMNOPQRSTUVWXYZ";

        String str = "";
        switch (createTypeFlag) {
            case "ch":
                //截取汉字
                str = createRandomStr(g, baseChineseChar);
                break;
            case "nl":
                //截取字母和数字
                str = createRandomStr(g, baseNumLetter);
                break;
            case "n":
                //截取数字
                str = createRandomStr(g, baseNum);
                break;
            case "l":
                //截取字母
                str = createRandomStr(g, baseLetter);
                break;
            default:
                //默认截取字母和数字组合
                str = createRandomStr(g, baseNumLetter);
        }
        return str;
    }


    /**
     * 创建随机字符串
     *
     * @param g
     * @param baseChar
     * @return 随机字符串
     */
    private static String createRandomStr(Graphics2D g, String baseChar) {
        StringBuffer sb = new StringBuffer();

        //字符串的长度
        int baseCharLength = baseChar.length();
        //图片上的x坐标
        int x = 20;
        //用来得到随机字符串
        String ch = "";
        //获取给定个数的随机字符，并画在图片上
        for (int i = 0; i < length; i++) {
            //字体旋转的角度（正负30度之间）
            int degree = random.nextInt(60) - 30;
            //获得随机字符
            ch = baseChar.charAt(random.nextInt(baseCharLength)) + "";
            sb.append(ch);
            //根据获得的角度计算弧度，然后旋转
            g.rotate(degree * Math.PI / 180, x, 25);
            //把得到的字符画在图片上
            g.drawString(ch, x, 25);
            //旋转回原来的位置
            g.rotate(-degree * Math.PI / 180, x, 25);
            //x坐标移动
            x += 30;
        }

        return sb.toString();
    }

}
