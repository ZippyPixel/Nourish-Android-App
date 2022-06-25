package com.example.nourish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class WordDetail : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var backButton: ImageView
    private lateinit var item: ImageView
    private lateinit var speakButton: ImageView

    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView


    private var titlesList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    private var descriptionList = mutableListOf<String>()

    private var title: String = ""
    private var description: String = ""

    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_detail)

        backButton = findViewById(R.id.backBtn)
        tvTitle = findViewById(R.id.textViewTitle)
        tvDescription = findViewById(R.id.textViewDescription)
        item = findViewById(R.id.imageViewItem)
        speakButton = findViewById(R.id.imageViewSpeak)

        val position = intent.getIntExtra("wordPosition", 0)
        postToList()

        title = titlesList[position]
        description = descriptionList[position]

        tvTitle.text = title
        tvDescription.text = description
        item.setImageResource(imagesList[position])

        speakButton.isEnabled = false
        tts = TextToSpeech(this, this)

        speakButton.setOnClickListener {
            speakOut(title)
        }

        tvDescription.setOnClickListener {
            speakOut(description)
        }

        backButton.setOnClickListener{
            finish()
        }
    }

    private fun addToList(title: String, image: Int, description: String){
        titlesList.add(title)
        imagesList.add(image)
        descriptionList. add(description)
    }

    private fun postToList(){
        addToList("Apple", R.drawable.apple, "Apples are an incredibly nutritious fruit that offers multiple health benefits. They're rich in fiber and antioxidants. Eating them is really good for health.")
        addToList("Ball", R.drawable.ball, "A ball is a round object. It is used in many games, where it is hit, kicked or thrown by the players. Also, size of the ball varies depending on the game.")
        addToList("Cat", R.drawable.cat, "Cats are most of the time considered as pet. They smaller than dog and can live up to 18 years. They are really cute!")
        addToList("Dog", R.drawable.dog, "Dogs have four legs or two arms and two legs, two ears, eyes, sharp teeth and a long tail. Dog is always faithful and loyal to his masters. The dog is an intelligent pet. Dogs are of different color.")
        addToList("Egg", R.drawable.egg, "Eggs are nutritious. They often come from hen. It has a outer shell. Inside there is egg white and yolk. Yolk is yellow.")
        addToList("Fish", R.drawable.fish, "Fish is an animal that lives in Water. There are many kinds of fish that live in this World. People eat fish. Fish uses their gills to breathe. Without water, fish can't live.")
        addToList("Goat", R.drawable.goat, "Goat has four legs and a small tail and has horns on its head. Goat is a useful and a domestic animal. Goat can live up to 18 years.")
        addToList("Hand", R.drawable.hand, "Hands can push, pull, pat, scoop, and carry. They can wave, point, and make many other gestures, or signs. With the opposable thumb, a hand can pick up small objects and handle tools.")
        addToList("Ink", R.drawable.ink, "Ink is a liquid that is used to write, draw, print, or make marks. Ink is used in pens, in some computer printers. People usually write or print using black ink, but ink can be any color.")
        addToList("Jug", R.drawable.jug, "A jug is a type of container commonly used to hold liquids. It has an opening, often narrow, from which to pour or drink, and has a handle.")
        addToList("Kite", R.drawable.kite, "Kites are popular toys on windy days. A kite is made of paper, plastic, or cloth stretched across a light, often wooden frame. They fly high in the air at the ends of long strings.")
        addToList("Lion", R.drawable.lion, "The lion has a long body, short legs, sharp claws, and a large head. Lions are covered with yellow-brown hair. A male lion is easy to spot because of its mane.")
        addToList("Mango", R.drawable.mango, "Mango is a fruit. The mango tree first grew in India and parts of eastern Asia. Ripe mangoes are red or yellow.")
        addToList("Nose", R.drawable.nose, "The nose is an important organ, or body part, for breathing and smelling. In humans, the nose is located in the middle of the face, above the mouth.")
        addToList("Orange", R.drawable.orange, "An orange is a type of citrus fruit which people often eat. Oranges are a very good source of vitamins, especially vitamin C.")
        addToList("Plant", R.drawable.plant, "Plants are living things that grow from the soil and turn light from the Sun into food. Plants can be big or small.")
        addToList("Queen", R.drawable.queen, "The wife of a king is called a queen.")
        addToList("Rat", R.drawable.rat, "Rats are rodents, which are small animals with sharp front teeth that gnaw. Rats have pointy noses, long, hairless tails and brown, gray, black or white fur, and they're known to chew through things.")
        addToList("Snake", R.drawable.snake, "A snake is a reptile with a long, thin body but no legs.")
        addToList("Tiger", R.drawable.tiger, "Tiger is easily recognized by its coat of reddish-orange with dark stripes, the tiger is the largest wild cat in the world.")
        addToList("Umbrella", R.drawable.umbrella, "An umbrella is a hand tool that is used to stop rain from falling on a person. It is also used to make shade and protect people from sunlight.")
        addToList("Volcano", R.drawable.volcano, "A volcano is a mountain or hill with an opening. When a volcano erupts, magma is pushed up through the opening with great force.")
        addToList("Water", R.drawable.water, "Water is the most important liquid on Earth. It covers almost 75 percent of Earth's surface in the form of oceans, rivers, and lakes.")
        addToList("Ox", R.drawable.ox, "Oxen are adult male bulls, or cattle that have been domesticated, or tamed, typically to do farm work.")
        addToList("Yellow", R.drawable.yellow, "Yellow is a color. It is the color of the color of amber.")
        addToList("Zebra", R.drawable.zebra, "Zebras are mammals that are known for their black and white stripes. They belong to the horse family of animals.")
    }

    private fun speakOut(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                speakButton.isEnabled = true
            }
        } else {
            Log.e("TTS", "Initialization Failed!")
        }
    }
}