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
| ≥ 85        | A+     |
| ≥ 80        | A     |
| ≥ 70        | B     |
| ≥ 60        | C     |
| ≥ 50        | D     |
| < 50        | E     |

---

## ✅ Status Kelulusan

* Nilai Akhir ≥ 70 → **LULUS**
* Nilai Akhir < 70 → **TIDAK LULUS**

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
