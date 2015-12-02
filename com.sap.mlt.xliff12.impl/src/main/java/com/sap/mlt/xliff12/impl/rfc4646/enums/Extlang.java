/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  The ASF licenses this file to You
* under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.  For additional information regarding
* copyright in this work, please see the NOTICE file in the top level
* directory of this distribution.
*/
package com.sap.mlt.xliff12.impl.rfc4646.enums;

import java.util.Locale;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag;

/**
 * Enum constants used to validate language tags
 */
public enum Extlang {
// none registered yet
  ;
  
  private final String deprecated;
  private final String preferred;
  private final String prefix;
  private final String[] descriptions;
  
  private Extlang(
    String dep, 
    String pref, 
    String prefix, 
    String... desc) {
      this.deprecated = dep;
      this.preferred = pref;
      this.prefix = prefix;
      this.descriptions = desc;
  }

  public String getDeprecated() {
    return deprecated;
  }
  
  public boolean isDeprecated() {
    return deprecated != null;
  }

  public String getPreferredValue() {
    return preferred;
  }
  
  public Extlang getPreferred() {
    return preferred != null ? 
      valueOf(preferred.toUpperCase(Locale.ENGLISH)) : this;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getDescription() {
    return descriptions.length > 0 ? descriptions[0] : null;
  }
  
  public String[] getDescriptions() {
    return descriptions.clone();
  }
  
  public Subtag newSubtag() {
    return new Subtag(this);
  }
  
  public static Extlang valueOf(Subtag subtag) {
    if (subtag == null) return null;
    if (subtag.getType() == Subtag.Type.PRIMARY)
      return valueOf(subtag.getName().toUpperCase(Locale.ENGLISH));
    else throw new IllegalArgumentException("Wrong subtag type");
  }
  
}

