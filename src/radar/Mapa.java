package radar;

import obiekty.Naziemne;
import obiekty.Obiekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mapa {
    private int width;
    private int height;
    private List<Obiekt> obiektyNieruchome;

    public Mapa(String nazwaPlikuMapy, String nazwaPlikuObiektow) throws FileNotFoundException {
        //Odczytywanie z plików wielkość mapy oraz wpisanie do niej obiektów nieruchomych
        obiektyNieruchome = new ArrayList<Obiekt>();
        Scanner odczytMapy = new Scanner(new File(nazwaPlikuMapy+".txt"));
        Scanner odczytObiektow = new Scanner(new File(nazwaPlikuObiektow+".txt"));
        this.width = odczytMapy.nextInt();
        this.height = odczytMapy.nextInt();
        while(odczytObiektow.hasNextLine()){
            obiektyNieruchome.add(new Naziemne(odczytObiektow.nextDouble(),odczytObiektow.nextInt(),odczytObiektow.nextInt()));
        }
        odczytMapy.close();
        odczytObiektow.close();
    }

    public int getWidth() { //pobieranie szerokości  mapy
        return width;
    }

    public int getHeight() { //pobieranie wysokośći mapy
        return height;
    }

    public List<Obiekt> getObiektyNieruchome() { //pobieranie obiektów nieruchomych
        return obiektyNieruchome;
    }

}
