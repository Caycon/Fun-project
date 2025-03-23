![image](https://hackmd.io/_uploads/rycFCSk5yg.png)
## 1.Giới thiệu
### 1.1. Bối cảnh và ý nghĩa của IDS
#### 1.1.1. Bối cảnh
 - Hệ thống phát hiện xâm nhập xuất hiện trong bối cảnh các mối đe dọa mạng ngày càng gia tăng, đặc biệt là khi các tổ chức ngày càng phụ thuộc vào hệ thống CNTT để vận hành. Với sự phát triển của Internet và mạng doanh nghiệp, các cuộc tấn công như **malware, DDoS, brute-force, SQL injection** và nhiều hình thức khác đã trở thành mối đe dọa nghiêm trọng.
 - Để đối phó với các mối nguy này, IDS ra đời nhằm giám sát lưu lượng mạng, phát hiện hoạt động đáng ngờ và cảnh báo cho quản trị viên hoặc hệ thống bảo mật để có biện pháp phản ứng kịp thời.
#### 1.1.2. Ý nghĩa
 - IDS đóng vai trò quan trọng trong an ninh mạng nhờ các lợi ích sau:
    - **Phát hiện mối đe dọa sớm:** IDS có thể phát hiện dấu hiệu của một cuộc tấn công ngay khi nó bắt đầu, giúp giảm thiểu tổn thất.
    - **Bảo vệ hệ thống và dữ liệu:** Ngăn chặn các cuộc tấn công bằng cách cảnh báo sớm cho đội ngũ bảo mật.
    - **Giám sát liên tục:** IDS hoạt động 24/7, đảm bảo hệ thống luôn được theo dõi.
    - **Hỗ trợ điều tra sự cố:** Các log do IDS ghi lại giúp phân tích nguyên nhân và cách thức tấn công.
    - **Tuân thủ quy định bảo mật:** Nhiều tiêu chuẩn bảo mật (như ISO 27001, PCI-DSS) yêu cầu tổ chức phải có cơ chế phát hiện xâm nhập.
### 1.2. Mục tiêu và phạm vi báo cáo
#### 1.2.1. Mục tiêu  
- Báo cáo này nhằm cung cấp một cái nhìn tổng quan về việc triển khai và kiểm thử hệ thống giám sát an ninh mạng bằng cách sử dụng hai công cụ phổ biến: **Snort** và **Zeek**. Cụ thể, báo cáo hướng đến các mục tiêu sau:  

    - Hiểu rõ cách thức cài đặt, cấu hình và vận hành Snort và Zeek trong hệ thống mạng.  
    - Triển khai các rule để phát hiện và ngăn chặn các cuộc tấn công mạng phổ biến như **Port Scanning, Brute Force SSH, Command Injection, và DDoS**.  
    - So sánh hiệu suất và khả năng phát hiện của Snort và Zeek trong các tình huống thực tế.  
    - Ghi nhận, phân tích log và đánh giá khả năng cảnh báo của hai hệ thống IDS này.  
    - Đưa ra nhận xét và đề xuất hướng cải tiến cho việc triển khai hệ thống giám sát an ninh mạng hiệu quả hơn.  

#### 1.2.2. Phạm vi  
- Báo cáo tập trung vào các nội dung sau:  
	- **Cài đặt và cấu hình Snort & Zeek** trên môi trường Linux.  
	- **Viết và áp dụng các rule tùy chỉnh** để phát hiện các cuộc tấn công phổ biến.  
    - **Thực hiện các kịch bản tấn công giả lập** để kiểm tra khả năng phát hiện của hệ thống.  
    - **Phân tích log và kết quả cảnh báo** từ Snort và Zeek.  
    - **So sánh, đánh giá hiệu suất và tính năng** của hai công cụ IDS. 
- Báo cáo này không đi sâu vào các phương pháp tấn công nâng cao hoặc tích hợp Snort & Zeek với các nền tảng SIEM, mà chỉ tập trung vào việc triển khai và kiểm thử độc lập hai công cụ này.  
-------
## 2.Tổng quan về Hệ thống Phát hiện Xâm nhập
### 2.1. Định nghĩa và chức năng
#### 2.1.1. Định nghĩa

 - **IDS (Intrusion Detection System)** là một hệ thống phát hiện xâm nhập được thiết kế để giám sát mạng hoặc hệ thống máy tính để phát hiện, phản ứng lại các hoạt động xâm nhập trên thiết bị. 

#### 2.1.2. Chức năng của IDS

 - Phát hiện tấn công mạng: IDS có thể nhận diện các mối đe dọa như quét cổng (port scanning), tấn công brute-force, mã độc, SQL Injection, DDoS, v.v.
 - Cảnh báo bảo mật: Khi phát hiện hoạt động bất thường, IDS sẽ gửi cảnh báo đến quản trị viên hoặc hệ thống bảo mật.
 - Lưu trữ và phân tích dữ liệu: IDS ghi lại nhật ký (log) của các sự kiện để phục vụ điều tra và xử lý sự cố.
 - Hỗ trợ hệ thống bảo mật khác: IDS có thể kết hợp với firewall, SIEM (Security Information and Event Management) để nâng cao hiệu quả bảo vệ hệ thống.
 
### 2.2. Các loại IDS: Dựa trên host, mạng và kết hợp

#### 2.2.1. Host-based IDS (HIDS) – IDS dựa trên máy chủ
 - Cách hoạt động: Giám sát các file, registry, tiến trình, nhật ký sự kiện trên một máy chủ cụ thể để phát hiện các hoạt động đáng ngờ.
 - Ví dụ: OSSEC, Wazuh, Tripwire.
 - Ứng dụng: Dùng để bảo vệ máy chủ quan trọng, hệ thống lưu trữ dữ liệu nhạy cảm.
#### 2.2.2. Network-based IDS (NIDS) – IDS dựa trên mạng
 - Cách hoạt động: Giám sát lưu lượng mạng bằng cách phân tích các gói tin để phát hiện các cuộc tấn công hoặc hoạt động bất thường.
 - Ví dụ: Snort, Suricata, Zeek (Bro).
 - Ứng dụng: Được triển khai ở cổng mạng (network gateway) hoặc các điểm quan trọng trong hệ thống mạng để bảo vệ toàn bộ hạ tầng.
#### 2.2.3. Hybrid IDS – IDS kết hợp
 - Cách hoạt động: Kết hợp cả HIDS và NIDS để tận dụng điểm mạnh của cả hai hệ thống.
 - Ví dụ: Wazuh (có cả HIDS và NIDS), IBM QRadar.
 - Ứng dụng: Dùng cho các hệ thống lớn cần giám sát nhiều lớp bảo mật, thường được tích hợp vào SIEM để phân tích chuyên sâu.

### 2.3. Ưu, nhược điểm của IDS

| **Loại IDS**  | **Ưu điểm**  | **Nhược điểm**  |
|--------------|------------|----------------|
| **HIDS**  | - Phát hiện chính xác các thay đổi trên máy chủ.  <br> - Có thể phát hiện tấn công mà không cần dựa vào mạng.  <br> - Hữu ích cho việc giám sát file quan trọng. | - Chỉ bảo vệ được máy chủ cài đặt IDS.  <br> - Không thể phát hiện tấn công trên mạng trước khi đến máy chủ.  <br> - Cần tài nguyên hệ thống để chạy (CPU, RAM). |
| **NIDS**  | - Bảo vệ toàn bộ hệ thống mạng.  <br> - Không gây ảnh hưởng hiệu suất máy chủ.  <br> - Phát hiện tấn công theo thời gian thực. | - Có thể bỏ lỡ tấn công được mã hóa (HTTPS, VPN).  <br> - Không phát hiện được tấn công nội bộ trên máy chủ.  <br> - Cần cấu hình đúng để giảm cảnh báo sai. |
| **Hybrid IDS**  | - Kết hợp ưu điểm của cả HIDS và NIDS.  <br> - Phát hiện tấn công đa lớp hiệu quả hơn.  <br> - Dữ liệu phong phú, giúp phân tích chính xác hơn. | - Cấu hình phức tạp, yêu cầu kỹ thuật cao.  <br> - Tốn tài nguyên và yêu cầu hệ thống mạnh.  <br> - Có thể sinh ra nhiều cảnh báo cần xử lý. |
-------

## 3.Giới thiệu về Snort và Zeek
- Trong lĩnh vực an ninh mạng, việc giám sát và bảo vệ hệ thống trước các mối đe dọa là nhiệm vụ quan trọng. Hai công cụ nổi bật hỗ trợ nhiệm vụ này là Snort và Zeek, cả hai đều đóng vai trò quan trọng trong việc phát hiện và phân tích các mối đe dọa trên mạng.
- **Snort** là một hệ thống phát hiện và ngăn chặn xâm nhập (IDS/IPS) mã nguồn mở phổ biến, có khả năng phân tích lưu lượng mạng theo thời gian thực và phát hiện các hành vi đáng ngờ. Với vai trò như một "lá chắn" bảo vệ hệ thống, Snort giúp nhận diện và phản ứng trước các cuộc tấn công mạng một cách nhanh chóng và hiệu quả.
- Ngược lại, **Zeek** (trước đây là **Bro**) không chỉ đơn thuần là một hệ thống phát hiện xâm nhập mà còn là một nền tảng phân tích lưu lượng mạng mạnh mẽ. Zeek tập trung vào việc thu thập, ghi nhận và phân tích dữ liệu để cung cấp cái nhìn chi tiết về các hoạt động trên mạng, hỗ trợ điều tra và phát hiện các mối đe dọa tiềm ẩn.
- Cả hai công cụ đều đóng vai trò quan trọng trong hệ thống giám sát an ninh mạng, mỗi công cụ có thế mạnh riêng và có thể kết hợp để cung cấp một hệ thống phòng thủ toàn diện.

### 3.1. Snort
#### 3.1.1. Lịch sử và phát triển của Snort

 - Snort được phát triển bởi Martin Roesch vào năm 1998. Hiện tại, Snort được phát triển bởi Sourcefire, Roesch trong vai trò là người sáng lập và CTO, được mua lại và sở hữu bởi Cisco từ năm 2013. Snort là một mã nguồn mở miễn phí với nhiều tính năng trong việc bảo vệ hệ thống bên trong, phát hiện sự tấn công từ bên ngoài vào hệ thống - một kiểu IDS/IPS, thực hiện giám sát các gói tin ra vào hệ thống.
 - Các giai đoạn phát triển:

     - **1998:** Phiên bản đầu tiên của Snort ra đời, hoạt động như một bộ phân tích lưu lượng mạng đơn giản.
     - **2001:** Martin Roesch thành lập công ty Sourcefire để thương mại hóa Snort.
     - **2003– 2012:** Snort trở thành một trong những hệ thống phát hiện xâm nhập phổ biến nhất, được nhiều tổ chức và chính phủ sử dụng.
     - **2013:** Cisco mua lại Sourcefire với giá 2.7 tỷ USD, biến Snort thành một phần quan trọng trong hệ sinh thái bảo mật của họ.
     - **Hiện nay:** Snort tiếp tục phát triển với phiên bản Snort 3.0, tối ưu hóa về hiệu suất, khả năng mở rộng và quản lý dễ dàng hơn.
 - Hơn hai thập kỷ qua, Snort không chỉ là một công cụ, mà còn là một biểu tượng của tinh thần mã nguồn mở trong an ninh mạng, với một cộng đồng mạnh mẽ luôn sẵn sàng hỗ trợ và phát triển nó ngày một tốt hơn.

#### 3.1.2. Các tính năng chính của Snort

 - Snort không chỉ đơn thuần là một công cụ giám sát mạng, mà nó còn là một "bộ óc" tinh vi giúp phát hiện và ngăn chặn các cuộc tấn công một cách hiệu quả. Dưới đây là những tính năng nổi bật làm nên sức mạnh của Snort:

    - 1. **Packet Sniffing:** Snort có thể hoạt động như một công cụ sniffer, thu thập và phân tích các gói tin đi qua mạng, tương tự như Wireshark nhưng mạnh mẽ hơn khi tích hợp thêm khả năng phát hiện tấn công.

    - 2. **Intrusion Detection System:** Snort sử dụng một tập hợp quy tắc (rules) để phân tích lưu lượng mạng, phát hiện các dấu hiệu của tấn công như:

        - Tấn công từ chối dịch vụ (DoS/DDoS)
        - Quét cổng (Port Scanning)
        - Tấn công SQL Injection, XSS
        - Hoạt động đáng ngờ của malware
     - 3. **Intrusion Prevention System:** Không chỉ dừng lại ở phát hiện, Snort còn có khả năng ngăn chặn các mối đe dọa bằng cách chặn lưu lượng nguy hiểm hoặc thay đổi gói tin để bảo vệ hệ thống.

     - 4. Linh hoạt với nhiều chế độ hoạt động
        - Snort có thể hoạt động theo nhiều chế độ khác nhau tùy vào nhu cầu:

         	- **Sniffer Mode:** Thu thập và hiển thị gói tin trực tiếp.
         	- **Packet Logger Mode:** Ghi lại dữ liệu để phân tích sau.
         	- **Network Intrusion Detection System (NIDS) Mode:** Giám sát và phát hiện các cuộc tấn công mạng theo thời gian thực.
     - 5. Cộng đồng và hỗ trợ mạnh mẽ
        - Snort có một cộng đồng đông đảo cung cấp các quy tắc phát hiện được cập nhật thường xuyên, giúp hệ thống luôn sẵn sàng đối phó với những mối đe dọa mới nhất.

#### 3.1.3. Kiến trúc và cơ chế hoạt động

- **Snort** có một kiến trúc mô-đun giúp nó hoạt động hiệu quả và linh hoạt trong việc phát hiện xâm nhập. Hệ thống của Snort được chia thành ba thành phần chính:

![image](https://hackmd.io/_uploads/ByzvF81qyx.png)

- 1. Bộ tiền xử lý (**Preprocessor**)
    - Đây là bước đầu tiên trong quá trình phân tích gói tin, nơi Snort thực hiện các tác vụ như:
        - Giải mã và kiểm tra giao thức
		- Xử lý phân mảnh gói tin
		- Phát hiện các mẫu tấn công phổ biến
- 2. Bộ phân tích và so khớp quy tắc (**Detection Engine**)
    - Đây là "trái tim" của Snort, nơi hệ thống sẽ so sánh từng gói tin với các quy tắc bảo mật để phát hiện các mối đe dọa. Hệ thống có thể sử dụng nhiều thuật toán khác nhau để đảm bảo tốc độ và độ chính xác cao.

- 3. Bộ ghi log và phản hồi (**Logging & Alerting System**)
    - Sau khi phát hiện mối đe dọa, Snort sẽ thực hiện một trong các hành động sau:

     	- Ghi log để phân tích sau
     	- Gửi cảnh báo đến quản trị viên qua email, syslog, hoặc giao diện web
     	- Kích hoạt cơ chế chặn (nếu chạy ở chế độ IPS)

##### Cách hoạt động của snort

- Snort hoạt động dựa trên một mô hình nhiều lớp để phát hiện, phân loại và ngăn chặn các hoạt động đáng ngờ trên mạng. Khi lưu lượng mạng đi qua, Snort bắt đầu quá trình của mình bằng cách sử dụng libpcap (trên hệ điều hành Linux/Unix) hoặc WinPcap/Npcap (trên Windows) để bắt giữ các gói dữ liệu. Sau đó, những gói dữ liệu này được chuyển tới bộ phân tích mạng, nơi mọi gói dữ liệu được giải mã từ các lớp giao thức mạng khác nhau như Ethernet, IP, TCP, v.v.

![image](https://hackmd.io/_uploads/Hy_SHDk5kx.png)

- Snort là một hệ thống phát hiện và ngăn chặn xâm nhập mạng hoạt động dựa trên mô hình nhiều lớp. Quá trình hoạt động của Snort được chia thành các bước chính như sau:

1. **Bắt Giữ Gói Dữ Liệu:** Snort sử dụng libpcap (trên Linux/Unix) hoặc WinPcap/Npcap (trên Windows) để bắt giữ các gói dữ liệu mạng.

2. **Giải Mã Gói Dữ Liệu:** Các gói dữ liệu này được chuyển tới bộ phân tích mạng, nơi mọi gói dữ liệu được giải mã từ các lớp giao thức mạng như Ethernet, IP, TCP, v.v.

3. **Xử Lý Trước (Preprocessors):** Các bộ xử lý trước (preprocessors) tái cấu trúc và chuẩn bị dữ liệu để phân tích, giúp phát hiện các kỹ thuật lẩn tránh thông thường.

4. **Phát Hiện Xâm Nhập:** Lưu lượng mạng được chuyển tới động cơ phát hiện của Snort, nơi dữ liệu được so sánh với các quy tắc phát hiện xâm nhập đã được định nghĩa trước. Các quy tắc này mô tả các hoạt động đáng ngờ cụ thể và chứa các signature hoặc điều kiện để nhận biết các hành động nguy hiểm.

5. **Thực Hiện Hành Động:** Khi dữ liệu khớp với một quy tắc, Snort sẽ thực hiện hành động tương ứng, có thể là ghi nhật ký, tạo cảnh báo, hoặc chặn lưu lượng mạng đó.

6. **Ghi Chép và Cảnh Báo:** Thông tin về các sự kiện nguy hiểm hoặc đáng ngờ được ghi lại trong hệ thống ghi chép và sinh ra các cảnh báo thông qua các kênh đã được cấu hình, chẳng hạn như email, logs, hoặc giao diện người dùng dựa trên web. Snort cho phép đăng ký các hành động cụ thể cho từng quy tắc, giúp người quản trị tùy chỉnh cách hệ thống phản ứng với mọi loại tấn công.

### 3.2. Zeek
#### 3.2.1. Giới thiệu Zeek
- Zeek là một nền tảng giám sát mạng mã nguồn mở, được thiết kế để phân tích lưu lượng mạng theo thời gian thực, phát hiện xâm nhập và hỗ trợ điều tra bảo mật. Được phát triển bởi Vern Paxson vào những năm 1990 tại Đại học California, Berkeley, Zeek hiện nay được sử dụng rộng rãi trong lĩnh vực an ninh mạng.
#### 3.2.2. Lịch sử hình thành
- Giai đoạn ban đầu: Bro (1995 - 2018)
    - **1995**: Vern Paxson, một nhà nghiên cứu tại Đại học California, Berkeley, đã bắt đầu phát triển Bro như một hệ thống giám sát mạng tập trung vào bảo mật.
    - 1998: Bro chính thức được công bố trong một bài nghiên cứu khoa học của Vern Paxson, mô tả cách hệ thống này có thể phát hiện các cuộc tấn công mạng bằng cách phân tích lưu lượng dữ liệu.
    - Những năm 2000: Bro tiếp tục phát triển với sự đóng góp từ nhiều tổ chức, đặc biệt là tại Viện Khoa học Máy tính Quốc tế (ICSI). Hệ thống này được sử dụng rộng rãi trong các tổ chức nghiên cứu và cơ quan chính phủ.
    - 2010s: Bro trở thành một trong những công cụ giám sát mạng phổ biến nhất, đặc biệt trong các tổ chức lớn như NSA, Bộ Năng lượng Hoa Kỳ, và nhiều trường đại học.
- Đổi tên thành Zeek (2018 - nay)
    - 2018: Nhóm phát triển quyết định đổi tên Bro thành Zeek nhằm tránh hiểu lầm với thuật ngữ "Bro culture" (văn hóa độc hại trong giới công nghệ).
    - 2019 - nay: Zeek tiếp tục được cải tiến với nhiều tính năng mạnh mẽ hơn, bao gồm hỗ trợ tích hợp với các công cụ bảo mật khác như Suricata, Elastic Stack, Splunk, Security Onion.


#### 3.2.3. Các tính năng chính của zeek
- Phân tích lưu lượng mạng (Network Traffic Analysis - NTA)
    - Zeek ghi lại toàn bộ hoạt động mạng và trích xuất thông tin quan trọng từ lưu lượng dữ liệu.
    - Không chỉ đơn thuần dựa vào dấu hiệu (signature-based) như IDS truyền thống, Zeek có thể phân tích hành vi (behavior-based) để phát hiện bất thường.
- Ghi nhật ký chi tiết (Rich Logging Capabilities)
    - Zeek tạo ra nhật ký chi tiết về các hoạt động trên mạng như:
        - conn.log: Ghi lại thông tin về tất cả các kết nối mạng.
        - http.log: Theo dõi các yêu cầu HTTP.
        - dns.log: Ghi lại truy vấn DNS.sz
        - ssl.log: Giám sát các kết nối SSL/TLS.
        - files.log: Theo dõi các tệp được truyền qua mạng.
    - Các nhật ký này giúp các nhà phân tích bảo mật dễ dàng kiểm tra và điều tra sự cố.
- Phát hiện mối đe dọa (Threat Detection)
    - Zeek có thể phát hiện hoạt động đáng ngờ hoặc độc hại dựa trên:
        - Hành vi của lưu lượng mạng (ví dụ: phát hiện quét cổng, kết nối bất thường, tấn công DoS).
        - Phân tích giao thức (chặn các giao thức nguy hiểm hoặc bất thường).
        - Phát hiện dấu hiệu xâm nhập (Intrusion Detection) bằng cách kết hợp với các công cụ như Suricata.
- Hỗ trợ giám sát bảo mật (Security Monitoring)
    - Zeek có thể được tích hợp với các hệ thống SIEM như Splunk, ELK Stack (Elasticsearch, Logstash, Kibana), Security Onion để cung cấp dữ liệu giám sát bảo mật mạnh mẽ.
    - Hỗ trợ phát hiện tấn công APT (Advanced Persistent Threats) bằng cách theo dõi hành vi của kẻ tấn công trong thời gian dài.
- Phân tích tệp (File Analysis)
    - Zeek có thể trích xuất tệp từ lưu lượng mạng và phân tích chúng.
    - Hỗ trợ kiểm tra hash của tệp để phát hiện phần mềm độc hại.
- Hỗ trợ ngôn ngữ scripting mạnh mẽ
    - Zeek có một ngôn ngữ lập trình riêng (Zeek scripting language) cho phép người dùng:
        - Viết chính sách bảo mật tùy chỉnh.
        - Phát hiện các hành vi nguy hiểm cụ thể dựa trên nhu cầu của tổ chức.
- Hỗ trợ nhiều giao thức mạng
    - Zeek có thể phân tích nhiều giao thức như HTTP, DNS, FTP, SMTP, SSL/TLS, SSH, SMB, RDP, giúp giám sát nhiều loại lưu lượng khác nhau.
- Tích hợp mở rộng với các công cụ bảo mật khác
    - Zeek có thể kết hợp với Suricata, Snort, MISP, TheHive, Velociraptor, giúp tăng cường khả năng phát hiện và phản ứng với mối đe dọa.
#### 3.2.4. Đặc điểm chính của Zeek
-  Phân tích và giám sát lưu lượng mạng
    -  Thu thập và phân tích dữ liệu mạng một cách chi tiết.
    - Hỗ trợ nhiều giao thức mạng như HTTP, DNS, SSL/TLS, FTP, SSH, SMTP,...
    - Không chỉ tập trung vào phát hiện xâm nhập mà còn cung cấp thông tin phong phú để điều tra sự cố bảo mật.
- Hệ thống tập lệnh mạnh mẽ
    - Zeek sử dụng ngôn ngữ lập trình Zeek Script để tùy chỉnh và mở rộng chức năng.
    - Người dùng có thể viết tập lệnh để xử lý dữ liệu, phát hiện bất thường và tự động hóa phản hồi bảo mật.
- Ghi nhật ký chi tiết
    - Zeek tạo ra nhiều loại nhật ký (logs) chứa thông tin quan trọng về lưu lượng mạng như:
        - conn.log – Ghi lại thông tin kết nối mạng.
        - http.log – Ghi lại thông tin về các yêu cầu HTTP.
        - dns.log – Ghi lại truy vấn và phản hồi DNS.
        - ssl.log – Ghi lại thông tin về phiên TLS/SSL.
- Phát hiện xâm nhập và bất thường
    - Zeek không sử dụng phương pháp so khớp mẫu (signature-based) như các hệ thống phát hiện xâm nhập truyền thống như Snort hay Suricata.
    - Thay vào đó, Zeek dựa trên phân tích hành vi để phát hiện các hoạt động đáng ngờ.
#### 3.2.5. Kiến trúc của Zeek
- Lớp Capture (Data Capture Layer)
    - Đây là lớp đầu tiên, chịu trách nhiệm bắt (capture) và xử lý các gói tin từ mạng.
        - Zeek thường sử dụng libpcap để thu thập dữ liệu từ giao diện mạng (eth0, wlan0, v.v.).
        - Lớp này chỉ thu thập dữ liệu thô mà chưa phân tích nội dung.
- Lớp Phân tích (Event Engine Layer)
    - Tại lớp này, Zeek giải mã (parse) các gói tin để trích xuất thông tin hữu ích từ các giao thức như HTTP, DNS, SSL/TLS, FTP, SSH, SMB, RDP, v.v.
    - Zeek chuyển đổi dữ liệu thô thành các sự kiện (events).
    - Các sự kiện này bao gồm:
        - Một kết nối TCP mới được thiết lập.
        - Một truy vấn DNS được gửi đi.
        - Một tệp tin được tải xuống qua HTTP.
- Lớp Chính sách (Policy Layer)
    - Đây là lớp quan trọng nhất, nơi Zeek xử lý dữ liệu dựa trên các tập lệnh (scripts) do người dùng hoặc hệ thống định nghĩa.
    - Lớp này giúp Zeek có thể:
        - Ghi nhật ký (logging) các sự kiện quan trọng.
        - Phát hiện mối đe dọa dựa trên hành vi của lưu lượng mạng.
        - Tích hợp với các công cụ bảo mật khác như SIEM, IDS/IPS.
    - Lớp này sử dụng Zeek Scripting Language để viết các quy tắc tùy chỉnh.
#### 3.2.6. Cơ chế hoạt động của Zeek
- Zeek hoạt động theo mô hình event-driven (hướng sự kiện), có nghĩa là nó không kiểm tra từng gói tin riêng lẻ như IDS truyền thống (ví dụ: Snort, Suricata), mà thay vào đó nó xử lý các sự kiện quan trọng trong kết nối mạng.
- **Bước 1:** Bắt dữ liệu mạng
    - Zeek sử dụng libpcap để thu thập dữ liệu từ card mạng.
    - Gói tin được chuyển đến lớp Event Engine để phân tích.
- **Bước 2:** Giải mã gói tin
    - Zeek kiểm tra các giao thức mạng để trích xuất thông tin quan trọng.
    - Ví dụ: Nếu là gói tin HTTP, Zeek sẽ lấy ra phương thức (GET, POST), URL, User-Agent, mã phản hồi HTTP.
- **Bước 3:** Tạo sự kiện
    - Dựa trên phân tích gói tin, Zeek tạo ra các sự kiện.
    - Ví dụ: Nếu phát hiện một kết nối TCP mới, Zeek tạo ra sự kiện new_connection().
    - Nếu có một truy vấn DNS, Zeek tạo ra sự kiện dns_request().
- **Bước 4:** Xử lý sự kiện bằng Zeek Scripting Language
    - Các tập lệnh Zeek (Zeek scripts) sẽ xử lý các sự kiện này.
    - Ví dụ:
        - Nếu thấy một truy vấn DNS đến domain độc hại, Zeek có thể ghi vào nhật ký dns.log và gửi cảnh báo.
        - Nếu phát hiện một tệp tin tải xuống qua HTTP, Zeek có thể lưu lại hash của tệp để kiểm tra mã độc.
- **Bước 5:** Ghi nhật ký và xuất dữ liệu
    - Sau khi xử lý, Zeek ghi dữ liệu vào các tệp nhật ký như:
        - conn.log (nhật ký kết nối mạng)
        - http.log (nhật ký HTTP)
        - dns.log (nhật ký DNS)
        - ssl.log (nhật ký SSL/TLS)
    - Zeek cũng có thể xuất dữ liệu sang SIEM, ELK Stack, Splunk hoặc gửi cảnh báo qua email.
-------
## 4.Cài đặt Snort và Zeek trên linux
### 4.1. Cài đặt Snort
- Bước 1: Cập nhật hệ thống
    - Trước khi cài đặt, bạn nên cập nhật hệ thống để đảm bảo mọi gói phần mềm đều ở phiên bản mới nhất.
```bash
sudo apt update && sudo apt upgrade -y
```

- Bước 2: Cài đặt các gói phụ thuộc
    - Snort yêu cầu một số thư viện và công cụ để hoạt động đúng:

`
sudo apt install -y build-essential libpcap-dev libpcre3-dev libdnet-dev zlib1g-dev \
    pkg-config liblzma-dev libnghttp2-dev libssl-dev tcpdump
`
- Bước 3: Cài đặt Snort
    - Ubuntu có thể cài Snort trực tiếp từ kho phần mềm:

```bash
sudo apt install -y snort
```
- Bước 4: Xác minh cài đặt
    - Sau khi cài đặt, kiểm tra phiên bản của Snort:

```bash
snort -V
```
-    - Nếu hiển thị thông tin về phiên bản Snort, tức là cài đặt đã thành công.
- Tiếp theo ta sẽ cấu hình thử và chạy demo snort.
- Bước 5: Cấu hình Snort
    - Mở file cấu hình chính:
```bash
sudo nano /etc/snort/snort.conf
```

-    - Tìm dòng:

```bash
var HOME_NET any
```
-    - Sửa thành dải mạng nội bộ của bạn, ví dụ:

```bash
var HOME_NET 192.168.1.0/24
```
- Bước 6: Chạy thử Snort
    - Snort có thể chạy ở chế độ kiểm tra:

```bash
sudo snort -T -c /etc/snort/snort.conf
```
-    - Nếu không có lỗi, bạn có thể chạy Snort ở chế độ lắng nghe gói tin:

````bash
sudo snort -A console -q -c /etc/snort/snort.conf -i eth0
````

-    - Thay eth0 bằng tên interface mạng của bạn (kiểm tra bằng ip a).

- Bước 7: Cấu hình Snort chạy dưới dạng dịch vụ (tùy chọn)
Nếu muốn Snort chạy tự động khi khởi động hệ thống, bạn có thể tạo service:

```bash
sudo nano /etc/systemd/system/snort.service
```
-    - Thêm nội dung sau:

```ini
[Unit]
Description=Snort IDS/IPS
After=network.target

[Service]
ExecStart=/usr/sbin/snort -D -c /etc/snort/snort.conf -i eth0
Restart=always

[Install]
WantedBy=multi-user.target
```
-    - Lưu lại, sau đó kích hoạt và khởi động dịch vụ:
```bash
sudo systemctl enable snort
sudo systemctl start snort
```
- Kiểm tra trạng thái:

```bash
sudo systemctl status snort
```
- Bước 8: Kiểm tra nhật ký
    - Snort sẽ ghi lại các sự kiện vào thư mục /var/log/snort/. Bạn có thể kiểm tra log bằng:

```bash
sudo tail -f /var/log/snort/alert
```

### 4.2. Zeek
- Cập nhật và cài đặt cái gói tài nguyên.
    ```
    sudo apt-get update && sudo apt-get upgrade
    ```
    ![image](https://media-hosting.imagekit.io//9f06ca3e960b470e/1.png?Expires=1834390772&Key-Pair-Id=K2ZIVPTIP2VGHC&Signature=tTFjoTcFK273ZbIiLuEAJ41d5Mq1Z8GQnDUhkicvSFLjYrzNf2PP-Uq0QFVrh70xIlpo-gQKMKxLmhHNHLdQiz7vAocIg7FKZJzWj0ooFeOn2xqYCkaGu9CK~--6IOlzzLOTQxpy-LixppIWmKYB699-ZmRaUeFPAi717jeCSOYUcw7373IcIksApmL8ClmLmQQg8dxIRfGghJdX0ef1jZowDsp4b-24JGXUPOtzl2724bcN9Y9MtWNkf1VX6YlecIoMhqzUw0vewusH6JBw9KUIRQzOJgs9WX11PsFHHXn4FiRoXyBBmljshLu~ohP7nA8GDcaN94lbM0krHNADoQ__)
- Cài đặt các gói tin cần thiết cho zeek.
    ```
    apt-get install -y --no-install-recommends g++ cmake make libpcap-dev
    ```
    ![image](https://media-hosting.imagekit.io//043654b336c04d98/2.png?Expires=1834390772&Key-Pair-Id=K2ZIVPTIP2VGHC&Signature=fCYYmHTAw3nHKer0oxtn5o~Nq~2BspeKiyD4fLqbVDGV0j9ck-ufjcuX6qiBI9qpeZSX8Y0ot4jKmWlMyZ5YMeabN~~jjv8DSYFyvBgv4r2Ga7btxmIpiNwMF12pqOcN7Z-Y~sjopoJR9ykDOD89bdqrZEowh2~V3gIPO29QRLzszyG8QZqCcezlPX-d6A0DCR5-UncJfctXz~B1NGlFhHCkL0vz5I5yJ6DV3gQfGIiVe7lrBecoKPAujL80hfW2vSTlK~tsKSrXu9q0S1KYSSHNipnJzOe2I8uAr2Q~9SlxxMT-4cYIxG76eF4WaLyZcp9SGODwO1Vqbw6zlKwAHQ__)
- Thêm repository của Zeek vào hệ thống Ubuntu 22.04 và nhập khóa GPG để xác thực gói phần mềm.

`snap install curl`

`echo 'deb http://download.opensuse.org/repositories/security:/zeek/xUbuntu_22.04/ /' | sudo tee /etc/apt/sources.list.d/security:zeek.list`

`curl -fsSL https://download.opensuse.org/repositories/security:zeek/xUbuntu_22.04/Release.key | gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/security_zeek.gpg > /dev/null
    `
    ![image](https://media-hosting.imagekit.io//a7f6a0f599b148e3/3.png?Expires=1834390772&Key-Pair-Id=K2ZIVPTIP2VGHC&Signature=P7nn1Pp5K2hqZ05v1P2g5VZwTPYT8-WJGVARQ3kgTPFk3w5Om0xFk1zDdj7pIwx6PbqtGYJCIRfB5I-yKHvIniJLSc5BBdDvlbuk9MOX8BfSJBKFjFfPGtnDRehkyBEJSis4ttWi2XdbbbkUR8oxA~1919fm5VRjCJwEbT65qbSa2GgExI3lrl3jtw2wCK5CzxYLR4uv7o6OePqo~qblueaGBNd8beHnDL8EnbiUrUYU2rqV3bePKOlm7iHk2nBQTYZYw5dRCG622gT3LKCCGZ~OIQtIgCOfv52cVad9dCstO9xX8lBsBTj0Mjy8AjHs5N~zbzjqB-RXQRxCP~wUMg__)
    ![image](https://media-hosting.imagekit.io//17fc056fd6e8494e/4.png?Expires=1834390772&Key-Pair-Id=K2ZIVPTIP2VGHC&Signature=zqb~0qzHzWJtQZB7Utx7y130RedMBGcjG81-nvxq5kfvF9sRJfJfNKVYQbtfwAy58QG5mDlGT3QHQpBQxwpVEremFBBsFbsAVSYlMYn-tCTNYu4q80FBs8EchlFRneyh0ALu-yf-iWWP-ZXKj3-8dlGfVG9dD4yalN9bK7o~J8Im3P7N4-MBe-2M-Ab5XeKZgI9RWWmGn7pSYyx5W15Ae0Gjfr9WeKk5pkQeZD8lInxJUuOPVLH0uUpX0giE1yoTyNoCEa1HQrK2Imz4iulmogY2tXe8BENBwmdR5HG0eeXkrKm3oFLqgjr3M3CtNdxsa9zc~BWuKQNy6aQSyouqtA__)
- Cập nhật lại các gói tin để tiến hành tải zeek.
    ```
    sudo apt update
    sudo apt install zeek-6.0
    ```
    ![image](https://media-hosting.imagekit.io//93db9bd17d54426f/5.png?Expires=1834390772&Key-Pair-Id=K2ZIVPTIP2VGHC&Signature=sVeN3Fd5XvadnNzCnuEXWTUABHaLE2cl7bHsurns6aDX89DpraN~~RKsU4ugVNbagD~FMAEdCE9~Ab6YNYhi50HUt3g9zdmE~AwcwemIWGatHiRxej0LQce22FMXPUxPVXXlMML2M1KczKjEnm1yOUrYc25PpTSxqmPa5s4Kz3WfhZZ6~cTL49v625bn-xbchKs95Ku3HYO4lH88wZ5xNscIbFJmEsd0poAGTHa~bVoU7EZjpKwqc2Yvr0SAkO6yjXDqWAeBAWqHvtJxGd3ep8I8FSz3FRVXR14ethdi2UNks8Y~yTqwoquHen-ha65jgXPLSRUi8O3L6xPnLjN1Jg__)
- Sử dụng `ifconfig` để check network interface.
    ```
    sudo apt install net-tools -y
    ifconfig
    ```
- Sau đó vào file `node.cfg` để chỉnh sửa như ảnh.
    ```
    nano /opt/zeek/etc/node.cfg
    ```
    ![image](https://media-hosting.imagekit.io//e21119869897491f/6.png?Expires=1834390772&Key-Pair-Id=K2ZIVPTIP2VGHC&Signature=OsfuBCDhcsuTinbZB3y3tBiTJyzTcd0nzLiTLwQv0MzGP~vY8KGmdmiyqETN2cqQJdX3orxX83rFXKbSzxbnCCAtfRP7OGqWvZmHl1ROriNZGsFmkBogzLzxy0hFcKjm3H7l6MDG45CjkzqROi3Lw5FxOG5M24KqU4y4~M1Ld-qaadr4p4LSvF9s~35izpLkvMY~78f4nrJxjW40shxX5mm736NXMHYIq20xPi1f2VVyZCZH~8LjLyoLX-CsyyS8Xq4DDXpnWxFGDi3JZ-mj08niGpE8A9PjCB-94o3bVPmsVCQ1imyLKJ3gY6lvrjPYOnYJisxTPH1j0j9cGedPvQ__)
- Vào file `.bashrc` add vào dòng lệnh `export PATH=/opt/zeek/bin:$PATH`
    ```
    nano ~/.bashrc
    ```
    ![image](https://media-hosting.imagekit.io//2dc04edbce244275/7.png?Expires=1834390772&Key-Pair-Id=K2ZIVPTIP2VGHC&Signature=ILA82lR9M2nrFFAT9ugKmfFqcnB69-2CNDAstUUMfrb3wEw9aLBFpHO6m8jlJzqYs9DRyV4q2l1NM99qeXp4h9ySIps6RPRArifH06UIqv6vcHphXDLe8KGusK3dQ9zQvF2olwtQTYaxQMMfOYQjqxuxbfU~yUEGuTF7gJKXssKVWyRCev9paWbnItSskl1Expu26Nivh4rDrIQ6xoVhOfJJ6fet99LMhZxWkDh~PSWPxL-acVC8CcnLpfMM74QbJ~oY4XB-xyVU3zAH~EG82HL3VmEq3Fy7IjA630MauCoBfSfg7MAMR77-2WYOXugj3oKw7m3T-bDUzpG0vUQ0RQ__)
- Sử dụng lệnh `source ~/.bashrc` dùng để tải lại file cấu hình, và hãy check lại xem zeek đã hoạt động chưa
    ![image](https://media-hosting.imagekit.io//c55de5c9978f4831/8.png?Expires=1834390772&Key-Pair-Id=K2ZIVPTIP2VGHC&Signature=Pn~UbH2PWdxIszT5a4EIjriCu3gJy~a6DVynZAMYz2~iKim5VG5b4EjFd6Ls-VZeNMIguSFXmKtglEklL65dQov-q1UaoTpqwQkvJYOnFmIWb9ZH~7M6GL7P5MA-sfYAhxs4KATxmnC7mhDcxQ3bZrnBFo8qA3kBLsV~GxybuH9AQE0KaBkeB6CB-mgJ1B4poyX66Ek-XIKyXn86IyB-QQFjrqaZUtWCbz3xpw5KF47y9OyospEMRK3~~b4idpTNjMV~K82B4CJI2vgzYZrgRPY18fVj306ZRYla2r6usE2sgF~8IAzpQw9Yq4ZijNOWtS4KrCcjo7XWHtn4uqUOpQ__)
-------
## 5.Xây dựng và đặt Rules trong Snort
### 5.1. Cấu trúc và cú pháp của quy tắc Snort

#### Cấu trúc của một Snort Rule:

- Tất cả các rule Snort đều bao gồm hai phần chính: **header** và **options**.

##### Header của rule Snort
- Header chứa thông tin về hành động mà rule sẽ thực hiện và các tiêu chuẩn để so sánh rule với gói tin. Cấu trúc tổng quát của phần header như sau:

```plaintext
action protocol source_IP source_port -> destination_IP destination_port
```

- Trong đó:
    - **Action:** Xác định kiểu hành động được thực hiện khi một tiêu chuẩn được thỏa mãn và rule khớp với gói tin dữ liệu. Hành động điển hình bao gồm việc tạo ra các cảnh báo hoặc ghi lại thông điệp log.
	- **Protocol:** Giao thức mạng mà rule áp dụng, ví dụ: IP, TCP, UDP, ICMP.
	- **Source_IP:** Địa chỉ IP nguồn của gói tin.
	- **Source_Port:** Cổng nguồn của gói tin.
	- **Destination_IP:** Địa chỉ IP đích của gói tin.
	- **Destination_Port:** Cổng đích của gói tin.
	- **Direction:** Định hướng của rule xác định địa chỉ và cổng nào được sử dụng như là nguồn hoặc đích.

##### Options của rule Snort
- Phần options thường chứa các thông điệp cảnh báo và thông tin về phần nào của gói tin được sử dụng để tạo ra cảnh báo. Một rule có thể phát hiện một hoặc nhiều kiểu xâm nhập.

- Ví dụ về một rule Snort hoàn chỉnh:

`alert tcp any any -> 192.168.1.0/24 80 (msg:"HTTP GET request detected"; content:"GET"; sid:1000001; rev:1;)
`

#### Chi tiết các thành phần của Header

- **Action:** Định nghĩa hành động cần thực hiện khi rule khớp:
  - `alert`: Gửi cảnh báo.
  - `log`: Ghi lại thông tin gói tin.
  - `pass`: Bỏ qua gói tin.
  - `activate`: Kích hoạt rule khác.
  - `dynamic`: rule động, được kích hoạt bởi rule `activate`.

- **Protocol:** Giao thức mạng như IP, TCP, UDP, ICMP.

- **Address:** Địa chỉ nguồn và địa chỉ đích:
  - Địa chỉ có thể là của một host cụ thể, nhiều host, hoặc địa chỉ mạng.

- **Port:** Sử dụng trong trường hợp TCP hoặc UDP:
  - Xác định cổng nguồn và đích của gói tin. Đối với giao thức IP và ICMP, số port không có ý nghĩa.

- **Direction:** Xác định hướng của gói tin:
  - `->` Định hướng từ nguồn đến đích.
  - `<->` Hai chiều, không xác định rõ nguồn và đích.

### 5.2. Zeek

#### Xây dựng và đặt Rules trong Zeek
##### 5.2.1. Cấu trúc cơ bản của script Zeek
- Một script Zeek thường bao gồm các thành phần sau:

    - Khai báo module: Tổ chức mã trong các không gian tên để tránh xung đột.
    - Khai báo biến và hằng: Định nghĩa các biến và hằng số sử dụng trong script.
    - Định nghĩa hàm: Tạo các hàm để thực hiện các tác vụ cụ thể.
    - Xử lý sự kiện: Định nghĩa các hành động khi một sự kiện cụ thể xảy ra.
    - Quy tắc và chính sách: Định nghĩa các điều kiện và hành động cụ thể
- Rule của zeek khá giống với các ngôn ngữ lập trình khác, gồm các hàm, biến, toán tử, thư viện, lệnh ..v.v.. Ví dụ: 
    ```
    @load base/frameworks/notice
    @load base/protocols/http
    module MyModule;

    export {
        const threshold = 100;
        global conn_count: table[addr] of count = {};
    }

    event connection_established(c: connection) {
        conn_count[c$id$orig_h] += 1;

        if (conn_count[c$id$orig_h] > threshold) {
            print fmt("IP %s đã vượt ngưỡng kết nối: %d", c$id$orig_h, conn_count[c$id$orig_h]);
        }
    }

    ```
##### 5.2.2. Các kiểu dữ liệu cơ bản:
- `int`: Số nguyên.
- `count`: Số nguyên không âm.
- `double`: Số thực.
- `string`: Chuỗi ký tự.
- `bool`: Giá trị logic (true/false).
- `time`: Thời gian.
- `interval`: Khoảng thời gian.
- `pattern`: Biểu thức chính quy.
- `addr`: Địa chỉ IP.
- `port`: Cổng mạng.
##### 5.2.3. Cú pháp cơ bản trong Zeek
- Khai báo biến và hằng số:
    ```
    global my_variable: int = 10;
    const my_constant: string = "Hello, Zeek!";
    ```
    - global dùng để khai báo biến toàn cục.
    - const dùng để khai báo hằng số.
- Định nghĩa sự kiện (event handlers):
    ```
    event connection_established(c: connection)
    {
        print "Connection established", c$id$orig_h, c$id$resp_h;
    }
    ```
    - event là từ khóa dùng để định nghĩa một sự kiện.
    - connection_established là tên sự kiện, được kích hoạt khi một kết nối mới - được thiết lập.
    - c: connection là tham số truyền vào, đại diện cho thông tin kết nối
- Các hàm và thủ tục (functions và procedures):
    ```
    function add(a: int, b: int): int
    {
        return a + b;
    }

    procedure log_message(msg: string)
    {
        print msg;
    }
    ```
    - function dùng để định nghĩa một hàm có giá trị trả về.
    - procedure dùng để định nghĩa một thủ tục không có giá trị trả về.
- Các quy tắc và chính sách:
    ```
    rule my_rule
    {
        condition
        {
            return some_condition == true;
        }
        action
        {
            print "Condition met!";
        }
    }
    ```
    - rule dùng để định nghĩa một quy tắc.
    - condition là điều kiện để quy tắc được kích hoạt.
    - action là hành động được thực hiện khi điều kiện được đáp ứng.
##### 5.2.4. Framework và Module
- Zeek cung cấp nhiều module để mở rộng khả năng giám sát, phân tích và xử lý dữ liệu mạng. Các module này được thiết kế để giúp người dùng dễ dàng tích hợp các tính năng phức tạp vào kịch bản của mình.
- Dưới đây là các chức năng cơ bản của zeek, vẫn còn rất nhiều các Framework và Module khác hữu dụng và tiện ích hơn nữa.
###### 5.2.4.1 Framework

| **Framework** | **Mục đích** |
|----------------------------|--------------|
| **Notice Framework**        | Tạo và quản lý cảnh báo (notices). |
| **Logging Framework**       | Ghi log các sự kiện mạng. |
| **Sumstats Framework**      | Thống kê dữ liệu mạng (ví dụ: đếm số lượng kết nối, yêu cầu HTTP). |
| **Intel Framework**         | Tích hợp dữ liệu threat intelligence để phát hiện mối đe dọa. |
| **File Analysis Framework** | Phân tích file được truyền qua mạng (ví dụ: file đính kèm email). |
| **Packet Filtering Framework** | Lọc gói tin dựa trên điều kiện (ví dụ: lọc theo cổng hoặc giao thức). |

- Cách sử dụng: Gọi các hàm của framework trong sự kiện.
    ```
    event http_request(c: connection, method: string, uri: string)
    {
        if (uri == "/admin")
        {
            NOTICE([$note=Notice::ALARM, $msg="Admin access detected"]);
        }
    }
    ```
###### 5.2.4.2 Module

| **2. Các Module Chính**     | **Mục đích** |
|----------------------------|--------------|
| **HTTP Module**             | Phân tích lưu lượng HTTP (yêu cầu, phản hồi, header, v.v.). |
| **DNS Module**              | Phân tích lưu lượng DNS (truy vấn, phản hồi, tên miền, v.v.). |
| **SSL/TLS Module**          | Phân tích lưu lượng SSL/TLS (chứng chỉ, phiên kết nối, v.v.). |
| **SMTP Module**             | Phân tích lưu lượng email (gửi/nhận email, file đính kèm, v.v.). |
| **FTP Module**              | Phân tích lưu lượng FTP (đăng nhập, tải lên/tải xuống file, v.v.). |
| **SSH Module**              | Phân tích lưu lượng SSH (phiên kết nối, xác thực, v.v.). |

- Cách sử dụng: Sử dụng `@load` để tải module (Như import thư viện trong python, c, c++)
    ```
    @load base/frameworks/notice
    @load base/protocols/http
    ```
-------
## 6.Triển khai và Kiểm thử Hệ thống
### 6.1. Snort
#### 6.1.1 Cấu hình rules trong Snort
-    Thêm rule vào trong file local.rules trong folder /etc/snort/rules
        ```
        sudo nano /etc/snort/rules/local.rules
        ```
-    Chạy thử Snort ở chế độ kiểm tra
        ```
        sudo snort -T -c /etc/snort/snort.conf
        ```
-    Nếu không có lỗi, bạn có thể chạy Snort ở chế độ lắng nghe gói tin:

        ````bash
        sudo snort -A console -q -c /etc/snort/snort.conf -i eth0
        ````

-    Thay eth0 bằng tên interface mạng của bạn (kiểm tra bằng ip a).
#### 6.1.2 Thực hiện các kịch bản tấn công mô phỏng (1, 2, 3, 4).
-    **Kịch bản 1:** Phát hiện TCP SYN Scan
    -    Cảnh báo phát hiện 10 gói tin TCP với cờ SYN được bật từ cùng 1 địa chỉ IP nguồn trong vòng 5 giây.
    -    Alert Rule: ``alert tcp any any -> any any (msg:"TCP SYN Scan detected"; flags:S; threshold:type both, track by_src, count 10, seconds 5; sid:40001;)`` 
    -    Attack Command: ``nmap -sS -p 1-1000 192.168.136.213``
    ![image](https://hackmd.io/_uploads/ByKNlue51l.png)

-    **Kịch bản 2:** Phát hiện tấn công Brute Force SSH
    -    Cảnh báo phát hiện 10 kết nối SSH từ cùng một địa chỉ IP nguồn trong vòng 50 giây.
    -    Alert Rule: ``alert tcp any any -> any 22 (msg:"SSH Brute Force Detected"; flow:to_server,established; detection_filter:track by_src, count 10, seconds 50; sid:20001;)`` 
    -    Attack Command: ``hydra -l user -P /home/user/wordlists/rockyou.txt 192.168.231.129 ssh -I`` hoặc có thể sử dụng các ngôn ngữ lập trình để tấn công.
    ![image](https://hackmd.io/_uploads/H1PDxdg5kg.png)

-    **Kịch bản 3:** Phát hiện tấn công Command Injection
    -    Cảnh báo phát hiện sử dụng Command Injection dựa trên các ký tự đặc biệt và lệnh nguy hiểm trong các requests.
    -    Alert Rule: ``alert tcp any any -> any 80 (msg:"Command Injection Attempt"; pcre:"/(\;|%3B|\&|%26|\||%7C|\`|%60|\$\(|%24\()\s*(ls|cat|rm|wget|curl|id|cd|whoami)/i"; sid:20002;)`` 
    -    Attack Command: Sử dụng kỹ thuật Command Injection với web server, ví dụ: ``;cd ../../.. && ls && cat /etc/passwd;``
         ![image](https://hackmd.io/_uploads/HJlkCyOlqkg.png)

-    **Kịch bản 4:** Phát hiện và ngăn chặn tấn công Command Injection
    -    Cảnh báo phát hiện sử dụng Command Injection dựa trên các ký tự đặc biệt và lệnh nguy hiểm trong các requests và chặn ngay lập tức.
    -    Alert Rule: ``drop  tcp any any -> any 80 (msg:"Command Injection Attempt"; pcre:"/(\;|%3B|\&|%26|\||%7C|\`|%60|\$\(|%24\()\s*(ls|cat|rm|wget|curl|id|cd|whoami)/i"; sid:20003;)`` 
    -    Attack Command: Sử dụng kỹ thuật Command Injection với web server, ví dụ: ``;cd ../../.. && ls && cat /etc/passwd;``
         ![image](https://hackmd.io/_uploads/HJlkCyOlqkg.png)
#### 6.1.3 Ghi nhận và phân tích log, cảnh báo+
-    **Kịch bản 1**

        `02/17-15:26:20.175861  [**] [1:40001:0] TCP SYN Scan detected [**] [Priority: 0] {TCP} 192.168.136.232:53141 -> 192.168.136.213:143`
        
        `02/17-15:26:22.095654  [**] [1:40001:0] TCP SYN Scan detected [**] [Priority: 0] {TCP} 192.168.136.232:53141 -> 192.168.136.213:824`

-    - Giải thích
            -    Snort phát hiện một cuộc TCP SYN Scan xuất phát từ 192.168.136.232 đến máy đích 192.168.136.213 trên các cổng 143 (IMAP) và 824.
            -    SYN Scan là một kỹ thuật của Port Scanning, thường được sử dụng để kiểm tra xem các cổng nào đang mở trên hệ thống đích.
-    **Kịch bản 2**

`02/17-15:32:36.421578  [**] [1:20001:0] SSH Brute Force Detected [**] [Priority: 0] {TCP} 192.168.136.1:50690 -> 192.168.136.213:22`

`02/17-15:32:36.452432  [**] [1:20001:0] SSH Brute Force Detected [**] [Priority: 0] {TCP} 192.168.136.1:50690 -> 192.168.136.213:22`
        
`02/17-15:32:38.442590  [**] [1:20001:0] SSH Brute Force Detected [**] [Priority: 0] {TCP} 192.168.136.1:50692 -> 192.168.136.213:22`

- - Giải thích: Phát hiện hành vi bruteforce SSH từ địa chỉ 192.168.136.1 khi đã có quá 10 kết nối trong vòng 50 giây.

-    **Kịch bản 3**

`02/17-15:41:16.960350  [**] [1:20002:0] Command Injection Attempt [**] [Priority: 0] {TCP} 192.168.136.1:50821 -> 192.168.136.213:80`

`02/17-15:41:52.974528  [**] [1:20002:0] Command Injection Attempt [**] [Priority: 0] {TCP} 192.168.136.1:50828 -> 192.168.136.213:80`

`02/17-15:42:06.884834  [**] [1:20002:0] Command Injection Attempt [**] [Priority: 0] {TCP} 192.168.136.1:50834 -> 192.168.136.213:80`

- - Giải thích: Phát hiện hành vi gửi HTTP request đáng ngờ chứa các ký tự đặc biệt và các câu lệnh nguy hiểm từ địa chỉ IP nguồn là 192.168.136.1 qua port 50821.

-    **Kịch bản 4**
-    
`02/17-15:45:19.310256 [Drop] [**] [1:20002:0] Command Injection Attempt [**] [Priority: 0] {TCP} 192.168.136.1:50821 -> 192.168.136.213:80`

`02/17-15:45:55.371342 [Drop] [**] [1:20002:0] Command Injection Attempt [**] [Priority: 0] {TCP} 192.168.136.1:50828 -> 192.168.136.213:80`

- - Giải thích: Phát hiện hành vi gửi HTTP request đáng ngờ chứa các ký tự đặc biệt và các câu lệnh nguy hiểm từ địa chỉ IP nguồn là 192.168.136.1 qua port 50821. Sau đó đã chặn địa chỉ IP nguồn này.

### 6.2. Zeek
#### 6.2.1 Thiết lập rule cho Zeek
- Bạn vào foler chứa các rule:
    ```
    cd /opt/zeek/share/zeek/site
    ```
- Tạo file rule và add rule của bạn vào:
    ```
    nano your_rule.zeek
    ```
- Sau đó vào file local.zeek ở đường dẫn này lun `/opt/zeek/share/zeek/site`, import rule của bạn vào.
    ```
    @load site/your_rule
    ```

#### 6.2.2 Thực hiện các kịch bản tấn công mô phỏng (1, 2).
- **Kịch bản 1:** Tấn công Port Scan
    - Cho phép theo dõi toàn bộ các kết nối TCP, UDP gửi tới zeek.
    - Rule:
    ```
    @load base/protocols/conn

    event connection_state_remove(c: connection) {
        if (c$conn$history == "S") {
            print fmt("Nmap scan detected: %s:%s -> %s:%s",
                      c$id$orig_h, c$id$orig_p, c$id$resp_h, c$id$resp_p);
        }
    }
    
    ```
    - Attack Command: `nmap -sS 192.168.138.xxx`
- **Kịch bản 2:** Tấn công DDOS
    - Cho phép theo dõi toàn bộ các kết nối TCP, UDP gửi tới zeek
    - Rule:
        ```
        @load base/protocols/conn
        @load base/frameworks/notice 
        module DDoS_Detection;
        export { 
            redef enum Notice::Type += { DDoS_Attempt }; 
        }
        global ddos_attempts: table[addr] of count &default=0;
        event new_connection(c: connection) {

            if (c$id$resp_p == 80 && c$proto == "tcp" && c$history == "S") {                                        
                ddos_attempts[c$id$orig_h] += 1;

                if (ddos_attempts[c$id$orig_h] > 50) {
                    NOTICE([
                    $note=DDoS_Attempt, 
                    $msg=fmt("[!] DDoS SYN Flood detected from %s",c$id$orig_h),
                    $sub=fmt("%s", c$id$orig_h),
                    $identifier=c$id$orig_h, 
                    $conn=c
                    ]);
                }
            }
        }

        ```
        
    - Attack Command: `hping3 -2 -p 53 --flood 192.168.138.xxx`
#### 6.2.3 Ghi nhận và phân tích log, cảnh báo
- **Kịch bản 1:** Tấn công Port Scan
![nmap_scan](https://hackmd.io/_uploads/BJmk5dx9ke.png)
    - Giải thích: Ta có thể thấy rất nhiều log với nhiều port khác nhau được gửi tới zeek bằng TCP, và zeek cũng có cảnh báo có dấu hiệu scan port đến từ IP 192.168.138.209 (máy attacker)
- **Kịch bản 2:** Tấn công DDOS
![ddos](https://hackmd.io/_uploads/S1vz2dx9Jl.png)
    - Giải thích: Ta có thể thấy rất nhiều log với UDP protocol được gửi tới zeek và cũng từ IP 192.168.138.209 (máy attacker)
    -------
## 7.Phân tích kết quả và đánh giá Hiệu quả
### 7.1. Hiệu quả của Hệ thống Giám sát

- Sau khi triển khai và kiểm thử hệ thống Snort và Zeek với các kịch bản tấn công mô phỏng, ta có thể đánh giá hiệu quả của hệ thống như sau:
    - **Snort**:
        - Có khả năng phát hiện các kiểu tấn công phổ biến như TCP SYN Scan, SSH Brute Force, Command Injection.
        - Khi cấu hình đúng, Snort có thể chặn ngay lập tức các cuộc tấn công nguy hiểm như Command Injection.
        - Các cảnh báo được ghi nhận đầy đủ trong log và có thể dễ dàng phân tích.
    - **Zeek**:
        - Hiệu quả trong việc giám sát mạng ở mức sâu hơn, phát hiện các cuộc tấn công như Port Scan, DDoS.
        - Log của Zeek chi tiết, giúp dễ dàng phân tích các hành vi đáng ngờ.
        - Rule của Zeek có thể tùy chỉnh theo nhu cầu giám sát cụ thể.

### 7.2. Hạn chế của Hệ thống

- **Snort:**
    - Rule dựa trên mẫu cố định, dễ bị bypass nếu tấn công được tùy biến.
    - Không có khả năng phân tích lưu lượng mạng sâu như Zeek.
- **Zeek:**
    - Không có cơ chế chặn trực tiếp các cuộc tấn công, chỉ phát hiện và log lại.
    - Cần thời gian để phân tích dữ liệu log, khó phản ứng ngay lập tức với tấn công.

| Tiêu chí         | Snort                           | Zeek                         |
|-----------------|--------------------------------|------------------------------|
| **Chức năng chính** | Phát hiện và ngăn chặn xâm nhập dựa trên rule | Phân tích và ghi log lưu lượng mạng |
| **Cơ chế hoạt động** | Dựa trên signature-based detection (quy tắc định nghĩa trước) | Dựa trên phân tích hành vi (behavioral analysis) |
| **Ngôn ngữ scripting** | Quy tắc viết theo cú pháp Snort | Sử dụng Zeek scripting language |
| **Hiệu suất**   | Nhẹ, nhanh, phù hợp với real-time detection | Nặng hơn Snort do phân tích chuyên sâu |
| **Khả năng tùy chỉnh** | Chủ yếu dựa vào các rule định sẵn | Linh hoạt, có thể viết script để giám sát tùy chỉnh |
| **Phát hiện tấn công** | Tốt trong phát hiện tấn công dựa trên signature | Mạnh trong phát hiện tấn công zero-day và bất thường |
| **Ghi log**     | Ghi log dựa trên alert | Ghi log chi tiết về toàn bộ traffic |
| **Chặn tấn công** | Có thể chặn tấn công khi kết hợp với firewall | Không chặn trực tiếp, chủ yếu dùng để giám sát |
| **Ứng dụng thực tế** | Tích hợp với firewall để chặn tấn công | Phù hợp cho forensic analysis và threat hunting |
-------
## 8.Kết luận
### 8.1. Kết luận
- Việc triển khai Snort và Zeek đã giúp xây dựng một hệ thống giám sát mạnh mẽ, có khả năng phát hiện nhiều dạng tấn công phổ biến. Cả hai công cụ đều cung cấp các tính năng quan trọng:
    - Snort: Phù hợp để phát hiện và ngăn chặn các tấn công dựa trên rule.
    - Zeek: Phù hợp để phân tích lưu lượng mạng và phát hiện các hành vi đáng ngờ một cách chi tiết.
### 8.2. Đề xuất Cải thiện
- Để nâng cao khả năng giám sát và phản ứng với tấn công, có thể áp dụng các cải tiến sau:
    - Kết hợp Snort và Zeek để tận dụng thế mạnh của cả hai:
		- Dùng Snort để chặn trực tiếp các tấn công phổ biến.
		- Dùng Zeek để phân tích chuyên sâu các hành vi mạng và phát hiện các cuộc tấn công tinh vi hơn.
        - Tích hợp với SIEM (Security Information and Event Management) để quản lý log tập trung và tự động hóa phát hiện tấn công.
        - Sử dụng Machine Learning để phát hiện các hành vi tấn công mới mà không cần rule cố định.
        - Cập nhật rule thường xuyên để đảm bảo khả năng phát hiện tấn công mới nhất.

- Hệ thống giám sát mạng cần được duy trì và cập nhật liên tục để đối phó với các mối đe dọa ngày càng tinh vi. Việc triển khai Snort và Zeek là một bước quan trọng trong việc bảo vệ hệ thống trước các cuộc tấn công mạng.
-------
## Tài liệu Tham khảo
- [Hướng dẫn cài đặt Ubuntu trên VMware](https://www.youtube.com/watch?v=X0k-2si-qow).
- [Cài đặt Snort trên Ubuntu](/Zv70_jMPT_ib7yvRX6doBA).
- [Cài đặt Zeek trên Ubuntu](https://vi.linux-console.net/.?p=30832).
- [Cách cấu hình Snort](https://vi.linux-console.net/?p=17525).

#  