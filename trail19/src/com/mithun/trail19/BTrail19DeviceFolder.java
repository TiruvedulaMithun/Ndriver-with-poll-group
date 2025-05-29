/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19;

import javax.baja.ndriver.BNDeviceFolder;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

/**
 * BTrail19DeviceFolder is a folder for BTrail19Device.
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType
public class BTrail19DeviceFolder
  extends BNDeviceFolder
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.BTrail19DeviceFolder(2979906276)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19DeviceFolder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrail19Network.
   *
   * @return network as a BTrail19Network.
   */
  public final BTrail19Network getTrail19Network()
  {
    return (BTrail19Network) getNetwork();
  }

  /**
   * @return true if parent is BTrail19Network or BTrail19DeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BTrail19Network ||
           parent instanceof BTrail19DeviceFolder;
  }
}
