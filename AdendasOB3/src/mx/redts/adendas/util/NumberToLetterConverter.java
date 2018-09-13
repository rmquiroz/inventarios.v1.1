package mx.redts.adendas.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class NumberToLetterConverter {

	private static final String[] UNIDADES = {
			Messages.getString("NumberToLetterConverter.0"), Messages.getString("NumberToLetterConverter.1"), Messages.getString("NumberToLetterConverter.2"), Messages.getString("NumberToLetterConverter.3"), Messages.getString("NumberToLetterConverter.4"), Messages.getString("NumberToLetterConverter.5"), Messages.getString("NumberToLetterConverter.6"), Messages.getString("NumberToLetterConverter.7"), Messages.getString("NumberToLetterConverter.8"), Messages.getString("NumberToLetterConverter.9"), Messages.getString("NumberToLetterConverter.10"), Messages.getString("NumberToLetterConverter.11"), Messages.getString("NumberToLetterConverter.12"), Messages.getString("NumberToLetterConverter.13"), Messages.getString("NumberToLetterConverter.14"), Messages.getString("NumberToLetterConverter.15"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$
			Messages.getString("NumberToLetterConverter.16"), Messages.getString("NumberToLetterConverter.17"), Messages.getString("NumberToLetterConverter.18"), Messages.getString("NumberToLetterConverter.19"), Messages.getString("NumberToLetterConverter.20") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	private static final String[] DECENAS = {
			Messages.getString("NumberToLetterConverter.21"), Messages.getString("NumberToLetterConverter.22"), Messages.getString("NumberToLetterConverter.23"), Messages.getString("NumberToLetterConverter.24"), Messages.getString("NumberToLetterConverter.25"), Messages.getString("NumberToLetterConverter.26"), Messages.getString("NumberToLetterConverter.27"), Messages.getString("NumberToLetterConverter.28"), Messages.getString("NumberToLetterConverter.29") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$

	private static final String[] CENTENAS = {
			Messages.getString("NumberToLetterConverter.30"), Messages.getString("NumberToLetterConverter.31"), Messages.getString("NumberToLetterConverter.32"), Messages.getString("NumberToLetterConverter.33"), Messages.getString("NumberToLetterConverter.34"), Messages.getString("NumberToLetterConverter.35"), Messages.getString("NumberToLetterConverter.36"), Messages.getString("NumberToLetterConverter.37"), Messages.getString("NumberToLetterConverter.38") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$

	/**
	 * Convierte los trios de numeros que componen las unidades, las decenas y
	 * las centenas del numero.
	 * 
	 * @param number
	 *            Numero a convetir en digitos
	 * @return Numero convertido en letras
	 */
	private static String convertNumber(String number) {

		if (number.length() > 3)
			throw new NumberFormatException(
					Messages.getString("NumberToLetterConverter.39")); //$NON-NLS-1$

		// Caso especial con el 100
		if (number.equals(Messages.getString("NumberToLetterConverter.40"))) { //$NON-NLS-1$
			return Messages.getString("NumberToLetterConverter.41"); //$NON-NLS-1$
		}

		StringBuilder output = new StringBuilder();
		if (getDigitAt(number, 2) != 0)
			output.append(CENTENAS[getDigitAt(number, 2) - 1]);

		int k = Integer.parseInt(String.valueOf(getDigitAt(number, 1))
				+ String.valueOf(getDigitAt(number, 0)));

		if (k <= 20)
			output.append(UNIDADES[k]);
		else if (k > 30 && getDigitAt(number, 0) != 0)
			output.append(DECENAS[getDigitAt(number, 1) - 2]
					+ Messages.getString("NumberToLetterConverter.42") + UNIDADES[getDigitAt(number, 0)]); //$NON-NLS-1$
		else
			output.append(DECENAS[getDigitAt(number, 1) - 2]
					+ UNIDADES[getDigitAt(number, 0)]);

		return output.toString();
	}

	/**
	 * Convierte un numero en representacion numerica a uno en representacion de
	 * texto. El numero es valido si esta entre 0 y 999'999.999
	 * 
	 * @param number
	 *            Numero a convertir
	 * @return Numero convertido a texto
	 * @throws NumberFormatException
	 *             Si el numero esta fuera del rango
	 */
	public static String convertNumberToLetter(double doubleNumber,
			String moneda) throws NumberFormatException {

		StringBuilder converted = new StringBuilder();

		String patternThreeDecimalPoints = Messages
				.getString("NumberToLetterConverter.43"); //$NON-NLS-1$

		DecimalFormat format = new DecimalFormat(patternThreeDecimalPoints);
		format.setRoundingMode(RoundingMode.DOWN);

		// formateamos el numero, para ajustarlo a el formato de tres puntos
		// decimales
		String formatedDouble = format.format(doubleNumber);
		doubleNumber = Double
				.parseDouble(formatedDouble.replaceAll(
						Messages.getString("NumberToLetterConverter.44"), Messages.getString("NumberToLetterConverter.45"))); //$NON-NLS-1$ //$NON-NLS-2$

		// Validamos que sea un numero legal
		if (doubleNumber > 999999999)
			throw new NumberFormatException(
					Messages.getString("NumberToLetterConverter.46") + Messages.getString("NumberToLetterConverter.47")); //$NON-NLS-1$ //$NON-NLS-2$
		
		if (doubleNumber > 999999999)
			
			throw new NumberFormatException(
					Messages.getString("NumberToLetterConverter.48")); //$NON-NLS-1$

		String splitNumber[] = String.valueOf(doubleNumber).replace('.', '#')
				.split(Messages.getString("NumberToLetterConverter.49")); //$NON-NLS-1$

		// Descompone el trio de millones
		int millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
				8))
				+ String.valueOf(getDigitAt(splitNumber[0], 7))
				+ String.valueOf(getDigitAt(splitNumber[0], 6)));
		if (millon == 1)
			converted.append(Messages.getString("NumberToLetterConverter.50")); //$NON-NLS-1$
		else if (millon > 1)
			converted.append(convertNumber(String.valueOf(millon))
					+ Messages.getString("NumberToLetterConverter.51")); //$NON-NLS-1$

		// Descompone el trio de miles
		int miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
				5))
				+ String.valueOf(getDigitAt(splitNumber[0], 4))
				+ String.valueOf(getDigitAt(splitNumber[0], 3)));
		if (miles == 1)
			converted.append(Messages.getString("NumberToLetterConverter.52")); //$NON-NLS-1$
		else if (miles > 1)
			converted.append(convertNumber(String.valueOf(miles))
					+ Messages.getString("NumberToLetterConverter.53")); //$NON-NLS-1$

		// Descompone el ultimo trio de unidades
		int cientos = Integer.parseInt(String.valueOf(getDigitAt(
				splitNumber[0], 2))
				+ String.valueOf(getDigitAt(splitNumber[0], 1))
				+ String.valueOf(getDigitAt(splitNumber[0], 0)));
		if (cientos == 1)
			converted.append(Messages.getString("NumberToLetterConverter.54")); //$NON-NLS-1$

		if (millon + miles + cientos == 0)
			converted.append(Messages.getString("NumberToLetterConverter.55")); //$NON-NLS-1$
		if (cientos > 1)
			converted.append(convertNumber(String.valueOf(cientos)));

		if (Messages.getString("NumberToLetterConverter.56").equals(moneda)) //$NON-NLS-1$
			converted.append(Messages.getString("NumberToLetterConverter.57")); //$NON-NLS-1$
		else
			converted.append(Messages.getString("NumberToLetterConverter.58")); //$NON-NLS-1$

		// Descompone los centavos
		int centavos = Integer.parseInt(String.valueOf(getDigitAt(
				splitNumber[1], 2))
			//	+ String.valueOf(getDigitAt(splitNumber[1], 1))
		    //+ String.valueOf(getDigitAt(splitNumber[1], 0)));
		+ String.valueOf(getDigitAt(splitNumber[1], 1))
		+ String.valueOf(getDigitAt(splitNumber[1], 0)));
		if (centavos == 1)
			converted.append(Messages.getString("NumberToLetterConverter.59")); //$NON-NLS-1$
		else if (centavos > 1)
			converted
					.append(Messages.getString("NumberToLetterConverter.60") + convertNumber(String.valueOf(centavos)) + Messages.getString("NumberToLetterConverter.61")); //$NON-NLS-1$ //$NON-NLS-2$

		return converted.toString()
				+ Messages.getString("NumberToLetterConverter.62") + moneda; //$NON-NLS-1$
	}

	/**
	 * Convierte a letras un numero de la forma $123,456.32
	 * 
	 * @param number
	 *            Numero en representacion texto
	 * @throws NumberFormatException
	 *             Si valor del numero no es valido (fuera de rango o )
	 * @return Numero en letras
	 */
	public static String convertNumberToLetter(String number, String moneda)
			throws NumberFormatException {
		return convertNumberToLetter(Double.parseDouble(number), moneda);
	}

	/**
	 * Retorna el digito numerico en la posicion indicada de derecha a izquierda
	 * 
	 * @param origin
	 *            Cadena en la cual se busca el digito
	 * @param position
	 *            Posicion de derecha a izquierda a retornar
	 * @return Digito ubicado en la posicion indicada
	 */
	private static int getDigitAt(String origin, int position) {
		if (origin.length() > position && position >= 0)
			return origin.charAt(origin.length() - position - 1) - 48;
		return 0;
	}

}