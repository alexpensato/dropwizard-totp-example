package com.pensatocode.example.services.otp;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class QrCodeGenerator {
    public static void generateQRCode(String secretKey, String accountName, OutputStream outputStream)
            throws WriterException, IOException {
        String otpAuthURL = generateOTPAuthURL(secretKey, accountName);

        BitMatrix bitMatrix = generateQRCodeMatrix(otpAuthURL, 200, 200);

        writeQRCodeToStream(bitMatrix, "PNG", outputStream);
    }

    private static String generateOTPAuthURL(String secretKey, String accountName) {
        String encodedAccountName = URLEncoder.encode(accountName, StandardCharsets.UTF_8);
        return String.format("otpauth://totp/%s?secret=%s", encodedAccountName, secretKey);
    }

    private static BitMatrix generateQRCodeMatrix(String text, int width, int height) throws WriterException {
        Writer qrCodeWriter = new QRCodeWriter();
        return qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
    }

    private static void writeQRCodeToStream(BitMatrix bitMatrix, String format, OutputStream outputStream)
            throws IOException {
        int matrixWidth = bitMatrix.getWidth();
        int matrixHeight = bitMatrix.getHeight();

        BufferedImage qrCodeImage = new BufferedImage(matrixWidth, matrixHeight, BufferedImage.TYPE_INT_RGB);
        qrCodeImage.createGraphics();

        Graphics2D graphics = (Graphics2D) qrCodeImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixHeight);
        graphics.setColor(Color.BLACK);

        for (int x = 0; x < matrixWidth; x++) {
            for (int y = 0; y < matrixHeight; y++) {
                if (bitMatrix.get(x, y)) {
                    graphics.fillRect(x, y, 1, 1);
                }
            }
        }

        ImageIO.write(qrCodeImage, format, outputStream);
    }
}
