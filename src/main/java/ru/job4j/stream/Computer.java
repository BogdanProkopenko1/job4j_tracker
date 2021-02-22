package ru.job4j.stream;

public class Computer {

    private String gpu;
    private String brand;
    private String processor;
    private String model;
    private int ram;
    private int price;
    private int power;

    @Override
    public String toString() {
        return "Computer{" +
                System.lineSeparator() + "gpu='" + gpu + '\'' +
                System.lineSeparator() + "brand='" + brand + '\'' +
                System.lineSeparator() + "processor='" + processor + '\'' +
                System.lineSeparator() + "model='" + model + '\'' +
                System.lineSeparator() + "ram=" + ram +
                System.lineSeparator() + "price=" + price +
                System.lineSeparator() + "power=" + power +
                System.lineSeparator() + '}';
    }

    static class Builder {

        private String gpu;
        private String brand;
        private String processor;
        private String model;
        private int ram;
        private int price;
        private int power;

        Builder buildGPU(String gpu) {
            this.gpu = gpu;
            return this;
        }

        Builder buildBrand(String brand) {
            this.brand= brand;
            return this;
        }

        Builder buildProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildRAM(int ram) {
            this.ram = ram;
            return this;
        }

        Builder buildPrice(int price) {
            this.price = price;
            return this;
        }

        Builder buildPower(int power) {
            this.power = power;
            return this;
        }

        Computer build() {
            Computer computer = new Computer();
            computer.gpu = gpu;
            computer.brand = brand;
            computer.processor = processor;
            computer.model = model;
            computer.ram = ram;
            computer.price = price;
            computer.power = power;
            return computer;
        }
    }

    public static void main(String[] args) {
        Computer computer = new Builder().buildGPU("nVidia GeForce GTX 1050")
                .buildBrand("Lenovo")
                .buildProcessor("intel core i5 7400HQ")
                .buildModel("Legion y 520")
                .buildRAM(16)
                .buildPrice(56990)
                .buildPower(300)
                .build();
        System.out.println(computer);
    }
}