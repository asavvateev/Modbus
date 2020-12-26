import de.re.easymodbus.modbusclient.*;

public class master {
 public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Wrong arguments. Missing ip-address of slave.");
            return;
        }
        ModbusClient modbusClient = new ModbusClient(args[0], 502);
        try {
            modbusClient.Connect();
            System.out.println("Connected to slave: " + args[0]);
            while(true) {
                int[] result;
                result = modbusClient.ReadInputRegisters(0, 3);
                System.out.println(result[0] + ":" + result[1] + ":" + result[2]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        catch (Exception e) {
            System.out.println("Slave disconnected");
        }
 }
}

