package spinc.spmmvp.security;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

import butterknife.BindView;
import butterknife.ButterKnife;
import spinc.spmmvp.R;

/**
 * Created by webwerks on 24/2/17.
 */

public class SecurityActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatEditText edittextSecurity;

    AppCompatButton buttonEncript;

    AppCompatButton buttonDecript;

    AppCompatTextView tvSecurity;

    String key = "a";

    public static String seedValue = "I AM UNBREAKABLE";
    public static String MESSAGE = "No one can read this message without decrypting me.";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
        ButterKnife.bind(this);

        edittextSecurity = (AppCompatEditText) findViewById(R.id.edittextSecurity);
        buttonEncript = (AppCompatButton) findViewById(R.id.buttonEncript);
        buttonDecript = (AppCompatButton) findViewById(R.id.buttonDecript);
        tvSecurity = (AppCompatTextView) findViewById(R.id.tvSecurity);

        buttonEncript.setOnClickListener(this);
        buttonDecript.setOnClickListener(this);



        // Original text
        String theTestText = "This is just a simple test!";
        edittextSecurity.setText("\n[ORIGINAL]:\n" + theTestText + "\n");

        // Generate key pair for 1024-bit RSA encryption and decryption
        Key publicKey = null;
        Key privateKey = null;
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024);
            KeyPair kp = kpg.genKeyPair();
            publicKey = kp.getPublic();
            privateKey = kp.getPrivate();
        } catch (Exception e) {
            Log.e("asda", "RSA key pair error");
        }

        // Encode the original data with RSA private key
        byte[] encodedBytes = null;
        try {
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, privateKey);
            encodedBytes = c.doFinal(theTestText.getBytes());
        } catch (Exception e) {
            Log.e("SPM", "RSA encryption error");
        }

        tvSecurity.setText("[ENCODED]:\n" +
                Base64.encodeToString(encodedBytes, Base64.DEFAULT) + "\n");

        // Decode the encoded data with RSA public key
        byte[] decodedBytes = null;
        try {
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, publicKey);
            decodedBytes = c.doFinal(encodedBytes);
        } catch (Exception e) {
            Log.e("SPM", "RSA decryption error");
        }




        try {
            String encryptedData = AESHelper.encrypt(seedValue, MESSAGE);
            Log.v("EncryptDecrypt", "Encoded String " + encryptedData);
            String decryptedData = AESHelper.decrypt(seedValue, encryptedData);
            Log.v("EncryptDecrypt", "Decoded String " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonEncript :
                try {
                    tvSecurity.setText(AESHelper.encrypt(edittextSecurity.getText().toString().trim(),key));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.buttonDecript :
                try {
                    tvSecurity.setText(AESHelper.decrypt(edittextSecurity.getText().toString().trim(),key));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
