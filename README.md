# Enoca Backend Challenge

## 1-

MVC, Model-View-Controller kısaltmasıdır ve bir yazılım tasarım desenidir. Bu desen, bir uygulamanın farklı kısımlarını mantıklı bir şekilde ayırmak için kullanılır. Her biri farklı bir rol üstlenen üç temel bileşene sahiptir.

### Model
Model, veri ve iş mantığının bulunduğu bileşendir. Veri kaynaklarından veri alınması, işlenmesi ve depolanması gibi görevleri yerine getirir.

### View
Kullanıcı arayüzünü temsil eder. Kullanıcıya verinin nasıl görüneceğini belirler ve kullanıcı ile etkileşimi sağlar.

### Controller
Kullanıcıdan gelen istekleri ve olayları yöneten bileşendir. Kullanıcının etkileşimde bulunduğu arayüzü (View) ve veri modelini (Model) kontrol eder ve gerektiğinde günceller.

- MVC, kodun ayrıştırılmasını ve farklı kısımların bağımsız olarak geliştirilmesini sağlar. Bu sayede kodun bakımı, güncellenmesi ve genişletilmesi daha kolay hale gelir. Aynı zamanda farklı kullanıcı arayüzlerine (View) aynı modeli (Model) kullanarak destek verme yeteneği sağlar.

- Java'da, MVC genellikle Swing, JavaFX ve Spring MVC gibi GUI (Grafik Kullanıcı Arayüzü) veya web uygulamalarında kullanılır. Java'da, Swing ve JavaFX gibi GUI kütüphaneleri ile kullanıcı arayüzü oluşturulurken, Spring MVC gibi web framework'leri ile web uygulamaları geliştirirken MVC deseni uygulanabilir.

### OOP Katmanları
Nesne yönelimli (Object Oriented) katmanlar, bir uygulamanın farklı bölümlerinin ve bileşenlerinin belirli sorumluluklara sahip olduğu farklı düzeylerdir. 

**1.  Data Access :** Bu katman, veritabanı erişimini yönetir ve genellikle ORM (Object-Relational Mapping) gibi araçlar kullanarak veri tabanı ile iletişimi sağlar. ORM, veri tabanından veri okuma, veri güncelleme, veri ekleme ve veri silme gibi temel CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirerek, veri tabanı ile iletişimin soyutlanmasını sağlar.
    
**2.  Business Logic :** Bu katman, uygulamanın iş mantığı veya iş kurallarının uygulandığı yerdir. Veriye erişim, veriyi değiştirme ve veriyi kaydetme gibi işlemler bu katmanda gerçekleştirilir. İş mantığı, modelleri kullanarak veriye erişebilir ve değiştirebilir.
    
**3.  Command Processor :** Bu katman, farklı iş mantığı parçalarını çalıştırarak ve sistemdeki parçaları birleştirerek uygulamanın genel akışını yönetir. MVC (Model-View-Controller) mimarisinde "Controller" olarak adlandırılan bu katman, kullanıcı girişini (input) alır ve ilgili iş mantığı parçalarını çalıştırarak uygulamanın ilerlemesini sağlar.
    
**4.  User Interface :** Bu katman, kullanıcının uygulama ile etkileşim kurduğu yerdir. Veri görselleştirmesi (views) ve kullanıcı girişi (input) gibi işlemler bu katmanda gerçekleştirilir. MVC mimarisinde "View" olarak adlandırılan bu katman, veriyi kullanıcıya anlamlı bir şekilde gösterir ve kullanıcı girdilerini ilgili komut işlemci (command processor) parçalarına yönlendirir.
    
Bu katmanlar, bir uygulamanın farklı sorumluluklarını farklı düzeylerde yöneterek, uygulamanın modüler ve bakımı kolay bir şekilde geliştirilmesini sağlar.

```java
                                                                ,-> View
Database <-> ORM <-> Models <-> Business Logic <-> Command Processor
                                                                `<- User Input
