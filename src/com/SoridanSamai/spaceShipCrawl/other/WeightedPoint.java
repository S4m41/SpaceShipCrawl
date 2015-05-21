/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.SoridanSamai.spaceShipCrawl.other;

import java.awt.Point;

/**
 *
 * @author simlin329
 */
public class WeightedPoint extends Point{
    int weight = 0;

    public WeightedPoint(int x, int y) {
        super(x, y);
    }
    public WeightedPoint(Point p){
        super(p);
    }
    public void increaseWeight(int i){
        weight += i;
    }
    public void decreaseWeight(int i){
        weight -= i;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    boolean isHeavier(WeightedPoint p){
        return weight>p.weight;
    }
}
