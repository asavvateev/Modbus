using System;
using EasyModbus;

namespace ConsoleApp2
{
    class Program
    {
        public static void Main(string[] args)
        {
            if(args.Length < 1) {
                Console.WriteLine("Wrong arguments. Missing ip-address of slave.");
                Console.ReadKey();
                return;
            }
            ModbusClient modbusClient = new ModbusClient(args[0], 502);
            modbusClient.Connect();
            Console.WriteLine("Connected to slave: " + args[0]);
            while (true) {
                int[] result = modbusClient.ReadInputRegisters(0,3);
                Console.WriteLine(result[0] + ":" + result[1] + ":" + result[2]);
                System.Threading.Thread.Sleep(1000);
            }
        }
    }
}

