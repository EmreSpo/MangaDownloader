
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class MangaDownloader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Kullanıcıdan bölüm numarasını al
        System.out.print("Hangi bolumu indirmek istersiniz? (Ornek: 1131): ");
        String bolum = scanner.nextLine();

        // URL'yi oluştur
        String url = "https://tortuga-ceviri.com/manga/one-piece/one-piece-" + bolum + "/";

        // İndirilen dosyaların kaydedileceği klasör
        String downloadFolder = "C:\\Dev\\MangaDownloader\\One Piece - " + bolum + ".Bolum\\";

        try {
            // Sayfayı indir ve parse et
            Document doc = Jsoup.connect(url).get();

            // <img> etiketlerini seç
            Elements images = doc.select(".reading-content img");

            // Bölüme özel klasör oluştur
            createFolder(downloadFolder);

            int imageCount = 0;
            for (Element img : images) {
                // Görselin URL'sini al
                String imageUrl = img.attr("src").trim();

                // Görseli indir
                downloadImage(imageUrl, downloadFolder);
                imageCount++;
            }

            System.out.println("Toplam " + imageCount + " gorsel indirildi.");
        } catch (IOException e) {
            System.err.println("Bir hata oluştu: " + e.getMessage());
        }
        
        scanner.close();
    }

    private static void createFolder(String folderPath) {
        // Klasör oluştur
        java.io.File folder = new java.io.File(folderPath);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Klasor olusturuldu: " + folderPath);
            } else {
                System.err.println("Klasor olusturulamadı: " + folderPath);
            }
        }
    }

    private static void downloadImage(String imageUrl, String downloadFolder) {
        try {
            // URL'i URI'ye dönüştürür 
            URI uri = new URI(imageUrl);
            URL url = uri.toURL();

            try (BufferedInputStream in = new BufferedInputStream(url.openConnection().getInputStream());
                 FileOutputStream out = new FileOutputStream(downloadFolder + imageUrl.substring(imageUrl.lastIndexOf("/") + 1))) {
                
                byte[] dataBuffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    out.write(dataBuffer, 0, bytesRead);
                }
                System.out.println("Indirildi: " + imageUrl);
            }
        } catch (Exception e) {
            System.err.println("Indirilemedi: " + imageUrl);
        }
    }
}