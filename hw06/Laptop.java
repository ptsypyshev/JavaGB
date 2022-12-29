package hw06;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/** Represents a Laptop object.
* @author ptsypyshev
* @version 1.0
*/
public class Laptop {
    private CPU Cpu;
    private int RAMSizeGB;
    private int DiskSizeGB;
    private String DiskType;
    private int DisplaySizeInch;
    private String DisplayType;
    private String Color;
    private String OS;
    private double PriceRUR;

    /** Creates a Laptop object with the specified parameters.
    * @param CPU The name of CPU.
    * @param RAMSizeGB The vendor manufacturer.
    * @param DiskSizeGB The amount cores of CPU.    
    * @param DiskType The name of CPU.
    * @param DisplaySizeInch The vendor manufacturer.
    * @param DisplayType The amount cores of CPU.    
    * @param Color The name of CPU.
    * @param OS The vendor manufacturer.
    * @param PriceRUR The amount cores of CPU.
    */
    public Laptop(CPU CPU, int RAMSizeGB, int DiskSizeGB, String DiskType, int DisplaySizeInch, String DisplayType, String Color, String OS, double PriceRUR) {
        this.Cpu = CPU;
        this.RAMSizeGB = RAMSizeGB;
        this.DiskSizeGB = DiskSizeGB;
        this.DiskType = DiskType;
        this.DisplaySizeInch = DisplaySizeInch;
        this.DisplayType = DisplayType;
        this.Color = Color;
        this.OS = OS;
        this.PriceRUR = PriceRUR;
    }

    /** Gets the CPU information.
    * @return the CPU object
    */
    public CPU getCPU() {
        return this.Cpu;
    }

    /** Gets the RAM size information.
    * @return the RAM size
    */
    public int getRAMSizeGB() {
        return this.RAMSizeGB;
    }

    /** Gets the Disk size information.
    * @return the Disk size
    */
    public int getDiskSizeGB() {
        return this.DiskSizeGB;
    }

    /** Gets the Disk type information.
    * @return the Disk type
    */
    public String getDiskType() {
        return this.DiskType;
    }

    /** Gets the Display type information.
    * @return the Display type
    */
    public int getDisplaySizeInch() {
        return this.DisplaySizeInch;
    }

    /** Gets the Display type information.
    * @return the Display type
    */
    public String getDisplayType() {
        return this.DisplayType;
    }

    /** Gets the color information.
    * @return the color of Laptop
    */
    public String getColor() {
        return this.Color;
    }

    /** Gets the operating system information.
    * @return the operating system of Laptop
    */
    public String getOS() {
        return this.OS;
    }

    /** Gets the price information.
    * @return the price of Laptop in RUR
    */
    public double getPriceRUR() {
        return this.PriceRUR;
    }

    /** Checks the CPU Vendor.
    * @param vendor The vendor manufacturer
    * @return       is CPU produced by vendor (boolean)
    */
    public boolean hasCpuVendor(String vendor) {
        return this.Cpu.getVendor().toLowerCase().equals(vendor.toLowerCase());
    }

    /** Checks the OS.
    * @param OS The operating system to check
    * @return       checking result (boolean)
    */
    public boolean hasOS(String OS) {
        return this.getOS().toLowerCase().equals(OS.toLowerCase());
    }

    /** Checks that CPU has more or equal cores as in argument.
    * @param cores  cores of CPU
    * @return       checking result (boolean)
    */
    public boolean hasMoreOrEqualsCores(int cores) {
        return this.getCPU().getCores() >= cores;
    }

    /** Checks that Laptop has more or equal RAM size as in argument.
    * @param ram  RAM size
    * @return       checking result (boolean)
    */
    public boolean hasMoreOrEqualsRAM(int ram) {
        return this.getRAMSizeGB() >= ram;
    }

    /** Checks that Laptop has more or equal Disk size as in argument.
    * @param diskSize  Disk size
    * @return       checking result (boolean)
    */
    public boolean hasMoreOrEqualsDiskSize(int diskSize) {
        return this.getDiskSizeGB() >= diskSize;
    }

    /** Checks the max Laptop price.
    * @param maxPrice   Price limit (max)
    * @return       checking result (boolean)
    */
    public boolean cheaperThenMaxPrice(double maxPrice) {
        return this.getPriceRUR() <= maxPrice;
    }

    @Override
    public String toString() {
        return String.format("Laptop %s / %d GB RAM / %d GB %s / %s = %.2f RUR",
            this.Cpu,
            this.RAMSizeGB,
            this.DiskSizeGB,
            this.DiskType,
            this.OS,
            this.PriceRUR);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Laptop)) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return this.Cpu.equals(laptop.Cpu) && this.RAMSizeGB == laptop.RAMSizeGB && this.DiskSizeGB == laptop.DiskSizeGB && this.OS.equals(laptop.OS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cpu, RAMSizeGB, DiskSizeGB, DiskType, OS);
    }

    // Some lists with predefined values to generate laptop
    private static List<Integer> ramSizes = Arrays.asList(4, 6, 8, 12, 16, 32);
    private static List<String> diskTypes = Arrays.asList("HDD", "SSD", "NVMe");
    private static List<Integer> diskSizes = Arrays.asList(128, 256, 512, 1024, 2048);
    private static List<String> displayTypes = Arrays.asList("TN", "MVA", "IPS");
    private static List<Integer> displaySizes = Arrays.asList(10, 12, 13, 14, 15, 17);
    private static List<String> colorList = Arrays.asList("Black", "White", "Silver", "Blue", "Red");
    private static List<String> OSList = Arrays.asList("NoOS", "FreeDOS", "Linux", "Windows");

    /** Generates a Laptop with different parameters (random).
    * @return       A Laptop object
    */
    public static Laptop generateLaptop() {
        Random r = new Random();
        CPU cpu = CPU.GetRandomCPU();
        int RAMSizeGB = ramSizes.get(r.nextInt(ramSizes.size()));
        int DiskSizeGB = diskSizes.get(r.nextInt(diskSizes.size()));
        String DiskType = diskTypes.get(r.nextInt(diskTypes.size()));
        int DisplaySizeInch = displaySizes.get(r.nextInt(displaySizes.size()));
        String DisplayType = displayTypes.get(r.nextInt(displayTypes.size()));
        String Color = colorList.get(r.nextInt(colorList.size()));
        String OS = OSList.get(r.nextInt(OSList.size()));
        double PriceRUR = r.nextDouble(0.2, 1) * 100000;
        return new Laptop(cpu, RAMSizeGB, DiskSizeGB, DiskType, DisplaySizeInch, DisplayType, Color, OS, PriceRUR);
    }
}
