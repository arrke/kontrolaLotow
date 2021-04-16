import obiekty.*;
import radar.*;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args){
        String nazwaPlikuZMapa;
        String nazwaPlikuZNieruchomymi;
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj nazwe pliku z mapą bez rozszerzenia pliku:");
        nazwaPlikuZMapa = in.next();
        System.out.print("Podaj nazwe pliku z obiektami bez rozszerzenia pliku:");
        nazwaPlikuZNieruchomymi = in.next();
        try{
            Mapa m = new Mapa(nazwaPlikuZMapa, nazwaPlikuZNieruchomymi);
            Radar glowny = new Radar(m);

            Random generator = new Random();
            for(int i = 0; i<= generator.nextInt(15); i++){
                if(i % 3 == 2){
                    glowny.dodajObiekt(new Balon(generator.nextInt(50)
                            , generator.nextInt(glowny.getMapaWidth())
                            , generator.nextInt(glowny.getMapaHeight())
                            , generator.nextInt(10)
                            , generator.nextInt(10)));
                }
                if(i == 1 || i < 3){
                    glowny.dodajObiekt(new Samolot(generator.nextInt(50)
                            , generator.nextInt(glowny.getMapaWidth())
                            , generator.nextInt(glowny.getMapaHeight())
                            , generator.nextInt(15)
                            , generator.nextInt(15)));
                }
                else{
                    glowny.dodajObiekt(new Szybowiec(generator.nextInt(50)
                            , generator.nextInt(glowny.getMapaWidth())
                            , generator.nextInt(glowny.getMapaHeight())
                            , generator.nextInt(15)
                            , generator.nextInt(15)));
                }
            }
            glowny.dodajObiekt(new Smiglowiec(90,1,1,1,1));
            glowny.dodajObiekt(new Smiglowiec(130,10,20,2,0));
            System.out.println("WCZYTYWANIE SYSTEMU KONTROLI LOTÓW ..............");
            if(glowny.getObiekty().size() != m.getObiektyNieruchome().size()){
                new Reminder(1, glowny);
            }
            else System.out.println("Brak obiektow ruchomych na radarze.");
        }
        catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}

class Reminder{
    Timer timer;
    Radar r;

    public Reminder(int seconds, Radar r) {
        this.r = r;
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000, 2 * 1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            clearConsole();
            System.out.println("Literką D zaznaczone są obiekty naziemne, zaś kolejno:\n" +
                    "< - samolot, " +
                    "x - smiglowiec, " +
                    "o - balon, " +
                    "[ - szybowiec");
            r.odswiez();
            for (int i = 0; i < r.getObiekty().size(); i++) {
                for (int j = i + 1; j < r.getObiekty().size(); j++) {
                    if (!r.getObiekty().get(i).equals(r.getObiekty().get(j))) {
                        if (r.sprawdzKolizje(r.getObiekty().get(i), r.getObiekty().get(j))) {
                            if (r.getObiekty().get(j) instanceof Ruchome) {
                                try{r.pokazRadar(r.getObiekty().get(j));}
                                catch(NoSuchElementException e){
                                    System.err.print(e.getMessage());
                                }
                                zapobiegnij((Ruchome) r.getObiekty().get(j));
                            } else if (r.getObiekty().get(i) instanceof Ruchome) {
                                r.pokazRadar(r.getObiekty().get(i));
                                zapobiegnij((Ruchome) r.getObiekty().get(i));
                            }
                            continue;
                        }
                    }
                }
            }
            r.pokazRadar();
        }

    }

    public final static void clearConsole() {
        for (int i = 0; i < 45; ++i) System.out.println();
    }


    public Obiekt zapobiegnij(Ruchome r) {
        System.err.println("UWAGA NASTĄPI KOLIZJA.\n" +
                "Przewidziana została kolizja nadchodząca w najbliższym czasie." +
                " Zaznaczono na radarze przy obiekcie ruchomym sfera zagrożenia(*)\n" +
                " ZMIEN TRASE OBIEKTU O ID:" + r.getId());
        Scanner in = new Scanner(System.in);
        double nowaPredkoscX;
        double nowaPredkoscY;
        System.err.println("Ustal nową predkość X:");
        nowaPredkoscX = in.nextInt();
        System.err.println("Ustal nową predkość Y:");
        nowaPredkoscY = in.nextInt();
        r.zmienkierunek(nowaPredkoscX, nowaPredkoscY);
        return r;
    }
}



