/*
 * 435. Non-overlapping Intervals - https://leetcode.com/problems/non-overlapping-intervals/
 * Familia: greedy
 *
 * Me dan intervalos y tengo que decir cuantos borrar como minimo
 * para que los que quedan no se crucen.
 * Lo pienso al reves: cuantos puedo dejar como maximo.
 * Criterio greedy: ordeno por el fin y siempre me quedo con el que termina
 * primero, porque deja mas espacio para los siguientes.
 * Si el siguiente empieza despues (o justo cuando) termina el ultimo que deje,
 * lo dejo; si no, se borra.
 * Respuesta: total - los que quedaron.
 *
 * Tiempo: O(n log n) por el sort. Espacio: O(1) extra, aparte del sort.
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // ordeno por el fin para poder elegir siempre el que termina primero
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int quedan = 1;                  // el primero siempre se queda
        int finUltimo = intervals[0][1]; // donde termina el ultimo que deje

        for (int i = 1; i < intervals.length; i++) {
            // con >= porque si se tocan no se cruzan
            if (intervals[i][0] >= finUltimo) {
                quedan++;
                finUltimo = intervals[i][1];
            }
            // si no, este se cruza con el ultimo y se borra (no hago nada)
        }

        return intervals.length - quedan; // los que no quedaron son los borrados
    }
}