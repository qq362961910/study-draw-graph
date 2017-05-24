import com.jy.draw.graph.common.CanvasUtil;
import com.jy.draw.graph.tool.Circle;

public class CircleTest {

    private static final Circle circle = new Circle();

    public static void main(String[] args) {
        byte[][] source = CanvasUtil.randomCanvas(10, 10);
        //1.第一步寻找最大的正方形
        byte[][] square = circle.getMaxSquare(source);
        //填充线条
        circle.fillColor(square);
        //输出
        CanvasUtil.outputCanvasBytes(square);
    }
}
