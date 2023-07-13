package com.lulobank.factory;

import com.github.javafaker.Faker;

public class CreateImagesDataFactory {

    private static final Faker FAKER = new Faker();

    public static String LIMIT = String.valueOf(FAKER.random().nextInt(11,22));
}
