import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class KMeans {
    private int k;
    private List<Punto> puntos;
    private List<Punto> centroides;

    public KMeans(int k, List<Punto> puntos) {
        this.k = k;
        this.puntos = puntos;
        this.centroides = new ArrayList<>();

        inicializarCentroides();
    }

    private void inicializarCentroides() {
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int index = random.nextInt(this.puntos.size());
            Punto centroide = this.puntos.get(index);
            this.centroides.add(new Punto(centroide.getX(), centroide.getY()));
        }
    }

    public void ejecutar(int maxIteraciones) {
        int iteracion = 0;
        boolean converge = false;

        while (iteracion < maxIteraciones && !converge) {
            asignarPuntosAClusters();
            List<Punto> viejosCentroides = new ArrayList<>(this.centroides);
            actualizarCentroides();
            converge = this.centroides.equals(viejosCentroides);
            iteracion++;
        }
    }

    private void asignarPuntosAClusters() {
        for (Punto punto : puntos) {
            double distanciaMinima = Double.MAX_VALUE;
            int cluster = -1;

            for (int i = 0; i < k; i++) {
                double distancia = punto.distancia(this.centroides.get(i));
                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    cluster = i;
                }
            }

            punto.setCluster(cluster);
        }
    }

    private void actualizarCentroides() {
        for (int i = 0; i < k; i++) {
            double sumX = 0;
            double sumY = 0;
            int contador = 0;

            for (Punto punto : this.puntos) {
                if (punto.getCluster() == i) {
                    sumX += punto.getX();
                    sumY += punto.getY();
                    contador++;
                }
            }

            if (contador > 0) {
                double newX = sumX / contador;
                double newY = sumY / contador;
                this.centroides.set(i, new Punto(newX, newY));
            }
        }
    }

    public List<Punto> getPuntos() {
        return this.puntos;
    }

    public List<Punto> getCentroides() {
        return this.centroides;
    }

}
