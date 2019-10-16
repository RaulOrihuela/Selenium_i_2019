package mx.itesm.testing.colorhexa.service;

import mx.itesm.testing.colorhexa.bean.RgbColor;

import java.util.ArrayList;

public interface IRgbColorService {
    boolean rgbColor_C(RgbColor rgbColor);
    RgbColor rgbColor_R(int id);
    ArrayList<RgbColor> rgbColor_RA();
    boolean rgbColor_U (RgbColor rgbColor);
    boolean rgbColor_D(int id);
}