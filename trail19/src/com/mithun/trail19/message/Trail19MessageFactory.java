/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.message;

import javax.baja.ndriver.comm.IMessageFactory;
import javax.baja.ndriver.comm.LinkMessage;
import javax.baja.ndriver.comm.NMessage;

/**
 * Trail19MessageFactory implementation of IMessageFactory.
 *
 * @author mithun on 27 May 2025
 */
public class Trail19MessageFactory
  implements IMessageFactory
{
  public Trail19MessageFactory()
  {
  }

  public NMessage makeMessage(LinkMessage lm)
    throws Exception
  {
    //
    // TODO - convert linkMessage driver specific NMessage
    return null;
  }
}
