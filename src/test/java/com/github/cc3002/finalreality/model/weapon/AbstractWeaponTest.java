package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract class containing the common tests for all the types of weapons.
 *
 * @author Camila Labarca
 */

public abstract class AbstractWeaponTest {

  public static final String AXE_NAME = "Test Axe";
  public static final String STAFF_NAME = "Test Staff";
  public static final String SWORD_NAME = "Test Sword";
  public static final String BOW_NAME = "Test Bow";
  public static final String KNIFE_NAME = "Test Knife";
  public static final int DAMAGE = 15;
  public static final int SPEED = 10;

  public Axe testAxe;
  public Staff testStaff;
  public Sword testSword;
  public Bow testBow;
  public Knife testKnife;
  public Axe sameAxe;
  public Staff sameStaff;
  public Sword sameSword;
  public Bow sameBow;
  public Knife sameKnife;


  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED,15);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    sameAxe = testAxe;
    sameStaff = testStaff;
    sameSword = testSword;
    sameBow = testBow;
    sameKnife = testKnife;
  }


  void checkConstruction(final AbstractWeapon expectedWeapon,
                         final AbstractWeapon testEqualWeapon,
                         final AbstractWeapon sameClassDifferentWeapon,
                         final AbstractWeapon differentClassWeapon,
                         final AbstractWeapon sameWeapon) {

    assertEquals(expectedWeapon, testEqualWeapon);
    assertEquals(sameWeapon, testEqualWeapon);
    assertNotEquals(sameClassDifferentWeapon, testEqualWeapon);
    assertNotEquals(testEqualWeapon, differentClassWeapon);
    assertEquals(expectedWeapon.hashCode(), testEqualWeapon.hashCode());

  }
}