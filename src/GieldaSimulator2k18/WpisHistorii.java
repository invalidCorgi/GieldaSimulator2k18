/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GieldaSimulator2k18;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author wojtekreg
 */
public class WpisHistorii implements Serializable{
    private LocalDateTime czas;
    private double kurs;

    public WpisHistorii(LocalDateTime czas, double kurs) {
        this.czas = czas;
        this.kurs = kurs;
    }

    /**
     * Gets czas
     *
     * @return czas
     */
    public LocalDateTime getCzas() {
        return czas;
    }

    /**
     * Gets kurs
     *
     * @return kurs
     */
    public double getKurs() {
        return kurs;
    }
}
