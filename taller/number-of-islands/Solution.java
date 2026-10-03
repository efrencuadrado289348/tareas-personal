/*
 * 200. Number of Islands - https://leetcode.com/problems/number-of-islands/
 * Familia: grafos
 *
 * Me dan un mapa de '1' (tierra) y '0' (agua) y tengo que contar las islas.
 * Lo veo como un grafo: cada '1' es un nodo y se une con los '1' que tenga
 * arriba, abajo, izquierda o derecha (en diagonal no cuenta).
 * Cada isla es un grupo de nodos unidos entre si (componente conexa),
 * asi que contar islas es contar cuantos grupos hay.
 *
 * Como lo hago: recorro el mapa y cuando encuentro un '1' sumo una isla
 * y "hundo" toda esa isla (la vuelvo '0') para no contarla otra vez.
 * Para hundirla uso DFS: desde una celda voy a sus vecinas, y de ahi
 * a las vecinas de esas, hasta que no quede tierra pegada.
 *
 * Tiempo: O(m*n), cada celda se revisa una vez.
 * Espacio: O(m*n) en el peor caso, si todo es tierra la recursion se hace muy profunda.
 */
class Solution {
    public int numIslands(char[][] grid) {
        int islas = 0;

        // recorro todo el mapa celda por celda
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // si encuentro tierra que no he hundido, es una isla nueva
                if (grid[i][j] == '1') {
                    islas++;
                    hundir(grid, i, j); // borro toda la isla para no contarla dos veces
                }
            }
        }
        return islas;
    }

    // hunde la isla completa empezando desde la celda (i, j)
    private void hundir(char[][] grid, int i, int j) {
        // paro si me sali del mapa o si es agua (o tierra que ya hundi)
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // la vuelvo agua ANTES de seguir, si no las vecinas me devuelven aqui y nunca termina
        grid[i][j] = '0';

        // sigo con las 4 vecinas: abajo, arriba, derecha, izquierda
        hundir(grid, i + 1, j);
        hundir(grid, i - 1, j);
        hundir(grid, i, j + 1);
        hundir(grid, i, j - 1);
    }
}