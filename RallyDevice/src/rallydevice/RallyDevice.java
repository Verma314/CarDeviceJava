
package rallydevice;

/**
 *
 * @author A. Verma
 */
public class RallyDevice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        new Navigator().setVisible(true);
       
        Thread.sleep(3000);
        
        }catch (Exception ex) {}
    }
    
}
