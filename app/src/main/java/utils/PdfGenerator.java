package utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;

import java.util.List;

import model.PdfDataModel;

public class PdfGenerator {

    public static void generatePdf(List<PdfDataModel> datas,String filename){
        PdfDocument pdfDocument = new PdfDocument();
        Paint paint = new Paint();
        float currentDrawHeight = 0;
        //create first page header
        for (int i=0; i<datas.size(); i++) {
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(400,600,i+1).create();
            PdfDocument.Page page = pdfDocument.startPage(pageInfo);
            Canvas canvas = page.getCanvas();
            if(i==0){
                //generate 1st page contains header and first data
                paint.setColor(Color.BLUE);
                canvas.drawText("Data Rekap Komunitas Anime",200,20,paint);
                currentDrawHeight += 20;
                //draw divider
                paint.setColor(Color.BLACK);
                canvas.drawLine(50,currentDrawHeight+10,350,currentDrawHeight+10,paint);
                currentDrawHeight += 10;
            }

            //generate data-i


        }

    }

}
