package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.columnandbar.ColumnWithLazyMultiLevelDrilldown;
import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.LabelElement;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ColumnWithLazyMultiLevelDrilldownTBTest extends AbstractParallelTest {

  @Override
  protected String getTestViewName() {
    return ColumnWithLazyMultiLevelDrilldown.class.getSimpleName();
  }

  @Test
  public void test() throws IOException, AssertionError {
    driver.get(getTestUrl());

    waitForVaadin();

    WebElement findElement = driver.findElement(By.id("chart"));
    clickFirstDrilldownPoint();
    assertLogText("DrilldownEvent: Latin America and Carribean");

    clickFirstDrilldownPoint();
    assertLogText("DrilldownEvent: Costa Rica");

    clickDrilldownUp();
    assertLogText("ChartDrillupEvent");
  }

  private void clickFirstDrilldownPoint() {
    WebElement element = driver.findElement(By.cssSelector(".highcharts-drilldown-point"));
    element.click();
  }

  private void clickDrilldownUp() {
    WebElement element = driver.findElement(By.cssSelector(".highcharts-button"));
    element.click();
  }

  private void assertLogText(String text) {
    waitForVaadin();
    assertTrue(String.format("Couldn't find text '%s' from the log.", text), logContainsText(text));
  }

  private boolean logContainsText(String string) {
    LabelElement label = $(LabelElement.class).first();
    if (label.getText().contains(string)) {
      return true;
    }

    return false;
  }

  @Override
  protected String getPackageName() {
    return "columnandbar";
  }
}
