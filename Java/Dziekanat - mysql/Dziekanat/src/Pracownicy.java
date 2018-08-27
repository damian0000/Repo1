public class Pracownicy 
{
    private String ID;
    private String nazwisko;
    private String imie;
    private String telefon;
    private String ulica;
    private String miejscowosc;
    private String przedmiot;

    public String getID() {
        return ID;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getUlica() {
        return ulica;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public Pracownicy(String ID, String nazwisko, String imie, String telefon, String ulica, String miejscowosc, String przedmiot) {
        this.ID = ID;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.telefon = telefon;
        this.ulica = ulica;
        this.miejscowosc = miejscowosc;
        this.przedmiot = przedmiot;
    }

}
