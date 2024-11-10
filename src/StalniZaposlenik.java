import java.math.BigDecimal;

public class StalniZaposlenik extends Zaposlenik{

    private BigDecimal bonus = BigDecimal.valueOf(0.15);

    public StalniZaposlenik(String imeZaposlenika, BigDecimal osnovnaPlaca, int brojRadnihSati) {
        super(imeZaposlenika, osnovnaPlaca, brojRadnihSati);
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    @Override
    public BigDecimal izracunPlace() {
        if (getBrojRadnihSati() > 160){
            BigDecimal iznosBonusa = getOsnovnaPlaca().multiply(this.bonus);
            BigDecimal placaSaBonusom = getOsnovnaPlaca().add(iznosBonusa);
            return placaSaBonusom;
        } else {
            return getOsnovnaPlaca();
        }
    }

    @Override
    public String imaBonus() {
        if (getBrojRadnihSati() > 160){
            return " i ostvario je bonus.";
        } else {
            return "i nema bonusa.";
        }
    }

    // zasad ne
    @Override
    public void ispisPodatakaZaposlenika() {
        System.out.println("Zaposlenik " + getImeZaposlenika() + " ima osnovnu placu " + getOsnovnaPlaca() + " eura");
        System.out.println("Zaposlenik " + getImeZaposlenika() + " je stalni zaposlenik");
        System.out.println("Zaposlenik " + getImeZaposlenika() + " je imao " + getBrojRadnihSati() + " radnih sati" + imaBonus());
        if (getBrojRadnihSati()>160){
            System.out.println("Nakon bonusa placa mu iznosi " + izracunPlace() + " eura ");
        }
    }
}
