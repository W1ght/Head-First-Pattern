package com.wight.facade;

/**
 * @author wight
 * @date 2021/11/15
 * @apiNote
 */
public class Projector {
    String description;
    DvdPlayer dvdPlayer;

    public Projector(String description, DvdPlayer dvdPlayer) {
        this.description = description;
        this.dvdPlayer = dvdPlayer;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void wideScreenMode() {
        System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
    }

    public void tvMode() {
        System.out.println(description + " in tv mode (4x3 aspect ratio)");
    }

    @Override
    public String toString() {
        return description;
    }
}
