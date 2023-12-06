class Punto {
    private double x;
    private double y;
    private int cluster;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        this.cluster = -1; // Inicialmente no pertenece a ningún cluster
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public double distancia(Punto other) {
        return Math.sqrt(Math.pow((x - other.getX()), 2) + Math.pow((y - other.getY()), 2));
    }
}
