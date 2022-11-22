package com.sven.riceapp.ui.home.health_guide.variety_document;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sven.riceapp.R;

public class Nutrient extends AppCompatActivity {

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
        setContentView(R.layout.activity_nutrient);

        findid();
        String kahalagahan1 = "• Ang pataba o abono ang nagpupuno sa kakulangan ng sustansiya sa lupa, tubig, at " +
                "hangin upang matustusan ang pangangailangan ng tanim o palay. Ang sapat na " +
                "sustansiya mula pagsusuwi hanggang paglilihi at pamumulaklah ay nakatutulong sa " +
                "magandang pagbulas ng palay at panta).1Loi pantay na pagbuo ng mga uhay. Bunga " +
                "nito, rnaaaring 11 u ang pinakamataas na kayang anihin ng barayti.\n" +
                "• Kung kapos ang sustansiya sa mga naturang yugto ng paglaki ng palay, mabagal ang " +
                "pagyabong nito, limitado ang suwi at uhay, at magaan ang mga butil. Kung labis naman " +
                "ang pataba, rnalamya at maaaring humapay ang palay, madaling atakihin ng poste o " +
                "kapitan ng mga sakit, at dagdag-polusyon pa sa lupa. \n\n";


        String assessment1 = "✓ Walang sintomas ng kakulangan o kalabisan sa sustansiya mula pagsusuwi " +
                "hanggang paglilihi at pamumulaklak.\n" +
                "✓ Sa bawat metro kwadrado ay may 300 uhay para sa lipat-tanim at 350 uhay para sa " +
                "sabog-tanim, sa panahon ng paglalaman ng mga butil.\n\n " +
                "Paano malaman ang dami ng uhay sa panahon ng paglalaman\n" +
                "1. Kumuha ng sampol mula sa tatlong magkakahiwalay na lugar sa bukid, na isang " +
                "metro ang layo sa pilapil at may direksyong pahilis.\n" +
                "2. Sumahm ang bilang ng mga uhay na nasa loob ng bawat isang metrong parisukat. " +
                "Sumahin lahat ng nabilang na uhay at hatiin sa tatlo para makuha ang pangkaraniwang " +
                "bilang o average ng uhay bawat m².\n\n";


