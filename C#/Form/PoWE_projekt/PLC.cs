using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PoWE_projekt
{
    abstract class PLC
    {
        private string producent;
        private bool czyCF;
        
        public string Producent { get => producent; set => producent = value; }
        public bool CzyCF { get => czyCF; set => czyCF = value; }
        
        public PLC()
        {
        }

        public PLC(string producent, bool czyCF)
        {
            this.producent = producent;
            this.czyCF = czyCF;
        }

        public virtual void Wyswietl(TextBox tb1)
        {
            tb1.AppendText(this.producent + "\r\n");
            tb1.AppendText(this.czyCF.ToString() + "\r\n");
        }

        public abstract void Serwis();
    }
}
