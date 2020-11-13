package ba.unsa.etf.rpr.tutorijal02;
import java.util.Objects;
public class Interval {
  private double pocetna;
  private double krajnja;
  private boolean pocetnaPripada;
  private boolean krajnjaPripada;

    public Interval(double pocetna, double krajnja, boolean pocetnaPripada, boolean krajnjaPripada) {
        if (krajnja < pocetna)
            throw new IllegalArgumentException();
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.pocetnaPripada = pocetnaPripada;
        this.krajnjaPripada = krajnjaPripada;
    }
    public Interval(){
        this.pocetna=0;
        this.krajnja=0;
        this.pocetnaPripada=false;
        this.krajnjaPripada=false;
    }

    public boolean isNull(){
        if(this.pocetna==0 && this.krajnja==0)
            return true;
        return false;
    }
    public boolean isIn(double tacka){
        if(tacka>=pocetna && tacka<=krajnja){
            if(tacka==krajnja && !krajnjaPripada) {}
            else
            return true;}
        return false;
    }
   /* public Boolean isKrajnjaPripada() {
        return krajnjaPripada;
    }
    public Boolean isPocetnaPripada() {
        return pocetnaPripada;
    }*/
    public static Interval intersect(Interval i, Interval i2) {
        Interval temp;
        if(Double.compare(i.getPocetna(),i2.getKrajnja()) > 0)
        {
            temp=i;
            i=i2;
            i2=temp;
        }
        temp = new Interval(0,0,false,false);
        if(Double.compare(i.getPocetna(),i2.getPocetna())<=0 && Double.compare(i2.getKrajnja(),i.getKrajnja())<=0 ){
            temp.setPocetnaPripada(i2.isPocetnaPripada());
            temp.setKrajnjaPripada(i2.isKrajnjaPripada());
            temp.setKrajnja(i2.krajnja);
            temp.setPocetna(i2.pocetna);

        }else if(Double.compare(i.getKrajnja(),i2.getKrajnja())<0 && Double.compare(i.getPocetna(),i2.getKrajnja())<0){
            temp.setPocetna(i2.getPocetna());
            temp.setKrajnja(i.getKrajnja());
            temp.setPocetnaPripada(i2.isPocetnaPripada());
            temp.setKrajnjaPripada(i.isKrajnjaPripada());
        }
        if(Double.compare(i2.getPocetna(), i.getPocetna()) == 0){
            temp.setPocetnaPripada(i.pocetnaPripada && i2.pocetnaPripada);
        }
        if( Double.compare(i.getKrajnja(),i2.getKrajnja())==0 ){
            temp.setKrajnjaPripada(i.krajnjaPripada && i2.krajnjaPripada);
        }

        return temp;
    }

    public Interval intersect(Interval i)
    {
        Interval temp=intersect(this, i);
        this.pocetna=temp.pocetna;
        this.krajnja=temp.krajnja;
        this.pocetnaPripada = temp.pocetnaPripada;
        this.krajnjaPripada = temp.krajnjaPripada;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;

        Interval interval = (Interval) o;

        if (interval.getPocetna() == this.getPocetna()&&interval.getKrajnja() == this.getKrajnja() && interval.isPocetnaPripada()== this.isPocetnaPripada() &&interval.isKrajnjaPripada()== this.isKrajnjaPripada())
         return  true;
        else return false;

    }

    @Override
    public String toString() {
        if(isNull()) return "()";
        String output="";
        if (pocetnaPripada)output+="[";
        else output+="(";
        output+=pocetna+","+krajnja;
        if(krajnjaPripada)output+="]";
        else output+=")";
        return output;
    }

    public double getPocetna() {
        return pocetna;
    }

    public double getKrajnja() {
        return krajnja;
    }

    public boolean isPocetnaPripada() {
        return pocetnaPripada;
    }

    public boolean isKrajnjaPripada() {
        return krajnjaPripada;
    }

    public void setPocetna(double pocetna) {
        this.pocetna = pocetna;
    }

    public void setKrajnja(double krajnja) {
        this.krajnja = krajnja;
    }

    public void setPocetnaPripada(boolean pocetnaPripada) {
        this.pocetnaPripada = pocetnaPripada;
    }

    public void setKrajnjaPripada(boolean krajnjaPripada) {
        this.krajnjaPripada = krajnjaPripada;
    }
}


