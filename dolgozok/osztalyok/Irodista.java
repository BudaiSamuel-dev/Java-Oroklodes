package dolgozok.osztalyok;

import java.util.ArrayList;
import java.util.Arrays;

public class Irodista extends Dolgozo {

    private boolean ecdl;
    private ArrayList<String> beszeltNyelvek = new ArrayList<>();

    public Irodista(String nev, String szulDatum, String szulHely, String munkaviszonykezdete, boolean ecdl) {
        super(nev, szulDatum, szulHely, munkaviszonykezdete);
        this.ecdl = ecdl;
    }

    public boolean hasEcdl() {
        return ecdl;
    }

    public void setEcdl(boolean ecdl) {
        this.ecdl = ecdl;
    }

    public ArrayList<String> getBeszeltNyelvek() {
        return beszeltNyelvek;
    }

    public void addNyelv(String[] nyelvek){
        beszeltNyelvek.addAll(Arrays.asList(nyelvek));
    }


    @Override
    public String getInfo(){
        String info = "Irodista: " + super.getInfo();
        String vizsga = "";
        if (ecdl){
            vizsga = " ECDL vizsgával rendelkezik";
            info += vizsga;
        }


        String beszeltnyelvek = "";
        if (!beszeltNyelvek.isEmpty()){
            for (String nyelv : beszeltNyelvek){
                if (!beszeltnyelvek.isEmpty()){
                    beszeltnyelvek += ", " + nyelv;
                }else {
                    beszeltnyelvek += nyelv;
                }
            }
            info += String.format(" beszélt nyelvek: %s", beszeltnyelvek);
        }

        return info;
    }

    public String getJarulek(){
        int jarulek = 0;
        if (ecdl){
            jarulek += 3000;
        }

        jarulek += beszeltNyelvek.size() * 10000;

        return String.format("%s: %d Ft", nev, jarulek);
    }

}
