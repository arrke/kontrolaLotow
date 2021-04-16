package radar;

import obiekty.*;
import java.util.ArrayList;
import java.util.List;

public class Radar{
    // deklarowanie listy, mapy oraz radaru
    private List<Obiekt> obiekty;
    private Mapa mapa;

    public Radar(Mapa m) {
        mapa = m;
        obiekty = new ArrayList<>();
        Object[] zMapy = mapa.getObiektyNieruchome().toArray();
        for (Object nieruchomyZMapy : zMapy) {
            obiekty.add((Naziemne) nieruchomyZMapy); //dodanie nieruchomych obiektów do Listy
        }
    }

    public void usunObiekt(Obiekt o) {
        obiekty.remove(o); // usunięcie obiektu
    }

    public void dodajObiekt(Obiekt o) {
        obiekty.add(o); // dodanie obiektu
    }

    public boolean sprawdzKolizje(Obiekt obiekt1, Obiekt obiekt2){ // sprawdza czy dwa obiekty nie kolidują ze sobą
        int roznicaX = Math.abs(obiekt1.getPolozenieX() - obiekt2.getPolozenieX());
        int roznicaY = Math.abs(obiekt1.getPolozenieY() - obiekt2.getPolozenieY());
        if(obiekt1 instanceof Naziemne && obiekt1.getWysokosc() > obiekt2.getWysokosc()
                && roznicaX == 1 &&
                roznicaY == 1){
            return true;
        }
        if(obiekt2 instanceof Naziemne && obiekt2.getWysokosc() > obiekt1.getWysokosc()
                && roznicaX == 1 &&
                roznicaY == 1){
            return true;
        }
        double roznicaWysokosci = Math.abs(obiekt1.getWysokosc() - obiekt2.getWysokosc());
        if(roznicaWysokosci < 10 &&
                roznicaX == 1 &&
                roznicaY == 1)
            return true;
        else return false;
    }

    public void pokazRadar() { //wypisanie radaru w kąsoli
        char[][] tmp = new char[mapa.getWidth()][mapa.getHeight()];
        String wiersz;
        for(Obiekt o: obiekty) {
            if(o.getPolozenieX()>=mapa.getWidth()
                    || o.getPolozenieY() >= mapa.getHeight()
                    || o.getPolozenieY() <0
                    || o.getPolozenieX() <0) continue;
            else tmp[o.getPolozenieX()][o.getPolozenieY()] = o.getSymbol();
        }
            for (int i = 0; i < mapa.getWidth(); i++) {
                wiersz = "";
                for (int j = 0; j < mapa.getHeight(); j++) {
                    if (tmp[i][j] == 0) wiersz+= "-";
                    else wiersz += tmp[i][j];
                }
                System.out.println(wiersz);
            }
        }

    public void pokazRadar(Obiekt ruchomy) { //wypisywanie radaru z pokazanyą kolizją 
        char[][] tmp = new char[mapa.getWidth()][mapa.getHeight()];
        String wiersz;
            for(Obiekt o: obiekty) {
                if(o.getPolozenieX()>=mapa.getWidth()
                        || o.getPolozenieY() >= mapa.getHeight()
                        || o.getPolozenieY() <0
                        || o.getPolozenieX() <0) continue;
                else tmp[o.getPolozenieX()][o.getPolozenieY()] = o.getSymbol();
            }
            // sygnalizowanie kolizji
        for (int i = 0; i < mapa.getWidth(); i++) {
            wiersz = "";
            for (int j = 0; j < mapa.getHeight(); j++) {

                if(tmp[i][j] == 0){
                    if(i >= ruchomy.getPolozenieX()-1
                            && i <= ruchomy.getPolozenieX()+1
                            && j >= ruchomy.getPolozenieY()-1
                            && j <= ruchomy.getPolozenieY()+1
                            && (i != ruchomy.getPolozenieX() || j != ruchomy.getPolozenieY())){
                        wiersz+= "*";
                    }
                    else wiersz+= "-";
                }
                else wiersz += tmp[i][j];
            }
            System.out.println(wiersz);
        }
    }

    public void odswiez() { // odświerzenie mapy
        for (Obiekt o : obiekty) {
            if(o.getPolozenieX()>=mapa.getWidth()
                    || o.getPolozenieY() >= mapa.getHeight()
                    || o.getPolozenieX() <0
                    || o.getPolozenieY() <0 ){
                usunObiekt(o);
                break;
            }
            o.przesunObiekt();
        }
    }

    public Obiekt getObiekt(String id){
        for(Obiekt o: obiekty){
            if(o.getId().equals(id)){
                return o;
            }
        }
        return null;
    }

    public List<Obiekt> getObiekty() {
        return obiekty;
    }

    public int getMapaWidth() {
        return mapa.getWidth();
    }

    public int getMapaHeight() {
        return mapa.getHeight();
    }
}
