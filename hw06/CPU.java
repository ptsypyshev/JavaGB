package hw06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Represents a CPU object.
* @author ptsypyshev
* @version 1.0
*/
public class CPU {
    private String Name;
    private String Vendor;
    private int Cores;

    /** Creates a CPU object with the specified name, vendor and cores information.
    * @param Name The name of CPU.
    * @param Vendor The vendor manufacturer.
    * @param Cores The amount cores of CPU.
    */
    public CPU(String Name, String Vendor, int Cores) {
        this.Name = Name;
        this.Vendor = Vendor;
        this.Cores = Cores;
    }

    /** Gets the name of CPU.
    * @return A string representing the name of CPU
    */
    public String getName() {
        return this.Name;
    }

    /** Gets the vendor manufacturer.
    * @return A string representing the vendor manufacturer
    */
    public String getVendor() {
        return this.Vendor;
    }

    /** Gets the amount cores of CPU.
    * @return A string representing the amount cores of CPU
    */
    public int getCores() {
        return this.Cores;
    }

    @Override    
    public String toString() {
        return this.Name;
    }

    /** List of predefined CPUs
    * Can be used to create random CPU
    */
    private static final List<CPU> cpuList = new ArrayList<CPU>(){{
        add(new CPU("Intel Core i3 1115G4 3.0GHz", "Intel", 2));
        add(new CPU("Intel Core i5 1155G7 2.5GHz", "Intel", 4));
        add(new CPU("Intel Core i7 12700H 2.3GHz", "Intel", 14));
        add(new CPU("AMD Ryzen 3 3250U 2.6GHz", "AMD", 2));
        add(new CPU("AMD Ryzen 5 5500U 2.1GHz", "AMD", 6));
        add(new CPU("AMD Ryzen 7 5825U 2.0GHz", "AMD", 8));
    }};

    /** Returns random picked CPU from cpuList
    * @return   An CPU object
    */
    public static CPU GetRandomCPU() {
        Random r = new Random();
        return cpuList.get(r.nextInt(cpuList.size()));
    }
}
