package obiekty;

public class Ruchome extends Obiekt{ // klasa ruchome dziedziczy z klasy Obiekt
    //deklarowanie zmiennych
    private double predkoscX;
    private double predkoscY;

    public Ruchome(char symbol, double wysokosc, int X, int Y, double predkoscX, double predkoscY){ //konstruktor
        super(symbol,wysokosc,X,Y); // zaimplementowanie dziedziczenia z klasy obiekty.Obiekt
        this.predkoscX = predkoscX;
        this.predkoscY = predkoscY;
    }
    public double getPredkoscX() { //pobieranie prędkości współżędniej X i jej zwracanie
        return predkoscX;
    } // zwracanie prędkości
    public double getPredkoscY() { //pobieranie prędkości współżędniej Y i jej zwracanie
        return predkoscY;
    } // zwracanie prędkości 
    public void przesunObiekt(){ // przesunięcie obiektu o o wktory prędkości
        this.setPolozenieX((int) (this.getPolozenieX() + this.predkoscX));
        this.setPolozenieY((int) (this.getPolozenieY() + this.predkoscY));
    }
    public void zmienkierunek(double nowaPredkoscX, double nowaPredkoscY) // zmiana kierunku
    {
        this.predkoscX= nowaPredkoscX;
        this.predkoscY= nowaPredkoscY;
    }

    public boolean equals(Object obj) { // sprawdza czy obiekty są takie same
        if (obj == null) {
            return false; // zwraca false jeżeli nie są takie same
        }
        if (obj instanceof Ruchome) {
            Ruchome other = (Ruchome) obj;
            return getSymbol() == other.getSymbol() && //zwraca true jeżeli są takie same
                    getPolozenieY() == other.getPolozenieY() &&
                    getPolozenieX() == other.getPolozenieX() &&
                    getPredkoscX() == other.getPredkoscX() &&
                    getPredkoscY() == other.getPredkoscY() &&
                    getWysokosc() == other.getWysokosc() &&
                    getId() == other.getId();
        }
        return false;
    }
}