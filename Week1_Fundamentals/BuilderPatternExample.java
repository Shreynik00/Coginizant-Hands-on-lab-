package Week1_Fundamentals;
public class BuilderPatternExample {
   public static void main(String[] args) {
          Computer computer = new Computer.Builder()
          .setCPU("50-56")
          .setRAM("16GB")
          .setStorage("1TB")
          .build();
         System.out.println("CPU: "+computer.CPU    );
         System.out.println("RAM: "+computer.RAM    );
         System.out.println("Storage: "+computer.Storage    );
   } 
}
class Computer
{
    String CPU,RAM,Storage;
   private Computer( Builder builder)
    {
        this.CPU=builder.CPU;
        this.RAM=builder.RAM;
        this.Storage=builder.Storage;
    }
    static class Builder
    {
        String CPU,RAM,Storage;
        Builder()
        {};
        Builder setCPU(String CPU)
        {
            this.CPU=CPU;
            return this;
        }
        Builder setRAM(String RAM)
        {
            this.RAM=RAM;
            return this;
        }
        Builder setStorage(String Storage)
        {
            this.Storage=Storage;
            return this;
        }

        Computer build()
        {
             return new Computer(this);
        }
    }
}