```
***

## 2-
Farklı platformlarda yazılmış iki sistem arasında iletişim kurmak için birkaç farklı yöntem bulunmaktadır.

**1.  API (Application Programming Interface):**  Her iki platform, belirlenen bir API aracılığıyla haberleşebilir. API, belirli bir protokol ve format kullanarak veri paylaşımını sağlar. Örneğin, Java tarafında RESTful API kullanılırken, C# tarafında da RESTful API veya SOAP (Simple Object Access Protocol) gibi başka bir API türü kullanılabilir.
    
**2. Veri Paylaşımı Protokolleri:** İki platform, ortak bir veri paylaşım protokolü kullanarak haberleşebilir. Örneğin, JSON (JavaScript Object Notation) veya XML (eXtensible Markup Language) gibi veri formatları kullanılabilir. Bu formatlar, verinin belirli bir yapıda taşınmasını sağlar ve her iki platform da bu yapıya uygun veriyi işleyebilir.
    
**3.  Mesaj Kuyrukları**: İki platform, mesajlaşma protokolleri kullanarak haberleşebilir. Örneğin, Kafka veya RabbitMQ gibi mesajlaşma protokolleri kullanılabilir. Bu protokoller, asenkron bir şekilde mesajların gönderilmesine ve alınmasına olanak tanır ve farklı platformlar arasında iletişim kurmayı sağlar.
***

## 3-

Bir web sayfasında ekranın backend veya başka bir yapı tarafından güncellenen bilgileri anlık olarak ekrana yansıtmak için çeşitli teknikler bulunmaktadır.

**1.  WebSockets :** WebSockets, gerçek zamanlı iletişim sağlayan bir iletişim protokolüdür. Backend tarafında güncellenen veriler, web sayfasındaki WebSocket bağlantısı üzerinden anlık olarak tarayıcıya gönderilebilir. Tarayıcı tarafında ise WebSocket API'si kullanılarak güncel veri ekrana yansıtılabilir. Bu sayede sayfa yeniden yüklenmeden güncel veriler ekranda görüntülenebilir.
    
**2.  Server-Sent Events (SSE) :** SSE, tek yönlü bir iletişim protokolüdür ve backend tarafından anlık olarak güncellenen verileri tarayıcıya gönderir. Tarayıcı tarafında ise EventSource API'si kullanılarak güncel veriler ekranda görüntülenebilir. SSE, WebSockets gibi tam çift yönlü bir iletişim sağlamaz, ancak sadece sunucudan istemciye veri akışı sağlar.
    
**3.  Ajax :** Ajax, asenkron veri alışverişi yapabilmemizi sağlayan bir web teknolojisidir. Polling yöntemi ile backend'e belli aralıklarla sorgu göndererek güncel verileri kontrol edebiliriz. Backend tarafında güncellenen verileri sorgulama sonucunda tarayıcıya göndererek, tarayıcı tarafında da güncel veri ekranda görüntülenebilir. Ancak bu yöntem sürekli olarak backend'e sorgu gönderdiği için gereksiz yük oluşturabilir.
    
Bu yöntemlerden hangisini kullanacağınız, projenizin gereksinimlerine, kullanılabilir teknolojilere ve performans beklentilerinize bağlı olarak değişebilir.
***

## 4-

```java
public class StarPattern {
    public static void main(String[] args) {
    
        for (int i = 1; i <= 6; i++) {
	        // İlk satır için 1 yıldız yazdır, kalan satırlar için yıldız sayısını hesapla
            int numberOfStars = (i == 1) ? 1 : 2 * (i - 1);
            // Geçerli satır için yıldızları yazdır
            for (int j = 1; j <= numberOfStars; j++) {
                System.out.print("*");
            }
            // Bir sonraki satıra geç
            System.out.println();
        }
    }
}
```
***
## 5-
 - Sunucuya erişimi test etmek ve bağlanmak:
```bash
ssh kullanici_adi@ip_adresi -p port
```
 - Sunucuya dosya aktarmak:
```bash
scp dosya_adresi kullanici_adi@ip_adresi:uzak_dizin
```
 - Sunucudan dosya almak:
```bash
scp kullanici_adi@ip_adresi:dosya_adresi yerel_dizin
```
***
## 6-
# Proje API Dokümantasyonu

EnocaAPI, şirket ve çalışan bilgilerini yönetmek için kullanılan bir API'dir.


### Gereksinimler

- Java JDK 17
- Maven
- PostgreSQL veritabanı

### Kurulum

1. Bu repository'i kendi GitHub hesabınıza fork edin veya doğrudan zip olarak indirin.

2. Proje kök dizinine gidin ve aşağıdaki komutu kullanarak projeyi yerel ortamınıza klonlayın:
```bash
   git clone https://github.com/semihBiygit/enoca-challenge.git
