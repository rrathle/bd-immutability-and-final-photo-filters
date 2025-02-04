package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.Objects;

/**
 * Represents a single point in an image. Each pixel has a location in the image, and an associated RGB color.
 */
public final class Pixel {
    //1. make the class final
    //2. make the instance variables final
    //3 check constructors for reference parameters and replace assignments with defensive copy
    //4. make sure any references returned are defensive return
    //5. ensure that there are no setters in the class
    //6. modify the existing code so no instance variables are changed
    private final int x;
    private final int y;
    private final RGB rgb;

    //constructor is recieving a reference RGB defesnive copy
    public Pixel(int x, int y, RGB rgb) {
        this.x = x;
        this.y = y;
        //this.rgb = rgb;
        this.rgb = new RGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), rgb.getTransparency());
    }

    //method that returns a reference so defensive return
    public RGB getRGB() {
        //return rgb;
        return new RGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), rgb.getTransparency());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, rgb);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Pixel pixel = (Pixel) obj;

        return pixel.x == this.x && pixel.y == this.y &&
           Objects.equals(pixel.rgb, this.rgb);
    }
}
