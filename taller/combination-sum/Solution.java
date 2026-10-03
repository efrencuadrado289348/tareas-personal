/*
 * 39. Combination Sum - https://leetcode.com/problems/combination-sum/
 * Familia: backtracking
 *
 * Me dan numeros y un objetivo, y tengo que sacar TODAS las combinaciones
 * que suman el objetivo (puedo repetir numeros).
 * Voy armando una combinacion: elijo un numero, sigo buscando con lo que falta,
 * y al volver lo quito (eso es el backtrack) para probar el siguiente.
 * Si lo que falta llega a 0, guardo una copia de la combinacion.
 * Si un numero es mas grande que lo que falta, no lo pruebo (poda).
 * Para no repetir combinaciones en otro orden, nunca vuelvo a numeros anteriores.
 *
 * Tiempo: exponencial, O(n^(t/min)) en el peor caso, donde t es el target
 * y min el numero mas pequeño (la combinacion mas larga tiene t/min numeros).
 * Espacio: O(t/min) por la profundidad de la recursion, mas la salida.
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultado = new ArrayList<>();
        buscar(candidates, target, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    // falta: lo que me falta para llegar al target
    // inicio: desde que numero puedo elegir (para no repetir combinaciones)
    private void buscar(int[] candidates, int falta, int inicio,
                        List<Integer> actual, List<List<Integer>> resultado) {
        // llegue exacto: guardo una copia (si guardo "actual" directo, luego se borra)
        if (falta == 0) {
            resultado.add(new ArrayList<>(actual));
            return;
        }

        for (int i = inicio; i < candidates.length; i++) {
            // si este numero se pasa, no sigo por ahi (poda)
            if (candidates[i] > falta) {
                continue;
            }

            actual.add(candidates[i]);                                       // elijo
            buscar(candidates, falta - candidates[i], i, actual, resultado); // sigo con i porque puedo repetirlo
            actual.remove(actual.size() - 1);                                // deshago
        }
    }
}