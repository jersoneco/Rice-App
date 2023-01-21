package com.sven.riceapp.ui.home.health_guide.variety_document;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.sven.riceapp.R;

public class Variety extends AppCompatActivity {

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
        setContentView(R.layout.activity_variety);
        findid();
        String kahalagahand = "• Ang dekalidad na binhi ay puro, wala o bihira ang naihalong buto ng damo, walang " +
                "makikitang taglay na sakit, buo, pare-pareho ang laki at hugis, at 85% pataas ang antas " +
                "ng pagsibol.\n" +
                "• Ang ani ng dekalidad na binhi ay 10% o higit pa na mas mataas ang ani kaysa sa " +
                "karaniwang binhi. Lumalaki at nahihinog nang sabay-sabay ang pananim kaya mas " +
                "madali itong anihin.\n" +
                "• Ang mga rekomendadong barayti ay angkop sa lokal na kondisyon. Matibay sila sa " +
                "mga sakit at peste na laganap sa inyong lugar, mataas umani, at mabili sa merkado.\n\n";

        String assessmentd = "✓ Ang binhi ay dapat sertipikado ng BPI-NSQCS (Bureau of Plant Industry - National Seed Quality Control Services).\n" +
                "✓ Kung walang accredited seed growers sa inyong lugar, bumili ng binhi sa mga " +
                "magsasakang mahusay magpuro ng sariling dekalidad na binhi.\n" +
                "✓ Ang barayti ay angkop sa kalagayan ng inyong bukid (sahod-ulan, may patubig, o " +
                "pinapasok ng tubig-alat), at maganda ang resulta ng adaptability trials nito sa nakalipas " +
                "na dalawang taniman\n\n";

        String recommendationd = "1. Bumili ng binhi sa accredited seed growers. Tiyaking tunay ang NSQCS blue tag na\n" +
                "gumagarantiya sa kalidad ng binhi. Kung ang binhi ay laon, magsagawa ulit ng\n" +
                "germination test bago ito itanim o ipunla.\n\nKung walang accredited seed growers na malapit sa inyo:\n" +
                "      • Bumili sa a malapit sa inyo: mga pinagkakatiwalaan ninon on g kapwa magsasaka, o " +
                "magpuro ng sariling dekalidad na binhi alinsunood sa tamang paraan ng pagbibinhi " +
                "partikular ang masusing pagtanggal ng mga halo o roguing.\n" +
                "      • Siguraduhing ang sariling aning binhi ay pasado sa germination test na gagawin mo o " +
                "ng NSQCS.\n\n2. Piliin ang barayti na:\n" +
                "a. angkop sa kalagayan ng inyong bukid o panahon ng pagtatanim (tag-ulan o tagaraw). Sa tag-ulan, pumili ng barayting matibay sa sakit at peste na karaniwang " +
                "umaatake sa inyong lugar, at hindi basta-basta humahapay o lugasin.\n\n" +
                "b. sa mga lugar na madalas tamaan ng bagyo, tuyot, o baha, gumamit ng barayti na " +
                "maaaring mailihis sa mga naturang sakuna. Isa sa mga barayting angkop sa inyong " +
                "rehiyon ay tiyak na maganda sa inyong lokalidad;\n\n" +
                "c. maganda ang resulta ng adaptability trials sa nakalipas na dalawang taniman na " +
                "isinagawa ng PhilRice o DA office sa inyong lugar; at\n\n" +
                "d. mabili sa merkado. \n\n\nSource: PhilRice. (2020). Sistemang Palaycheck, 6-8.\n\n";


        kahalagahan.setText(kahalagahand);
        assessment.setText(assessmentd);
        recommendation.setText(recommendationd);
        key.setText("KEY CHECK 1: Gumamit ng dekalidad na binhi ng rekomendadong barayti");

    }
}