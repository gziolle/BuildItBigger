package com.jokewizard;

import java.util.ArrayList;

public class JokeWizard {

    private static String[] mJokes = new String[]{
            "What is the difference between a snowman and a snowwoman? Snowballs",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all.",
            "Coco Chanel once said that you should put perfume on places where you want to be kissed by a man. But hell does that burn!",
            "In a boomerang shop: \"I'd like to buy a new boomerang please. Also, can you tell me how to throw the old one away?\"",
            "I can’t believe I forgot to go to the gym today. That’s 7 years in a row now.",
            "The inventor of AutoCorrect is a stupid mass hole. He can fake right off.",
            "A naked women robbed a bank. Nobody could remember her face.",
            "I was making Russian tea. Unfortunately I cannot fish the teabag out of the vodka bottle.",
            "I’m selling my talking parrot. Why? Because yesterday, the bastard tried to sell me.",
            "A woman in a bikini reveals about 90% of her body.... and yet most men are so polite they only look at the covered parts."};

    public static String getJoke(){
        int index = (int) (Math.random() * mJokes.length);
        return mJokes[index];
    }

}
