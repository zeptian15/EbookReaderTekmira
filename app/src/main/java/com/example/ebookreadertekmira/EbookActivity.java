package com.example.ebookreadertekmira;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EbookActivity extends AppCompatActivity {
    @BindView(R.id.pdfView)
    PDFView pdfView;
    private String fileName = "PerahuKertas.pdf";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        ButterKnife.bind(this);

        //New instance of PDFHelper
        new PDFHelper(this, fileName, new Callable<Void>() {
            @Override
            public Void call() {
                //Callable function if download is successful
                showPDF();
                progressBar.setVisibility(View.GONE);
                return null;
            }
        }, new Callable<Void>() {
            @Override
            public Void call() {
                //Callable function if download isn't successful
                showError();
                return null;
            }
        });
    }

    public void showPDF(){
        //Getting the saved PDF
        File file = new File(this.getExternalFilesDir("pdfs") + File.separator + fileName);
        //Loading the PDF
        pdfView.fromFile(file)
                .defaultPage(0)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }

    public void showError(){
        Toast.makeText(this, "Error downloading ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Deleting the PDF that was saved
        new File(this.getExternalFilesDir("pdfs")
                + File.separator + fileName).delete();
    }
}
