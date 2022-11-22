package com.sven.riceapp.ui.home.health_guide.variety_document;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sven.riceapp.R;

public class Crop extends AppCompatActivity {

    private TextView kahalagahan,assessment,recommendation,key,key2,kahalagahantit, assessmenttit, recommendationtit, kahalagahan1, assessment1, recommendation1;

    private void findid(){
        kahalagahan = findViewById(R.id.kahalagahandecrip);
        assessment = findViewById(R.id.assessmentdecrip);
        recommendation = findViewById(R.id.recommendationdescrip);
        key = findViewById(R.id.key);
        key2 = findViewById(R.id.key1);
        kahalagahan1 = findViewById(R.id.kahalagahandecrip1);
        assessment1 = findViewById(R.id.assessmentdecrip1);
        recommendation1 = findViewById(R.id.recommendationdescrip1);
        kahalagahantit = findViewById(R.id.kahalagahan1);
        assessmenttit = findViewById(R.id.assessment1);
        recommendationtit = findViewById(R.id.recommendation1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        findid();
        String kahalagahand = "• Ang sabayang pagtatanim matapos pagpahingahin ang lupa ay nakatutulong sa sulit " +
                "na paggamit ng tubig at naiiwasan ang pagdami ng mga pesteng kulisap at sakit ng " +
                "palay tungo sa masaganang ani.\n" +
                "• Kung ang mga magsasaka sa isang lugar ay sabayang magtatanim, ang kanilang " +
                "palay ay halos magkakasabay na aanihin. Sa ganitong paraan, walang makakainan ang " +
                "mga pesteng insekto kung kaya't hindi sila makapagpaparami.\n\n";


        String assessmentd = "✓ Nakapagpahinga ang palayan nang 30 araw pagkatapos mag-ani, bago ang susunod " +
                "na taniman.\n" +
                "✓ Nakapagtanim ang karamihan 14 araw bago o 14 araw pagkatapos ang regular na " +
                "iskedyul ng pagtatanim ayon sa dating ng patubig sa lugar o pook.\n\n";

        String recommendationd = "1. Pagkatapos mag-ani, pagpahingahin ang lupa. Huwag tamnan ng palay ang bukid sa " +
                "loob ng 30 araw. Pakinabang ng pagpapahinga ng lupa:\n" +
                "    • Nahahadlangan ang patuloy na pagdami ng mga pesteng kulisap. Maraming pesteng " +
                "insekto ang karaniwang nabubuhay sa loob ng 30 araw lamang. Sa panahon ng " +
                "pagpapahinga ng lupa, walang sapat na makakainan ang mga peste kaya marami sa " +
                "kanila ang mamamatay.\n" +
                "    • Nasisira ang kanlungan ng mga sakit. Habang walang tanim na palay ang lupa, ang " +
                "pinagmulan ng sakit sa nakaraang taniman ay mamamatay bago pa ang simula ng " +
                "susunod na taniman.\n" +
                "    • Nabubulok nang lubusan ang mga organikong bagay tulad ng dayami na magiging " +
                "dagdag-pataba.\n" +
                "2. Sundin ang takdang panahon ng pagtatanim nang mas maraming bukid sa " +
                "komunidad ang maaabot ng patubig. Isagawa ang sabayang pagtatanim ayon sa dating " +
                "ng patubig sa purok, barangay, o dibisyon.\n\n";

        String kaha = "• Ang malusog na punla ay may maiksing lapak o leaf sheath, mahaba at makapal ang " +
                "mga ugat, at pantay-pantay ang taas. Sabay-sabay ang paglaki ng halaman at walang " +
                "pinsala ng peste.\n" +
                "• Ang malulusog na punla av nakakakuha ng sapat na init ng araw at sustansiva ng " +
                "lupa; madaling makarekober sa pagkakabunot at lipat-tanim; malakas magsuwi; at " +
                "masagana ang ani.\n\n";
        String assess = "✓ Nagpunla ng 20-40 kilong dekalidad na inbred na binhi para Ngp sa bawat ektarya.\n" +
                "✓ May 25 tundos bawat metro kwadrado (m²) sa manu-manong pagtatanim; 21 tundos " +
                "kung de-makina.\n" +
                "✓ May malusog na punla bawat tundos.\n\nPamantayan sa dami ng tundos (lipat-tanim):\n" +
                "1. Sa ika-10 araw pagkalipat-tanim, kumuha ng sampol mula sa tatlong " +
                "magkakahiwalay na lugar sa bukid, na isang metro ang layo sa pilapil at may " +
                "direksyong pahilis.\n" +
                "2. Bilangin ang buhay na tundos bawat m² ayon sa sukat ng manu-mano (1m x lm " +
                "parisukat) at de-makinang lipat-tanim (1.1 x 0.9m parisukat).\n" +
                "3. Sumahin ang bilang ng mga tundos sa tatlong lugar at hatiin sa tatlo, upang matuos " +
                "ang karaniwang bilang o average ng tundos bawat m².\n" +
                "4. Sa bawat pinitak, pumili ng 10 magkakahiwalay na tundos. Ang bawat tundos ay " +
                "dapat may isa o higit pang malusog na punla.\n\nManu-mano\n" +
                "    May 25 tundos/m², at bawat tundos ay may isa o higit pang malusog na punla 10 araw " +
                "pagkalipat-tanim\n\nDe-makina\n" +
                "    May 21 tundos/ m², at bawat tundos ay may isa o higit pang malusog na punla\n\nSabog-tanim\n" +
                "✓ Nagsabog ng 40-60kilo inbred na binhing dekalidad sa bawat ektarya (pahanay o " +
                "patudling gamit ang drumseeder); 60- 80kilo sa walang tudling.\n" +
                "✓ May 225 halaman sa bawat m² (60kilo/ekt); 300 halaman (80kilo/ekt) 15 araw " +
                "pagkatanim.\n" +
                "✓ Walang peste ang mga halaman sa bawat 0.25m² (0.5m x 0.5m) at pantay-pantay " +
                "ang kulay ng kanilang dahon at taas\n\nPamantayan sa dami ng tundos (sabog-tanim):\n" +
                "  1. Sa ika-15 araw pagkasabog-tanim, kumuha ng sampol mula sa tatlong " +
                "magkakahiwalay na lugar sa bukid, na may isang metro ang layo sa pilapil at may " +
                "direksyong pahilis.\n" +
                "  2. Gumamit ng 0.5m x 0.5m parisukat bawat m². Bilangin ang buhay na tundos bawat " +
                "m² at i-multiply sa apat nang malaman ang pangkaraniwang bilang o average ng " +
                "halaman/ m²\n" +
                "  3. Sa bawat parisukat o kwadrant, ang halaman ay kailangang pantay-pantay ang kulay " +
                "at taas, at walang sakit o peste.\n\n";
        String recom = "Lipat-tanim\n" +
                "1. Sundin ang mga sumusunod:\n" +
                "✓ Kung ang paraan ng paglilipat- tanim ay manu-mano. Ang dami ng binhi ay 20-40kilo " +
                "bawat ekt (ektarya), ang luwang ng punlaan ay 400 m², ang gulang ng punla ay 18-21 na araw, " +
                "ang bilang ng punla bawat tundos ay 2-3, at ang agwat ng tanim (sm) ay 20x20 sa tagulan at 20x15 sa tag-araw.\n" +
                "✓ Kung ang paraan ng paglilipat- tanim ay de-makina. Ang dami ng binhi ay 160g bawat " +
                "tray, ang luwang ng punlaan ay 250-300 trays*, ang gulang ng punla ay 14-18** na " +
                "araw, ang bilang ng punla bawat tundos ay 3-6, at ang agwat ng tanim (sm) ay 30x15 " +
                "sa tag-ulan at tag-araw.\n✓ Kung ang paraan ng paglilipat- tanim ay de-makina na modified wet dapog method.\n" +
                "Ang dami ng binhi ay 20-40kilo bawat ekt o kaya 420-960g bawat m², ang luwang ng " +
                "punlaan ay 50 m², ang gulang ng punla ay 14-18 na araw, ang bilang ng punla bawat " +
                "tundos ay 3-6, at ang agwat ng tanim (sm) ay 30 x 15 sa tag-ulan at tag-araw\n\n*Sukat ng tray: 28sm x 58sm\n" +
                "**Maaaring itanim ang 12 araw na punla kung ito ay may taas na 15sm. \n\n• Ang pagsasabog ng sapat na binhi lamang ay magbubunga ng malulusog na punla.\n" +
                "• Sa 20m x lm kamang punlaan, makatutubo nang husto ang mga punla.\n" +
                "• Ang mas kakaunting dami ng binhi ay inirerekomenda sa paggamit ng mechanical\n" +
                "transplanter para sa hybrid commercial rice production dahil na rin sa mataas na halaga " +
                "ng binhi.\n" +
                "• Maglagay ng 3-4 sako komersyal na organikong pataba bago pantayin ang kamang " +
                "punlaan sa pinong lupa lamang. Gumamit ng kompost o anumang bagay na lubusan " +
                "nang nabulok katulad ng tuyong dumi ng hayop, dayami, o sinunog na ipa. " +
                "Nakatutulong ang organikong pataba na maging buhaghag ang lupa kung kaya mas " +
                "madaling bunutin ang mga punla nang walang pinsala ang mga ugat.\n" +
                "• Pinipiling atakihin ng kuhol ang mga batang punla. Kung matanda naman sa 25 araw " +
                "ang punla, matagal magrekober sa pagkakabunot at mas kakaunti ang magiging suwi.\n" +
                "• Ang masyadong masinsin na punla ay mahina magsuwi at hindi makayabong. Madali " +
                "namang humapay ang masyadong matangkad na halaman.\n" +
                "• Huwag gupitan ang mga dahon ng punla bago ilipat-tanim nang maiwasan ang " +
                "pagpasok ng mga organismong nagdadala ng sakit.\n" +
                "2. Maghulip sa boob ng 7 araw pagkalipat-tanim. Gamitin ang natirang punla upang " +
                "sabay-sabay pa rin ang paggulang ng palay.\n\nSabog-tanim\n" +
                "1. Sundin ang paraan ng pag-aararo, pagsusuyod, at pagpapatag ng lupa batay sa Key " +
                "Check 2.\n" +
                "2. Protektahan ang isinabog na binhi laban sa mga ibon, daga, kuhol at damo alinsunod " +
                "sa isinusulong na paraan ng pamamahala sa peste.\n" +
                "3. Gumamit ng drumseeder o isabog ang binhi nang pantay-pantay.\n4. Magsabog ng 1 kilong pinasibol na ekstrang binhi sa gilid ng pinitak na maaaring " +
                "panghulip 7-10 araw pagkasabog upang sabay-sabay ang paggulang ng palay.\n\n ";

        kahalagahan.setText(kahalagahand);
        assessment.setText(assessmentd);
        recommendation.setText(recommendationd);
        kahalagahantit.setText("Kahalagahan");
        assessmenttit.setText("Pagtataya o Assessment");
        recommendationtit.setText("Mga rekomendasyon");
        kahalagahan1.setText(kaha);
        assessment1.setText(assess);
        recommendation1.setText(recom);
        key.setText("KEY CHECK 3: Nagtanim nang sabayan matapos pagpahingahin ang lupa ");
        key2.setText("KEY CHECK 4: Sapat na malulusog na punla ");

    }
}