package edu.ncsu.monopoly;
//pruebas git
public abstract class Card {

    public final static int TYPE_CHANCE = 1;
    public final static int TYPE_CC = 2;

    public abstract String getLabel();
    public abstract void applyAction();
    public abstract int getCardType();
}
