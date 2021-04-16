package obiekty;

import java.util.UUID;

public abstract class Obiekt {
    //zadeklarowanie zmiennych
    private char symbol;
    private double wysokosc;
    private int polozenieX;
    private int polozenieY;
    private String id;
    public Obiekt(char symbol, double wysokosc, int X, int Y) { //konstruktor
        this.id = UUID.randomUUID().toString();;
        this.symbol = symbol;
        this.wysokosc = wysokosc;
        this.polozenieX = X;
        this.polozenieY = Y;
    }

    public char getSymbol() { // pobieranie symbolu i jego zwracanie

        return this.symbol;
    }
    public double getWysokosc() { //pobieranie wysokości i jej zwracanie

        return wysokosc;
    }

    public int getPolozenieX() { //pobieranie położenia na X i jej zwracanie
        return polozenieX;
    } // pobieranie położenia na X

    public int getPolozenieY() {  //pobieranie położenia na Y i jej zwracanie
        return polozenieY;
    } // pobieranie położenia na Y

    public String getId() { //pobieranie identyfikator i jego zwracanie
        return id;
    } // pobieranie id obiektu

    public void setPolozenieX(int polozenieX) {
        this.polozenieX = polozenieX;
    } //ustawienie nowego położenia na X

    public void setPolozenieY(int polozenieY) {
        this.polozenieY = polozenieY;
    } //ustawienie nowego położenia na Y

    public abstract void przesunObiekt(); //przesuwanie obiektu

    public boolean equals(Object obj) { // sprawdza czy obiekty są takie same
        if (obj == null) {
            return false; // zwraca falsse jeżeli nie są
        }
        if (obj instanceof Obiekt) {
            Obiekt other = (Obiekt) obj;
            return getSymbol() == other.getSymbol() && // zwraca prawdę jeżeli wszystkie atrybuty się zgadzają
                    getPolozenieY() == other.getPolozenieY() &&
                    getPolozenieX() == other.getPolozenieX() && getWysokosc()==other.getWysokosc() && getId().equals(other.getId());
        }
        return false;
    }
}
