package com.example.learnwordsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<>();
    static ArrayList<Word> words = new ArrayList<>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        TextView textView = findViewById(R.id.levelacttextView);

        int pos = getMyIntent();

        textView.setText("Уровень " + (pos + 1));

        fillListAndWordsItems(pos);

        setListItems();

    }

    private void setListItems() {
        adapter = new ArrayAdapter<>(this, R.layout.list_item, listItems);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private int getMyIntent() {
        Intent intent = getIntent();
        int pos = intent.getIntExtra("POS", -1);
        return pos;
    }

    private void fillListAndWordsItems(int pos) {
        int startnumber = pos * 30;
        listItems.clear();
        for (int i = startnumber; i < startnumber + 30; i++) {
            Word word = new Word(englishWordsArr[i], russianWordsArr[i]);
            words.add(word);
            listItems.add(i%30 + " "+word.englishWord + " — " + word.russianWord);
        }
    }

    String[] englishWordsArr = new String[]{"absorb", "accord", "across", "adolescent", "advise", "aftermath", "air", "all along", "alter", "ammunition", "anniversary", "apart from", "appraise", "archive", "article", "asleep", "assure", "attain", "available", "axe", "bail", "banner", "bartender", "be back", "bear", "behave", "beneath", "bicycle", "bizarre", "blend", "blow", "bog", "border", "bow", "brave", "breath", "bring along", "broth", "built-in", "burden", "butter", "cable", "candy", "carcass", "carve", "cater", "cell", "chancellor", "chat", "cheerful", "chip", "cinema", "clamp", "clench", "close in on", "coal", "cold", "come along", "come to life", "commit", "compassion", "compress", "conduct", "connect", "console", "contempt", "converge", "cork", "count", "courtesy", "crank", "creek", "cross", "crush", "curl", "cut down", "dash", "deal with", "decline", "definite", "delusion", "dependent", "deserve", "detect", "diamond", "diligent", "discard", "disease", "dispel", "distinguish", "dizzy", "doom", "drag on", "drip", "dry up", "duo", "earn", "educate", "eliminate", "emphasis", "endeavor", "enrol", "environment", "essence", "evident", "exchange", "exist", "explore", "eyebrow", "fade", "fall for", "faraway", "favor", "fellow", "fiction", "find out", "fit in with", "flavor", "flinch", "fluent", "fold", "forbid", "forth", "fracture", "freeway", "frost", "fur", "gamble", "geared to", "get along", "get through", "glacier", "gloss", "go off", "gossip", "grasp", "grief", "gross", "guise", "hail", "handful", "hardly", "hawk", "heave", "helpless", "highway", "hitch", "honest", "horrify", "hue", "hurl", "ill", "implicate", "incidence", "indulge", "infuse", "innocent", "insulate", "intercept", "intimate", "involve", "janitor", "joint", "junior", "kettle", "knack", "lack", "lapse", "laundry", "leak", "legal", "lettuce", "light", "linen", "liven up", "locus", "look into", "lousy", "lush", "make fun of", "mandatory", "marital", "match", "mean", "melon", "mere", "mild", "miracle", "mix up", "monastery", "motion", "mug", "mute", "native", "neighbour", "niche", "nose around", "nudge", "obedience", "obvious", "offspring", "opaque", "ordinary", "outgoing", "oven", "overtake", "pad", "paper", "part-time", "pasture", "pay out", "pee", "perfect", "personnel", "pick up", "pineapple", "plain", "pledge", "point", "poll", "possible", "powerful", "predominant", "press", "prime", "procure", "proof", "prove", "pump", "put aside", "puzzle", "quit", "rainbow", "rapid", "reach out", "receipt", "record", "reflect", "regular", "relieve", "render", "repress", "resist", "restrict", "reveal", "rich", "ring", "roast", "root out", "royal", "run", "rut", "salt", "savings", "scent", "scramble", "scrub", "see to", "sense", "set", "settle on", "shake", "sheep", "shiver", "shred", "shy", "significant", "single", "skid", "slate", "slipper", "smear", "sneak", "sober up", "solitary", "source", "speak out", "spell out", "spokesman", "spy", "stable", "stamp", "stash", "steer", "stifle", "stoop", "strawberry", "strip", "stupid", "substance", "suck", "summary", "supreme", "suspect", "sweetheart", "tack", "take care", "tally", "taunt", "temporary"};
    String[] russianWordsArr = new String[]{"впитывать, поглощать", "согласие", "за, через", "подросток, подростковый", "советовать", "последствие, результат", "вид, впечатление", "всё время", "изменять", "боеприпасы", "годовщина", "помимо", "оценивать", "архив", "статья", "спящий", "уверять", "достигать", "доступный, в наличии", "топор", "залог", "знамя, транспарант", "бармен", "возвращаться", "нести, втч перен.", "вести себя", "ниже, под", "велосипед", "странный, причудливый", "смешивать", "дуть", "болото, трясина", "граница, край", "бант, бабочка", "храбрый", "дыхание, вздох", "взять с собой", "бульон, отвар", "встроенный", "бремя, нагружать", "масло сливочное", "канат, кабель, трос и т.д.", "конфеты", "туша", "вырезать (напр. из дерева)", "обслуживать, угождать", "ячейка, клетка", "канцлер", "болтать", "весёлый, неунывающий", "щепка, стружка", "кино, кинотеатр", "зажимать, зажим", "стиснуть, сжать", "приближаться", "уголь", "простуда", "продвигаться (о работе)", "оживать, приходить в себя", "совершить (напр. ошибку)", "сочуствие, сострадание", "сжимать, прессовать", "вести, поведение", "соединять", "утешать", "презрение, презирать", "сходиться, сближаться", "пробка", "считаться, иметь значение", "учтивость, этикет", "чудак, фрик", "ручей", "пересекать, пересечение, крест", "раздавливать, дробить", "скручивать, клубиться, завиток", "урезать, уменьшить", "бросать, бросаться", "иметь дело с", "снижаться, снижение", "определённый", "наваждение, заблуждение", "зависимый", "заслуживать", "обнаружить, выявить", "бриллиант обычно алмаз", "усердный, старательный", "отбросить, отказаться", "болезнь", "развеяться, исчезнуть", "выделять, отличать", "головокружительный", "гибель, рок, обречённость и т. д.", "тянуться долго", "капля, капать", "пересохнуть, иссякнуть", "дуэт", "зарабатывать", "воспитывать, обучать", "устранять, ликвидировать", "акцент, внимание, ударение", "стремиться, стараться, попытка", "записать (в члены), набрать", "среда, окружение", "сущность", "очевидный", "обмен", "существовать", "изучать", "бровь", "увядать, блекнуть", "вестись", "далёкий", "услуга", "парень, человек", "вымысел, худ.литература", "выяснить", "вписаться (в коллектив)", "вкус, приправлять", "дёрнуться, дрогнуть", "беглый", "сворачивать, складывать", "запрещать", "дальше, вперёд", "перелом, разрушение", "автострада", "мороз", "мех", "азартная игра, играть", "направлен на", "ладить", "дозвониться", "ледник", "глянец, лоск", "отключиться", "слухи", "схватывать", "горе", "грубый (во всех смыслах)", "облик, личина", "окликнуть, привлечь внимание", "горсть", "едва", "ястреб", "вздыматься", "беспомощный", "шоссе", "заминка, помеха", "честный", "ужасать", "цвет, оттенок", "метать, бросать с силой", "дурной, нехороший", "указать на причастность", "частотность, распространённость", "баловать, потворствовать", "вливать, настаивать", "невинный, невиновный", "изолировать, оградить", "перехватить, перехватить", "близкий", "содержать в себе (процесс)", "дворник, уборщик", "сустав, шарнир, стык и т. д.", "младший", "чайник", "умение, сноровка", "недостаток, нуждаться", "упущение, оплошность", "прачечная", "утечка, просачиваться, протекать", "законный, правовой", "салат (латук)", "зажигать", "льняная ткань", "оживить, взбодрить", "местоположение", "посмотреть, изучить", "паршивый", "пышный", "смеяться, издеваться", "обязательный", "супружеский", "соответствие, нечто соответствующее", "иметь в виду", "дыня", "всего лишь", "мягкий", "чудо", "перепутать", "монастырь", "движение", "кружка", "беззвучный, не говорящий", "родной", "сосед", "ниша", "рыскать, вынюхивать", "подталкивать", "покорность", "очевидный", "отпрыск или всё потомство", "непрозрачный", "обычный", "уходящий", "печь, духовка", "обгонять", "подушечка пальца, лапы", "бумага, документ", "неполная занятость", "пастбище", "выплатить (крупную сумму)", "писать", "совершенный", "персонал, личный состав", "подобрать", "ананас", "ровный, равнина", "обещание, обязательство", "смысл, суть", "опрос или голосование", "возможный", "мощный, действенный", "преобладающий", "нажимать", "важный, главный, первый", "достать, добыть, обеспечить", "доказательство (неисч.)", "доказывать", "насос, нагнетать", "отложить", "озадачить", "бросить, покинуть, перестать", "радуга", "быстрый", "потянуться (рукой)", "получение", "запись", "отражать(ся)", "обычный", "облегчить, освободить", "делать, придавать свойство", "подавлять", "сопротивляться", "ограничивать", "раскрыть, выявить", "богатый", "звонить, звонок", "жарить", "искоренить", "королевский", "управлять", "борозда, колея, рутина", "соль", "сбережения", "нюх или аромат", "драка, схватка", "чистить, драить", "заняться, позаботиться", "чувство, осознание", "набор, комплект", "определиться с", "пожать (руки)", "овца", "дрожь, дрожать", "мелко порубить", "застенчивый", "значительный", "один, отдельный, единый", "заносить, скользить, буксовать", "шифер или сланец", "тапок", "мазать", "красться", "протрезветь", "уединенный", "источник", "высказать", "разъяснить", "представитель, прес-секретарь", "шпион, шпионить", "устойчивый", "печать, штамп, марка", "тайник, заначка, прятать", "управлять, направлять", "удушать", "наклоняться или сутулиться", "клубника", "полоса, лента", "глупый", "вещество, материя", "сосать", "сводка, конспект", "высший, верховный", "подозревать, подозреваемый", "возлюбленный (ая), милый", "курс, линия поведения", "позаботиться, заняться", "подсчитывать, подсчёт, итог", "насмехаться, насмешка", "временный"};

}