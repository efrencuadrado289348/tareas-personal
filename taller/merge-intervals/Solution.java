/*
 * 56. Merge Intervals - https://leetcode.com/problems/merge-intervals/
 * Familia: ordenamiento
 *
 * Me dan intervalos [inicio, fin] y tengo que juntar los que se cruzan o se tocan.
 * Primero los ordeno por el inicio y despues los recorro una vez:
 * si el actual empieza antes de que termine el ultimo, los junto;
 * si no, empiezo uno nuevo.
 *
 * Tiempo: O(n log n) por el sort. Espacio: O(n) por la lista de salida.
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // ordeno por el inicio para que los que se cruzan queden juntos
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> resultado = new ArrayList<>();
        resultado.add(intervals[0]); // arranco con el primero

        for (int i = 1; i < intervals.length; i++) {
            int[] ultimo = resultado.get(resultado.size() - 1);
            int[] actual = intervals[i];

            // si el actual empieza antes de que termine el ultimo, se juntan
            // (con <= porque si se tocan tambien cuenta)
            if (actual[0] <= ultimo[1]) {
                // max por si el actual queda adentro del ultimo
                ultimo[1] = Math.max(ultimo[1], actual[1]);
            } else {
                // no se cruzan, entonces este es uno nuevo
                resultado.add(actual);
            }
        }

        return resultado.toArray(new int[0][]);
    }
}