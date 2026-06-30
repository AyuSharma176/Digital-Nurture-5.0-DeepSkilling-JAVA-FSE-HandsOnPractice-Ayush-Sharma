public class BuilderPatternDemo {
    public static void main(String[] args) {

        // Basic configuration using defaults
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB")
                .build();
        System.out.println(basicComputer);

        // Gaming configuration with all options set
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .storage("2TB SSD")
                .GPU("NVIDIA RTX 4080")
                .bluetooth(true)
                .wifi(true)
                .build();
        System.out.println(gamingComputer);

        // Office configuration with some custom options
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
                .storage("512GB SSD")
                .wifi(true)
                .build();
        System.out.println(officeComputer);
    }
}