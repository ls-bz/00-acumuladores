package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila
	 * donde todos sus elementos sean múltiplos del número recibido por
	 * parámetro.
	 *
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 *
	 * @param mat
	 * @param num
	 * @return
	 */
	public static boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		if(mat == null || mat.length==0 || num<=0) return false;

		boolean existeFilaMultiplo = false;
		boolean esMultiplo = true;

		for (int[] fila : mat) {
			esMultiplo = true;
			for (int elemento : fila) {
				esMultiplo = esMultiplo && (elemento%num==0);
			}
			existeFilaMultiplo = existeFilaMultiplo || esMultiplo;
		}
		return existeFilaMultiplo;
	}

	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 *
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz
	 * está vacía, devuelve falso.
	 *
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public static boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) {
		if (mat1==null || mat2==null) return false;
		if (mat1.length==0 || mat2.length==0) return false;
		if (mat1.length!=mat2.length) return false;

		boolean todasIntersecan = true;

		for (int f = 0; f < mat1.length; f++) {
			boolean hayInterseccion = false;
			for (int c = 0; c < mat1[0].length; c++) {
				for (int c2 = 0; c2 < mat2[0].length; c2++) {
					hayInterseccion = hayInterseccion || mat1[f][c]==mat2[f][c2];
				}
			}
			todasIntersecan = todasIntersecan && hayInterseccion;
		}
		return todasIntersecan;
	}

	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 *
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve
	 * falso.
	 *
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public static boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		if (mat==null || mat.length==0) return false;
		if (nColum < 0 || nColum >= mat[0].length) return false;

		int sumaColumnas = 0;
		boolean sumaDeFilaMayor = false;

		for (int f = 0; f < mat.length; f++) {
			sumaColumnas += mat[f][nColum];
		}

		for (int f = 0; f < mat.length; f++) {
			int sumaFilas = 0;
			for (int c = 0; c < mat[0].length; c++) {
				sumaFilas += mat[f][c];
			}
			sumaDeFilaMayor = sumaDeFilaMayor || sumaFilas>sumaColumnas;
		}

		return sumaDeFilaMayor;
	}

	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 *
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz
	 * está vacía, devuelve falso.
	 *
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public static boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) {

		if (mat1==null || mat2==null) return false;
		if (mat1.length==0 || mat2.length==0) return false;
		if (mat1[0].length!=mat2[0].length) return false;

		boolean todasIntersecan = true;

		for (int c = 0; c < mat1[0].length; c++) {
			boolean hayInterseccion = false;
			for (int f = 0; f < mat1.length; f++) {
				for (int f2 = 0; f2 < mat2.length; f2++) {
					hayInterseccion = hayInterseccion || mat1[f][c]==mat2[f2][c];
				}
			}
			todasIntersecan = todasIntersecan && hayInterseccion;
		}

		return todasIntersecan;
		//throw new RuntimeException("Metodo no implementado aun!!!");
	}
}
