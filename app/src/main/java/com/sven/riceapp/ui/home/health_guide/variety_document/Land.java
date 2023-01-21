package com.sven.riceapp.ui.home.health_guide.variety_document;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sven.riceapp.R;

public class Land extends AppCompatActivity {

    private TextView kahalagahan,assessment,recommendation,key;

    private void findid(){
        kahalagahan = findViewById(R.id.kahalagahandecrip);
        assessment = findViewById(R.id.assessmentdecrip);
        recommendation = findViewById(R.id.recommendationdescrip);
        key = findViewById(R.id.key);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        findid();
        String kahalagahan1 = "• Sa lupang pinatag nang maayos ay magiging sabay-sabay ang paglaki ng palay at " +
                "madaling pamahalaan ito. Ito ay nakatutulong na makamit ang mga sumusunod:\n" +
                "- Mas maayos, matipid, at epektibo ang pagpapatubig; \n" +
                "- Mas madaling pamahalaan ang damo at kuhol; \n" +
                "- Mas kapaki-pakinabang ang pag-aabono;\n" +
                "- Magiging pantay ang paglaki at paggulang ng palay; at \n" +
                "- Mas madali ang paggamit ng mga makinarya sa bukid.\n\n" +
                "• Upang mapatag nang maayos ang lupa, ang mga damo at dayami ay kailangang " +
                "lubusan na napabulok at ang lupa ay naararo nang maayos. Mga 5% ang ibababa ng " +
                "ani sa lupang hindi naihandang mabuti.";


        String assessment1 = "✓ Walang mataas o mababang bahagi ng lupa na makikita matapos ang huling " +
                "pagpapatag:\n" +
                "• Walang tumpok ng lupa na makikita matapos magpatubig ng 5sm (sentimetro) sa huling " +
                "pagpapatag. \n" +
                "• Walang makikitang malalim na bahagi ng lupa matapos magpatubig.\n\n";


        String recommendation1 = "1. Linisin at ayusin ang mga kanal at pilapil. \n" +
                "• Ang malinis na pilapil ay hindi pamamahayan ng peste. \n" +
                "• Kung maayos ang pagkakasiksik ng lupa sa pilapil, hindi tatagas ang tubig sa pinitak. \n" +
                "• Hindi maglulungga ang mga daga sa pilapil na may taas na 15sm at lapad na 20sm. \n" +
                "• Ang malinis at maayos na kanal ay nakatutulong upang maging pantay ang \n" +
                "pagpapatubig sa bukid, at madali iton bawasan kung kailangan.\n\n" +
                "2. Mag-araro 21-30 araw bago magtanim gamit ang hand tractor o rotovator. \n" +
                "• Hayaang sumibol ang mga nahulog na buto ng palay at damo. \n" +
                "• I-araro sa lupa ang damo, dayami, at pinaggapasan upang mabulok ang mga ito nang " +
                "lubusan.\n" +
                "• Maglagay ng organikong pataba para maging maluwag ang paglago ng ugat at hindi " +
                "masaktan ang mga ugat ng punla sa panahon ng paglilipat-tanim.\n\n" +
                "3. Suyurin ang lupa tuwing ika-7 araw matapos mag-araro. Ang unang pagsusuyod ay " +
                "dapat ayon sa direksyon ng pag-aararo. Ang pangalawa ay dapat pasalungat upang: \n" +
                "• Mabasag ang mga tingkal ng lupa \n" +
                "• Maihalo sa lupa ang mga pinaggapasan \n" +
                "• Tumubo ang mga nahulog na buto ng palay at damo\n" +
                "• Bumagal ang pagdami ng mga peste \n" +
                "• Hindi sobrang lumalim ang putik\n\n" +
                "4. Patagin ang lupa gamit ang tabla na maaaring nakakabit sa kalabaw o hand tractor. " +
                "Ang lalim ng tubig ay kailangang 5sm nang mapadali ang pagpapatag. \n\n" +
                "5. Para sa sabog-tanim, gumawa ng maliliit na kanal sa gitna at sa gilid paikot ng pinitak " +
                "para magsilbing lagusan ng sobrang tubig, ipunan ng kuhol, at daanan kung kailangang " +
                "maghulip at magdamo. Ang kanal ay may lapad na 25sm at lalim na 5sm.\n\n\nSource: PhilRice. (2020). Sistemang Palaycheck, 9-11.\n\n";

        kahalagahan.setText(kahalagahan1);
        assessment.setText(assessment1);
        recommendation.setText(recommendation1);
        key.setText("KEY CHECK 2: Pinatag nang maayos ang lupa ");
    }
}