        String recommendation1 = "1. Alamin at ibigaY ang sustansiyang kailangan ng tanin, na palay batay sa:\n" +
                "a. Pisikal na itsura: pansinin ang sintomas ng kulang 0 sobrang sustansiya\n"+
                "  • Bandang taas ng dahon - Zinc (Zn), Calcium (Ca), Copper (Cu), Iron (Fe), Boron (B), " +
                "Sulfur (S), at Manganese (Mn)\n" +
                "  • Bandang baba ng dahon - Nitrogen (N), Phosphorus (P), Potassium (K), at " +
                "Magnesium (Mg)\n" +
                "b. Results ng pagsusuri ng sustansiya garnit ang:\n" +
                "  • Leaf Color Chart (LCC)*: sinusukat ang nitrohenong kailangan ng palay batay sa " +
                "tingkad ng kulay ng dahon nito.\n" +
                "  • Minus-One-Element Technique (MOET) at MOET App*: ito ay eksperimento gamit ang " +
                "mga Paso at ICT-based application. Tinutukoy nito ang kakulangan ng sustansiya ng " +
                "lupa at ang dami ng sustansiyang kailangan pars sa minimithing dami ng ani.\n" +
                "  •Nutrient-Omission-Plot Test (NOPT)*: pagtantiya sa likas na dami ng sustansiya sa " +
                "lupa upang magabayan ang pagpapataba.\n" +
                "  • Rice Crop Manager (RCM), isang ICT-based platform na nagbibigay ng tiyak na " +
                "rekomendasyon sa tamang sustansiya at iba pang pamamahala ng palay. \n\n" +
                "2. Alamin ang tamang Element, Amount, Timing sa pagpapataba. Sundan ang E-A-T.\n" +
                "E- Alamin ang tamang ELEMENT na kailangan ng palay. Mas nakatitipid sa gastusin at " +
                "maaaring makamit ang potensiyal na ani kapag tama ang sustansiyang ipakakain sa " +
                "palay.\n" +
                "A- Alamin ang tamang AMOUNT o dami ng patabang ilalagay. Ang sobra o kulang na " +
                "sustansiya ay makasasama sa palay.\n" +
                "T- Alamin ang tamang TIMING o tiyempo nang mapakinabangan ng palay ang " +
                "sustansiyang ilalagay at mas sulit na paggastos sa pagbili ng pataba.\n\n" +
                "Mga pangunahing kailangang sustansiya ng palay:\n" +
                "■ Nitroheno (N)\n" +
                " Right element. Tumutulong sa mabilis na paglago o paglaki ng palay\n" +
                "  • Pinabibilis ang pmalala pagtaas ng palay at pagdami ng suwi pad at pinahahaba ang " +
                "mga dahon\n" +
                "  • Pinararami ang bilang ng butil sa bawat uhay\n" +
                "  • Pinararami ang protinang taglay ng mga butil.\n"+
                "  • Halos lahat ng butil ay may laman.\n\n" +
                "Kapag kulang:\n" +
                "  • Bansot ang palay; naninilaw at makitid ang mga dahon \n" +
                "Kapag labis:\n" +
                "  • Maaaring humapay ang palay, madaling kapitan ng mga peste, mas maraming walang " +
                "laman na butil, magastos at nagdudulot ng polusyon sa lupa \n" +
                "Tamang dami\n" +
                "  • Gumamit ng LCC, MOET/MOET App, NOPT, o RCM para matiyak ang dami ng " +
                "ilalagay na N.\n\n" +
                "Kung may LCC (Leaf Color Chart):\n" +
                "  • Gamitin ang LCC bawat ika-7 araw mula 14 araw pagkalipat-tanim o 21 araw " +
                "pagkasabog-tanim hanggang sa maagang pamumulaklak\n" +
                "  • Maglagay ng N kung 6 pataas sa bawat 10 dahon ay mababa sa 4 ang basa kung\n" +
                "lipat-tanim o 3 kung sabog-tanim\n" +
                "Kung walang LCC (Leaf Color Chart):\n" +
                "  • Sa palay na gumugulang sa 110 araw pababa:\n" +
                "    - Maglagay ng N mula 0-14 pagkalipat-tanim o 7-10 araw pagkasabog (unang\n" +
                "paglalagay) at 5-7 araw bago ang paglilihi ng palay (ika-2 paglalagay)\n" +
                "  • Sa palay na 110 araw pataas ang paggulang:\n" +
                "    - Maglagay ng N 0-14 araw pagkalipat-tanim o 7-10 araw pagkasabog (unang\n" +
                "paglalagay), aktibong pagsusuwi (ika-2 paglalagay) at 5-7 araw bago o pagkatapos ng\n" +
                "paglilihi ng palay (ika-3 paglalagay).\n\n" +
                "■ Posporo (P)\n" +
                "Right element. " +
                "Pinahahaba at pinalalalim ang mga ugat, tumutulon pagdami ng mga suwi, at sa " +
                "maagang pamumulaklak paghinog. Taga-imbak at tagalipat ng enerhiya. \n\n" +
                "Kapag kulang:\n" +
                "  • Bansot at matingkad na berde ang mga halaman na may makitid, maiksi, masyadong " +
                "patusok na dahon, at kaunti magsuwi\n" +
                "  • Patpatin ang mga puno, at mabagal ang paglaki ng palay\n" +
                "  • Kakaunti ang mga dahon, uhay, at butil bawat uhay\n" +
                "  • Gumamit ng MOET/MOET App, o RCM para matiyak ang dami ng ilalagay na P.\n\n" +
                "Lipat-tanim:\n" +
                "  • Maglagay 0-14 araw pagkalipat-tanim\n" +
                "Sabog-tanim:\n" +
                "  • Maglagay 7-10 araw pagkasabog-tanim.\n\n" +
                "■ Potasyo (K)\n" +
                "Right element. \n" +
                "  • Pinabubuti ang paglago ng ugat\n" +
                "  • Nagpapasigla ng palay\n" +
                "  • Pinabibilis pakinabangan ng palay ang mga sustansiya\n" +
                "  • Pinatitibay ang palay kontra sa peste at sakit, tagtuyot, at paghapay\n" +
                "  • Pinalalaki at pinabibigat nito ang mga butil.\n\n" +
                "Kapag kulang:\n" +
                "  • Matingkad na berde ang palay na may manilaw-nilaw na kayumangging leaf margins o " +
                "dark brown necrotic spots na unang makikita sa dulo ng matatandang dahon. \n" +
                "  • Manilaw-pilaw na kayumangging naglulukot ang dulo at gilid ng mga dahon • Natutuyo " +
                "ang dahon mula sa dulo pababa.\n\n" +
                "Lipat-tanim:\n" +
                "  • Unang paglalagay: 0-14 araw pagkalipat-tanim\n" +
                "  • Ika-2 paglalagay: 5-7 araw bago o pagkatapos maglihi\n" +
                "Sabog-tanim:\n" +
                "  • Unang paglalagay: 7-10 araw pagkasabog-tanim\n" +
                "  • Ika-2 paglalagay: 5-7 araw bago o pagkatapos maglihi ang palay.\n\n" +
                "■ Zinc (Zn)\n" +
                "Right element.\n" +
                "  • Nakatutulong sa pagpapaganda ng punla at sa kabuuang paglago ng palay.\n" +
                "Right amount.\n" +
                "  • Gumamit ng MOET o RCM para matiyak ang dami ng ilalagay na Zn\n" +
                "Kapag kulang:\n" +
                "  • May maalikabok na kayumangging batik sa dulo ng mga dahon ng bansot na halaman " +
                "na lumilitaw 2-4 linggo pagkatanim\n" +
                "Right-timing. Pumili ng isa sa mga panglunas [nasa susunod na pahinal kapag walang " +
                "MOET at RCM.\n\n" +
                "■ Sulfur (S)\n" +
                "Right element.\n" +
                "  • Tumutulong upang maging pare-pareho at sabay-paglaki at paggulang ng palay\n" +
                "Right amount\n" +
                "  • Gumamit ng RCM, MOET, o MOET App para matiyak ang darni ng ilalagay na S\n" +
                "  • Sapat na ang 14-14-12S (12% sulfur) bilang lunas sa kakulangan ng S\n\n" +
                "Kapag kulang:\n" +
                "  • Naninilaw ang mga talbos na dahon\n" +
                "  • Kakaunti ang mga suwi\n" +
                "  • Maiksi ang mga uhay\n" +
                "  • Kakaunti ang mga butil at atrasado ang paggulang.\n" +
                "Right timing. Gamitin ang MOET + MOET App, o RCM para sa tamang tyempo\n" +
                "Lipat-tanim:\n" +
                "  • 0-14 araw pagkalipat-tanim\n" +
                "Sabog-tanim:\n" +
                "  • 7-10 araw pagkasabog-tanim\n\n" +
                "Tamang paglalagay ng binutil (granular) na inorganic fertilizer:\n" +
                "  • Ihalo ang pataba sa lupa nang hindi sumingaw sa hangin ang nitroheno, at nang " +
                "masipsip ito ng palay.\n" +
                "  • Tatlumpung porsyento (30%) lamang ng kabuuang dami ng N ang unang ilalagay.\n" +
                "  • Sa paglalagay ng paupong abono, ihalo nang maigi ang pataba sa lupang mamasamasa at panatilihing 2-5sm ang lalim ng tubig.\n" +
                "  • Mas magandang magpataba sa hapon (3PM palampas) nang hindi sumingaw sa " +
                "hangin at mawaldas ang nitroheno, at nang mas mapakinabangan ito ng halaman.\n\n";

        kahalagahan.setText(kahalagahan1);
        assessment.setText(assessment1);
        recommendation.setText(recommendation1);
        key.setText("KEY CHECK 5: Sapat na sustansiya sa panah. pagsusuwi hanggang paglilihi at " +
                "pamumulaklak");
    }
}