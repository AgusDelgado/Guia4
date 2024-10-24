package service;

public class Persona {
    private String nombre;
    private Integer edad;
    private String dni;
    private char sexo;
    private Double peso;
    private Integer altura;

    private static final char sexoPorDefecto = 'H';
    private static final Integer sobrepeso = 1;
    private static final Integer pesoIdeal = 0;
    private static final Integer bajoPeso = -1;


    // Contructores
    public Persona (){}

    public Persona(String nombre, Integer edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = 'H';
    }

    public Persona(String nombre, Integer edad, String dni, char sexo, Double peso, Integer altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    //Metodos

    public String calcularIMC(){
        double imc = peso / (altura * altura);
        if (imc < 20){
            return bajoPeso + "Estas debajo de tu peso ideal";
        } else if (imc >= 20 && imc <= 25) {
            return pesoIdeal + "Estas en tiu peso ideal";
        } else {
            return sobrepeso + "Tenes sobrepeso";
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public char comprobarSexo (char sexo) {
        if ( sexo == 'H' || sexo == 'M' ){
            return sexo ;
        } else {
            return sexoPorDefecto;
        }
    }


    public String toSting() {
        return "Persona{" +
                "nombre='" + nombre +
                ", edad=" + edad +
                ", dni='" + dni  +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura;
    }

    public String generaDni(){

    }
}


/*Haz una clase llamada Persona que siga las siguientes condiciones:
 - Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso
 y altura. No queremos que se accedan directamente a ellos. Piensa
 que modificador de acceso es el más adecuado, también su tipo. Si
 quieres añadir algún atributo puedes hacerlo.
 - Por defecto, todos los atributos menos el DNI serán valores por
 defecto según su tipo (0 números, cadena vacía para String, etc.).
 Sexo sera hombre por defecto, usa una constante para ello.
 - Se implantaran varios constructores:
 ■ Un constructor por defecto.
 ■ Un constructor con el nombre, edad y sexo, el resto por
 defecto.
 ■ Un constructor con todos los atributos como parámetro.
 - Los métodos que se implementarán son:
 ➢ calcularIMC(): calculará si la persona está en su peso ideal
 (peso en kg/(altura^2 en m)), si esta fórmula devuelve un valor
 menor que 20, la función devuelve un -1, si devuelve un número
 entre 20 y 25 (incluidos), significa que está por debajo de su
 peso ideal la función devuelve un 0 y si devuelve un valor mayor
 que 25 significa que tiene sobrepeso, la función devuelve un 1.
 Te recomiendo que uses constantes para devolver estos
 valores.
 esMayorDeEdad(): indica si es mayor de edad, devuelve un
booleano.
➢ comprobarSexo(char sexo): comprueba que el sexo introducido
es correcto. Si no es correcto, será H. No será visible al exterior.
➢ toString(): devuelve toda la información del objeto.
➢ generaDNI(): genera un número aleatorio de 8 cifras, genera a
partir de este su número su letra correspondiente. Este método
será invocado cuando se construya el objeto. Puedes dividir el
método para que te sea más fácil. No será visible al exterior.
➢ Métodos set de cada parámetro, excepto de DNI.
Ahora, crea una clase ejecutable que haga lo siguiente:
- Pide por teclado el nombre, la edad, sexo, peso y altura.
- Crea 3 objetos de la clase anterior, el primer objeto obtendrá las
anteriores variables pedidas por teclado, el segundo objeto obtendrá
todos los anteriores menos el peso y la altura y el último por defecto,
para este último utiliza los métodos set para darle a los atributos un
valor.*/