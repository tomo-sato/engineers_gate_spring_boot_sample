# EngineersGate SpringBoot サンプルアプリケーション

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
1. アプリのDB接続設定（ [application.properties](https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/src/main/resources/application.properties) ）を確認する。
1. Eclipseでプロジェクトを起動する。

の流れになります。<br>
詳しい手順は資料を用意しました。下記参照ください。

手順書： [EngineersGate__SpringBoot_サンプルアプリケーションセットアップ.pdf](https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/EngineersGate__SpringBoot_%E3%82%B5%E3%83%B3%E3%83%97%E3%83%AB%E3%82%A2%E3%83%97%E3%83%AA%E3%82%B1%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%B3%E3%82%BB%E3%83%83%E3%83%88%E3%82%A2%E3%83%83%E3%83%97.pdf)


## 設計

使用した技術、実行環境及び設計は以下になります。

### 実行環境

- OS：Windows10
- IDE：Eclipse 2022-12
- Java：1.8.0_231
- SpringBoot：3.0.2
    - その他参照ライブラリは [build.gradle](https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/build.gradle) 参照
- MySQL：8.0.32

### DB設計

![ER図](https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/db/eg_bbs.png)

### パッケージ構成

```
src
└─main
    ├─java
    │  └─jp
    │      └─dcworks
    │          └─engineersgate
    │              └─egbbs
    │                  ├─controller      # コントローラクラスの管理。
    │                  ├─core            # コアクラスの管理。アプリ基底処理及び、設定に関する処理のプログラム群。
    │                  │  └─annotation
    │                  ├─dto             # DTOクラスの管理。入力フォーム関連。
    │                  ├─entity          # DBエンティティクラスの管理。
    │                  ├─repository      # DBアクセスリポジトリ。
    │                  ├─service         # リポジトリをラップしたサービスクラス等。他、必要に応じて外部連携等コンポーネント管理。
    │                  └─util            # ユーティリティクラスの管理。
    └─resources
        ├─static                          # 静的ファイル。js、css等。
        │  └─assets
        └─templates                       # テンプレートファイル。
            ├─account
            ├─common
            ├─error
            ├─home
            ├─login
            └─topic
```


## 画面説明

### ログイン画面

ログイン機能を提供します。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/login/index_001.jpg" width="75%">

- 「ログインID」「パスワード」を入力し、ログインします。
- 「ログインID」「パスワード」は必須入力です。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/login/index_002.jpg" width="75%">

- 「ログインID」「パスワード」を入力しなかった場合、jsでバリデーションを行いエラーとします。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/login/index_003.jpg" width="75%">

- HTMLの改ざんを考慮し、jsのバリデーションを改ざんされた場合、サーバサイドでバリデーションを行います。


### アカウント作成画面

アカウント作成機能を提供します。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/account/index_001.jpg" width="75%">

- 「お名前」「ログインID」「パスワード」を入力し、ログインします。
- 「お名前」「ログインID」「パスワード」は必須入力です。
- 「お名前」「ログインID」「パスワード」は最大文字数32文字です。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/account/index_002.jpg" width="75%">

- 「お名前」「ログインID」「パスワード」を入力しなかった場合、jsでバリデーションを行いエラーとします。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/account/index_003.jpg" width="75%">

- HTMLの改ざんを考慮し、jsのバリデーションを改ざんされた場合、サーバサイドでバリデーションを行います。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/account/index_004.jpg" width="75%">

- すでに登録されている場合（同一の「ログインID」が存在する場合）、サーバサイドでバリデーションを行います。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/account/complete_001.jpg" width="75%">

- 正常に入力が行われた場合、完了画面へ遷移しアカウントが登録されます。


### ホーム画面（トピック一覧画面）

トピック一覧参照機能を提供します。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/home/index_001.jpg" width="75%">

- トピックが投稿されていない状態ではアラートを表示します。
- 「トピックを投稿する」ボタン押下で、トピック投稿画面に遷移します。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/home/index_002.jpg" width="75%">

- トピックが投稿されている状態では、「タイトル」「本文」「ニックネーム」「投稿日時」を表示します。
- 登録済みのトピック「No.」「タイトル」「本文」のリンクよりトピック詳細画面へ遷移します。


### トピック投稿画面

トピック投稿機能を提供します。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/topic/input_001.jpg" width="75%">

- 「タイトル」「本文」を入力し、トピックを投稿します。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/topic/input_002.jpg" width="75%">

- 「タイトル」「本文」は必須入力です。
- 入力内容に誤りがある場合、サーバサイドでバリデーションエラーとします。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/topic/detail_001.jpg" width="75%">

- トピックの投稿が正常に完了した場合、トピック詳細画面へ遷移します。
- また、トピック投稿完了のメッセージを表示します。


### トピック詳細画面（コメント投稿画面）

投稿されたトピックの内容表示機能を提供します。<br>
また、トピックに対してコメントを投稿する機能を提供します。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/topic/detail_002.jpg" width="75%">

- 投稿者のトピックが閲覧できます。
- ログインしているユーザーがトピックの投稿者であった場合、トピックの削除ができます。
    - トピックを削除した場合、トピックにぶら下がるコメントも一緒に削除されます。
- トピックに対してコメントを投稿することができます。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/topic/detail_003.jpg" width="75%">

- コメントの投稿は、コメントの入力を必須としています。
- 入力内容に誤りがある場合、サーバサイドでバリデーションエラーとします。

<img src="https://github.com/tomo-sato/engineers_gate_spring_boot_sample/blob/main/doc/screenshot/topic/detail_003.jpg" width="75%">

- ログインしているユーザーのコメントであった場合、コメントの削除ができます。