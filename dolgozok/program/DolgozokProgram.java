package dolgozok.program;

import dolgozok.osztalyok.Dolgozo;
import dolgozok.osztalyok.Irodista;
import dolgozok.osztalyok.Szerelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;

public class DolgozokProgram {

    private static final File FILE_OUT = new File("C:\\Dev\\FeladatForrasok\\BudaiS\\szuperauto-szerelok.txt");

    static void main(String[] args) {

        ArrayList<Dolgozo> dolgozok = new ArrayList<>();

        Szerelo szerelo1 = new Szerelo("Varga Péter", "1980.02.11.", "Eger", "2015.10.01.", true);
        dolgozok.add(szerelo1);
        Szerelo szerelo2 = new Szerelo("Toldi Ernő", "1988.12.09.", "Siklós", "2020.01.01.", false);
        dolgozok.add(szerelo2);
        Szerelo szerelo3 = new Szerelo("Kovács Lajos", "1973.10.07.", "Budapest", "2020.04.15.", true);
        dolgozok.add(szerelo3);
        Szerelo szerelo4 = new Szerelo("Tollár Emil", "1997.03.01.", "Budapest", "2017.05.15.", true);
        dolgozok.add(szerelo4);
        Szerelo szerelo5 = new Szerelo("Poór Pál", "1985.05.28.", "Pécs", "2019.07.01.", true);
        dolgozok.add(szerelo5);

        Irodista irodista1 = new Irodista("Kiss Emese", "1988.12.09.", "Pécs", "2018.07.01.", true);
        irodista1.addNyelv(new String[]{"angol", "német"});
        dolgozok.add(irodista1);
        Irodista irodista2 = new Irodista("Nagy Ivett", "1996.06.19.", "Villány", "2018.09.01.", true);
        dolgozok.add(irodista2);
        Irodista irodista3 = new Irodista("Szabó Anna", "2001.01.30.", "Pécs", "2023.11.15.", false);
        irodista3.addNyelv(new String[]{"angol"});
        dolgozok.add(irodista3);

        System.out.printf("%d dolgozó van nyílvántartva.\n", dolgozok.size());

        //Az instanceof működése
        System.out.printf("szerelo1 instanceof Szerelo -> %b\n", szerelo1 instanceof Szerelo);
        System.out.printf("szerelo1 instanceof Dolgozo -> %b\n", szerelo1 instanceof Dolgozo);
        System.out.printf("szerelo1 instanceof Object -> %b\n", szerelo1 instanceof Object);

        System.out.printf("Osztálynév: %s\n", szerelo1.getClass().getName());


        System.out.println("\nDolgozók:");
        for(Dolgozo dolgozo : dolgozok){
            System.out.println("\t-" + dolgozo.getInfo());
        }

        try {
            FileWriter fileWriter = new FileWriter(FILE_OUT);

            for (Dolgozo dolgozo : dolgozok){
                if (dolgozo instanceof Szerelo){
                    fileWriter.write(dolgozo.getInfo()+"\n");
                }
            }

            fileWriter.flush();
            fileWriter.close();
            System.out.printf("\nA fájl kiírásra került. Hely: %s\n \n", FILE_OUT.getAbsoluteFile().toString());
        } catch (IOException e) {
            System.out.println("A fájl kiírása sikertelen!");
        }


        for (Dolgozo dolgozo : dolgozok){
            if (dolgozo instanceof Irodista){
                System.out.println(((Irodista) dolgozo).getJarulek());
            }
        }
    }
}
