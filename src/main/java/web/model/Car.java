package web.model;

public class Car {
    private String model;
    private int dataRelease;
    private int price;

    public Car() {
    }

    public Car(String model, int dataRelease, int price) {
        this.model = model;
        this.dataRelease = dataRelease;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDataRelease() {
        return dataRelease;
    }

    public void setDataRelease(int dataRelease) {
        this.dataRelease = dataRelease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", dataRelease=" + dataRelease +
                ", prise=" + price +
                '}';
    }
}
