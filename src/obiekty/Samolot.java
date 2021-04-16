package obiekty;

public class Samolot extends Ruchome { // klasa samolot dziedziczy z klasy ruchome
    public Samolot(double wysokosc, int X, int Y, double predkoscX, double predkoscY) {
        super('<', wysokosc, X, Y, predkoscX, predkoscY); // dziedziczenie z klasy obiekty.Ruchome
    }
}
