package dev.abhishekkumar.jokelib;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class JokeClass {
    List<String> list= asList(
            "I got another letter from this lawyer today. It said 'Final Notice'. Good that he will not bother me anymore. ",
            "What is invisible and smells of worms? - A bird's fart.",
            "Don't be sad when a bird craps on your head. Be happy that dogs can't fly.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "It has four legs and it can fly, what is it? - Two birds.",
            "How do you rob a snowman? - With a hairdryer."
    );

    public String getJoke(){
        Random random = new Random();

        String randomJoke = list.get(random.nextInt(list.size()));

        return  randomJoke;
    }
}
