package mx.redts.adendas.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.misc.BASE64Decoder;

public class Common {

	public static String generateFileNamePAC(String cliente) {
		SimpleDateFormat df = new SimpleDateFormat(
				Messages.getString("Common.17")); //$NON-NLS-1$

		return cliente
				.toLowerCase()
				.replaceAll(
						Messages.getString("Common.18"), Messages.getString("Common.19")).replaceAll(Messages.getString("Common.20"), Messages.getString("Common.21")).replaceAll(Messages.getString("Common.22"), Messages.getString("Common.23")).replaceAll(Messages.getString("Common.24"), Messages.getString("Common.25")).replaceAll(Messages.getString("Common.26"), Messages.getString("Common.27")).replaceAll(Messages.getString("Common.28"), Messages.getString("Common.29")).replaceAll(Messages.getString("Common.30"), Messages.getString("Common.31")).toUpperCase() //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$
				+ df.format(new Date())
				+ Messages.getString("Common.32") + (int) Math.random() * 10000 + Messages.getString("Common.33"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getStrEnc(String str) {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodedBytes;
		try {
			decodedBytes = decoder.decodeBuffer(str);

			return new String(decodedBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Messages.getString("Common.34"); //$NON-NLS-1$
		}

	}

	public static String md5Crypt(String original) {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance(Messages.getString("Common.35")); //$NON-NLS-1$
			md.update(original.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format(
						Messages.getString("Common.36"), b & 0xff)); //$NON-NLS-1$
			}

			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Messages.getString("Common.37"); //$NON-NLS-1$
		}
	}
}
