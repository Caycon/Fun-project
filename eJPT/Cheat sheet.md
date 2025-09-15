# Cheat Sheet

---

## 1. OSINT & Information Gathering

| Mục đích | Lệnh/Tool | Ghi chú |
|---|---|---|
| Whois domain | `whois domain.com` | Thông tin đăng ký, email |
| Tra cứu DNS | `nslookup domain.com` / `dig domain.com` | Xem bản ghi DNS |
| Thu thập email | `theHarvester -d domain.com` | OSINT email, subdomain |
| Liệt kê subdomain | `sublist3r -d domain.com` | Passive subdomain enum |
| Google Dork | `site:domain.com filetype:pdf` | Tìm file, subdomain, info rò rỉ |
| Kiểm tra robots.txt | Truy cập `domain.com/robots.txt` | Tìm thư mục ẩn |
| Lịch sử web | [archive.org](https://archive.org/web/) | Xem thông tin cũ |

**Note:** Kết hợp nhiều nguồn OSINT, dùng Google Dork tìm file backup, config, kiểm tra leaks trên haveibeenpwned, github.

---

## 2. Network & Service Scanning

| Mục đích | Lệnh/Tool | Ghi chú |
|---|---|---|
| Quét thiết bị LAN | `sudo arp-scan -I eth0 192.168.x.x/xx` | Xác định IP, MAC |
| Ping sweep | `fping -g 192.168.x.x/xx` | Liệt kê host sống |
| Quét port nhanh | `nmap -F <target>` | 100 port phổ biến |
| Quét toàn bộ port | `nmap -p- <target>` | 65535 port |
| Quét dịch vụ & version | `nmap -sV <target>` | Xác định version dịch vụ |
| Quét OS | `nmap -O <target>` | Phát hiện hệ điều hành |
| Quét script | `nmap -sC <target>` | NSE script mặc định |
| Quét nhanh nhiều host | `masscan -p1-65535 192.168.x.x/xx` | Cực nhanh, cần root |

**Note:** Kết hợp nhiều công cụ để xác thực kết quả, dùng Wireshark kiểm tra traffic khi scan.

---

## 3. Enumeration & Brute-force

| Dịch vụ | Lệnh/Tool | Mục đích |
|---|---|---|
| SMB | `enum4linux -a <target>` | Liệt kê user, share, group |
| SMB | `smbclient -L //<target>` | Liệt kê share SMB |
| FTP | `ftp <target>` | Kết nối, kiểm tra anonymous |
| FTP | `nmap --script ftp-anon,ftp-bounce <target>` | Kiểm tra ẩn danh, relay |
| SSH | `nmap --script ssh2-enum-algos <target>` | Liệt kê thuật toán SSH |
| HTTP | `nikto -h <target>` | Quét lỗ hổng web |
| HTTP | `gobuster dir -u <url> -w <wordlist>` | Quét thư mục/file ẩn |
| MYSQL | `nmap --script mysql-enum <target>` | Liệt kê user, db |
| SMTP | `nmap --script smtp-enum-users <target>` | Liệt kê user SMTP |
| Brute-force | `hydra -L users.txt -P pass.txt ssh://<target>` | SSH brute |
| Brute-force | `hydra -L users.txt -P pass.txt smb://<target>` | SMB brute |
| Brute-force | `hydra -L users.txt -P pass.txt ftp://<target>` | FTP brute |

**Note:** Kết hợp nmap script với tool chuyên dụng, luôn kiểm tra version dịch vụ để tra cứu lỗ hổng.

---

## 4. Web Application Pentest

| Mục tiêu | Tool/Lệnh | Ghi chú |
|---|---|---|
| Enum directory | gobuster, ffuf, dirb | Tìm file/dir ẩn |
| Enum method | curl, nmap | Kiểm tra method hỗ trợ |
| Scan vuln | nikto, zaproxy | Lỗ hổng phổ biến |
| SQLi | sqlmap, BurpSuite | Tự động/manual |
| XSS | xsser, BurpSuite | Reflected/Stored |
| Brute-force | hydra, BurpSuite | Login form, basic auth |
| File upload/LFI | BurpSuite, curl | Kiểm tra upload, path |

**Examples:**
```bash
# Directory enum
ffuf -u http://IP/FUZZ -w wordlist.txt
gobuster dir -u http://IP/ -w wordlist.txt
dirb http://IP

# HTTP method enum
curl -X OPTIONS http://IP -v

# Nikto scan
nikto -h http://IP

# SQLi tự động
sqlmap -u "http://IP/page.php?id=1" --cookie "PHPSESSID=..." -p id --dbs

# XSS tự động
xsser --url 'http://IP/page.php' -p 'param=XSS'

# Brute-force login
hydra -L users.txt -P pass.txt IP http-post-form "/login.php:user=^USER^&pass=^PASS^:Invalid"
```

---

## 5. Privilege Escalation & Post-Exploitation

| OS | Tool/Lệnh | Mục đích |
|---|---|---|
| Linux | `find / -perm -4000 2>/dev/null` | Tìm file SUID |
| Linux | `sudo -l` | Kiểm tra quyền sudo |
| Linux | `linpeas.sh` | Enum privesc tự động |
| Windows | `whoami /priv` | Kiểm tra quyền user |
| Windows | `winPEAS.exe` | Enum privesc tự động |
| Windows | `mimikatz` | Dump credential |
| All | `ps aux` / `tasklist` | Liệt kê process |
| All | `netstat -antup` / `netstat -ano` | Liệt kê kết nối mạng |

**Note:** Luôn kiểm tra SUID, sudo, dịch vụ chạy quyền cao, file backup, credential reuse.

---

## 6. Exploitation & Post-Exploitation

| Tool | Exam | Mục đích |
|---|---|---|
| searchsploit | `searchsploit <service/version>` | Tra cứu exploit offline |
| Metasploit | `msfconsole` | Khai thác lỗ hổng |
| Metasploit | `use exploit/...` | Chọn module |
| Metasploit | `set RHOSTS <target>` | Đặt IP target |
| Metasploit | `exploit` | Thực thi |
| Meterpreter | `sessions -l` | Quản lý shell |
| Meterpreter | `getuid`, `sysinfo`, `shell` | Thông tin hệ thống |

**Note:** Đọc kỹ mô tả module, kiểm tra hậu khai thác, dùng meterpreter để kiểm soát sâu hơn.

---


## 7. Note

- **Workflow:**
	1. OSINT/Recon → 2. Scan/Enum → 3. Exploit → 4. Privesc → 5. Post-Exploitation → 6. Report

- **OSINT nâng cao:**
	- Dùng amass, assetfinder, crt.sh để tìm subdomain.
	- Google Dork: `intitle:index.of` để tìm file backup, config, .git, .env.
	- Kiểm tra leaks trên github, haveibeenpwned, hunter.io.

- **Scan/Enum:**
	- Khi scan nmap chậm, dùng `-T4`, quét nhanh trước với `-F`, sau đó quét sâu từng host.
	- Kết hợp nmap với masscan/rustscan để tăng tốc.
	- Khi bị block ICMP, dùng TCP SYN scan hoặc UDP scan.

- **Brute-force:**
	- Ưu tiên user enum được từ SMB, FTP, HTTP, rồi brute SSH/FTP/SMB.
	- Dùng hydra, medusa, crackmapexec, chú ý delay để tránh lock account.

- **Webapp:**
	- Fuzz directory/file với gobuster, ffuf, wfuzz.
	- Kiểm tra HTTP method, header, cookie, session, CSRF.
	- Khi gặp WAF, thử đổi user-agent, thêm header, dùng proxy.

- **Exploitation:**
	- Tra cứu exploit với searchsploit, kiểm tra version thật kỹ.
	- Khi exploit web, luôn kiểm tra LFI/RFI, file upload, IDOR, SQLi, XSS.
	- Khi exploit dịch vụ, kiểm tra quyền user, file backup, config, script ẩn.

- **Privilege Escalation:**
	- Linux: kiểm tra SUID, sudo, cronjob, PATH, capability, kernel version.
	- Windows: kiểm tra UAC, dịch vụ yếu, token, always install elevated, scheduled task.
	- Dùng linpeas, winPEAS, les, winenum, PrivescCheck.

- **Post-Exploitation:**
	- Dump credential: Linux (`/etc/shadow`), Windows (SAM, SYSTEM, mimikatz).
	- Persistence: tạo user, thêm SSH key, registry, scheduled task.
	- Cleanup: xóa log, clear history, che dấu dấu vết.

- **Troubleshooting & bypass:**
	- Nếu brute-force bị lock, thử delay, đổi IP, hoặc tấn công dịch vụ khác, hoặc restart lại.
	- Nếu scan bị block, thử đổi port source, dùng decoy, proxychains, VPN.
	- Nếu exploit không thành công, kiểm tra lại version, cấu hình, quyền user.
