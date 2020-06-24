package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.lineandscatter.BasicLineWithTickCount;
import com.vaadin.testbench.elements.ButtonElement;
import org.junit.Test;

import java.io.IOException;

public class BasicLineWithTickCountTBTest extends AbstractParallelTest {
  @Test
  public void test() throws IOException, AssertionError {
    driver.get(getTestUrl());

    waitForVaadin();
    captureAndCompare("InitialCount");

    $(ButtonElement.class).first().click();

    waitForVaadin();
    captureAndCompare("FinalCount");
  }

  @Override
  protected String getTestViewName() {
    return BasicLineWithTickCount.class.getSimpleName();
  }

  @Override
  protected String getPackageName() {
    return "lineandscatter";
  }
}
