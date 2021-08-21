import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testMain() throws Exception {}

    @Test 
    public void testMetodo1() {
        App prueba = new App();
        assertEquals("0.0", Double.toString(prueba.metodo1()));
    }
    
    @Test 
    public void testMetodo2() {
        App prueba = new App();
        assertEquals("1.1", Double.toString(prueba.metodo2()));
    }
        
    @Test 
    public void testMetodo3() {
        App prueba = new App();
        assertEquals("M", prueba.metodo3());
    }

    @Test 
    public void testMetodo4() {
        App prueba = new App();
        assertEquals("Uninorte", prueba.metodo3());
    }
}
