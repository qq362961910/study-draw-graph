package com.jy.draw.graph.tool;

import com.jy.draw.graph.common.Color;
import com.jy.draw.graph.entity.Pix;

public class Circle {

    /**
     * 半径
     * */
    private int radius;

    /**
     * 圆心
     * */
    private Pix center;

    /**
     * 画布
     * */
    private byte[][] canvas;

    /**
     * 二位数组中获取最大的正方形
     * 圆的解析式为：(x-a)²+(y-b)²=r²
     * 其中，（a，b）为圆心坐标，r为半径。----都为已知数。因此，只要再（知道x，就可求对应y值）。即可得圆上（点的坐标）。
     * */
    public byte[][] getMaxSquare(byte[][] source) {
        if (source == null || source.length == 0) {
            return new byte[0][];
        }
        //寻找最小的边长,假设子数组长度一致
        int length = source.length;
        int width = source[0].length;
        if (length == width) {
            return source;
        }
        int squareLength = length;
        if (squareLength > width) {
            squareLength = width;
        }
        return new byte[squareLength][squareLength];
    }

    /**
     * 在正方形中计算圆形最大的半径
     * 不能以中心到达顶点的距离为半径，因为那样就超出了数组能表示的圆形,应以中心到边距为半径
     * 计算的起始位置应当从左上角,即(0,0)
     * */
    public int calculateRadius(byte[][] square) {
        //在数组中的表现形式为square[radius][radius]
        // 假设横向长度是７个,此时中心点index应该为3, (7-1)/2，成立
        // 假设横向长度是８个,此时中心点index应该为3, (8-1)/2，成立
        return (square.length + 1) / 2;
    }

    /**
     * 在正方形中填充圆形颜色
     * */
    public void fillColor(byte[][] square) {
        for (int x = 0; x < radius; x++) {
            int y = getYpointByX(x);
            //downleft
            square[y][x] = Color.BLACK.getValue();
            //upleft
            square[center.getY() *2 - y - 1][x] = Color.BLACK.getValue();
            //downright
            square[y][radius * 2 - 1 - x] = Color.BLACK.getValue();
            //upright
            square[center.getY() *2 - y - 1][radius * 2 - 1 - x] = Color.BLACK.getValue();

        }
    }

    /**
     * 圆的解析式为：(x-a)²+(y-b)²=r²
     * */
    public int getYpointByX(int x) {
        int radiusSquare = radius * radius;
        int widthRange = x - center.getX();
        int widthRangeSquare = widthRange * widthRange;
        int heightRangeSquare = radiusSquare - widthRangeSquare;
        int heightRange = (int)Math.sqrt(heightRangeSquare);
        int y = heightRange + center.getY();
        return y;
    }


    public Circle(byte[][] canvas) {
        this.canvas = canvas;
        this.radius = calculateRadius(canvas);
        this.center = new Pix(this.radius, this.radius);
    }
}
