

public class Procesos {

    public double calcularIMC(double altura, double peso) {

        return peso / (altura * altura);
    }

    public String evaluarIMC(double imc) {
        String resul = "";
        if (imc < 18.5) {
            resul = "Bajo peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            resul = "Peso saludable";
        } else if (imc >= 25 && imc < 29.9) {
            resul = "Sobrepeso";
        } else {
            resul = "Obeso";
        }
        return resul;
    }
}