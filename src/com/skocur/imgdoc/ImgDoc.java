package com.skocur.imgdoc;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ImgDoc {

    private int width;
    private int height;
    private String fileName;

    private ImgDoc(int width, int height, String fileName) {
        this.width = width;
        this.height = height;
        this.fileName = fileName;
    }

    public void draw(Class<?> obj) {
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 45);
        graphics2D.setFont(font);

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2D = img.createGraphics();

        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_DITHERING,
                RenderingHints.VALUE_DITHER_ENABLE);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_PURE);
        graphics2D.setFont(font);

        FontMetrics fontMetrics = graphics2D.getFontMetrics();

        // To have white background
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setColor(Color.BLACK);

        int fontY = fontMetrics.getAscent();

        if (obj.isAnnotationPresent(Draw.class)) {
            Annotation annotation = obj.getAnnotation(Draw.class);
            Draw drawAnnotation = (Draw) annotation;

            graphics2D.drawString(obj.getSimpleName(),width / 3, fontY);

            font = new Font("Arial", Font.PLAIN, 24);
            graphics2D.setFont(font);

            graphics2D.setColor(Color.DARK_GRAY);

            graphics2D.drawString(drawAnnotation.author(), width / 3, fontY += graphics2D.getFontMetrics().getHeight());
            graphics2D.drawString(drawAnnotation.version(), width / 3, fontY += graphics2D.getFontMetrics().getHeight());
            graphics2D.drawString(drawAnnotation.description(), width / 3, fontY += graphics2D.getFontMetrics().getHeight());

            graphics2D.setColor(Color.BLACK);
        }

        int splitter = 0;

        List<Integer> yCordsOfFont = new ArrayList<>();

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Draw.class)) {
                Annotation annotation = method.getAnnotation(Draw.class);
                Draw drawAnnotation = (Draw) annotation;

                font = new Font("Arial", Font.PLAIN, 35);
                graphics2D.setFont(font);

                int fontX = 0;

                if (splitter % 2 != 0) {
                    fontX = width - (width / 2) + 20;
                }

                if (splitter % 2 == 0) {
                    yCordsOfFont.add(fontY += graphics2D.getFontMetrics().getHeight());

                    for (int i = 0; i < 4; ++i) {
                        yCordsOfFont.add(fontY += graphics2D.getFontMetrics().getHeight());
                    }
                }

                graphics2D.setColor(Color.BLACK);
                graphics2D.drawString(method.getName() + "()", fontX, yCordsOfFont.get(0));

                font = new Font("Arial", Font.PLAIN, 24);
                graphics2D.setFont(font);

                graphics2D.setColor(Color.DARK_GRAY);
                graphics2D.drawString("returns: " + method.getReturnType(), fontX, yCordsOfFont.get(1));

                graphics2D.drawString(drawAnnotation.author(), fontX, yCordsOfFont.get(2));
                graphics2D.drawString(drawAnnotation.version(), fontX, yCordsOfFont.get(3));

                boolean areCordsUpdated = false;

                if (drawAnnotation.description().length() >= 50) {
                    List<String> subStrings = new ArrayList<>();
                    int endIndex = 50;
                    
                    for (int i = 0; i < drawAnnotation.description().length() / 50; ++i) {
                        subStrings.add(drawAnnotation.description().substring(endIndex - 50, endIndex));
                        endIndex += 50;
                    }

                    int tempYCords = yCordsOfFont.get(4);
                    for (String text : subStrings) {
                        graphics2D.drawString(text, fontX, tempYCords);
                        tempYCords += graphics2D.getFontMetrics().getHeight();
                    }

                    if (splitter % 2 != 0) {
                        yCordsOfFont.set(0, tempYCords + 30);
                        for (int i = 1; i <= 4; ++i) {
                            yCordsOfFont.set(i, yCordsOfFont.get(i) + tempYCords);
                        }

                        areCordsUpdated = true;
                    }
                } else {
                    graphics2D.drawString(drawAnnotation.description(), fontX, yCordsOfFont.get(4) + 30);
                }

                if (splitter % 2 != 0 && !areCordsUpdated) {
                    yCordsOfFont.set(0, fontY += graphics2D.getFontMetrics().getHeight() + 30);

                    for (int i = 1; i <= 4; ++i) {
                        yCordsOfFont.set(i, fontY += graphics2D.getFontMetrics().getHeight());
                    }
                }

                splitter++;
            }
        }

        graphics2D.dispose();

        try {
            ImageIO.write(img, "png", new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DocBuilder {

        private int tempWidth = 1000;
        private int tempHeight = 1000;
        private String tempFileName = "default.png";

        public DocBuilder setWidth(int width) {
            this.tempWidth = width;
            return this;
        }

        public DocBuilder setHeight(int height) {
            this.tempHeight = height;
            return this;
        }

        public DocBuilder setPNGFileName(String fileName) {
            this.tempFileName = fileName;
            return this;
        }

        public ImgDoc init() {
            return new ImgDoc(tempWidth, tempHeight, tempFileName);
        }
    }
}