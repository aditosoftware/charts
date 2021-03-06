package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.dataprovider.ChartWithExternalDataProviderWithChangingData;
import com.vaadin.testbench.By;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ChangingDataProviderTBTest extends AbstractParallelTest {

  @Override
  protected String getTestViewName() {
    return ChartWithExternalDataProviderWithChangingData.class.getSimpleName();
  }

  @Test
  public void test() throws IOException, AssertionError {
    driver.get(getTestUrl());

    waitForVaadin();
    captureAndCompare("before");

    WebElement element = driver.findElement(By.className("v-button"));
    element.click();
    element.click();

    waitForDynamicChanges();
    captureAndCompare("after");
  }

  @Override
  protected String getPackageName() {
    return "dataprovider";
  }
}
