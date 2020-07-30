package ua.fortop.fa;

import android.content.SharedPreferences;

public class DataClass {

    private SharedPreferences sharedPreferences;
    private int value = 100, onClick = 1;
    private int lvl1Price = 200, lvl2Price, lvl3Price, lvl4Price, lvl5Price;

    public int getValue() {
        return value;
    }

    public int getOnClick() {
        return onClick;
    }

    public int getLvl1Price() {
        return lvl1Price;
    }

    public int getLvl2Price() {
        return lvl2Price;
    }

    public int getLvl3Price() {
        return lvl3Price;
    }

    public int getLvl4Price() {
        return lvl4Price;
    }

    public int getLvl5Price() {
        return lvl5Price;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setOnClick(int onClick) {
        this.onClick = onClick;
    }

    public void setLvl1Price(int lvl1Price) {
        this.lvl1Price = lvl1Price;
    }

    public void setLvl2Price(int lvl2Price) {
        this.lvl2Price = lvl2Price;
    }

    public void setLvl3Price(int lvl3Price) {
        this.lvl3Price = lvl3Price;
    }

    public void setLvl4Price(int lvl4Price) {
        this.lvl4Price = lvl4Price;
    }

    public void setLvl5Price(int lvl5Price) {
        this.lvl5Price = lvl5Price;
    }

    public static void main(String[] args) {

    }
    public void rr() {
    }
}
