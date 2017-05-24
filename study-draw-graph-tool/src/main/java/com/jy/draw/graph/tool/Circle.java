package com.jy.draw.graph.tool;

import com.jy.draw.graph.common.Color;
import com.jy.draw.graph.entity.Pix;

public class Circle {
    /**
     * 二位数组中获取最大的正方形
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
        return (square.length - 1) / 2;
    }

    /**
     * 在正方形中填充圆形颜色
     * */
    public void fillColor(byte[][] square) {
        int radius = calculateRadius(square);
        //1.圆心在(radius, radius), 首先画上下左右边上的四个顶点
        boolean isEven = square.length%2 == 0;
        if(isEven) {
            int UpX = radius;
            int UpY = 0;
            int rightX = radius * 2 + 1;
            int rightY = radius;
            int DownX = radius;
            int DownY = radius * 2 + 1;
            int leftX = 0;
            int leftY = radius;
            fillEvenColor(square, new Pix(UpX, UpY), new Pix(rightX, rightY), new Pix(DownX, DownY), new Pix(leftX, leftY));
        }
        else {
            int UpX = radius;
            int UpY = 0;
            int rightX = radius * 2;
            int rightY = radius;
            int DownX = radius;
            int DownY = radius * 2;
            int leftX = 0;
            int leftY = radius;
            fillOddColor(square, new Pix(UpX, UpY), new Pix(rightX, rightY), new Pix(DownX, DownY), new Pix(leftX, leftY));
        }
    }

    /**
     * 当像素个数为偶数
     * */
    public void fillEvenColor(byte[][] square, Pix up, Pix right, Pix down, Pix left) {
        //顶端两个点
        square[up.getY()][up.getX()] = Color.BLACK.getValue();
        square[up.getY()][up.getX() + 1] = Color.BLACK.getValue();
        //右侧两个点
        square[right.getY()][right.getX()] = Color.BLACK.getValue();
        square[right.getY() + 1][right.getX()] = Color.BLACK.getValue();
        //下侧两个点
        square[down.getY()][down.getX()] = Color.BLACK.getValue();
        square[down.getY()][down.getX() + 1] = Color.BLACK.getValue();
        //左侧两个点
        square[left.getY()][left.getX()] = Color.BLACK.getValue();
        square[left.getY() + 1][left.getX()] = Color.BLACK.getValue();
        //2.根据已有顶点寻找两点之间的顶点
    }
    /**
     * 当像素个数为偶数
     * */
    public void fillOddColor(byte[][] square, Pix up, Pix right, Pix down, Pix left) {
        //顶端一个点
        square[up.getY()][up.getX()] = Color.BLACK.getValue();
        //右侧两个点
        square[right.getY()][right.getX()] = Color.BLACK.getValue();
        //下侧两个点
        square[down.getY()][down.getX()] = Color.BLACK.getValue();
        //左侧两个点
        square[left.getY()][left.getX()] = Color.BLACK.getValue();
    }

}
