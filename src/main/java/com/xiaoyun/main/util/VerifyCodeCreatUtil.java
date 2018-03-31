package com.xiaoyun.main.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class VerifyCodeCreatUtil {
    private static VerifyCodeCreatUtil instance;

    private VerifyCodeCreatUtil() {
    }

    public static VerifyCodeCreatUtil getInstance() {
        if (instance == null) {
            instance = new VerifyCodeCreatUtil();
        }
        return instance;
    }

    public HashMap<String, Object> getVerifyCode() throws IOException {
        String s = "0123456789";
        String sRand = "";
        synchronized (sRand) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            int width = 50;
            int height = 20;
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_3BYTE_BGR);
            Graphics g = image.getGraphics();
            Random random = new Random();
            g.setColor(getRandColor(200, 255));
            g.fillRect(0, 0, width, height);
            g.setColor(getRandColor(0, 100));
            g.drawRect(0, 0, width - 1, height - 1);
            g.setColor(getRandColor(100, 150));
            /* for (int i = 0; i < 1; i++) { */

            /* int x = random.nextInt(width); */

            /* int y = random.nextInt(height); */

            /* int x1 = random.nextInt(width) + 10; */

            /* int y1 = random.nextInt(height) + 10; */

            /* g.drawLine(x, y, x1, y1); */

            /* } */

            g.setColor(getRandColor(160, 200));
            for (int i = 0; i < 20; i++) {
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                g.drawLine(x, y, x, y);
            }

            int length = 4;

            for (int i = 0; i < length; i++) {
                String ch = null;
                ch = String.valueOf(s.charAt(random.nextInt(s.length())));
                sRand += ch;
                g.setColor(new Color(20 + random.nextInt(120), 20 + random.nextInt(120), 20 + random.nextInt(150)));
                g.setFont(new Font("宋体", random.nextInt(1) + 1, random.nextInt(4) + 14));

                g.drawString(ch, 10 * i + 8, random.nextInt(3) * i + 12);
            }
            g.dispose();

            ByteArrayOutputStream baOut = new ByteArrayOutputStream();

            ImageIO.write(image, "jpg", baOut);

            /* JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baOut); */

            /* encoder.encode(image); */

            byte[] b = baOut.toByteArray();
            map.put("sRand", sRand);
            map.put("bImage", b);
            return map;
        }
    }

    public Color getRandColor(int lower, int upper) {
        Random random = new Random();
        if (upper > 255)
            upper = 255;
        if (upper < 1)
            upper = 1;
        if (lower < 1)
            lower = 1;
        if (lower > 255)
            lower = 255;
        int r = lower + random.nextInt(upper - lower);
        int g = lower + random.nextInt(upper - lower);
        int b = lower + random.nextInt(upper - lower);
        return new Color(r, g, b);
    }
}
