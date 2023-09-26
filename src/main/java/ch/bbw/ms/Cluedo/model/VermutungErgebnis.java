    package ch.bbw.ms.Cluedo.model;

    public class VermutungErgebnis {
        private boolean verdachtigerRichtig;
        private boolean waffeRichtig;
        private boolean zimmerRichtig;

        public VermutungErgebnis() {}

        public VermutungErgebnis(boolean verdachtigerRichtig, boolean waffeRichtig, boolean zimmerRichtig) {
            this.verdachtigerRichtig = verdachtigerRichtig;
            this.waffeRichtig = waffeRichtig;
            this.zimmerRichtig = zimmerRichtig;
        }

        public boolean isVerdachtigerRichtig() {
            return verdachtigerRichtig;
        }

        public void setVerdachtigerRichtig(boolean verdachtigerRichtig) {
            this.verdachtigerRichtig = verdachtigerRichtig;
        }

        public boolean isWaffeRichtig() {
            return waffeRichtig;
        }

        public void setWaffeRichtig(boolean waffeRichtig) {
            this.waffeRichtig = waffeRichtig;
        }

        public boolean isZimmerRichtig() {
            return zimmerRichtig;
        }

        public void setZimmerRichtig(boolean zimmerRichtig) {
            this.zimmerRichtig = zimmerRichtig;
        }
    }
