import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dataset {

    private List<Double> data;

    public Dataset(String filename) throws IOException {
        data = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));
        while ( in.hasNextDouble() ) {  // Read until end-of-file.
            double inputNumber = in.nextDouble();
            data.add( inputNumber );
        }

    }

    public int size() {
        return data.size();
    }

    public double meanValue() {

        if (size() == 0){
            throw new ArithmeticException();
        }
        return data.stream().mapToDouble(Double::doubleValue).sum() / size();
    }
}
