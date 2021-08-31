using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PoWE_projekt
{
    class PowerPanels : PLC
    {
        private string rozdzielczosc;

        public PowerPanels(string producent, bool czyCF, string rozdzielczosc) : base(producent, czyCF)
        {
            this.rozdzielczosc = rozdzielczosc;
        }

        public override void Wyswietl(TextBox tb1)
        {
            base.Wyswietl(tb1);
            tb1.AppendText(rozdzielczosc + "\r\n");
        }

        public override void Serwis()
        {
            MessageBox.Show("Serwis Panelu");
        }
    }
}
