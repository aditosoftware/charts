package com.vaadin.addon.charts.model.serializers;

/*-
 * #%L
 * Vaadin Charts Addon
 * %%
 * Copyright (C) 2012 - 2019 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <https://vaadin.com/license/cval-3>.
 * #L%
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vaadin.addon.charts.model.AxisTitle;

import java.io.IOException;

/** Serializer for {@link com.vaadin.addon.charts.model.AxisTitle}. */
public class AxisTitleBeanSerializer extends BeanSerializationDelegate<AxisTitle> {

  @Override
  public Class<AxisTitle> getBeanClass() {
    return AxisTitle.class;
  }

  public void serialize(
      AxisTitle bean,
      BeanSerializerDelegator<AxisTitle> serializer,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException {
    jgen.writeStartObject();

    if (bean != null && bean.getText() == null) {
      jgen.writeNullField("text");
    } else {
      // write fields as per normal serialization rules
      serializer.serializeFields(bean, jgen, provider);
    }

    jgen.writeEndObject();
  }
}
