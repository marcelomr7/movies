package com.movies.movies;

import java.util.List;
import java.util.logging.Logger;

import com.movies.movies.datos.CargarDatos;
import com.movies.movies.modelo.Catalogo;
import com.movies.movies.modelo.EstadoAnimo;
import com.movies.movies.modelo.Pelicula;
import com.movies.movies.modelo.Producto;
import com.movies.movies.modelo.Usuario;
import com.movies.movies.utils.Utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	private final static Logger LOGGER = Logger.getLogger(AppTest.class.getName());

	private CargarDatos datos = new CargarDatos();
	private Usuario usuario1 = datos.usuarios.get(0);
	private Usuario usuario2 = datos.usuarios.get(1);
	private Usuario usuario3 = datos.usuarios.get(2);

	
    public AppTest( String testName )
    {
        super( testName );
    }
    
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testEsAntiguo()
    {
    	datos.cargarProductosViejos();
    	assertTrue(usuario1.esAntiguo());
    	assertTrue(usuario2.esAntiguo());
    	assertTrue(usuario3.esAntiguo());
    	
		LOGGER.info("Usuarios antiguos: "+datos.usuarios.size());
    }
    
    public void testEsModerno()
    {
    	datos.cargarProductosNuevos();
    	assertFalse(usuario1.esAntiguo());
    	assertFalse(usuario2.esAntiguo());
    	assertFalse(usuario3.esAntiguo());
    	
		LOGGER.info("Usuarios Modernos: "+datos.usuarios.size());
    }
    
    public void testInteresante()
    {
    	datos.cargarProductosInteresantes();
    	assertTrue(usuario1.algoInteresante());
    	assertTrue(usuario3.algoInteresante());
    	assertTrue(usuario2.algoInteresante());
    	
		LOGGER.info("Usuarios Interesantes: "+datos.usuarios.size());
    }
    
    public void testEsAburrido()
    {
    	datos.cargarProductosNoInteresantes();
    	assertFalse(usuario1.algoInteresante());
    	assertFalse(usuario3.algoInteresante());
    	assertFalse(usuario2.algoInteresante());
    	
    	LOGGER.info("Usuarios aburridos: "+datos.usuarios.size());
    }
    
    public void testCatalogo()
    {
    	datos.cargarProductos();
    	final Catalogo catalogo = datos.catalogo;
    	final List<Producto> productos = catalogo.getProductos();
    	assertEquals(productos.size(), 7);
    	
    	assertEquals(catalogo.getDocumentales().size(), 2);
    	assertEquals(catalogo.getDocumentalesNuevas().size(), 1);
    	assertEquals(catalogo.getDocumentalesViejas().size(), 1);
    	
    	assertEquals(catalogo.getPeliculas().size(), 3);
    	assertEquals(catalogo.getPeliculasNuevas().size(), 1);
    	assertEquals(catalogo.getPeliculasViejas().size(), 2);
    	
    	assertEquals(catalogo.getSeriesViejas().size(), 1);
    	
    	LOGGER.info("Productos cargados: "+productos.size());
    }
    
    public void testCatalogoDocumentales()
    {
    	datos.cargarProductos();
    	final Catalogo catalogo = datos.catalogo;
    	
    	final List<Producto> cortos = catalogo.getDocumentalesCortas();
    	final List<Producto> largos = catalogo.getDocumentalesLargas();
    	final List<Producto> mayoresDe10Anios = catalogo.getDocumentalesMayoresDe10Anios();

    	
    	assertEquals(cortos.size(), 1);
    	assertEquals(largos.size(), 1);
    	assertEquals(mayoresDe10Anios.size(), 0);
    	
    	verificarCorto(cortos);
    	verificarLargo(largos);
    	
    	LOGGER.info("Documentales cortos: "+cortos.size()+" Documentales Largos: "+largos.size());
    }
    
    public void testCatalogoSeries()
    {
    	datos.cargarProductos();
    	final Catalogo catalogo = datos.catalogo;
    	
    	final List<Producto> cortos = catalogo.getSeriesCortas();
    	final List<Producto> largos = catalogo.getSeriesLargas();
    	final List<Producto> mayoresDe10Anios = catalogo.getSeriesMayoresDe10Anios();

    	assertEquals(cortos.size(), 1);
    	assertEquals(largos.size(), 1);
    	assertEquals(mayoresDe10Anios.size(), 0);
    	
    	verificarCorto(cortos);
    	verificarLargo(largos);
    	
    	LOGGER.info("Series cortas: "+cortos.size()+" Series Largas: "+largos.size());

    }
    
    public void testCatalogoPeliculas()
    {
    	datos.cargarProductos();
    	final Catalogo catalogo = datos.catalogo;
    	
    	final List<Producto> cortos = catalogo.getPeliculasCortas();
    	final List<Producto> largos = catalogo.getPeliculasLargas();
    	final List<Producto> mayoresDe10Anios = catalogo.getPeliculasMayoresDe10Anios();
    	
    	
    	assertEquals(cortos.size(), 2);
    	assertEquals(largos.size(), 1);
    	assertEquals(mayoresDe10Anios.size(), 1);
    	
    	verificarCorto(cortos);
    	verificarLargo(largos);
    	verificarMayores10Anios(mayoresDe10Anios);
    	
    	LOGGER.info("Peliculas cortos: "+cortos.size()+" Peliculas Largos: "+largos.size()+" Peliculas Estreno mayor a 10 años: "+largos.size());

    }
    
    public void verificarCorto(List<Producto> productos) {
    	productos.stream().forEach(p->{
    		assertTrue(p.getDuracion()<=2D);
    	});
    }
    
    public void verificarLargo(List<Producto> productos) {
    	productos.stream().forEach(p->{
    		assertTrue(p.getDuracion()>2D);
    	});
    }
    
    public void verificarMayores10Anios(List<Producto> productos) {
    	productos.stream().forEach(p->{
        	assertTrue(p.getEstreno().before(Utils.menosAnios(10)));
    	});
    }
    
    public void testEstadoAnimo()
    {
    	datos.cargarProductos();
    	final List<Producto> tristes = datos.catalogo.getPeliculasPorEstadoAnimo(EstadoAnimo.TRISTE);
    	final List<Producto> melanco = datos.catalogo.getPeliculasPorEstadoAnimo(EstadoAnimo.MELANCOLICO);
    	final List<Producto> contento = datos.catalogo.getPeliculasPorEstadoAnimo(EstadoAnimo.CONTENTO);
    	
    	assertEquals(tristes.size(),1);
    	assertTrue(tristes.get(0).getDuracion()>2D);
    	assertTrue(tristes.get(0).esViejo());
    	assertTrue(tristes.get(0).esInteresante());


    	assertEquals(melanco.size(),1);
    	Pelicula peliculaMelan = (Pelicula)melanco.get(0);
    	assertTrue(peliculaMelan.getEstreno().before(Utils.menosAnios(10)));
    	assertEquals(peliculaMelan.getEstreno(), CargarDatos.ESTRENO_15_A);
    	assertEquals(peliculaMelan.getTitulo(),"EL REY LEON");
    	assertTrue(peliculaMelan.getDuracion()<2D);
    	assertFalse(peliculaMelan.esInteresante());
    	
    	assertTrue(peliculaMelan.getCantidadOscar()<1);
    	
    	assertEquals(contento.size(), 3);
    	
    	LOGGER.info("Peliculas Tristes: "+tristes.size()+" Peliculas Melancólicas: "+melanco.size());
    }
    
}
