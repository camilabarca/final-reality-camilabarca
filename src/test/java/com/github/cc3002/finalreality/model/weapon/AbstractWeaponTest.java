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

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED,15);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
  }


  void checkConstruction(final AbstractWeapon expectedWeapon,
                         final AbstractWeapon testEqualWeapon,
                         final AbstractWeapon sameClassDifferentWeapon,
                         final AbstractWeapon differentClassWeapon) {

    assertEquals(expectedWeapon, testEqualWeapon);
    assertNotEquals(sameClassDifferentWeapon, testEqualWeapon);
    assertNotEquals(testEqualWeapon, differentClassWeapon);
    assertEquals(expectedWeapon.hashCode(), testEqualWeapon.hashCode());
    /*var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, 15);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE,SPEED);
    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE,SPEED);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());*/
  }
}