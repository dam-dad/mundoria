package dad.mundoria.model;

import java.util.Random;

/**
 * Representa un dado con un número específico de caras. 
 * Este dado puede ser lanzado para obtener un valor aleatorio dentro del rango de caras.
 */
public class Dado {

    private int caras;
    private Random random;

    /**
     * Constructor que inicializa el dado con un número determinado de caras.
     * 
     * @param caras El número de caras del dado.
     */
    public Dado(int caras) {
        super();
        this.caras = caras;
        this.random = new Random();
    }

    /**
     * Lanza el dado y devuelve un valor aleatorio entre 1 y el número de caras del dado.
     * 
     * @return El valor aleatorio obtenido al lanzar el dado.
     */
    public int lanzar() {
        return random.nextInt(caras) + 1;
    }

    /**
     * Obtiene el número de caras del dado.
     * 
     * @return El número de caras del dado.
     */
    public int getCaras() {
        return caras;
    }
}
