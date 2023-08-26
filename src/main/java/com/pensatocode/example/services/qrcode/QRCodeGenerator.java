package com.pensatocode.example.services.qrcode;

import com.google.zxing.WriterException;
import com.pensatocode.example.model.Credential;

import java.io.IOException;

public interface QRCodeGenerator {

    byte[] generateQRCode(Credential credentials) throws WriterException, IOException;
}
