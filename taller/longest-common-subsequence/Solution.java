/*
 * 1143. Longest Common Subsequence - https://leetcode.com/problems/longest-common-subsequence/
 * Familia: programacion dinamica
 *
 * Me dan dos palabras y tengo que decir cuantas letras tienen en comun
 * en el mismo orden (no tienen que estar pegadas).
 * Uso una tabla dp donde dp[i][j] es la respuesta para las primeras i letras
 * de text1 y las primeras j letras de text2.
 * Si las letras son iguales: diagonal + 1.
 * Si no: me quedo con el mayor entre arriba y la izquierda.
 * La fila 0 y la columna 0 valen 0 porque una palabra vacia no comparte nada.
 *
 * Tiempo: O(n*m) porque lleno toda la tabla. Espacio: O(n*m) por la tabla.
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // una fila y columna extra para el caso de palabra vacia (quedan en 0)
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // uso i-1 y j-1 porque la tabla esta corrida una posicion
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // letras iguales: lo de la diagonal mas esta letra
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // letras distintas: lo mejor quitando una letra de alguna palabra
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m]; // la ultima casilla tiene la respuesta
    }
}