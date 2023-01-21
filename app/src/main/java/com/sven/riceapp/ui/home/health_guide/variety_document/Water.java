package com.sven.riceapp.ui.home.health_guide.variety_document;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sven.riceapp.R;

public class Water extends AppCompatActivity {

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
        setContentView(R.layout.activity_water);

        findid();
        String kahalagahan1 = "Ang sapat na patubig ay tumutulong sa maayos na pagdala ng mga mahalagang " +
                "sustansiya mula sa lupa tungo sa ibang bahagi ng halamang palay, maganda at " +
                "malusog na tanim, magandang bulas, normal na paglaki, at magliwalas na paggawa sa " +
                "bukid.\n\n" +
                "\nSintomas ng problema sa tubig mula pagtubo hanggang sa paglago ng palay bago " +
                "mamulaklak:\n" +
                "- Kulang-sa-tubig\n" +
                "  • Pagkabansot\n" +
                "  • Pagkatuyot ng dulo ng dahon/pagbilot ng dahon\n" +
                "- Sobrasa tubig(7-5 sentimetro (sm) lalim sa loob ng 7 araw o higit pa)\n" +
                "  • Kaunti ang suwi (walang 10 suwi bawat tundos)\n" +
                "  • Malililt na dahon\n" +
                "  • Maitim ang ugat na dapat ay mamula-mulang kayumanggi.\n" +
                "\nSintomas ng problema sa tubig mula sa paglilihi ng palay hanggang sa paglalaman ng " +
                "butil:\n" +
                "  • Pagkatuyot ng dulo ng dahon/ pagbilot ng dahon\n" +
                "  • Maraming impis o walang lamang butil\n" +
                "  • Bawas na paglabas ng uhay.\n\n";


        String assessment1 = "✓ Walang palatandaan ng kakulangan sa tubig mula sa panal ng paglaki, paglilihi, " +
                "pamumulaklak, hanggang paglalama ng butil.\n" +
                "✓ Walang palatandaan ng kalabisan sa tubig sa panahon ng paglaki ng palay.\n\n ";

        String recommendation1 = "1. Panatilihin ang 2-3sm (sentimetro) babaw ng tubig sa pinitak 3-14 araw pagkalipat-tanim.\n" +
                "  • Itigil ang patubig 0-14 araw pagkasabog-tanim kung may tubig pa sa palayan maliban " +
                "kung nakararanas ng matinding tuyot.\n" +
                "2 Paabutin sa 3-5sm ang lalim tuwing magpapatubig.\n" +
                "3 Panatilihin ang 5sm lalim ng tubig sa panahon ng pamumulaklak.\n" +
                "4. Paabutin nang 5sm ang lalim ng tubig ng paghinog ng palay.\n" +
                "5. Alisan o ihinto ang pagpapatubig:\n" +
                "  • 1 linggo bago mag-ani para sa mga galas na lupa o sa tag-araw\n" +
                "  • 2 linggo bago mag-ani para sa lagkiting lupa o sa tag-ulan\n" +
                "6. Kung kulang sa tubig, isagawa ang controlled irrigation o Alternate Wetting and " +
                "Drying (AWD) technology sa tulong ng observation well.\n" +
                "  • Kapag naubos na ang tubig sa observation well, hudyat ito na kailangan nang\n" +
                "magpatubig.\n\nSource: PhilRice. (2020). Sistemang Palaycheck, 35-37.\n\n";

        kahalagahan.setText(kahalagahan1);
        assessment.setText(assessment1);
        recommendation.setText(recommendation1);
        key.setText("KEY CHECK 6: Naiwasan ang kulang o labis na patubig, na nakakaapekto sa paglaki " +
                "ng palay");
    }
}