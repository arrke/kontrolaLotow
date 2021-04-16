package obiekty;

public class Szybowiec extends Ruchome{ // klasa szybowiec dziedziczy z klasy ruchome

    public Szybowiec(double wysokosc, int X, int Y, double predkoscX, double predkoscY) {
        super('[', wysokosc, X, Y, predkoscX, predkoscY); // dziedziczenie z klasy obiekty.Ruchome
    }
}
