import de.re.easymodbus.server.*;
import java.util.Date;

public class slave {
  public static void main(String[] args) {
    ModbusServer modbusServer = new ModbusServer();
    modbusServer.setPort(502);
    try {
      modbusServer.Listen();
    } catch(Exception e) {
    }
    while(true) {
      Date date = new Date();
      modbusServer.inputRegisters[1] = Integer.parseInt(date.toString().substring(11, 13));
      modbusServer.inputRegisters[2] = Integer.parseInt(date.toString().substring(14, 16));
      modbusServer.inputRegisters[3] = Integer.parseInt(date.toString().substring(17, 19));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
      }
    }
  }
}

