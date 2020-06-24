package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.lineandscatter.SplineWithItemLabels;

public class SplineWithItemLabelsTBTest extends AbstractSimpleScreenShotTestBenchTest {

  @Override
  protected String getTestViewName() {
    return SplineWithItemLabels.class.getSimpleName();
  }

  @Override
  protected String getPackageName() {
    return "lineandscatter";
  }
}
