
package Modelo;

/**
 *
 * @author Leonardo
 */
public class DetalleVenta {
    private int numeroDocumento;
    private int codigoArticulo;
    private String nomArticulo;
    private double precioVenta;
    private int cantidad;
    private double iva;
    private double sinIva;
    private double porcentajeDescuento;
    private double totalDescuento;
    private double total;

    public DetalleVenta(int numeroDocumento, int codigoArticulo, String nomArticulo, double precioVenta, int cantidad, double iva, double sinIva, double porcentajeDescuento, double totalDescuento, double total) {
        this.numeroDocumento = numeroDocumento;
        this.codigoArticulo = codigoArticulo;
        this.nomArticulo = nomArticulo;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.iva = iva;
        this.sinIva = sinIva;
        this.porcentajeDescuento = porcentajeDescuento;
        this.totalDescuento = totalDescuento;
        this.total = total;
    }
    

    public DetalleVenta() {
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNomArticulo() {
        return nomArticulo;
    }

    public void setNomArticulo(String nomArticulo) {
        this.nomArticulo = nomArticulo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSinIva() {
        return sinIva;
    }

    public void setSinIva(double sinIva) {
        this.sinIva = sinIva;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
