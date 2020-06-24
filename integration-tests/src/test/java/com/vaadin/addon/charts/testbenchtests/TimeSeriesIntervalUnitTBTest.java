package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.lineandscatter.TimeSeriesIntervalUnit;
import com.vaadin.testbench.elements.ButtonElement;
import org.junit.Test;

import java.io.IOException;

public class TimeSeriesIntervalUnitTBTest extends AbstractParallelTest {
  @Test
  public void test() throws IOException, AssertionError {
    driver.get(getTestUrl());

    waitForVaadin();
    captureAndCompare("OneMonthInterval");

    $(ButtonElement.class).first().click();

    waitForVaadin();
    captureAndCompare("OneDayInterval");
  }

  @Override
  protected String getTestViewName() {
    return TimeSeriesIntervalUnit.class.getSimpleName();
  }

  @Override
  protected String getPackageName() {
    return "lineandscatter";
  }
}
