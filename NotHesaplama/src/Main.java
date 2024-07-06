import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int vizeOlasilik, finalOlasilik, vizeSElektronik, finalSElektronik, vizeOtomata, finalOtomata;
        int vizeSistemP, finalSistemP, vizeGomulu, finalGomulu, vizeSimulasyon, finalSimulasyon;
        float ort;

        Scanner input = new Scanner(System.in);

        // Olasilik
        vizeOlasilik = getValidScore(input, "Olasilik vize notunu giriniz:");
        finalOlasilik = getValidScore(input, "Olasilik final notunu giriniz:");
        float olasilik = vizeOlasilik * 0.4f + finalOlasilik * 0.6f;

        // S-Elektronik
        vizeSElektronik = getValidScore(input, "S-Elektronik vize notunu giriniz:");
        finalSElektronik = getValidScore(input, "S-Elektronik final notunu giriniz:");
        float sElektronik = vizeSElektronik * 0.4f + finalSElektronik * 0.6f;

        // Otomata
        vizeOtomata = getValidScore(input, "Otomata vize notunu giriniz:");
        finalOtomata = getValidScore(input, "Otomata final notunu giriniz:");
        float otomata = vizeOtomata * 0.4f + finalOtomata * 0.6f;

        // Sistem P
        vizeSistemP = getValidScore(input, "Sistem P vize notunu giriniz:");
        finalSistemP = getValidScore(input, "Sistem P final notunu giriniz:");
        float sistemP = vizeSistemP * 0.4f + finalSistemP * 0.6f;

        // Gomulu
        vizeGomulu = getValidScore(input, "Gomulu vize notunu giriniz:");
        finalGomulu = getValidScore(input, "Gomulu final notunu giriniz:");
        float gomulu = vizeGomulu * 0.4f + finalGomulu * 0.6f;

        // Simulasyon
        vizeSimulasyon = getValidScore(input, "Simulasyon vize notunu giriniz:");
        finalSimulasyon = getValidScore(input, "Simulasyon final notunu giriniz:");
        float simulasyon = vizeSimulasyon * 0.4f + finalSimulasyon * 0.6f;

        // Ortalama hesaplama
        ort = (olasilik*4 + sElektronik*4 + otomata*7 + sistemP*6 + gomulu*5 + simulasyon*7) / 33;

        System.out.println("Tum derslerin ortalamasi : " + ort);

        if (ort >= 55) {
            System.out.println("Gectiniz!");
        } else {
            System.out.println("Kaldiniz.");
        }

        // Finalde en az alınması gereken not hesaplaması
        System.out.println("En az almaniz gereken final notlari:");
        System.out.println("Olasilik: " + hesaplaEnDusukFinalNotu(vizeOlasilik));
        System.out.println("S-Elektronik: " + hesaplaEnDusukFinalNotu(vizeSElektronik));
        System.out.println("Otomata: " + hesaplaEnDusukFinalNotu(vizeOtomata));
        System.out.println("Sistem P: " + hesaplaEnDusukFinalNotu(vizeSistemP));
        System.out.println("Gomulu: " + hesaplaEnDusukFinalNotu(vizeGomulu));
        System.out.println("Simulasyon: " + hesaplaEnDusukFinalNotu(vizeSimulasyon));
    }

    public static int getValidScore(Scanner input, String prompt) {
        int score;
        while (true) {
            System.out.println(prompt);
            score = input.nextInt();
            if (score >= 0 && score <= 100) {
                break;
            } else {
                System.out.println("Hata: Not 0 ile 100 arasında olmalıdır. Tekrar deneyin.");
            }
        }
        return score;
    }

    public static int hesaplaEnDusukFinalNotu(int vizeNotu) {
        // Vize notuna göre finalde geçmek için en az alınması gereken not
        return (int) Math.ceil((55 - vizeNotu * 0.4) / 0.6);
    }
}
