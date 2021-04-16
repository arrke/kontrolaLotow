package obiekty;

public class Naziemne extends Obiekt{

    public Naziemne(double wysokosc, int x, int y)
    {
        super('D',wysokosc,x,y); //zaimplementowanie dziedziczenia z klasy Obiekt
    }

    @Override
    public void przesunObiekt() //przesuniecie obiektu naziemnego
    {

    }
}
