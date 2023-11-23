package cervantes.inventario.servicio;

import cervantes.inventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> listarProducto();

    public Producto buscarProductoPorId(Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public void eliminarProductoPorId(Integer idProducto);
}
