/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.access.tests.e2e;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestUriPermissions {
  private EndToEndTestContext context;
  private static final String dataFile = "/kv1.dat";
  private String dataFilePath = this.getClass().getResource(dataFile).getFile();

  @Before
  public void setup() throws Exception {
    context = new EndToEndTestContext(new HashMap<String, String>());
  }

  @After
  public void tearDown() throws Exception {
    if (context != null) {
      context.close();
    }
  }

  @AfterClass
  public static void shutDown() throws IOException {
    EndToEndTestContext.shutdown();
  }

  // test load data into table
  @Test
  public void testLoadPrivileges() throws Exception {
    String dbName = "db1";
    String tabName = "tab1";
    Connection userConn = null;
    Statement userStmt = null;

    String testPolicies[] = {
        "[groups]",
        "admin_group = admin_role",
        "user_group1  = db1_read, db1_write, data_read",
        "user_group2  = db1_write",
        "[roles]",
        "db1_write = server=server1->db=" + dbName + "->table=" + tabName + "->action=INSERT",
        "db1_read = server=server1->db=" + dbName + "->table=" + tabName + "->action=SELECT",
        "data_read = server=server1->URI=file:" + dataFilePath,
        "admin_role = server=server1",
        "[users]",
        "user1 = user_group1",
        "user2 = user_group2",
        "admin = admin_group"
        };
    context.makeNewPolicy(testPolicies);

    // create dbs
    Connection adminCon = context.createConnection("admin", "foo");
    Statement adminStmt = context.createStatement(adminCon);
    adminStmt.execute("use default");
    adminStmt.execute("DROP DATABASE IF EXISTS " + dbName + " CASCADE");
    adminStmt.execute("CREATE DATABASE " + dbName);
    adminStmt.execute("use " + dbName);
    adminStmt.execute("CREATE TABLE " + tabName + "(id int)");
    context.close();

    // positive test, user1 has access to file being loaded
    userConn = context.createConnection("user1", "foo");
    userStmt = context.createStatement(userConn);
    userStmt.execute("use " + dbName);
    userStmt.execute("load data local inpath '" + dataFilePath +
        "' into table " + tabName);
    userStmt.execute("select * from " + tabName + " limit 1");
    ResultSet res = userStmt.getResultSet();
    Assert.assertTrue("Table should have data after load", res.next());
    res.close();
    context.close();

    // Negative test, user2 doesn't have access to the file being loaded
    userConn = context.createConnection("user2", "foo");
    userStmt = context.createStatement(userConn);
    userStmt.execute("use " + dbName);
    try {
    userStmt.execute("load data local inpath '" + dataFilePath +
        "' into table " + tabName);
    Assert.assertTrue("load should fail for user2", false);
    } catch (SQLException e) {
      context.verifyAuthzException(e);
    }
    context.close();
  }

  // Test alter partition location
  @Test
  public void testAlterPartitionLocationPrivileges() throws Exception {
    String dbName = "db1";
    String tabName = "tab1";
    String newPartitionDir = "foo";
    String tabDir = System.getProperty(EndToEndTestContext.WAREHOUSE_DIR) +
      "/" + tabName + "/" + newPartitionDir;
    Connection userConn = null;
    Statement userStmt = null;

    String testPolicies[] = {
        "[groups]",
        "admin_group = admin_role",
        "user_group1  = db1_all, data_read",
        "user_group2  = db1_all",
        "[roles]",
        "db1_all = server=server1->db=" + dbName,
        "data_read = server=server1->URI=" + tabDir,
        "admin_role = server=server1",
        "[users]",
        "user1 = user_group1",
        "user2 = user_group2",
        "admin = admin_group"
        };
    context.makeNewPolicy(testPolicies);

    // create dbs
    Connection adminCon = context.createConnection("admin", "foo");
    Statement adminStmt = context.createStatement(adminCon);
    adminStmt.execute("use default");
    adminStmt.execute("DROP DATABASE IF EXISTS " + dbName + " CASCADE");
    adminStmt.execute("CREATE DATABASE " + dbName);
    adminStmt.execute("use " + dbName);
    adminStmt.execute("CREATE TABLE " + tabName + " (id int) PARTITIONED BY (dt string)");
    context.close();

    // negative test: user2 doesn't have privilege to alter table set partition
    userConn = context.createConnection("user2", "foo");
    userStmt = context.createStatement(userConn);
    userStmt.execute("use " + dbName);
    try {
      userStmt.execute("ALTER TABLE " + tabName + " ADD PARTITION (dt = '21-Dec-2012') " +
          " LOCATION '" + tabDir + "/foo'");
    Assert.assertTrue("partition location shouldfail for user2", false);
    } catch (SQLException e) {
      context.verifyAuthzException(e);
    }
    context.close();

 // positive test: user doesn't have privilege to alter table set partition    userConn = context.createConnection("user1", "foo");
    userConn = context.createConnection("user1", "foo");
    userStmt = context.createStatement(userConn);
    userStmt.execute("use " + dbName);
    userStmt.execute("ALTER TABLE " + tabName + " ADD PARTITION (dt = '21-Dec-2012') " +
            " LOCATION '" + tabDir + "'");
    context.close();
  }

  // test alter table set location
  @Test
  public void testAlterTableLocationPrivileges() throws Exception {
    String dbName = "db1";
    String tabName = "tab1";
    String tabDir = "file:" + System.getProperty(EndToEndTestContext.WAREHOUSE_DIR) +
      "/" + tabName;
    Connection userConn = null;
    Statement userStmt = null;

    String testPolicies[] = {
        "[groups]",
        "admin_group = admin_role",
        "user_group1  = db1_all, data_read",
        "user_group2  = db1_all",
        "[roles]",
        "db1_all = server=server1->db=" + dbName,
        "data_read = server=server1->URI=" + tabDir,
        "admin_role = server=server1",
        "[users]",
        "user1 = user_group1",
        "user2 = user_group2",
        "admin = admin_group"
        };
    context.makeNewPolicy(testPolicies);

    // create dbs
    Connection adminCon = context.createConnection("admin", "foo");
    Statement adminStmt = context.createStatement(adminCon);
    adminStmt.execute("use default");
    adminStmt.execute("DROP DATABASE IF EXISTS " + dbName + " CASCADE");
    adminStmt.execute("CREATE DATABASE " + dbName);
    adminStmt.execute("use " + dbName);
    adminStmt.execute("CREATE TABLE " + tabName + " (id int)");
    context.close();

    // negative test: user2 doesn't have privilege to alter table set partition
    userConn = context.createConnection("user2", "foo");
    userStmt = context.createStatement(userConn);
    userStmt.execute("use " + dbName);
    try {
      userStmt.execute("ALTER TABLE " + tabName + " SET LOCATION '" + tabDir +  "'");
    Assert.assertTrue("set table location should fail for user2", false);
    } catch (SQLException e) {
      context.verifyAuthzException(e);
    }
    context.close();

 // positive test: user doesn't have privilege to alter table set partition    userConn = context.createConnection("user1", "foo");
    userConn = context.createConnection("user1", "foo");
    userStmt = context.createStatement(userConn);
    userStmt.execute("use " + dbName);
    userStmt.execute("ALTER TABLE " + tabName + " SET LOCATION '" + tabDir + "'");
    context.close();
  }

  // Test external table
  @Test
  public void testExternalTablePrivileges() throws Exception {
    String dbName = "db1";
    String tabName = "tab1";
    Connection userConn = null;
    Statement userStmt = null;

    String testPolicies[] = {
        "[groups]",
        "admin_group = admin_role",
        "user_group1  = db1_all, data_read",
        "user_group2  = db1_all",
        "[roles]",
        "db1_all = server=server1->db=" + dbName,
        "data_read = server=server1->URI=" + context.getDataDir(),
        "admin_role = server=server1",
        "[users]",
        "user1 = user_group1",
        "user2 = user_group2",
        "admin = admin_group"
        };
    context.makeNewPolicy(testPolicies);

    // create dbs
    Connection adminCon = context.createConnection("admin", "foo");
    Statement adminStmt = context.createStatement(adminCon);
    adminStmt.execute("use default");
    adminStmt.execute("DROP DATABASE IF EXISTS " + dbName + " CASCADE");
    adminStmt.execute("CREATE DATABASE " + dbName);
    context.close();

    // negative test: user2 doesn't have privilege to create external table in given path
    userConn = context.createConnection("user2", "foo");
    userStmt = context.createStatement(userConn);
    userStmt.execute("use " + dbName);
    try {
    userStmt.execute("CREATE EXTERNAL TABLE extab1(id INT) LOCATION '" + context.getDataDir() + "'");
    Assert.assertTrue("load should fail for user2", false);
    } catch (SQLException e) {
      context.verifyAuthzException(e);
    }
    context.close();

    // positive test: user1 has privilege to create external table in given path
    userConn = context.createConnection("user1", "foo");
    userStmt = context.createStatement(userConn);
    userStmt.execute("use " + dbName);
    userStmt.execute("CREATE EXTERNAL TABLE extab1(id INT) LOCATION '" + context.getDataDir() + "'");
    context.close();
  }

}