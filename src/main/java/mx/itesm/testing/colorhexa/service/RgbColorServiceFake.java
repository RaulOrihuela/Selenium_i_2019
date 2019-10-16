package mx.itesm.testing.colorhexa.service;

import mx.itesm.testing.colorhexa.bean.RgbColor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RgbColorServiceFake implements IRgbColorService{
    private ArrayList<RgbColor> colors;

    public RgbColorServiceFake(){
        colors = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            RgbColor tempColor = new RgbColor();
            if (i == 0)tempColor.setR(255);
            if (i == 1)tempColor.setG(255);
            if (i == 2)tempColor.setB(255);
            tempColor.setId(i);
            colors.add(tempColor);
        }
        Random random = new Random();
        int items = random.nextInt(12);
        for (int i = 0; i < items; i++){
            RgbColor tempColor = new RgbColor(
                    random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)
            );
            tempColor.setId(i+3);
            colors.add(tempColor);
        }
    }

    public boolean rgbColor_C(RgbColor rgbColor) {
        rgbColor.setId(colors.get(colors.size()-1).getId()+1);
        colors.add(rgbColor);
        return true;
    }

    public RgbColor rgbColor_R(int id) {
        for (RgbColor temp : colors) {
            if (temp.getId() == id) return temp;
        }
        return null;
    }

    public ArrayList<RgbColor> rgbColor_RA() {
        return colors;
    }

    public boolean rgbColor_U(RgbColor rgbColor) {
        for (RgbColor temp : colors) {
            if (temp.getId() == rgbColor.getId()) {
                temp.setR(rgbColor.getR());
                temp.setG(rgbColor.getG());
                temp.setB(rgbColor.getB());
                return true;
            }
        }
        return false;
    }

    public boolean rgbColor_D(int id) {
        Iterator<RgbColor> iterator = colors.iterator();
        while (iterator.hasNext()){
            RgbColor temp = iterator.next();
            if (temp.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
