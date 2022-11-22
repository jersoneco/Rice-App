package com.sven.riceapp.ui.home.health_guide.variety_document;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sven.riceapp.R;

public class Pest extends AppCompatActivity {

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
        setContentView(R.layout.activity_pest);

        findid();
        String kahalagahan1 = "  • Kung naiintindihan ang ugnayan ng halamang palay at mga may buhay (biotic factors) " +
                "na bagay na nakaaapekto sa paglaki ng tanim, kapaligiran (agro-ecosystem), at " +
                "matukoy nang tama ang peste, maaalagaan ang tanim at mapapanatiling mataas ang " +
                "ani nito. Matitiyak din na maganda ang kalidad ng butil.\n";


        String assessment1 = "✓ Hindi bumaba ang ani sanhi ng mga pesteng insekto, sakit, daga, kuhol, at ibon. " +
                "Dalawa o mas marami pang peste makababawas sa ani.\n\n" +
                "Mga pangkaraniwang peste ng palay\n" +
                "  • White stem borer\n" +
                "  • Yellow stem borer\n" +
                "  • Rice black bug\n" +
                "  • Brown planthoppers\n" +
                "  • Rice bug\n" +
                "Mga pangkaraniwang sakit ng palay\n" +
                "  • Bacterial leaf blight\n" +
                "  • Tungro\n" +
                "  • Brown spot\n" +
                "  • Leaf blast\n" +
                "  • Sheath blight\n\n" +
                "";

        String recommendation1 = "1. Gumamit ng barayting napatunayang matibay at angkop sa inyong lugar. Ito ang " +
                "pangunahing depensa laban sa mga peste at naaayon sa likas na paraan ng pagsugpo " +
                "ng mga ito. Magpalit ng barayti towing ika-2 hanggang ika-4 na taniman.\n" +
                "2. Magtanim nang sabayan pagkatapos ng 30 araw na pahinga ng lupa (sumunod sa " +
                "Key Check 3).\n" +
                "3. Palaging bisitahin ang palayan upang maagang matukoy at maagapan ang mga " +
                "potensiyal na problema dulot ng peste. Isagawa ang mga makakalikasang pamamaraan " +
                "upang maiwasan ang paglala ng mga sakit na mahirap nang puksain. Magpunla ng " +
                "maresistensyang barayti at magtanim nang sabayan. Magbomba ng pestisidyo kung " +
                "lubhang kailangan lamang.\n" +
                "4. Paramihin ang mga kaibigang insekto at iba pang kakamping organismo sa palayan " +
                "na pumapatay sa mga peste. Ang barang pagbomba ng pestisidyo ay maaaring " +
                "ikamatay ng mga kaibigang organismo. Ang pagpaparami sa mga ito ay matipid at " +
                "pangmatagalan.\n\n";

        kahalagahan.setText(kahalagahan1);
        assessment.setText(assessment1);
        recommendation.setText(recommendation1);
        key.setText("KEY CHECK 7: Hindi bumaba ang ani dahil sa mga peste ");
    }
}