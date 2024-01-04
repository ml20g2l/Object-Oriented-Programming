import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

public class Circle implements Writeable{

    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter(){
        return  Math.PI * 2 * radius;
    }

    @Override
    public void writeTo(Writer destination) throws IOException {
        destination.write(String.format(Locale.US,"Circle: r=%.4f\n", radius));
        destination.flush();
    }
}
