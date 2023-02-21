


package Modelo;


public class LineaProducto {
    private int idLinea;
    private String descripcion;


    public LineaProducto (int idLinea, String descripcion) {
        this.idLinea = idLinea;
        this.descripcion = descripcion;
    }

    public LineaProducto() {
    }

    public int getidLinea() {
        return idLinea;
    }

    public void setidLinea(int idLinea) {
        this.idLinea=idLinea;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  descripcion;
    }

    
    
}

