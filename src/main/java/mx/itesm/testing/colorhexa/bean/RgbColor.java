package mx.itesm.testing.colorhexa.bean;

import java.io.Serializable;

public class RgbColor implements Serializable {
    private int id, r, g, b;

    //===========================================
    //CONSTRUCTORS
    //===========================================
    public RgbColor(){
        r = 0;
        g = 0;
        b = 0;
    }
    public RgbColor(int R, int G, int B){
        this.r = R;
        this.g = G;
        this.b = B;
    }

    //===========================================
    //GETTERS & SETTERS
    //===========================================
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getR() { return r; }
    public void setR(int r) { this.r = r; }

    public int getG() { return g; }
    public void setG(int g) { this.g = g; }

    public int getB() { return b; }
    public void setB(int b) { this.b = b; }

    //===========================================
    //TO STRING
    //===========================================
    @Override
    public String toString() {
        return "RgbColor{" +
                "id=" + id +
                ", r=" + r +
                ", g=" + g +
                ", b=" + b +
                '}';
    }

    //===========================================
    //OTHERS
    //===========================================
    public String toHexColor(){
        String result = "";
        if (r <16) result += "0";
        result += Integer.toHexString(r);
        if (g <16) result += "0";
        result += Integer.toHexString(g);
        if (b <16) result += "0";
        result += Integer.toHexString(b);
        return result;
    }
}
