
package com.SoridanSamai.spaceShipCrawl.world;

import com.SoridanSamai.spaceShipCrawl.Reference;
import java.io.*;
import java.util.*;

/**
 *
 * @author petmeu239
 */
public class MapReader {
    

    public static byte[][] read(String filename) {
        try {
            ArrayList<String> list = new ArrayList();
            InputStreamReader isr = new InputStreamReader(MapReader.class.getResourceAsStream(Reference.RECOURCE_PATH.getPath()+ filename));
            BufferedReader br = new BufferedReader(isr);
            while (br.ready()) {
                list.add(br.readLine());
            }
            int w = list.get(1).length();
            int h = list.size();
            byte[][] arr = new byte[w][h];
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    arr[x][y] = (list.get(y).charAt(x) == '1') ? (byte) 1 : (byte) 0;
                }
            }
            return arr;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        int i = (int) (3*Math.random());
        byte[][] arr = MapReader.read("level"+i+".txt");
        System.out.println(arr.length);
    }
}
