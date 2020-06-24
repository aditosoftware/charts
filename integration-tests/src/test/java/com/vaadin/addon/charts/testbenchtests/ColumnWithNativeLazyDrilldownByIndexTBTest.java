package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.columnandbar.ColumnWithNativeLazyDrilldownByIndex;
import com.vaadin.testbench.By;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ColumnWithNativeLazyDrilldownByIndexTBTest extends AbstractParallelTest {

  @Override
  protected String getTestViewName() {
    return ColumnWithNativeLazyDrilldownByIndex.class.getSimpleName();
  }

  @Test
  public void test() throws IOException, AssertionError {
    driver.get(getTestUrl());

    waitForVaadin();
    captureAndCompare("before");

    WebElement element = driver.findElement(By.cssSelector(".highcharts-drilldown-point"));
    element.click();

    waitForDynamicChanges();
    captureAndCompare("after");
  }

  @Override
  protected String getPackageName() {
    return "columnandbar";
  }
}
