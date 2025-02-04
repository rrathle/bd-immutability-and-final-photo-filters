package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class representing a PrimePhoto - contains dimensions, and a list of Pixels that make up the image.
 */
public final class PrimePhoto {
    //1. make the class final
    //2. make the instance variables final
    //3 check constructors for reference parameters and replace assignments with defensive copy
    //4. make sure any references returned are defensive return
    //5. ensure that there are no setters in the class
    //6. modify the existing code so no instance variables are changed
    private final List<Pixel> pixels;
    private final int height;
    private final int width;
    // used when saving to a buffered image
    private final int type;

    //constructor contains a refernce parameter-List is a parameter- so a defensive copy needs to happen
    public PrimePhoto(List<Pixel> pixelList, int height, int width, int type) {
        if (pixelList.size() != (height * width)) {
            throw new IllegalArgumentException("Not enough pixels for the dimensions of the image.");
        }
        this.pixels = new ArrayList<>(pixelList); //copy the parameter into our variable
        this.height = height;
        this.width = width;
        this.type = type;
    }

    //this returns a reference list is an object whihc is an reference
    public List<Pixel> getPixels() {

        //return pixels;
        return new ArrayList<>(pixels);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pixels, height, width, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PrimePhoto photo = (PrimePhoto) obj;

        return photo.height == this.height && photo.width == this.width &&
            photo.type == photo.type && Objects.equals(photo.pixels, this.pixels);
    }

}
