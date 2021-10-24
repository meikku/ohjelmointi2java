package demo.d6.rajapinta;

/**
 * @author meikk
 * @version 16.10.2021
 *
 */
public interface ElainRajapinta {
    
     /**
     * eläimen ääntelyä
     */
    void aantele();
    /**
     * @return eläimen tiedot muodossa "Miuku 18000"
     */
    
    @Override
    String toString();
}
