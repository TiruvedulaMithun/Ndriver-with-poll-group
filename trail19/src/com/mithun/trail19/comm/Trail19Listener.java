/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.comm;

import javax.baja.ndriver.comm.ICommListener;
import javax.baja.ndriver.comm.NMessage;
import javax.baja.ndriver.datatypes.BCommConfig;

/**
 * Trail19Listener processes unsolicited messages.
 *
 * @author mithun on 27 May 2025
 */
public class Trail19Listener
  implements ICommListener
{
  /**
   * Constructor
   */
  public Trail19Listener(BCommConfig ccfg)
  {
  }

  /**
   * Customized to process the unsolicited message for this driver.
   *
   * @param nMsg message received from device
   */
  public void receiveMessage(NMessage nMsg)
  {
    // TODO
  }
}
