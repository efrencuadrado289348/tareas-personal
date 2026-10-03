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