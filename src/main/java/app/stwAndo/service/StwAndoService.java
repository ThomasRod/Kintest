package app.stwAndo.service;

public interface StwAndoService {

    /**
     * Return Swt when i is multiple of 3, Ando when its a multiple of 5
     * and SwtAndo when its both.
     *
     * @param i
     * @return String "Swt" or "Ando" or "SwtAndo"
     */
    String buildStwAndo(Integer i);
}
