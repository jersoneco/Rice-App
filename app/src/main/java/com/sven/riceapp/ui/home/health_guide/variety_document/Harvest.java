package com.sven.riceapp.ui.home.health_guide.variety_document;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sven.riceapp.R;

public class Harvest extends AppCompatActivity {

    private TextView kahalagahan,assessment,recommendation, key;

    private void findid(){
        kahalagahan = findViewById(R.id.kahalagahandecrip);
        assessment = findViewById(R.id.assessmentdecrip);
        recommendation = findViewById(R.id.recommendationdescrip);
        key = findViewById(R.id.key);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest);

        findid();
        String kahalagahan1 = "  • Ang paggapas at paggiik sa tamang panahon ay magbubwriga, ng magandang " +
                "kalidad ng butil ng palay at bigaskungkaNia mahal ang presyo nito sa merkado, at " +
                "uunahin pa nwrna mamimili.\n" +
                "  • Sa sobrang maagang pag-ani, maraming butil ang masasayang at mas kakaunti ang " +
                "makukuhang bigas kapag nagpagiling.\n" +
                "  • Kung atrasado naman ang pag-ani, mars mi t ang malulugas (>3% kung manu-mano). " +
                "Sa mga 32% ang madudurog na bigas kung ginapas; makina ang umani. \n\n";


        String assessment1 = "✓ Anihin ang palay kung karamihan sa mga butil ay hinog o kulay-ginto na:\n" +
                "  • 85-90% kung gagapasin/gigiikin\n" +
                "  • 90-95% kung gagamit ng combine harvester\n" +
                "  • 95-100% kung gagamitin itong binhi\n" +
                "✓ Nagiik ang ginapas na palay sa loob ng 1 araw mula pagkaati kung tag-ulan; 2 araw " +
                "kung tag-araw. \n\n";

        String recommendation1 = "1. Patuyuan ang palayan 1-2 linggo bago ang inaasahang araw ng pag-ani:\n" +
                "  • Nang maging sabay-sabay ang paggulang at paghinogng mga butil at maiwasang " +
                "mabasa ang mga butil sa anihan\n" +
                "  • Nang mapadali ang operasyon sa pag-ani\n" +
                "2. Anihin ang palay kapag 85-90% (ginapas) o 90-950, ibine harvester) ng butil ay hinog " +
                "na.\n" +
                "3. Mag-ani sa tamang MC o porsyento ng halumigmig ng butil.\n" +
                "  • Gumamit ng moisture meter. Sa tag-araw, anihin ang palay sa 18-21% MC; 20-25% " +
                "MC sa tag-ulan. " +
                "4. Pagkagapas, giikin ang palay nang hindi lalampas sa isang araw kapag tag-Ulan; 2 " +
                "araw kung tag-araw.\n" +
                "  • Huwag imbakin ang ginapas na palay nang higit sa isang araw sapagkat mag-iinit ito, " +
                "mangingitim ang butil, at pangit ang magiging bigas.\n" +
                "  • Iwasang maggiik ng basang palay dahil maraming matatapon at masasayang na butil.\n" +
                "  • Sundin ang rekomendadong threshing speed (800rpm sa pangkaraniwang thresher) " +
                "upang maihiwalay nang mabuti ang butil sa uhay.\n\n";

        kahalagahan.setText(kahalagahan1);
        assessment.setText(assessment1);
        recommendation.setText(recommendation1);
        key.setText("KEY CHECK 8: Inani ang palay sa tamang panahon");
    }
}