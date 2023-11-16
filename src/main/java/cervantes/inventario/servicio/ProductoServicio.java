package cervantes.inventario.servicio;

import cervantes.inventario.modelo.Producto;
import cervantes.inventario.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio {


    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Override
    public List<Producto> listarProducto() {
        this.productoRepositorio.findAll();

    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public void guardarProducto(Producto producto) {
        this.productoRepositorio.save(producto);

    }

    @Override
    public void eliminarProductoPorId(Integer idProducto) {

        this.productoRepositorio.deleteById(idProducto);
        
    }
}
