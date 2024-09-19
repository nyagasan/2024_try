package com.example.nuka2024_try.ui.qr_scanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.nuka2024_try.R
import com.example.nuka2024_try.ui.stamps.StampsFragment
import com.google.zxing.integration.android.IntentIntegrator

class QR_Scanner_Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrscanner)

        val qrButton = findViewById<Button>(R.id.qr_button)

        // ボタンを押した際にQRスキャン画面に遷移
        qrButton.setOnClickListener {
            IntentIntegrator(this).apply {
                captureActivity = QRCodeCaptureActivity::class.java // QRスキャンアクティビティを設定
            }.initiateScan()
        }
    }

    // QRスキャン結果の処理
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // QRコード読み取り結果
        val qrCodeResult = "読み取った文字列"

// Intent に QRコード読み取り結果を格納
        val intent = Intent(this, StampsFragment::class.java)
        intent.putExtra("qrCodeResult", qrCodeResult)

// StampsFragment を起動
        startActivity(intent)
    }


    /*
    // StampsFragmentにスタンプを追加するメソッド
    private fun addStampToStampsPage(stampName: String) {
        val fragment = supportFragmentManager.findFragmentById(R.id.stampContainer) as? StampsFragment
        fragment?.addStamp(stampName)
        addStampToStampsPage("aiueo")
    }
     */
}
