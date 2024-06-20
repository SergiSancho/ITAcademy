package tasca7.n1exercici2.herencia;

    public class TreballadorPresencial extends Treballador {

        private static double benzina = 45.45;

        public TreballadorPresencial(String nom, String cognom, double preuHora) {
            super(nom, cognom, preuHora);
        }

        public static double getBenzina() {
            return benzina;

        }

        @Override
        public double calcularSou(double horesTreballades) {

            return horesTreballades * preuHora + benzina;
        }

        @Deprecated
        public int vacances() {
            return 99;
        }
    }
