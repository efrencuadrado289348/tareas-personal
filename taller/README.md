# Taller · Cinco familias en LeetCode

## 56. Merge Intervals

Enlace: https://leetcode.com/problems/merge-intervals/  
Familia: ordenamiento  
Idea: se ordenan los intervalos por su inicio y luego se recorren una sola vez;
si el actual empieza antes o justo cuando termina el último, se fusionan
(el fin queda en el mayor de los dos); si no, se abre un intervalo nuevo.  
Complejidad: tiempo O(n log n) por el ordenamiento (la pasada es O(n));
espacio O(n) para la salida. n = número de intervalos.  
Código: [merge-intervals/Solution.java](merge-intervals/Solution.java)

![Accepted — Merge Intervals](evidencias/merge-intervals-accepted.png)



## 200. Number of Islands

Enlace: https://leetcode.com/problems/number-of-islands/

Familia: grafos

Modelo: cada celda '1' es un vértice; hay arista entre dos celdas '1' vecinas
(arriba, abajo, izquierda, derecha). Grafo no dirigido. Contar islas es contar
componentes conexas (grupos de celdas de tierra unidas entre sí).

Idea: se recorre la grilla; cada '1' sin visitar es una isla nueva y con DFS
se hunde toda la isla (se cambia a '0') para no contarla dos veces.

Complejidad: tiempo Θ(m·n), cada celda se visita una vez; espacio O(m·n) en el
peor caso por la pila de recursión. m = filas, n = columnas.

Código: [number-of-islands/Solution.java](number-of-islands/Solution.java)

![Accepted — Number of Islands](evidencias/number-of-islands-accepted.png)



## 1143. Longest Common Subsequence

Enlace: https://leetcode.com/problems/longest-common-subsequence/

Familia: programación dinámica

Estado: dp[i][j] = longitud de la LCS de los primeros i caracteres de text1
y los primeros j caracteres de text2.

Base: dp[0][j] = dp[i][0] = 0 (un prefijo vacío no comparte nada).

Recurrencia: si text1[i-1] == text2[j-1], dp[i][j] = dp[i-1][j-1] + 1;
si no, dp[i][j] = max(dp[i-1][j], dp[i][j-1]).

Complejidad: tiempo Θ(n·m) y espacio Θ(n·m) por la tabla.
n = longitud de text1, m = longitud de text2.

Código: [longest-common-subsequence/Solution.java](longest-common-subsequence/Solution.java)

![Accepted — Longest Common Subsequence](evidencias/longest-common-subsequence-accepted.png)