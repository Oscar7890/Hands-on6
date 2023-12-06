
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Punto> puntos = new ArrayList<>();
        // Agregar puntos de muestra
        puntos.add(new Punto(1, 2));
        puntos.add(new Punto(1.5, 1.8));
        puntos.add(new Punto(5, 8));
        puntos.add(new Punto(8, 8));
        puntos.add(new Punto(1, 0.6));
        puntos.add(new Punto(9, 11));
        puntos.add(new Punto(5, 10));
        
        int k = 5; // Número de clusters
        KMeans kMeans = new KMeans(k, puntos);
        kMeans.ejecutar(1000); // Máximo de iteraciones

        List<Punto> centroids = kMeans.getCentroides();
        for (int i = 0; i < centroids.size(); i++) {
            System.out.println("Centroide " + i + ": (X: " + centroids.get(i).getX() + ", Y:" + centroids.get(i).getY() + ")");
        }
    }
}
