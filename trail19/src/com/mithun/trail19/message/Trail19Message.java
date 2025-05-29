/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.message;

import java.io.*;

import javax.baja.ndriver.comm.*;
import javax.baja.ndriver.datatypes.*;
import javax.baja.ndriver.io.TypedInputStream;
import javax.baja.util.ICoalesceable;

/**
 * Trail19Message is super class for all trail19 messages
 *
 * @author mithun on 27 May 2025
 */
public class Trail19Message
  extends NMessage
{
  // Override for outgoing messages
//  public boolean toOutputStream(OutputStream out)
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    TypedOutputStream to = new TypedOutputStream();
//
//    to.toOutputStream(out);
//    return false;
//  }

  //   Override for incoming messages
//  public void fromInputStream(InputStream in)
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    // Note: messageFactory must have created TypedInputStream
//    TypedInputStream ti = (TypedInputStream)in;
//  }

  //   Typical overrides
//  public Object getTag() { return nullTag; }
//  public boolean isResponse() { return false; }
//  public boolean isFragmentable() { return false; }
//  public int getResponseTimeOut() { return 2500; }

//  public String toTraceString()
//  {
//    return "??";
//  }

  /**
   * Returns the coalescing key used to group coalescable requests.
   * <p>
   * This key determines whether two queue elements are eligible to be combined.
   * It must implement proper {@code hashCode()} and {@code equals()} semantics
   * in line with the driver’s coalescing logic.
   * <p>
   * The default implementation returns {@code this}, which effectively disables
   * coalescing by treating each request as unique.
   * <p>
   * To enable coalescing, override this method to return a meaningful grouping key
   * (e.g., based on point address, priority, or operation type).
   *
   * @return the key used for identifying coalescable requests
   *
   * @see ICoalesceable#coalesce(ICoalesceable)
   * @since Niagara 5.0
   */
  @Override
  public Object getCoalesceKey()
  {
    // TODO if the message can coalesce, return a unique key to coalesce the message
    return this;
  }

  /**
   * Attempts to coalesce this object with the newly enqueued {@code newElement}.
   * <p>
   * This method is called when two queue elements have matching coalescing keys
   * (as returned by {@link #getCoalesceKey()}) and are eligible to be merged.
   * Typically, either {@code this} (the older object) or {@code newElement} (the newer object)
   * is returned based on your desired overwrite or merge strategy.
   * <p>
   * The default implementation always returns {@code newElement}, meaning
   * that newer requests override older ones without merging. To support
   * smarter merging (e.g., aggregating changes or selecting based on priority),
   * override this method accordingly.
   *
   * @param newElement the newly added queue element with the same coalescing key
   * @return the result of the coalescing operation (typically {@code this} or {@code newElement})
   *
   * @see #getCoalesceKey()
   * @since Niagara 5.0
   */
  @Override
  public ICoalesceable coalesce(ICoalesceable newElement)
  {
    // TODO if the message can coalesce, determine the final coalesced message
    return newElement;
  }
}
