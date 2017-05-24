import com.jy.draw.graph.common.CanvasUtil;
import com.jy.draw.graph.tool.Circle;

public class CircleTest {

    public static void main(String[] args) {

        for (int i=0; i<1000; i++) {
            try {
                byte[][] source = CanvasUtil.randomCanvas(30, 30);
                final Circle circle = new Circle(source);
                //1.第一步寻找最大的正方形
                byte[][] square = circle.getMaxSquare(source);
                //填充线条
                circle.fillColor(square);
                //输出
                CanvasUtil.outputCanvasBytes(square);
            } catch (Exception e) {
                continue;
            }
            break;
        }
    }
}
