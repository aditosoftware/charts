package com.vaadin.addon.charts.testbenchtests;

import com.google.common.collect.Lists;
import com.vaadin.addon.charts.examples.pie.PieWithLegend;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PieLegendItemClickTBTest extends AbstractParallelTest {

  @Test
  public void test() {
    driver.get(getTestUrl());

    WebElement ie = getLegendItem("IE");
    ie.click();
    try {
      getNotification("Legend item click : 1 : IE");
    } catch (NoSuchElementException ex) {
      Assert.fail("The click notification was not displayed");
    }
  }

  @Test
  public void testLegendPointIndex() {
    driver.get(getTestUrl());

    List<String> items = Lists.newArrayList("Firefox", "IE", "Chrome", "Safari", "Opera", "Others");

    for (int i = 0; i < items.size(); i++) {
      WebElement item = getLegendItem(items.get(i));
      item.click();
      try {
        getNotification("Legend item click : " + i + " : " + items.get(i));
      } catch (NoSuchElementException ex) {
        Assert.fail("The click notification was not displayed for item: " + items.get(i));
      }
    }
  }

  private WebElement getLegendItem(String name) {
    return driver.findElement(
        By.xpath(
            "//*[contains(@class, 'highcharts-legend-item')]"
                + "//*[contains(text(), '"
                + name
                + "')]"));
  }

  private WebElement getNotification(String text) {
    return driver.findElement(
        By.xpath(
            "//*[contains(@class, 'v-Notification')]" + "//*[contains(text(), '" + text + "')]"));
  }

  @Override
  protected String getTestViewName() {
    return PieWithLegend.class.getSimpleName();
  }

  @Override
  protected String getPackageName() {
    return "pie";
  }
}
