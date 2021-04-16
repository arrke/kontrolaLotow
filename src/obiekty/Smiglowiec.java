package obiekty;

public class Smiglowiec extends Ruchome { // klasa śmiglowiec dziedziczy z klasy Ruchome
    public Smiglowiec(double wysokosc, int X, int Y, double predkoscX, double predkoscY) {
        super('x', wysokosc, X, Y, predkoscX, predkoscY); // dziedziczenie z klasy obiekty.Ruchome
    }
}
