using System;
using System.Net.Sockets;
using Modbus.Device;

namespace NModbusTest
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            if(args.Length < 1) {
                Console.WriteLine("Wrong arguments. Missing ip-address of slave.");
                Console.ReadKey();
                return;
            }
            TcpClient tcpClient = new TcpClient(); //Create a new TcpClient object.
            tcpClient.BeginConnect(args[0], 502, null, null);
            ModbusIpMaster master = ModbusIpMaster.CreateIp(tcpClient);
            Console.WriteLine("Connected to slave: " + args[0]);
            while (true) {
                ushort[] result = master.ReadInputRegisters(1, 0, 3);
                Console.WriteLine(result[0] + ":" + result[1] + ":" + result[2]);
                System.Threading.Thread.Sleep(1000);
            }
        }
    }
}