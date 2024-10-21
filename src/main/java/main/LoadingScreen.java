package main;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class LoadingScreen extends JPanel {

    public LoadingScreen() {
        // set layout dan warna
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // lebel loading
        JLabel loadingLabel = new JLabel("Lagi Loading, Sebentar yaa ...", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.ITALIC, 30));
        loadingLabel.setForeground(Color.RED);

        // Membuat bar berjalan
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);

        // Tambahkan label dan bar berjalan ke game panel
        add(loadingLabel, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);
    }

    //menampilkan loading selama 3 detik
    public void showLoading() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
