package dolgozok.osztalyok;

public class Szerelo extends Dolgozo{

    private boolean szakvizsga;

    public Szerelo(String nev, String szulDatum, String szulHely, String munkaviszonykezdete, boolean szakvizsga) {
        super(nev, szulDatum, szulHely, munkaviszonykezdete);
        this.szakvizsga = szakvizsga;
    }

    public boolean hasSzakvizsga() {
        return szakvizsga;
    }

    public void setSzakvizsga(boolean szakvizsga) {
        this.szakvizsga = szakvizsga;
    }

    @Override
    public String getInfo(){
        String s = "Szerelő: " + super.getInfo();

        String ertek = szakvizsga ? " szakvizsgával rendelkezik" : " nem rendelkezik szakvizsgával";
        s+=ertek;
        return s;
    }
}
