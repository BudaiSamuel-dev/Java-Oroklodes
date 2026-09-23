package dolgozok.osztalyok;

public class Dolgozo {

    protected String nev;
    protected String szulDatum;
    protected String szulHely;
    protected String munkaviszonykezdete;

    public Dolgozo(String nev, String szulDatum, String szulHely, String munkaviszonykezdete) {
        this.nev = nev;
        this.szulDatum = szulDatum;
        this.szulHely = szulHely;
        this.munkaviszonykezdete = munkaviszonykezdete;
    }

    public String getNev() {
        return nev;
    }

    public String getSzulDatum() {
        return szulDatum;
    }

    public String getSzulHely() {
        return szulHely;
    }

    public String getMunkaviszonykezdete() {
        return munkaviszonykezdete;
    }

    public String getInfo(){
        return String.format("%s (%s)", nev, munkaviszonykezdete);
    }
}
