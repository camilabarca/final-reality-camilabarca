package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ComunesTest extends AbstractPlayerCharacterTest {
    private static final String KNIGHT_NAME = "Adelbert";
    private static final String ENGINEER_NAME = "Cid";
    private static final String THIEF_NAME = "Zidane";

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testCharacters.add(new Comunes(KNIGHT_NAME, 10,10, ComunesType.KNIGHT, turns));
        testCharacters.add(new Comunes(ENGINEER_NAME, 10,10, ComunesType.ENGINEER, turns));
        testCharacters.add(new Comunes(THIEF_NAME,10,10, ComunesType.THIEF,turns));
        testPlayerCharacters.add(new Comunes(KNIGHT_NAME, 10,10, ComunesType.KNIGHT, turns));
        testPlayerCharacters.add(new Comunes(ENGINEER_NAME, 10,10, ComunesType.ENGINEER, turns));
        testPlayerCharacters.add(new Comunes(THIEF_NAME,10,10, ComunesType.THIEF,turns));

    }

    @Test
    void constructorTest() {
        checkConstruction(new Comunes(KNIGHT_NAME, 10,10, ComunesType.KNIGHT, turns),
                testCharacters.get(0),
                new Comunes(KNIGHT_NAME,11, 11,  ComunesType.THIEF, turns),
                new Mage(KNIGHT_NAME, 11, 11,MageType.WHITE_MAGE,turns, 11));
        checkConstruction(new Comunes(ENGINEER_NAME, 10,10, ComunesType.ENGINEER, turns),
                testCharacters.get(1),
                new Comunes(ENGINEER_NAME,11, 11,  ComunesType.KNIGHT, turns),
                new Mage(ENGINEER_NAME, 11, 11,MageType.WHITE_MAGE,turns, 11));
        checkConstruction(new Comunes(THIEF_NAME, 10,10, ComunesType.THIEF, turns),
                testCharacters.get(2),
                new Comunes(THIEF_NAME,11, 11,  ComunesType.ENGINEER, turns),
                new Mage(THIEF_NAME, 11, 11,MageType.WHITE_MAGE,turns, 11));


    }
    @Test
    void waitTurnTest() {
        super.waitTurnTest();
    }

    @Test
    void equipWeaponTest() {
        super.equipWeaponTest();
    }
}
