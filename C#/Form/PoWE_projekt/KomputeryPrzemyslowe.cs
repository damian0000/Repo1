using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PoWE_projekt
{
    class KomputeryPrzemyslowe : PLC
    {
        private int klasaszczelnosci;

        public KomputeryPrzemyslowe(string producent, bool czyCF, int klasaszczelnosci) : base(producent, czyCF)
        {
            this.klasaszczelnosci = klasaszczelnosci;
        }

        public override void Wyswietl(TextBox tb1)
        {
            base.Wyswietl(tb1);
            tb1.AppendText(klasaszczelnosci + "\r\n");
        }

        public override void Serwis()
        {
            MessageBox.Show("Serwis Komputera");
        }
    }
}
