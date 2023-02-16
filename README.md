# Engineers Gate SpringBoot サンプルアプリケーション

Engineers Gateの教材としてSpringBootで作成した、掲示板サイトになります。


## 目的

SpringBootでのWebアプリケーション作成において、<br>
サンプルコードとして参照していただくことを目的としております。

作成した機能としては、

- アカウント作成機能
- ログイン機能
- アカウントごとのトピック作成機能
- トピックに対するコメント投稿機能

を実装しております。


## インストール方法

アプリ起動までの大まかな流れとしては、

1. git clone する。
1. Eclipseにプロジェクトをインポートする。
1. DBを作成する。
1. Eclipseでプロジェクトを起動する。

の流れになります。<br>
詳しい手順は資料を用意しました。下記参照ください。

手順書： [タイトル](https://github.com/tomo-sato/engineers_gate_spring_boot_sample)


## 使い方

使い方を記述する


## 設計

使用した技術、実行環境は以下になります。

### 実行環境

- OS：Windows10
- IDE：Eclipse 2022-12
- Java：1.8.0_231
- SpringBoot：3.0.2
    - その他参照ライブラリは [build.gradle](https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/build.gradle) 参照
- MySQL：8.0.32

### DB設計

[![ER図](https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/db/eg_bbs.png)]

