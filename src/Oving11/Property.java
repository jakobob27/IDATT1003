package Oving11;

public class Property {
    private int munNum;
    private String munName;
    private int lnr;
    private int snr;
    private String bName;
    private float area;
    private String nameOwner;

    public Property(int munNum, String munName, int lnr, int snr, float area, String nameOwner) {
        if (munNum>5054||munNum<101||lnr<1||snr<1||area<=0) {
            throw new IllegalArgumentException();
        }
        this.munNum=munNum;
        this.munName=munName;
        this.lnr=lnr;
        this.snr=snr;
        this.area=area;
        this.nameOwner=nameOwner;
    }

    public Property(int munNum, String munName, int lnr, int snr, String bName, float area, String nameOwner) {
        this(munNum, munName, lnr, snr, area, nameOwner);
        this.bName=bName;
    }

    public int getLnr() {
        return lnr;
    }

    public float getArea() {
        return area;
    }

    public int getSnr() {
        return snr;
    }

    public int getMunNum() {
        return munNum;
    }

    public String getbName() {
        return bName;
    }

    public String getMunName() {
        return munName;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    @Override
    public String toString() {
        return munNum+"-"+lnr+"/"+snr;
    }
}
