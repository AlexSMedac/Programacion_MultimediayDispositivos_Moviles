package tema5.listaseries;

public class Series {
    private String titulo;
    private String genero;
    private int imagen; // recurso drawable

    public Series(String titulo, String genero, int imagen) {
        this.titulo = titulo;
        this.genero = genero;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getImagen() {
        return imagen;
    }
}
