public class Studenci {
    private String nazwisko;
    private String imie;
    private String kierunek;
    private int semestr;
    private String przedmiot;
    private String grupa;

    public Studenci(String nazwisko, String imie, String kierunek, int semestr, String przedmiot, String grupa) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.kierunek = kierunek;
        this.semestr = semestr;
        this.przedmiot = przedmiot;
        this.grupa = grupa;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getKierunek() {
        return kierunek;
    }

    public int getSemestr() {
        return semestr;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public String getGrupa() {
        return grupa;
    }
    // zamiana int na string aby pobrac go z tabeli i wpisac do pola, przy zaznaczaniu rekordu w tabeli
    public String getSemestr_string()
    {
        String sem=new Integer(semestr).toString();
        return sem;
    }
}
