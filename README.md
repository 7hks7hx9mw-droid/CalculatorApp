# CalculatorApp

Java（Swing）で実装したシンプルな電卓アプリです。  
MVC（Model / View / Controller）アーキテクチャを採用し、  
**UI・計算ロジック・操作制御を明確に分離した構造** になっています。

四則演算だけでなく、符号反転、少数入力、バックスペース、  
クリア操作などの電卓として必要な基本機能を実装しています。

---

## 🚀 機能一覧

- 数字入力（0〜9）
- 四則演算（＋、−、×、÷）
- クリア（C）
- バックスペース（←）
- 符号反転（±）
- 小数点入力（.）
- 計算結果の表示
- 0除算エラー処理
- MVC 構造でのアプリケーション管理

---

## 🏗 使用技術

- **Java 17**
- **Swing（GUI）**
- **BigDecimal（高精度計算）**
- **JUnit（任意：計算ロジックのテストが可能）**

---

## 📚 アーキテクチャ（MVC）
- CalculatorApp.java # アプリケーション起動クラス
- CalculatorModel.java # 計算ロジック（ビジネスロジック）
- CalculatorView.java # GUI（Swing）
- CalculatorController.java # 操作制御（イベント処理）
