package com.jy.draw.graph.common;

public class CanvasUtil {

    public static byte[][] randomCanvas(int maxwidth, int maxHeight) {
        int width = DigitalUtil.randomInt(3, maxwidth);
        int height = DigitalUtil.randomInt(3, maxHeight);
        System.out.println("width: " + width + ", height: " + height);
        return new byte[height][width];
    }

    public static void outputCanvasBytes(byte[][] bytes) {
        if (bytes != null && bytes.length > 0) {
            for (int i=0; i<bytes.length; i++) {
                byte[] line = bytes[i];
                for (int k=0; k<line.length; k++) {
                    System.out.print(line[k]);
                    System.out.print("  ");
                }
                System.out.println();
            }
        }
    }

}
