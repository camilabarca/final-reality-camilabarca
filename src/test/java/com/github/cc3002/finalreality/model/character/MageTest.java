package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MageTest extends AbstractPlayerCharacterTest {
    private static final String BLACK_MAGE_NAME = "Vivi";
    private static final String WHITE_MAGE_NAME = "Eiko";

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        testCharacters.add(new Mage(BLACK_MAGE_NAME, 10,10, MageType.BLACK_MAGE, turns,10));
        testCharacters.add(new Mage(WHITE_MAGE_NAME, 10,10, MageType.WHITE_MAGE, turns,10));
        testPlayerCharacters.add(new Mage(BLACK_MAGE_NAME, 10,10, MageType.BLACK_MAGE, turns,10));
        testPlayerCharacters.add(new Mage(WHITE_MAGE_NAME, 10,10, MageType.WHITE_MAGE, turns,10));

    }

    @Test
    void constructorTest() {
        checkConstruction(new Mage(BLACK_MAGE_NAME, 10,10,MageType.BLACK_MAGE , turns, 10),
                testCharacters.get(0),
                new Mage(BLACK_MAGE_NAME, 11, 11,MageType.WHITE_MAGE,turns, 11),
                new Comunes(BLACK_MAGE_NAME,11, 11,  ComunesType.THIEF, turns));
        checkConstruction(new Mage(WHITE_MAGE_NAME, 10,10,MageType.WHITE_MAGE , turns, 10),
                testCharacters.get(1),
                new Mage(WHITE_MAGE_NAME, 11, 11,MageType.BLACK_MAGE,turns, 11),
                new Comunes(WHITE_MAGE_NAME,11, 11,  ComunesType.THIEF, turns));

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
