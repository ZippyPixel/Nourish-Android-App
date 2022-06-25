package com.example.nourish

object QuestionBank{

    fun wordGuessQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1,
        "Select the correct word",
        R.drawable.apple,
        "Banana",
        "Orange",
        "Apple",
        "Mango",
        "Apple")
        questionList.add(question1)

        val question2 = Question(2,
            "Select the correct word",
            R.drawable.ball,
            "Ball",
            "Orange",
            "Plant",
            "Rat",
            "Ball")
        questionList.add(question2)

        val question3 = Question(3,
            "Select the correct word",
            R.drawable.cat,
            "Dog",
            "Ox",
            "Goat",
            "Cat",
            "Cat")
        questionList.add(question3)

        val question4 = Question(4,
            "Select the correct word",
            R.drawable.dog,
            "Cat",
            "Fish",
            "Dog",
            "Lion",
            "Dog")
        questionList.add(question4)

        val question5 = Question(5,
            "Select the correct word",
            R.drawable.egg,
            "Orange",
            "Egg",
            "Apple",
            "Mango",
            "Egg")
        questionList.add(question5)

        val question6 = Question(6,
            "Select the correct word",
            R.drawable.fish,
            "Snake",
            "Frog",
            "Fish",
            "Car",
            "Fish")
        questionList.add(question6)

        val question7 = Question(7,
            "Select the correct word",
            R.drawable.goat,
            "Dog",
            "Goat",
            "Tiger",
            "Cat",
            "Goat")
        questionList.add(question7)

        val question8 = Question(8,
            "Select the correct word",
            R.drawable.hand,
            "Hand",
            "Nose",
            "Zebra",
            "Leg",
            "Hand")
        questionList.add(question8)

        val question9 = Question(9,
            "Select the correct word",
            R.drawable.ink,
            "Pen",
            "Water",
            "Jug",
            "Ink",
            "Ink")
        questionList.add(question9)

        val question10 = Question(10,
            "Select the correct word",
            R.drawable.jug,
            "Pen",
            "Jug",
            "Ink",
            "Kite",
            "Jug")
        questionList.add(question10)

        val question11 = Question(11,
            "Select the correct word",
            R.drawable.kite,
            "Lion",
            "Kite",
            "Car",
            "Plant",
            "Kite")
        questionList.add(question11)

        val question12 = Question(12,
            "Select the correct word",
            R.drawable.lion,
            "Dog",
            "Zebra",
            "Goat",
            "Lion",
            "Lion")
        questionList.add(question12)

        val question13 = Question(13,
            "Select the correct word",
            R.drawable.mango,
            "Banana",
            "Orange",
            "Apple",
            "Mango",
            "Mango")
        questionList.add(question13)

        val question14 = Question(14,
            "Select the correct word",
            R.drawable.nose,
            "Hand",
            "Nose",
            "Hair",
            "Leg",
            "Nose")
        questionList.add(question14)

        val question15 = Question(15,
            "Select the correct word",
            R.drawable.orange,
            "Banana",
            "Mango",
            "Apple",
            "Orange",
            "Orange")
        questionList.add(question15)

        val question16 = Question(16,
            "Select the correct word",
            R.drawable.plant,
            "Orange",
            "Plant",
            "Apple",
            "Rat",
            "Plant")
        questionList.add(question16)

        val question17 = Question(17,
            "Select the correct word",
            R.drawable.queen,
            "King",
            "Man",
            "Queen",
            "Snake",
            "Queen")
        questionList.add(question17)

        val question18 = Question(18,
            "Select the correct word",
            R.drawable.rat,
            "Rat",
            "Cat",
            "Dog",
            "Lion",
            "Rat")
        questionList.add(question18)

        val question19 = Question(19,
            "Select the correct word",
            R.drawable.snake,
            "Snake",
            "Rat",
            "Tiger",
            "Umbrella",
            "Snake")
        questionList.add(question19)

        val question20 = Question(20,
            "Select the correct word",
            R.drawable.tiger,
            "Lion",
            "Dog",
            "Tiger",
            "Zebra",
            "Tiger")
        questionList.add(question20)

        val question21 = Question(21,
            "Select the correct word",
            R.drawable.umbrella,
            "Plant",
            "Jug",
            "Umbrella",
            "Water",
            "Umbrella")
        questionList.add(question21)

        val question22 = Question(22,
            "Select the correct word",
            R.drawable.volcano,
            "Mango",
            "Volcano",
            "Apple",
            "Umbrella",
            "Volcano")
        questionList.add(question22)

        val question23 = Question(23,
            "Select the correct word",
            R.drawable.water,
            "Yellow",
            "Orange",
            "White",
            "Water",
            "Water")
        questionList.add(question23)

        val question24 = Question(24,
            "Select the correct word",
            R.drawable.ox,
            "Dog",
            "Tiger",
            "Goat",
            "Ox",
            "Ox")
        questionList.add(question24)

        val question25 = Question(25,
            "Select the correct word",
            R.drawable.yellow,
            "Red",
            "Orange",
            "Yellow",
            "Mango",
            "Yellow")
        questionList.add(question25)

        val question26 = Question(26,
            "Select the correct word",
            R.drawable.zebra,
            "Lion",
            "Zebra",
            "Dog",
            "Tiger",
            "Zebra")
        questionList.add(question26)

        return questionList
    }

    fun blankFillQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1,
            "A_PLE",
            R.drawable.apple,
            "B",
            "P",
            "D",
            "L",
            "P")
        questionList.add(question1)

        val question2 = Question(2,
            "_ALL",
            R.drawable.ball,
            "H",
            "G",
            "E",
            "B",
            "B")
        questionList.add(question2)

        val question3 = Question(3,
            "CA_",
            R.drawable.cat,
            "T",
            "G",
            "Y",
            "L",
            "T")
        questionList.add(question3)

        val question4 = Question(4,
            "_OG",
            R.drawable.dog,
            "D",
            "E",
            "K",
            "V",
            "D")
        questionList.add(question4)

        val question5 = Question(5,
            "EG_",
            R.drawable.egg,
            "Q",
            "P",
            "G",
            "H",
            "G")
        questionList.add(question5)

        val question6 = Question(6,
            "_ISH",
            R.drawable.fish,
            "S",
            "F",
            "T",
            "E",
            "F")
        questionList.add(question6)

        val question7 = Question(7,
            "G_AT",
            R.drawable.goat,
            "A",
            "O",
            "I",
            "U",
            "O")
        questionList.add(question7)

        val question8 = Question(8,
            "HA_D",
            R.drawable.hand,
            "E",
            "U",
            "N",
            "M",
            "N")
        questionList.add(question8)

        val question9 = Question(9,
            "IN_",
            R.drawable.ink,
            "K",
            "S",
            "D",
            "L",
            "K")
        questionList.add(question9)

        val question10 = Question(10,
            "_UG",
            R.drawable.jug,
            "A",
            "H",
            "J",
            "L",
            "J")
        questionList.add(question10)

        val question11 = Question(11,
            "KI_E",
            R.drawable.kite,
            "L",
            "G",
            "K",
            "T",
            "T")
        questionList.add(question11)

        val question12 = Question(12,
            "LI_N",
            R.drawable.lion,
            "O",
            "T",
            "D",
            "F",
            "O")
        questionList.add(question12)

        val question13 = Question(13,
            "MA_GO",
            R.drawable.mango,
            "R",
            "T",
            "M",
            "N",
            "N")
        questionList.add(question13)

        val question14 = Question(14,
            "NO_E",
            R.drawable.nose,
            "A",
            "S",
            "H",
            "L",
            "S")
        questionList.add(question14)

        val question15 = Question(15,
            "O_ANGE",
            R.drawable.orange,
            "B",
            "R",
            "T",
            "P",
            "R")
        questionList.add(question15)

        val question16 = Question(16,
            "_LANT",
            R.drawable.plant,
            "P",
            "R",
            "L",
            "K",
            "P")
        questionList.add(question16)

        val question17 = Question(17,
            "_UEEN",
            R.drawable.queen,
            "T",
            "R",
            "Q",
            "G",
            "Q")
        questionList.add(question17)

        val question18 = Question(18,
            "RA_",
            R.drawable.rat,
            "L",
            "T",
            "Q",
            "E",
            "T")
        questionList.add(question18)

        val question19 = Question(19,
            "SNA_E",
            R.drawable.snake,
            "T",
            "L",
            "P",
            "K",
            "K")
        questionList.add(question19)

        val question20 = Question(20,
            "TI_ER",
            R.drawable.tiger,
            "Q",
            "B",
            "G",
            "A",
            "G")
        questionList.add(question20)

        val question21 = Question(21,
            "_MBRELLA",
            R.drawable.umbrella,
            "Q",
            "U",
            "H",
            "W",
            "U")
        questionList.add(question21)

        val question22 = Question(22,
            "_OLCANO",
            R.drawable.volcano,
            "I",
            "U",
            "V",
            "B",
            "V")
        questionList.add(question22)

        val question23 = Question(23,
            "WATE_",
            R.drawable.water,
            "P",
            "C",
            "D",
            "R",
            "R")
        questionList.add(question23)

        val question24 = Question(24,
            "O_",
            R.drawable.ox,
            "X",
            "A",
            "S",
            "I",
            "X")
        questionList.add(question24)

        val question25 = Question(25,
            "_ELLOW",
            R.drawable.yellow,
            "P",
            "T",
            "Y",
            "H",
            "Y")
        questionList.add(question25)

        val question26 = Question(26,
            "_EBRA",
            R.drawable.zebra,
            "W",
            "Q",
            "Y",
            "Z",
            "Z")
        questionList.add(question26)

        return questionList
    }

    fun countQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(1,
            "How many apples are there?",
            R.drawable.apples,
            "7",
            "2",
            "5",
            "8",
            "8")
        questionList.add(question1)

        val question2 = Question(2,
            "How many bananas are there?",
            R.drawable.bananas,
            "2",
            "3",
            "1",
            "4",
            "3")
        questionList.add(question2)

        val question3 = Question(3,
            "How many bananas are there?",
            R.drawable.bananas1,
            "2",
            "1",
            "4",
            "3",
            "2")
        questionList.add(question3)

        val question4 = Question(4,
            "How many birds are there?",
            R.drawable.birds,
            "1",
            "3",
            "2",
            "11",
            "2")
        questionList.add(question4)

        val question5 = Question(5,
            "How many books are there?",
            R.drawable.books,
            "2",
            "3",
            "4",
            "5",
            "4")
        questionList.add(question5)

        val question6 = Question(6,
            "How many cats are there?",
            R.drawable.cats,
            "2",
            "3",
            "4",
            "5",
            "3")
        questionList.add(question6)

        val question7 = Question(7,
            "How many pens are there?",
            R.drawable.pens,
            "2",
            "3",
            "4",
            "6",
            "3")
        questionList.add(question7)

        val question8 = Question(8,
            "How many persons are there?",
            R.drawable.persons,
            "2",
            "3",
            "4",
            "5",
            "3")
        questionList.add(question8)

        val question9 = Question(9,
            "How many persons are there?",
            R.drawable.persons1,
            "3",
            "5",
            "7",
            "8",
            "7")
        questionList.add(question9)

        val question10 = Question(10,
            "How many trees are there?",
            R.drawable.trees,
            "3",
            "5",
            "2",
            "8",
            "2")
        questionList.add(question10)

        val question11 = Question(11,
            "How many Bats are there?",
            R.drawable.bats,
            "7",
            "2",
            "5",
            "8",
            "2")
        questionList.add(question11)

        val question12 = Question(12,
            "How many eggs are there?",
            R.drawable.eggs,
            "5",
            "3",
            "1",
            "4",
            "5")
        questionList.add(question12)

        val question13 = Question(13,
            "How many flowers are there?",
            R.drawable.flowers,
            "2",
            "1",
            "4",
            "3",
            "2")
        questionList.add(question13)

        val question14 = Question(14,
            "How many hands are there?",
            R.drawable.hands,
            "1",
            "5",
            "2",
            "3",
            "3")
        questionList.add(question14)

        val question15 = Question(15,
            "How many Oranges are there?",
            R.drawable.oranges,
            "2",
            "3",
            "4",
            "5",
            "3")
        questionList.add(question15)

        val question16 = Question(16,
            "How many Boxes are there?",
            R.drawable.boxes,
            "2",
            "1",
            "4",
            "3",
            "3")
        questionList.add(question16)

        return questionList
    }
}