```
3. Proje klasörüne gidin:
```bash
   cd enoca-challenge
```
4. Proje kök dizininde yer alan `application.yml` dosyasını güncelleyin. 

5. Uygulamayı derlemek için Maven kullanarak aşağıdaki komutu çalıştırın:
```bash
   mvn clean install
```
6. Uygulamayı başlatmak için aşağıdaki komutu kullanabilirsiniz:
```bash
   mvn spring-boot:run
```
7. API, http://localhost:8080 adresinde çalışmaya başlayacaktır. İsterseniz http://localhost:8080/swagger-ui/index.html adresinden Swagger ile veya Postman gibi bir API test aracı kullanarak API endpointlerine istekler yapabilirsiniz.
---
![Swagger](assets/swagger-ui.jpg)

---


Proje, aşağıdaki API endpointlerini sağlar:

## Company API

### Şirket Oluşturma
```
POST /v1/api/company
```
Bu endpoint ile yeni bir şirket oluşturulabilir. İstek gövdesinde `CreateCompanyRequestDto` formatında şirket bilgileri bulunmalıdır.

### Tüm Şirketleri Listeleme
```
GET /v1/api/company`
```
Bu endpoint ile sistemde kayıtlı olan tüm şirketlerin listesi alınabilir.

### Şirket Detayları
```
GET /v1/api/company/{id}
```
Bu endpoint ile belirtilen `id` parametresine sahip bir şirketin detayları alınabilir.

### Şirket Güncelleme
```
PUT /v1/api/company/{id}
```
Bu endpoint ile belirtilen `id` parametresine sahip bir şirketin bilgileri güncellenebilir. İstek gövdesinde `CreateCompanyRequestDto` formatında güncellenecek şirket bilgileri bulunmalıdır.

### Şirket Silme
```
DELETE /v1/api/company/{id} 
```
Bu endpoint ile belirtilen `id` parametresine sahip bir şirket sistemden silinebilir.

## Employee API

### Çalışan Oluşturma
```
POST /v1/api/employee
```
Bu endpoint ile yeni bir çalışan oluşturulabilir. İstek gövdesinde `CreateEmployeeRequestDto` formatında çalışan bilgileri bulunmalıdır.

### Tüm Çalışanları Listeleme
```
GET /v1/api/employee
```
Bu endpoint ile sistemde kayıtlı olan tüm çalışanların listesi alınabilir.

### Çalışan Detayları
```
GET /v1/api/employee/{id}
```
Bu endpoint ile belirtilen `id` parametresine sahip bir çalışanın detayları alınabilir.

### Çalışan Güncelleme
```
PUT /v1/api/employee/{id}
```
Bu endpoint ile belirtilen `id` parametresine sahip bir çalışanın bilgileri güncellenebilir. İstek gövdesinde `CreateEmployeeRequestDto` formatında güncellenecek çalışan bilgileri bulunmalıdır.

### Çalışan Silme
```
DELETE /v1/api/employee/{id}
```
Bu endpoint ile belirtilen `id` parametresine sahip bir çalışan sistemden silinebilir.

### Çalışana Şirket Ekleme
```
POST /v1/api/employee/{employeeId}/company/{companyId}
```
Bu endpoint ile belirtilen `employeeId` ve `companyId` parametrelerine sahip bir çalışana bir şirket eklenabilir.
***
## 7-
2020 Ocak ayından sonraki verileri getiren solr query'si  
```
http://example?query=updatedAt:[2020-01-01T00:00:00Z TO *]
```
***

										

## Semih Biygit
