package org.example;
/*
Descripción: Proyecto integrador de Química e Introducción a Sistemas Computacionales, desarrollado
en Java para calcular el potencial de una celda electroquímica.
Integrantes: Carlos Bautista Garcia, Said Moises, Arturo Rioz.
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class OrdinariodeQuimica {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Lista de diccionarios de los electrodos
        ArrayList<HashMap<String, String>> electrodos = new ArrayList<>();

        // Registramos los 15 elementos quimicos
        agregarElectrodo(electrodos, "Au", "Oro", 1.498, 3,
                "Au → Au³⁺ + 3e⁻",
                "Au³⁺ + 3e⁻ → Au");

        agregarElectrodo(electrodos, "Pt", "Platino", 1.200, 2,
                "Pt → Pt²⁺ + 2e⁻",
                "Pt²⁺ + 2e⁻ → Pt");

        agregarElectrodo(electrodos, "Ag", "Plata", 0.799, 1,
                "Ag → Ag⁺ + e⁻",
                "Ag⁺ + e⁻ → Ag");

        agregarElectrodo(electrodos, "Cu", "Cobre", 0.337, 2,
                "Cu → Cu²⁺ + 2e⁻",
                "Cu²⁺ + 2e⁻ → Cu");

        agregarElectrodo(electrodos, "H", "Hidrogeno", 0.000, 2,
                "H₂ → 2H⁺ + 2e⁻",
                "2H⁺ + 2e⁻ → H₂");

        agregarElectrodo(electrodos, "Pb", "Plomo", -0.126, 2,
                "Pb → Pb²⁺ + 2e⁻",
                "Pb²⁺ + 2e⁻ → Pb");

        agregarElectrodo(electrodos, "Sn", "Estaño", -0.136, 2,
                "Sn → Sn²⁺ + 2e⁻",
                "Sn²⁺ + 2e⁻ → Sn");

        agregarElectrodo(electrodos, "Ni", "Niquel", -0.250, 2,
                "Ni → Ni²⁺ + 2e⁻",
                "Ni²⁺ + 2e⁻ → Ni");

        agregarElectrodo(electrodos, "Co", "Cobalto", -0.280, 2,
                "Co → Co²⁺ + 2e⁻",
                "Co²⁺ + 2e⁻ → Co");

        agregarElectrodo(electrodos, "Fe", "Hierro", -0.440, 2,
                "Fe → Fe²⁺ + 2e⁻",
                "Fe²⁺ + 2e⁻ → Fe");

        agregarElectrodo(electrodos, "Cr", "Cromo", -0.744, 3,
                "Cr → Cr³⁺ + 3e⁻",
                "Cr³⁺ + 3e⁻ → Cr");

        agregarElectrodo(electrodos, "Zn", "Zinc", -0.763, 2,
                "Zn → Zn²⁺ + 2e⁻",
                "Zn²⁺ + 2e⁻ → Zn");

        agregarElectrodo(electrodos, "Al", "Aluminio", -1.662, 3,
                "Al → Al³⁺ + 3e⁻",
                "Al³⁺ + 3e⁻ → Al");

        agregarElectrodo(electrodos, "Mg", "Magnesio", -2.363, 2,
                "Mg → Mg²⁺ + 2e⁻",
                "Mg²⁺ + 2e⁻ → Mg");

        agregarElectrodo(electrodos, "Na", "Sodio", -2.714, 1,
                "Na → Na⁺ + e⁻",
                "Na⁺ + e⁻ → Na");
        // Ciclo principal del programa
        while (true) {
            try {

                System.out.println("");
                System.out.println("------------------------------------");
                System.out.println("=== CELDA ELECTROQUIMICA ===");
                System.out.println("1. Calcular potencial de celda");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opcion: ");



                String entrada = scanner.nextLine().trim();

                if (entrada.isEmpty()) {
                    System.err.println("Error: no puede dejar el campo vacio");
                    continue;
                }

                int opcion = Integer.parseInt(entrada);

                if (opcion == 2) {
                    System.out.println("Gracias por utilizar el programa");
                    scanner.close();
                    return;
                }

                if (opcion != 1) {
                    System.err.println("Error: seleccione una opcion valida");

                } else {

                    String electrodo1 = "", electrodo2 = "";
                    String nombre1 = "", nombre2 = "";
                    String oxidacion1 = "", oxidacion2 = "";
                    String reduccion1 = "", reduccion2 = "";

                    double potencial1 = 0, potencial2 = 0;
                    double estandar1 = 0, estandar2 = 0;
                    double concentracion1 = 0, concentracion2 = 0;

                    System.out.println("------------------------------------");
                    System.out.println("=== ELECTRODOS DISPONIBLES ===");

                    // Mostramos los elementos disponibles
                    for (int i = 0; i < electrodos.size(); i++) {

                        System.out.println(
                                electrodos.get(i).get("simbolo")
                                        + " - "
                                        + electrodos.get(i).get("nombre"));
                    }

                    System.out.println("------------------------------------");

                    // Pedimos los dos electrodos
                    for (int i = 1; i <= 2; i++) {

                        String simbolo = "";
                        String nombre = "";
                        String oxidacion = "";
                        String reduccion = "";

                        double potencial = 0;
                        double concentracion = 0;

                        int electrones = 0;

                        boolean valido = false;

                        // Validamos el simbolo quimico
                        do {

                            System.out.print("Ingrese el simbolo del electrodo "
                                    + i + ": ");

                            simbolo = scanner.nextLine().trim();

                            valido = false;

                            if (simbolo.isEmpty()) {

                                System.err.println("Error: debe elegir un electrodo");

                            } else if (i == 2 && simbolo.equals(electrodo1)) {

                                System.err.println("Error: los electrodos deben ser diferentes");

                            } else {

                                // Buscamos el elemento en los diccionarios
                                for (int j = 0; j < electrodos.size(); j++) {

                                    HashMap<String, String> elemento = electrodos.get(j);

                                    if (simbolo.equals(elemento.get("simbolo"))) {

                                        nombre = elemento.get("nombre");

                                        potencial = Double.parseDouble(elemento.get("potencial"));

                                        electrones = Integer.parseInt(elemento.get("electrones"));

                                        oxidacion = elemento.get("oxidacion");
                                        reduccion = elemento.get("reduccion");

                                        valido = true;

                                        break;
                                    }
                                }

                                if (valido == false) {

                                    System.err.println("Error: simbolo incorrecto o no disponible");
                                    System.err.println("Ejemplos correctos: Zn, Cu, H");
                                    System.err.println("Respete las mayusculas y minusculas");
                                }
                            }

                        } while (valido == false);

                        System.out.println("Elemento seleccionado: " + nombre);

                        System.out.printf("Potencial estandar: %.4f V%n",
                                potencial);

                        System.out.println("Electrones transferidos: " + electrones);

                        // Validamos la concentracion molar
                        do {
                            try {

                                System.out.print("Ingrese la concentracion molar de " + simbolo + " (M): ");

                                String entradaConcentracion = scanner.nextLine().trim();

                                if (entradaConcentracion.isEmpty()) {

                                    System.err.println("Error: la concentracion no puede estar vacia");

                                    concentracion = 0;

                                } else {

                                    concentracion = Double.parseDouble(entradaConcentracion);

                                    if (!(concentracion > 0 && concentracion <= Double.MAX_VALUE)) {

                                        System.err.println("Error: ingrese una concentracion positiva y finita");

                                        concentracion = 0;
                                    }
                                }

                            } catch (Exception e) {

                                System.err.println("Error: no se aceptan valores no numericos");

                                concentracion = 0;
                            }

                        } while (concentracion <= 0);

                        // Guardamos el potencial estandar
                        double potencialEstandar = potencial;

                        // Aplicamos la ecuacion de Nernst
                        if (concentracion == 1) {

                            System.out.println("Concentracion estandar de 1 M");
                            System.out.println("No se necesita corregir el potencial");

                        } else {

                            System.out.println("------------------------------------");
                            System.out.println("=== ECUACION DE NERNST ===");

                            double logaritmo = Math.log10(concentracion);

                            if (simbolo.equals("H")) {

                                // Caso especial del hidrogeno
                                System.out.println("E = E° + (0.0592/2) log([H⁺]²)");

                                System.out.println("E = " + potencial + " + (0.0592/2) * 2 * log("
                                        + concentracion + ")");

                                potencial = potencial
                                        + (0.0592 / electrones)
                                        * 2 * logaritmo;

                            } else {

                                System.out.println("E = E° + (0.0592/n) log(Cion)");

                                System.out.println("E = " + potencial + " + (0.0592/" + electrones
                                        + ") log(" + concentracion + ")");

                                potencial = potencial
                                        + (0.0592 / electrones)
                                        * logaritmo;
                            }

                            System.out.printf("Logaritmo: %.4f%n", logaritmo);

                            System.out.printf("Potencial corregido: %.4f V%n",
                                    potencial);
                        }

                        // Guardamos los datos de cada electrodo
                        if (i == 1) {

                            electrodo1 = simbolo;
                            nombre1 = nombre;
                            potencial1 = potencial;
                            estandar1 = potencialEstandar;
                            concentracion1 = concentracion;
                            oxidacion1 = oxidacion;
                            reduccion1 = reduccion;

                        } else {

                            electrodo2 = simbolo;
                            nombre2 = nombre;
                            potencial2 = potencial;
                            estandar2 = potencialEstandar;
                            concentracion2 = concentracion;
                            oxidacion2 = oxidacion;
                            reduccion2 = reduccion;
                        }

                        System.out.println("------------------------------------");
                    }

                    // Variables del anodo y catodo
                    String anodo, catodo;
                    String nombreAnodo, nombreCatodo;
                    String reaccionOxidacion, reaccionReduccion;

                    double potencialAnodo, potencialCatodo;
                    double estandarAnodo, estandarCatodo;

                    System.out.println("");
                    System.out.println("========== RESULTADOS ==========");

                    System.out.println("Electrodo 1: "
                            + nombre1 + " (" + electrodo1 + ")");

                    System.out.println("Concentracion: "
                            + concentracion1 + " M");

                    System.out.printf("Potencial estandar: %.4f V%n",
                            estandar1);

                    System.out.printf("Potencial final: %.4f V%n",
                            potencial1);

                    System.out.println("");

                    System.out.println("Electrodo 2: " + nombre2 + " (" + electrodo2 + ")");

                    System.out.println("Concentracion: " + concentracion2 + " M");

                    System.out.printf("Potencial estandar: %.4f V%n", estandar2);

                    System.out.printf("Potencial final: %.4f V%n", potencial2);

                    // Determinamos el anodo y catodo
                    // Comparando los potenciales estandar
                    if (estandar1 < estandar2) {

                        anodo = electrodo1;
                        nombreAnodo = nombre1;
                        potencialAnodo = potencial1;
                        estandarAnodo = estandar1;
                        reaccionOxidacion = oxidacion1;

                        catodo = electrodo2;
                        nombreCatodo = nombre2;
                        potencialCatodo = potencial2;
                        estandarCatodo = estandar2;
                        reaccionReduccion = reduccion2;

                    } else {

                        anodo = electrodo2;
                        nombreAnodo = nombre2;
                        potencialAnodo = potencial2;
                        estandarAnodo = estandar2;
                        reaccionOxidacion = oxidacion2;

                        catodo = electrodo1;
                        nombreCatodo = nombre1;
                        potencialCatodo = potencial1;
                        estandarCatodo = estandar1;
                        reaccionReduccion = reduccion1;
                    }

                    // Imprimimos el anodo
                    System.out.println("------------------------------------");

                    System.out.println("ANODO: " + nombreAnodo + " (" + anodo + ")");

                    System.out.println("En el anodo ocurre la OXIDACION");
                    System.out.println("Pierde electrones");
                    System.out.println("Semirreaccion:");
                    System.out.println(reaccionOxidacion);

                    // Imprimimos el catodo
                    System.out.println("------------------------------------");

                    System.out.println("CATODO: " + nombreCatodo + " (" + catodo + ")");

                    System.out.println("En el catodo ocurre la REDUCCION");
                    System.out.println("Gana electrones");
                    System.out.println("Semirreaccion:");
                    System.out.println(reaccionReduccion);

                    // Cambiamos el signo del anodo
                    // Agregamos *(-1) para poder cambiar el signo
                    // Para obtener su potencial de oxidacion
                    double estandarOxidacion = estandarAnodo * (-1);
                    double potencialOxidacion = potencialAnodo * (-1);

                    // Sumamos los potenciales
                    double voltajeEstandar = estandarCatodo + estandarOxidacion;
                    double voltaje = potencialCatodo + potencialOxidacion;

                    // Potencial estandar de celda
                    System.out.println("------------------------------------");
                    System.out.println("=== POTENCIAL ESTANDAR DE CELDA ===");

                    System.out.println("E°celda = E°catodo + E°anodo");

                    System.out.printf("E°celda = %.4f + (%.4f)%n", estandarCatodo, estandarOxidacion);

                    System.out.printf("E°celda = %.4f V%n", voltajeEstandar);

                    // Potencial final de celda
                    System.out.println("------------------------------------");
                    System.out.println("=== POTENCIAL FINAL DE CELDA ===");

                    System.out.println("Ecelda = Ecatodo + Eanodo");

                    System.out.printf("Ecelda = %.4f + (%.4f)%n",
                            potencialCatodo, potencialOxidacion);

                    System.out.printf("VOLTAJE DE LA CELDA: %.4f V%n", voltaje);

                    // Determinamos si la reaccion es espontanea  o no
                    if (voltaje > 0) {
                        System.out.println("La reaccion es ESPONTANEA");

                    } else if (voltaje < 0) {
                        System.out.println("La reaccion NO ES ESPONTANEA");

                    } else {
                        System.out.println("La celda esta en equilibrio");
                    }

                    // Calculamos la reaccion inversa
                    // Multiplicamos el catodo por -1
                    double estandarCatodoInverso = estandarCatodo * (-1);
                    double potencialCatodoInverso = potencialCatodo * (-1);

                    double voltajeEstandarInverso = estandarCatodoInverso + estandarAnodo;

                    double voltajeInverso = potencialCatodoInverso + potencialAnodo;

                    System.out.println("------------------------------------");
                    System.out.println("=== POTENCIAL DE LA REACCION INVERSA ===");

                    System.out.println("Anodo: " + nombreCatodo);
                    System.out.println("Catodo: " + nombreAnodo);

                    System.out.printf("E°celda = %.4f + (%.4f)%n", estandarCatodoInverso, estandarAnodo);

                    System.out.printf("E°celda = %.4f V%n", voltajeEstandarInverso);

                    System.out.printf("Ecelda = %.4f + (%.4f)%n", potencialCatodoInverso, potencialAnodo);

                    System.out.printf("VOLTAJE INVERSO: %.4f V%n", voltajeInverso);

                    if (voltajeInverso > 0) {
                        System.out.println("La reaccion inversa es ESPONTANEA");
                    } else if (voltajeInverso < 0) {

                        System.out.println("La reaccion inversa NO ES ESPONTANEA");

                    } else {

                        System.out.println("La celda esta en equilibrio");
                    }

                    System.out.println("------------------------------------");
                    System.out.println("=== FIN DEL CALCULO ===");
                }

            } catch (Exception e) {

                System.err.println("Error: ingrese un valor numerico valido");
            }
        }
    }

    // Metodo para crear y guardar los diccionarios
    public static void agregarElectrodo(
            ArrayList<HashMap<String, String>> electrodos,
            String simbolo, String nombre,
            double potencial, int electrones,
            String oxidacion, String reduccion) {

        HashMap<String, String> elemento = new HashMap<>();

       elemento.put("simbolo", simbolo);
        elemento.put("nombre", nombre);
        elemento.put("potencial", String.valueOf(potencial));
        elemento.put("electrones", String.valueOf(electrones));
        elemento.put("oxidacion", oxidacion);
        elemento.put("reduccion", reduccion);

        electrodos.add(elemento);
    }
}
