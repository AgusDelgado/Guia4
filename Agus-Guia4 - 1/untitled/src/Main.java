import service.Libro;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Libro libro = new Libro();
        Libro libro2 = new Libro();

        System.out.println(libro.getAnioPublicacion().toString());

        List<Libro> libroList = new ArrayList<>();

        libro.setTitulo("pito");
        libro.setPrecio(39.00);
        libro.setAutor("Mati");
        libro.setAnioPublicacion(2021);
        libroList.add(libro);

        libro2.setTitulo("pito2");
        libro2.setPrecio(40.00);
        libro2.setAutor("Mati2");
        libro2.setAnioPublicacion(2022);
        libroList.add(libro2);

        System.out.println(libroList.toString());


        if(libroList.contains(libro)){ // busqueda por objeto
            System.out.println("el libro esta");
        }

        if(libroList.stream().filter(x -> x.getTitulo().equals("pito")).count() > 0){ // busqueda por titulo
            System.out.println("el libro esta");
        }

        int dondeEstaElLibro = libroList.indexOf(new Libro()); // busqueda por indice
        System.out.println("El libro esta en la posicion  " + dondeEstaElLibro);

        try{
            libroList.get(dondeEstaElLibro).setPrecio(100.0); // actualizacion de precio

        } catch (Exception exception){
            System.out.println("aca rompio");
            return;
        }

        System.out.println(libroList.toString());

        double precioTotal = libroList.stream()
                .mapToDouble(x -> x.getPrecio())
                .sum();

        System.out.println("EL precion total es  " + precioTotal);

        System.out.println("El numero de libros es  " + libroList.size());

        Libro libroCaro = libroList.stream()
                .max((x, y) -> Double.compare(x.getPrecio(), y.getPrecio()))
                .get();
        System.out.println("El libro mas caro es  " + libroCaro.toString());

        Libro libroBarato = libroList.stream()
                .min((x, y) -> Double.compare(x.getPrecio(), y.getPrecio()))
                .get();
        System.out.println("El libro mas barato es  " + libroBarato.toString());
    }

}


/*Supongamos que estás desarrollando un programa para gestionar una
tienda de libros. Cada libro tiene un título, un autor, un precio, y el año de
publicación. El programa debe permitir realizar las siguientes operaciones:
● Agregar un nuevo libro al inventario.
● Eliminar un libro del inventario.
● Mostrar todos los libros en el inventario.
● Buscar un libro por su título.
● Actualizar el precio de un libro.
● Calcular el precio total de todos los libros en el inventario.
● Contar el número total de libros en el inventario.
● Encontrar el libro más caro y el más barato en el inventario.
Pensar que estructuras de datos vista (ArrayList, LinkedList, Stack,
HashMap, etc.) nos conviene para implementar las operaciones anteriores.
Consideraciones adicionales:
- Crea una clase Libro que tenga atributos para el título, autor, precio y año
de publicación.
- Asegúrate de agregar validaciones de entrada para garantizar que los
datos ingresados por el usuario sean válidos.*/
