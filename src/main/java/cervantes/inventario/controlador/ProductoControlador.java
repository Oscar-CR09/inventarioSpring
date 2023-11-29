package cervantes.inventario.controlador;

import cervantes.inventario.excepcion.RecursoNoEncontradoExcepcion;
import cervantes.inventario.modelo.Producto;
import cervantes.inventario.servicio.ProductoServicio;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //localhost:8080//inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    //http://localhost:8080/inventario-app/prouctos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProducto();

        logger.info("Productos obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));

        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar : "+ producto);
        return  this.productoServicio.guardarProducto(producto);

    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable int id){
        Producto producto =
                this.productoServicio.buscarProductoPorId(id);

        if (producto!= null){

            return ResponseEntity.ok(producto);
        }else {
            throw  new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }

    }


}
