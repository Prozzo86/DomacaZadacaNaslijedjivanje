import java.math.BigDecimal;

// Koristim apstraktnu klasu jer nece moci koristiti apstraktne metode u protivnom
public abstract class Zaposlenik {

    private String imeZaposlenika;
    private BigDecimal osnovnaPlaca;
    private int brojRadnihSati;

    public Zaposlenik(String imeZaposlenika, BigDecimal osnovnaPlaca, int brojRadnihSati) {
        this.imeZaposlenika = imeZaposlenika;
        this.osnovnaPlaca = osnovnaPlaca;
        this.brojRadnihSati = brojRadnihSati;
    }

    public String getImeZaposlenika() {
        return this.imeZaposlenika;
    }

    public void setImeZaposlenika(String imeZaposlenika) {
        this.imeZaposlenika = imeZaposlenika;
    }

    public BigDecimal getOsnovnaPlaca() {
        return this.osnovnaPlaca;
    }

    public void setOsnovnaPlaca(BigDecimal osnovnaPlaca) {
        this.osnovnaPlaca = osnovnaPlaca;
    }

    public int getBrojRadnihSati() {
        return brojRadnihSati;
    }

    public void setBrojRadnihSati(int brojRadnihSati) {
        this.brojRadnihSati = brojRadnihSati;
    }

    // Koristim apstraktne metode zbog polimorfizma i razlicitog outputa
    public abstract BigDecimal izracunPlace();

    public abstract String imaBonus();
    public abstract void ispisPodatakaZaposlenika();

}
