# 📚 Tugas Pertemuan 2 - Dasar Pemrograman Java

## 📖 Deskripsi

Project ini merupakan tugas mata kuliah **Dasar Pemrograman Java** yang bertujuan untuk menerapkan konsep dasar **Object Oriented Programming (OOP)** menggunakan Java Console.

Program dibuat untuk melakukan pendataan nilai mahasiswa, menghitung nilai akhir, menentukan grade, menentukan status kelulusan, serta menampilkan seluruh data mahasiswa yang telah diinput.

---

## 🎯 Fitur Program

* Input jumlah mahasiswa.
* Input data mahasiswa:

  * NIM
  * Nama
  * Nilai Tugas
  * Nilai UTS
  * Nilai UAS
* Menghitung nilai akhir mahasiswa.
* Menentukan grade berdasarkan nilai akhir.
* Menentukan status kelulusan.
* Menampilkan seluruh data mahasiswa.

---

## 🧮 Rumus Nilai Akhir

```text
Nilai Akhir = (30% × Nilai Tugas)
            + (30% × Nilai UTS)
            + (40% × Nilai UAS)
```

---

## 🏆 Kriteria Grade

| Nilai Akhir | Grade |
| ----------- | ----- |
| ≥ 85        | A     |
| ≥ 70        | B     |
| ≥ 55        | C     |
| ≥ 40        | D     |
| < 40        | E     |

---

## ✅ Status Kelulusan

* Nilai Akhir ≥ 60 → **LULUS**
* Nilai Akhir < 60 → **TIDAK LULUS**

---

## 📂 Struktur Project

```text
tugas
└── pertemuan2
    ├── Main.java
    ├── Mahasiswa.java
    └── NilaiService.java
```

---

## 🧱 Penjelasan Class

### 1. Main.java

Class utama yang berfungsi untuk:

* Menjalankan program.
* Menerima input dari pengguna menggunakan Scanner.
* Membuat objek Mahasiswa.
* Menampilkan hasil perhitungan.

### 2. Mahasiswa.java

Class yang digunakan sebagai model data mahasiswa.

Berisi:

* Atribut mahasiswa.
* Constructor.
* Getter.

### 3. NilaiService.java

Class yang berisi logika program, seperti:

* Menghitung nilai akhir.
* Menentukan grade.
* Menentukan status kelulusan.
* Menampilkan predikat menggunakan Switch Case.

---

## 💻 Konsep Java yang Diterapkan

Project ini menerapkan beberapa materi dasar Java, antara lain:

* Package
* Import Library
* Scanner
* Output (`System.out.println`)
* Variabel
* Tipe Data
* Operator
* Class
* Object
* Constructor
* Access Modifier (`private`)
* Getter
* Method
* Method Parameter
* Method Return
* Static Method
* Non-Static Method
* Array of Object
* If-Else
* Operator Ternary
* Switch Case
* Perulangan `for`
* Perulangan `do-while`

---

## ▶️ Cara Menjalankan Program

1. Compile seluruh file Java.

```bash
javac tugas/pertemuan2/*.java
```

2. Jalankan program.

```bash
java tugas.pertemuan2.Main
```

---

## 📷 Contoh Output

```text
Input Jumlah Mahasiswa :
2

Data Mahasiswa Ke-1
NIM           : 02042411014
Nama          : Fadllan Rizky
Nilai Tugas   : 90
Nilai UTS     : 90
Nilai UAS     : 90

Data Mahasiswa Ke-2
NIM           : 02042411015
Nama          : Tamro
Nilai Tugas   : 50
Nilai UTS     : 50
Nilai UAS     : 50

===============================
Data Mahasiswa
===============================

NIM              : 02042411014
Nama             : Fadllan Rizky
Nilai Akhir      : 90.0
Grade            : A
Status           : LULUS

NIM              : 02042411015
Nama             : Tamro
Nilai Akhir      : 50.0
Grade            : D
Status           : TIDAK LULUS
```

---
**Fadllan Rizky**
