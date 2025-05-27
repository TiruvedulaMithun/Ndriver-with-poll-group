/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.point;

import javax.baja.ndriver.discover.BNDiscoveryPreferences;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;


/**
 * BTrail19PointDiscoveryPreferences controls the type of discovery leafs using during
 * point discovery for trail19
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType
public class BTrail19PointDiscoveryPreferences
  extends BNDiscoveryPreferences
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.point.BTrail19PointDiscoveryPreferences(2979906276)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19PointDiscoveryPreferences.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public BTrail19PointDiscoveryPreferences()
  {
  }

  public Type getDiscoveryLeafType()
  {
    return BTrail19PointDiscoveryLeaf.TYPE;
  }
}
