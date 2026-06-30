public class Computer {
    // Required parameters
    private final String CPU;
    private final String RAM;

    // Optional parameters
    private final String storage;
    private final String GPU;
    private final boolean hasBluetooth;
    private final boolean hasWifi;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi = builder.hasWifi;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU +
                ", RAM=" + RAM +
                ", Storage=" + storage +
                ", GPU=" + GPU +
                ", Bluetooth=" + hasBluetooth +
                ", WiFi=" + hasWifi + "]";
    }

    // Static nested Builder class
    public static class Builder {
        private final String CPU;
        private final String RAM;

        private String storage = "256GB SSD";   // default value
        private String GPU = "Integrated";       // default value
        private boolean hasBluetooth = false;
        private boolean hasWifi = false;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder GPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder bluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Builder wifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}