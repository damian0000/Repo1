using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PoWE_projekt
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1plc_Click(object sender, EventArgs e)
        {
            // ten fragment jest wykomentowany ze względu na to, że klasa została zmieniona na abstrakcyjną
            //PLC plc1 = new PLC();
            //plc1.Producent = "Siemens";
            //plc1.CzyCF = true;

            //PLC plc2 = new PLC(producent: "Omron", czyCF: false);

            //plc1.Wyswietl(textBoxPLC);
            //plc2.Wyswietl(textBoxPLC);

            PowerPanels power_panel1 = new PowerPanels(producent: "Mitsubishi", czyCF: true, rozdzielczosc: "1920x1080");
            KomputeryPrzemyslowe komputer_przemyslowy1 = new KomputeryPrzemyslowe(producent: "Modicon", czyCF: false, klasaszczelnosci: 66);

            //polimorfizm
            PLC plc3 = new PowerPanels(producent: "Schneider", czyCF: true, rozdzielczosc: "1920x1080");

            plc3.Wyswietl(textBox1plc);
            plc3.Serwis(); // abstrakcyjna
            plc3 = new KomputeryPrzemyslowe(producent: "Modicon", czyCF: false, klasaszczelnosci: 68);
            plc3.Wyswietl(textBox1plc);
            plc3.Serwis(); // abstrakcyjna
        }
    }
}
