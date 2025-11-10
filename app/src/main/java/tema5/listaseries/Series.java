package tema5.listaseries;
public class Series {
    private String titulo;
    private String genero;
    private int imagen;
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
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
