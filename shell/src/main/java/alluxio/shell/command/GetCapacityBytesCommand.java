/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package alluxio.shell.command;

import alluxio.Configuration;
import alluxio.client.block.AlluxioBlockStore;
import alluxio.client.file.FileSystem;

import org.apache.commons.cli.CommandLine;

import java.io.IOException;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Gets the capacity of the {@link FileSystem}.
 */
@ThreadSafe
public final class GetCapacityBytesCommand extends AbstractShellCommand {

  /**
   * Constructs a new instance to get the capacity of the {@link FileSystem}.
   *
   * @param conf the configuration for Alluxio
   * @param fs the filesystem of Alluxio
   */
  public GetCapacityBytesCommand(Configuration conf, FileSystem fs) {
    super(conf, fs);
  }

  @Override
  public String getCommandName() {
    return "getCapacityBytes";
  }

  @Override
  protected int getNumOfArgs() {
    return 0;
  }

  @Override
  public void run(CommandLine cl) throws IOException {
    long capacityBytes = AlluxioBlockStore.get().getCapacityBytes();
    System.out.println("Capacity Bytes: " + capacityBytes);
  }

  @Override
  public String getUsage() {
    return "getCapacityBytes";
  }

  @Override
  public String getDescription() {
    return "Gets the capacity of the Alluxio file system.";
  }
}