package com.company;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Main {

    public static void main(String[] args) {


            BufferedImage image = null;

            try {

                image = ImageIO.read(new File("example.png"));
                System.out.println("Loading is successful");
            }

            catch (Exception e) {
                System.out.println(e.getMessage());
            }


            int width = image.getWidth();
            int height = image.getHeight();


            Pixel[][] pixel = new Pixel[height][width];


            // Making 2D array that represent the pixels.
            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {

                    int red = (image.getRGB(j, i) >> 24) & 0xff;
                    int green = (image.getRGB(j, i) >> 16) & 0xff;
                    int blue = (image.getRGB(j, i)) & 0xff;
                    pixel[i][j] = new Pixel(red, blue, green);
                }
            }


            Thread1 th1= new Thread1(pixel);
            th1.run();


        }


    }


