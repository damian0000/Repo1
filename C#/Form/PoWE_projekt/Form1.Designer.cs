namespace PoWE_projekt
{
    partial class Form1
    {
        /// <summary>
        /// Wymagana zmienna projektanta.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Wyczyść wszystkie używane zasoby.
        /// </summary>
        /// <param name="disposing">prawda, jeżeli zarządzane zasoby powinny zostać zlikwidowane; Fałsz w przeciwnym wypadku.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Kod generowany przez Projektanta formularzy systemu Windows

        /// <summary>
        /// Metoda wymagana do obsługi projektanta — nie należy modyfikować
        /// jej zawartości w edytorze kodu.
        /// </summary>
        private void InitializeComponent()
        {
            this.button1plc = new System.Windows.Forms.Button();
            this.textBox1plc = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // button1plc
            // 
            this.button1plc.Location = new System.Drawing.Point(12, 12);
            this.button1plc.Name = "button1plc";
            this.button1plc.Size = new System.Drawing.Size(168, 23);
            this.button1plc.TabIndex = 0;
            this.button1plc.Text = "Uruchomienie PLC";
            this.button1plc.UseVisualStyleBackColor = true;
            this.button1plc.Click += new System.EventHandler(this.button1plc_Click);
            // 
            // textBox1plc
            // 
            this.textBox1plc.Location = new System.Drawing.Point(186, 12);
            this.textBox1plc.Multiline = true;
            this.textBox1plc.Name = "textBox1plc";
            this.textBox1plc.Size = new System.Drawing.Size(602, 426);
            this.textBox1plc.TabIndex = 1;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.textBox1plc);
            this.Controls.Add(this.button1plc);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1plc;
        private System.Windows.Forms.TextBox textBox1plc;
    }
}

