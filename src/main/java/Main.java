import domain.Hardware;
import service.HardwareService;

public class Main {
    public static void main(String[] args) {
        HardwareService hardwareService = new HardwareService();
        System.out.println(hardwareService.getById(1));
        hardwareService.save(new Hardware("Болтик", "М6", 45, "нержавейка"));
    }
}
