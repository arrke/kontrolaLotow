package obiekty;

public class Balon extends Ruchome // klasa balon dziedziczy z klasy ruchome
{
    public Balon(double wysokosc, int X, int Y, double predkoscX, double predkoscY) {
        super('o', wysokosc, X, Y, predkoscX, predkoscY); // dziedziczenie z klasy obiekty.Ruchome
    }
}
