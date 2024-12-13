# MangaDownloader

Bu projedeki amacım; bir manga sitesinden manga bölümleri indirmeye yarayan bir program olması sağlamaktır. İlk aşama olarak bir manga serisi üzerinden gideceğim.

1.Güncelleme:
Proje için gerekli olabilecek kütüphaneleri dosya içerisine ekledim. Ayrıca proje için Jsoup kütüphanesi için ayrı bir klasör oluşturdum.

-------------------------------------------------------------------------------------------------------------------------------------------

2.Güncelleme:
Proje için geliştirmeler yapıldı. İlk olarak "One Piece" mangasını denedim. Amacım indirilecek linkten "One Piece" mangasını istediğim bölümü indirmek. Bu güncellemede eklenenler:

1.Kod içerisine indirilen bölümleri, otomatik olarak bölüm ile aynı adlı klasör oluştururup içerisine kaydedildi.
2.Klasör oluşursa "Klasör olusturuldu" mesajı erilecek, oluşturulmadıysa "Klasör oluşturulmadı" mesajı verilecek.
2.Jsoup kullanarak sayfa indirirdi ve parse edildi.
3.İndirilen linkten kaç adet görsel indirildiğini gösterirdi. Hata varsa bir "Bir hata oluştu" mesajı gösterilecek.
4.İndirmeler başarılı ise " 'İndirildi' + imageUrl ", başarız olursa " 'İndirilmedi' + imageUrl " mesajı verilecek.

-------------------------------------------------------------------------------------------------------------------------------------------

